/*
 * MIT License
 * 
 * Copyright (c) 2020 Hochschule Esslingen
 * 
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 * 
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 * 
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE. 
 */
package de.hsesslingen.keim.efs.adapter.trias;

import static de.hsesslingen.keim.efs.adapter.trias.factories.ModeConverter.from;
import static de.hsesslingen.keim.efs.adapter.trias.factories.TriasModelUtils.extract;
import static de.hsesslingen.keim.efs.adapter.trias.factories.TriasModelUtils.firstOf;
import static de.hsesslingen.keim.efs.adapter.trias.factories.TriasModelUtils.ifPresent;
import de.hsesslingen.keim.efs.middleware.model.Leg;
import de.hsesslingen.keim.efs.middleware.model.Option;
import de.hsesslingen.keim.efs.middleware.model.Place;
import de.vdv.trias.ContinuousLeg;
import de.vdv.trias.GeoPosition;
import de.vdv.trias.LocationRef;
import de.vdv.trias.TimedLeg;
import de.vdv.trias.Trias;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import de.hsesslingen.keim.efs.adapter.trias.supertypes.ILegEnd;
import de.hsesslingen.keim.efs.middleware.model.Asset;
import static de.hsesslingen.keim.efs.middleware.utils.StringUtils.joinNonEmpty;
import static de.hsesslingen.keim.efs.mobility.exception.HttpException.*;
import de.hsesslingen.keim.efs.mobility.service.Mode;
import de.vdv.trias.ContinuousModesEnumeration;
import de.vdv.trias.IndividualModesEnumeration;
import de.vdv.trias.InterchangeModesEnumeration;
import de.vdv.trias.TripLeg;
import de.vdv.trias.TripResult;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;
import static org.apache.commons.lang3.StringUtils.isNotBlank;
import org.springframework.beans.factory.annotation.Value;

/**
 * This class creates EFS- Mobility Objects from Trias Response - Objects
 *
 * @author Ben Oesch and Emanuel Reichsöllner
 */
@Component
public class TriasResponseConverter {

    @Value("${middleware.provider.mobility-service.id}")
    private String serviceId;

    @Autowired
    private TriasLocationInformationService triasLocationInformationService;

    public Place createPlace(LocationRef locationRef) {
        if (locationRef == null) {
            return null;
        }

        var place = new Place();

        place.setServiceId(serviceId);

        if (locationRef.getGeoPosition() != null) {
            place.setLat(locationRef.getGeoPosition().getLatitude());
            place.setLon(locationRef.getGeoPosition().getLongitude());
        }

        if (locationRef.getStopPointRef() != null) {
            place.setId(locationRef.getStopPointRef().getValue());
        }

        var names = locationRef.getLocationName(); // names is never null. See src.

        if (!names.isEmpty()) {
            place.setName(names.get(0).getText());
        }

        return place;
    }

    public Place createPlace(ILegEnd legEnd) {
        if (legEnd == null) {
            return null;
        }

        var pos = triasLocationInformationService.getGeoPositionFromStopPoint(legEnd.getStopPointRef());
        return createPlace(legEnd, pos);
    }

    public Place createPlace(ILegEnd legEnd, GeoPosition geoPosition) {
        if (legEnd == null) {
            return null;
        }

        var place = new Place();

        place.setServiceId(serviceId);

        if (legEnd.getStopPointRef() != null) {
            place.setId(legEnd.getStopPointRef().getValue());
        }

        if (!legEnd.getStopPointName().isEmpty()) {
            place.setName(legEnd.getStopPointName().get(0).getText());

            if (geoPosition != null) {
                place.setLat(geoPosition.getLatitude());
                place.setLon(geoPosition.getLongitude());
            }
        }

        return place;
    }

    private CompletableFuture<Place> createPlaceAsync(ILegEnd legEnd) {
        return CompletableFuture.supplyAsync(() -> {
            // First get the geo coordinates from the server.
            var geoPos = triasLocationInformationService.getGeoPositionFromStopPoint(legEnd.getStopPointRef());
            // The convert it to a place.
            return createPlace(legEnd, geoPos);
        });
    }

