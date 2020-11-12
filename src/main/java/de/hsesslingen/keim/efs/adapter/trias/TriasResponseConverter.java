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

import com.fasterxml.jackson.databind.ObjectMapper;
import de.hsesslingen.keim.efs.middleware.model.Leg;
import de.hsesslingen.keim.efs.middleware.model.Option;
import de.hsesslingen.keim.efs.middleware.model.Place;
import de.hsesslingen.keim.efs.mobility.exception.HttpException;
import de.hsesslingen.keim.efs.mobility.service.Mode;
import de.vdv.trias.ContinuousLeg;
import de.vdv.trias.GeoPosition;
import static de.vdv.trias.IndividualModesEnumeration.CYCLE;
import static de.vdv.trias.IndividualModesEnumeration.MOTORCYCLE;
import static de.vdv.trias.IndividualModesEnumeration.OTHERS_DRIVE_CAR;
import static de.vdv.trias.IndividualModesEnumeration.SELF_DRIVE_CAR;
import static de.vdv.trias.IndividualModesEnumeration.TRUCK;
import de.vdv.trias.LocationRef;
import de.vdv.trias.PtModesEnumeration;
import static de.vdv.trias.PtModesEnumeration.CABLEWAY;
import static de.vdv.trias.PtModesEnumeration.COACH;
import static de.vdv.trias.PtModesEnumeration.INTERCITY_RAIL;
import static de.vdv.trias.PtModesEnumeration.METRO;
import static de.vdv.trias.PtModesEnumeration.TROLLEY_BUS;
import static de.vdv.trias.PtModesEnumeration.URBAN_RAIL;
import static de.vdv.trias.PtModesEnumeration.WATER;
import de.vdv.trias.TimedLeg;
import de.vdv.trias.Trias;
import java.io.IOException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import de.hsesslingen.keim.efs.adapter.trias.supertypes.ILegEnd;
import de.hsesslingen.keim.efs.middleware.model.Asset;
import de.vdv.trias.ContinuousModesEnumeration;
import de.vdv.trias.IndividualModesEnumeration;
import de.vdv.trias.InterchangeModesEnumeration;
import de.vdv.trias.TripLeg;
import de.vdv.trias.TripResult;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import static java.util.stream.Collectors.toList;
import org.slf4j.Logger;
import static org.slf4j.LoggerFactory.getLogger;

/**
 * This class creates EFS- Mobility Objects from Trias Response - Objects
 *
 * @author Ben Oesch and Emanuel Reichsöllner
 */
@Component
public class TriasResponseConverter {

    private static final Logger logger = getLogger(TriasResponseConverter.class);

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private TriasLocationInformationService triasLocationInformationService;