    /**
     * Converts a {@link ContinuousLeg} to a {@link Leg}. A ContinuousLeg means
     * a leg that is not bound to a timetable like walking, bicycle- or carride,
     * ...
     *
     * @param cLeg
     * @return
     */
    public Leg createLeg(ContinuousLeg cLeg) {
        var leg = new Leg();

        // origin Time
        leg.setStartTime(cLeg.getTimeWindowStart());
        leg.setFrom(TriasResponseConverter.this.createPlace(cLeg.getLegStart()));
        leg.setEndTime(cLeg.getTimeWindowEnd());
        leg.setTo(TriasResponseConverter.this.createPlace(cLeg.getLegEnd()));

        // triplength
        ifPresent(cLeg.getLength(), length -> {
            leg.setDistanceMeter(length.intValue());
        });

        Mode mode = from(cLeg);
        leg.setMode(mode);

        if (mode != Mode.WALK) {
            var asset = new Asset()
                    .setServiceId(serviceId)
                    .setMode(mode);

            var service = cLeg.getService();

            ifPresent(service.getJourneyRef(), ref -> {
                asset.setId(ref.getValue());
            });

            var section = firstOf(service.getServiceSection());

            if (section != null) {
                var lineName = extract(section.getPublishedLineName(), null);
                var dstTxt = extract(service.getDestinationText(), null);

                asset.setName(joinNonEmpty(" ", lineName, dstTxt));
            }

            leg.setAsset(asset);
            leg.setAssetId(asset.getId());
        }

        return leg;
    }

    /**
     * Converts a {@link TimedLeg} to a {@link Leg}. A TimedLeg means a leg with
     * timetabled schedule like Bus, Tram, Train,...
     *
     * @param timedLeg
     * @return
     */
    public Leg createLeg(TimedLeg timedLeg) {
        var leg = new Leg();
        var asset = new Asset().setServiceId(serviceId);

        // ### PLACE INFO ###
        // Kick of async retrieval of place creation, which involves a call to the TRIAS api for geo coordinates.
        var placeFormFuture = createPlaceAsync(timedLeg.getLegBoard());
        var placeToFuture = createPlaceAsync(timedLeg.getLegAlight());

        // ### TIME INFO ###
        leg.setStartTime(timedLeg.getLegBoard().getServiceDeparture().getTimetabledTime());
        leg.setEndTime(timedLeg.getLegAlight().getServiceArrival().getTimetabledTime());

        var service = timedLeg.getService(); // Service is not-null according to docs.

        asset.setId(service.getJourneyRef().getValue()); // JourneyRef is not-null according to docs.

        firstOf(service.getServiceSection(), section -> {
            var lineName = extract(section.getPublishedLineName());
            var dstTxt = extract(service.getDestinationText());
            asset.setName(joinNonEmpty(" ", lineName, dstTxt));
        });

        var attributes = service.getAttribute();
        if (!attributes.isEmpty()) {
            var description = attributes.stream()
                    .map(attr -> extract(attr.getText()))
                    .collect(joining("</p><p>"));

            if (isNotBlank(description)) {
                description = "<p>" + description + "</p>";
            }

            asset.setDescription(description);
        }

        Mode mode = from(timedLeg);
        asset.setMode(mode);
        leg.setMode(mode);

        // ### TRIP LENGTH ###
        ifPresent(timedLeg.getLegTrack(), track -> {
            // triplength is calculated by summing up all TrackSection lengths.
            var totalTrackLength = track.getTrackSection().stream()
                    .filter(s -> s.getLength() != null)
                    .mapToInt(s -> s.getLength().intValue())
                    .sum();

            leg.setDistanceMeter(totalTrackLength);
        });

        // ### REST OF PLACE INFO ###
        try {
            // Wait for the asynchronous creation of place data to finish and then insert the gained information...
            leg.setFrom(placeFormFuture.get().setServiceId(serviceId));
            leg.setTo(placeToFuture.get().setServiceId(serviceId));
        } catch (InterruptedException | ExecutionException ex) {
            throw internalServerError(ex, "Unable to retrieve geo location for start or end point or both.");
        }

        leg.setAsset(asset);
        leg.setAssetId(asset.getId());

        return leg;
    }