    public Place createPlaceFromLocationRef(LocationRef locationRef) {
        var place = new Place();

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

    public Place createPlaceFromStopPoint(ILegEnd legEnd) {
        var pos = triasLocationInformationService.getGeoPositionFromStopPoint(legEnd.getStopPointRef());
        return createPlaceFromStopPoint(legEnd, pos);
    }

    public Place createPlaceFromStopPoint(ILegEnd legEnd, GeoPosition geoPosition) {
        var place = new Place();

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

    private Mode ptModeToMode(PtModesEnumeration mode) {
        switch (mode) {
            case BUS:
            case TROLLEY_BUS:
                return Mode.BUS;
            case COACH:
                return Mode.BUSISH;
            case TRAM:
                return Mode.TRAM;
            case TAXI:
                return Mode.TAXI;
            case METRO:
                return Mode.SUBWAY;
            case RAIL:
            case INTERCITY_RAIL:
                return Mode.RAIL;
            case FUNICULAR:
                return Mode.FUNICULAR;
            case WATER:
                return Mode.FERRY;
            case CABLEWAY:
                return Mode.GONDOLA;
            case URBAN_RAIL:
                return Mode.TRAINISH;
            default:
                return null;
        }
    }

    private Mode indivModeToMode(IndividualModesEnumeration mode) {
        switch (mode) {
            case WALK:
                return Mode.WALK;
            case CYCLE:
            case MOTORCYCLE:
                return Mode.BICYCLE;
            case TAXI:
                return Mode.TAXI;
            case SELF_DRIVE_CAR:
            case TRUCK:
                return Mode.CAR;
            case OTHERS_DRIVE_CAR:
                return Mode.BUSISH;
            default:
                return null;
        }
    }

    private CompletableFuture<Place> createPlaceFromLegEndAsync(ILegEnd legEnd) {
        return CompletableFuture.supplyAsync(() -> {
            // First get the geo coordinates from the server.
            var geoPos = triasLocationInformationService.getGeoPositionFromStopPoint(legEnd.getStopPointRef());
            // The convert it to a place.
            return createPlaceFromStopPoint(legEnd, geoPos);
        });
    }

    // A Trias - contninous Leg means a Leg that is not bound to a Timetable like walking, bicycle- or carride
    public Leg createLegFromContinuousLeg(ContinuousLeg continuousLeg) {
        var leg = new Leg();

        // origin Time 
        if (continuousLeg.getTimeWindowStart() != null) {
            leg.setStartTime(continuousLeg.getTimeWindowStart().toInstant());
        }

        // origin Place
        if (continuousLeg.getLegStart() != null) {
            leg.setFrom(createPlaceFromLocationRef(continuousLeg.getLegStart()));
        }

        // destination Time
        if (continuousLeg.getTimeWindowEnd() != null) {
            leg.setEndTime(continuousLeg.getTimeWindowEnd().toInstant());
        }

        //destination Place
        if (continuousLeg.getLegEnd() != null) {
            leg.setTo(createPlaceFromLocationRef(continuousLeg.getLegEnd()));
        }

        // triplength
        if (continuousLeg.getLength() != null) {
            leg.setDistanceMeter(continuousLeg.getLength().intValue());
        }

        if (continuousLeg.getService().getIndividualMode() != null) {
            leg.setMode(indivModeToMode(continuousLeg.getService().getIndividualMode()));
        }

        return leg;
    }

    // A Trias - timed Leg means a Leg with timetabled schedule like Bus, Tram, Train,...
    public Leg createLegFromTimedLeg(TimedLeg timedLeg) {
        var leg = new Leg();

        // ### PLACE INFO ###
        // Kick of async retrieval of place creation, which involves a call to the TRIAS api for geo coordinates.
        var futureBoard = createPlaceFromLegEndAsync(timedLeg.getLegBoard());
        var futureAlight = createPlaceFromLegEndAsync(timedLeg.getLegAlight());

        // ### TIME INFO ###
        // The Trias Object LegBoard contains Information about boarding the vehicle 
        var departure = timedLeg.getLegBoard().getServiceDeparture().getTimetabledTime();
        if (departure != null) {
            leg.setStartTime(departure.toInstant());
        }

        // The Trias Object LegAlight contains Information about getting off (alighting) the vehicle 
        var arrival = timedLeg.getLegAlight().getServiceArrival().getTimetabledTime();
        if (arrival != null) {
            leg.setEndTime(arrival.toInstant());
        }

        // ### TRIP LENGTH ###
        var trackSections = timedLeg.getLegTrack().getTrackSection();

        if (trackSections != null && !trackSections.isEmpty()) {
            // triplength is calculated by summing up all TrackSection - Length
            // if the field length is null then 0 is added
            var totalTrackLength = trackSections.stream()
                    .filter(s -> s.getLength() != null)
                    .mapToInt(s -> s.getLength().intValue())
                    .sum();

            leg.setDistanceMeter(totalTrackLength);
        }

        // ### MODE INFO ###
        var serviceSections = timedLeg.getService().getServiceSection();

        if (!serviceSections.isEmpty()) {
            leg.setMode(ptModeToMode(serviceSections.get(0).getMode().getPtMode()));
        }

        // ### REST OF PLACE INFO ###
        try {
            // Wait for the asynchronous creation of place data to finish and then insert the gained information...
            leg.setFrom(futureBoard.get());
            leg.setTo(futureAlight.get());
        } catch (InterruptedException | ExecutionException ex) {
            throw HttpException.internalServerError(ex, "Unable to retrieve geo location data for start and end points.");
        }

        return leg;
    }

    private Leg createLegFromTripLeg(TripLeg tripLeg) {
        if (tripLeg.getContinuousLeg() != null) {
            return createLegFromContinuousLeg(tripLeg.getContinuousLeg());
        }

        if (tripLeg.getTimedLeg() != null) {
            return createLegFromTimedLeg(tripLeg.getTimedLeg());
        }

        return null;
    }

    Leg getLastNonWalkLeg(List<Leg> legs) {
        // First try the very last one...
        Leg res = legs.get(legs.size() - 1);

        if (res.getMode() != Mode.WALK) {
            return res;
        }

        //If that did work, create a list iterator and walk backwards from the end.
        var lit = legs.listIterator(legs.size() - 1);

        do {
            res = lit.previous();
        } while (res.getMode() == Mode.WALK);

        return res;
    }

    /**
     * if the MobilityOption contains more than one Leg with different
     * TravelModes we assign the TravelMode of the Leg with the longest Distance
     * as MainMode
     *
     * @param legs
     * @return
     */
    public Mode assignMainMode(List<Leg> legs) {

        // set Mode.WALK as default Mode if no other Mode can be assigned
        Mode mainMode = Mode.WALK;

        int longestDistance = 0;

        for (Leg leg : legs) {
            if (leg.getDistanceMeter() != null) {
                if (leg.getDistanceMeter() > longestDistance) {
                    mainMode = leg.getMode();
                    longestDistance = leg.getDistanceMeter();
                }
            }
        }
        return mainMode;
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
    private Option createOptionFromTripResult(TripResult tripResult) {

        // each option can store just one LegBaseItem
        var mainLeg = new Leg();

        var asset = new Asset();

        // therefore the details about sub-legs are stored in a list and later convertet to a string which is stored in meta.other
        var legs = tripResult.getTrip().getTripLeg().stream()
                .map(this::createLegFromTripLeg)
                .filter(leg -> leg != null)
                .collect(toList());

        if (!legs.isEmpty()) {
            // Get the first leg that is not WALK:
            var firstOpt = legs.stream()
                    .filter(l -> l.getMode() != Mode.WALK)
                    .findFirst();

            if (!firstOpt.isPresent()) {
                // If we don't have any NON-walk legs, return null!
                return null;
            }

            var first = firstOpt.get();

            // Get the last leg that is not WALK:
            var last = getLastNonWalkLeg(legs);

            // since the efsMaas  Option- Object can contain just one MainLeg (LegBaseItem) a workaround is done here 
            //assign the StartTime and OriginPlace of the first Leg to the legBaseItem
            mainLeg.setStartTime(first.getStartTime());
            mainLeg.setFrom(first.getFrom());

            //assign the EndTime and DestinationPlace of the last Leg to the legBaseItem
            mainLeg.setEndTime(last.getEndTime());
            mainLeg.setTo(last.getTo());

            // now we are facing a problem here: the efsMaas  Option- Object can contain just one MainLeg (LegBaseItem) so a workaround has to be done here.
            // first we have to decide which Travel Mode should be displayed as the Main- Travelmode.
            // we call the Method assignMainMode() which assigns from several Legs the Mode of the Leg with the longest Distance as MainMode
            Mode mainMode = assignMainMode(legs);

            asset.setMode(mainMode);
            mainLeg.setMode(mainMode);

            // for the detailed Leg Information for the intermediate Legs we use a Sub Json which we store in the field Option-Meta-other
            // we assign "[]" that in case of an Mapping error, at least an empty JSON is returned here
            String optionsAsJsonString = "[]";

            // convert whole Leg - List (including WALK - Legs) to JSON :
            try {
                optionsAsJsonString = objectMapper.writeValueAsString(legs);
            } catch (IOException e) {

            }

            // assign the whole Leg - List as subJSON to the field meta.other
            asset.setOther(optionsAsJsonString);

            logger.trace("Sub-Legs: " + optionsAsJsonString);
        }

        mainLeg.setAsset(asset);

        return new Option(mainLeg);
    }

    public List<Option> extractMobilityOptionsFromTrias(Trias responseTrias, Integer limitTo) {
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

        return stream.map(this::createOptionFromTripResult)
                .filter(opt -> opt != null)
                .collect(toList());
    }

}