    /**
     * Converts a {@link TripLeg} to a {@link Leg}.
     *
     * @param tripLeg
     * @return
     */
    public Leg createLeg(TripLeg tripLeg) {
        if (tripLeg.getContinuousLeg() != null) {
            return createLeg(tripLeg.getContinuousLeg());
        }

        if (tripLeg.getTimedLeg() != null) {
            return TriasResponseConverter.this.createLeg(tripLeg.getTimedLeg());
        }

        return null;
    }

    public boolean canConvertTripResultToOption(TripResult tripResult) {
        // Check if any of the contained legs is NOT a walk leg.
        return tripResult.getTrip().getTripLeg().stream().anyMatch(l -> {
            if (l.getContinuousLeg() != null) {
                var service = l.getContinuousLeg().getService();

                if (service.getIndividualMode() != null
                        && service.getIndividualMode() == IndividualModesEnumeration.WALK) {
                    return false;
                } else if (service.getContinuousMode() != null
                        && service.getContinuousMode() == ContinuousModesEnumeration.WALK) {
                    return false;
                }
            }

            if (l.getInterchangeLeg() != null) {
                var leg = l.getInterchangeLeg();

                if (leg.getInterchangeMode() != null
                        && leg.getInterchangeMode() == InterchangeModesEnumeration.WALK) {
                    return false;
                } else if (leg.getContinuousMode() != null
                        && leg.getContinuousMode() == ContinuousModesEnumeration.WALK) {
                    return false;
                }
            }

            return true;
        });
    }

    /**
     * Each trip result from TRIAS represents an Option from EFS
     *
     * @param tripResult
     * @return
     */
    private Option createOption(TripResult tripResult) {

        // Initializing some one-value-arrays that will be populated in the following stream.
        var nonWalkLegsCount = new int[]{0};

        // Initialize an array of legs to collect special legs.
        // 0 = first non-walk leg, 1 = last non-walk leg, 2 = longest leg in collection
        var specialLegs = new Leg[3];

        // therefore the details about sub-legs are stored in a list and later convertet to a string which is stored in meta.other
        var legs = tripResult.getTrip().getTripLeg().stream()
                .map(this::createLeg)
                .filter(leg -> leg != null)
                .peek(leg -> {
                    if (leg.getMode() != Mode.WALK) {
                        ++nonWalkLegsCount[0];

                        // Set first leg...
                        if (specialLegs[0] == null) {
                            specialLegs[0] = leg;
                        }

                        // Set last leg... (can be same as first leg)
                        specialLegs[1] = leg;

                        // Check if current leg is longer that longest leg so far...
                        if (specialLegs[2] == null
                                || specialLegs[2].getDistanceMeter() < leg.getDistanceMeter()) {
                            specialLegs[2] = leg;
                        }
                    }
                })
                .collect(toList());

        if (nonWalkLegsCount[0] == 0) {
            return null;
        }

        var first = specialLegs[0];
        var last = specialLegs[1];
        var longest = specialLegs[2];

        // Initialize the super leg, which is the leg that spans from first to last non-walk legs.
        var superLeg = new Leg();

        // since the efsMaas  Option- Object can contain just one MainLeg (LegBaseItem) a workaround is done here 
        //assign the StartTime and OriginPlace of the first Leg to the legBaseItem
        superLeg.setStartTime(first.getStartTime());
        superLeg.setFrom(first.getFrom());

        //assign the EndTime and DestinationPlace of the last Leg to the legBaseItem
        superLeg.setEndTime(last.getEndTime());
        superLeg.setTo(last.getTo());

        superLeg.setSubLegs(legs);
        superLeg.setMode(longest.getMode());
        superLeg.setAsset(longest.getAsset());

        return new Option(serviceId, superLeg);
    }

    public List<Option> extractOptions(Trias responseTrias, Integer limitTo) {
        // Convert the trip results in parallel to options...
        var stream = responseTrias.getServiceDelivery()
                .getDeliveryPayload()
                .getTripResponse()
                .getTripResult()
                .stream()
                .filter(this::canConvertTripResultToOption);

        // If required, limit to given value.
        if (limitTo != null) {
            stream = stream.limit(limitTo);
        }

        return stream.map(this::createOption)
                .filter(opt -> opt != null)
                .collect(toList());
    }

}
