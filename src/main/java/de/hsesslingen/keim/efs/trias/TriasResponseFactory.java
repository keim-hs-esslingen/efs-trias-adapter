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
package de.hsesslingen.keim.efs.trias;

import com.fasterxml.jackson.databind.ObjectMapper;
import de.hsesslingen.keim.efs.middleware.booking.Leg;
import de.hsesslingen.keim.efs.middleware.common.LegBaseItem;
import de.hsesslingen.keim.efs.middleware.common.Options;
import de.hsesslingen.keim.efs.middleware.common.Place;
import de.hsesslingen.keim.efs.middleware.common.TypeOfAsset;
import de.hsesslingen.keim.efs.mobility.ICoordinates;
import de.hsesslingen.keim.efs.mobility.service.Mode;
import de.vdv.trias.ContinuousLegStructure;
import de.vdv.trias.GeoPositionStructure;
import static de.vdv.trias.IndividualModesEnumeration.CYCLE;
import static de.vdv.trias.IndividualModesEnumeration.MOTORCYCLE;
import static de.vdv.trias.IndividualModesEnumeration.OTHERS_DRIVE_CAR;
import static de.vdv.trias.IndividualModesEnumeration.SELF_DRIVE_CAR;
import static de.vdv.trias.IndividualModesEnumeration.TRUCK;
import de.vdv.trias.LocationRefStructure;
import de.vdv.trias.PtModesEnumeration;
import static de.vdv.trias.PtModesEnumeration.CABLEWAY;
import static de.vdv.trias.PtModesEnumeration.COACH;
import static de.vdv.trias.PtModesEnumeration.INTERCITY_RAIL;
import static de.vdv.trias.PtModesEnumeration.METRO;
import static de.vdv.trias.PtModesEnumeration.TROLLEY_BUS;
import static de.vdv.trias.PtModesEnumeration.URBAN_RAIL;
import static de.vdv.trias.PtModesEnumeration.WATER;
import de.vdv.trias.TimedLegStructure;
import de.vdv.trias.Trias;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import de.hsesslingen.keim.efs.trias.supertypes.ILegEnd;
import de.vdv.trias.IndividualModesEnumeration;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * This class creates EFS- Mobility Objects from Trias Response - Objects
 *
 * @author Ben Oesch and Emanuel Reichsöllner
 */
@Component
public class TriasResponseFactory {

    private static final Log log = LogFactory.getLog(TriasResponseFactory.class);

    @Value("${efs.mobility-service.id}")
    private String serviceId;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private TriasLocationInformationService triasLocationInformationService;

    public Place createPlaceFromLocationRef(LocationRefStructure locationRef) {
        var place = new Place();

        if (locationRef.getGeoPosition() != null) {
            place.setLat(locationRef.getGeoPosition().getLatitude());
            place.setLon(locationRef.getGeoPosition().getLongitude());
        }

        if (locationRef.getStopPointRef() != null) {
            place.setStopId(locationRef.getStopPointRef().getValue());
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

    public Place createPlaceFromStopPoint(ILegEnd legEnd, GeoPositionStructure geoPosition) {
        var place = new Place();

        if (legEnd.getStopPointRef() != null) {
            place.setStopId(legEnd.getStopPointRef().getValue());
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
        return switch (mode) {
            case BUS, TROLLEY_BUS ->
                Mode.BUS;
            case COACH ->
                Mode.BUSISH;
            case TRAM ->
                Mode.TRAM;
            case TAXI ->
                Mode.TAXI;
            case METRO ->
                Mode.SUBWAY;
            case RAIL, INTERCITY_RAIL ->
                Mode.RAIL;
            case FUNICULAR ->
                Mode.FUNICULAR;
            case WATER ->
                Mode.FERRY;
            case CABLEWAY ->
                Mode.GONDOLA;
            case URBAN_RAIL ->
                Mode.TRAINISH;
            default ->
                null;
        };
    }

    private Mode indivModeToMode(IndividualModesEnumeration mode) {
        return switch (mode) {
            case WALK ->
                Mode.WALK;
            case CYCLE, MOTORCYCLE ->
                Mode.BICYCLE;
            case TAXI ->
                Mode.TAXI;
            case SELF_DRIVE_CAR, TRUCK ->
                Mode.CAR;
            case OTHERS_DRIVE_CAR ->
                Mode.BUSISH;
            default ->
                null;
        };
    }

    private CompletableFuture<GeoPositionStructure> getGeoPositionAsync(ILegEnd legEnd) {
        return CompletableFuture.supplyAsync(() -> {
            return triasLocationInformationService.getGeoPositionFromStopPoint(legEnd.getStopPointRef());
        });
    }

    // A Trias - contninous Leg means a Leg that is not bound to a Timetable like walking, bicycle- or carride
    public Leg createLegFromContinuousLeg(ContinuousLegStructure continuousLeg) {
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
            leg.setDistance(continuousLeg.getLength().intValue());
        }

        if (continuousLeg.getService().getIndividualMode() != null) {
            leg.setMode(indivModeToMode(continuousLeg.getService().getIndividualMode()));
        }

        leg.setServiceId(serviceId);

        return leg;
    }

    // A Trias - timed Leg means a Leg with timetabled schedule like Bus, Tram, Train,...
    public Leg createLegFromTimedLeg(TimedLegStructure timedLeg) {
        var leg = new Leg();

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

        // ### PLACE INFO ###
        var legBoard = timedLeg.getLegBoard();
        var legAlight = timedLeg.getLegAlight();

        var futureBoard = getGeoPositionAsync(legBoard);
        var futureAlight = getGeoPositionAsync(legAlight);

        GeoPositionStructure startFromTrack = null;
        GeoPositionStructure endFromTrack = null;
        GeoPositionStructure startFromService = null;
        GeoPositionStructure endFromService = null;

        var track = timedLeg.getLegTrack();
        var trackSections = track != null ? track.getTrackSection() : null; //getTrackSection() never returns null.

        if (trackSections != null && !trackSections.isEmpty()) {
            // extract geo positions from track projection details.
            var section = trackSections.get(0);
            var projection = section.getProjection();

            if (projection != null && !projection.getPosition().isEmpty()) {
                var positions = projection.getPosition();
                startFromTrack = positions.get(0);
                endFromTrack = positions.get(positions.size() - 1);
            }
        }

        try {
            // Wait for the information requests to return...
            startFromService = futureBoard.get();
            endFromService = futureAlight.get();
        } catch (InterruptedException | ExecutionException ex) {
            log.error(ex);
        }

        // We prefer using the information from the service, because it's probably more accurate.
        var start = startFromService != null ? startFromService : startFromTrack;
        var end = endFromService != null ? endFromService : endFromTrack;

        // We are interested in how accurate the endings in the track projection are. Lets log the difference:
        if (log.isTraceEnabled()) {
            if (startFromService != null
                    && startFromTrack != null
                    && endFromService != null
                    && endFromTrack != null) {
                log.trace("\nDifference real track start and projection start:\n"
                        + "\tlat: " + Math.abs(startFromService.getLatitude() - startFromTrack.getLatitude())
                        + "\tlon: " + Math.abs(startFromService.getLongitude() - startFromTrack.getLongitude())
                        + "\tkm: " + ICoordinates.distanceKmBetween(startFromService, startFromTrack)
                        + "\nDifference real track end and projection end:\n"
                        + "\tlat: " + Math.abs(endFromService.getLatitude() - endFromTrack.getLatitude())
                        + "\tlon: " + Math.abs(endFromService.getLongitude() - endFromTrack.getLongitude())
                        + "\tkm: " + ICoordinates.distanceKmBetween(endFromService, endFromTrack)
                );
            } else {
                log.trace("Cannot calculate difference between real track ends and projection ends. "
                        + "At least one of the needed values is missing.");
            }
        }

        // Set the values in the leg
        leg.setFrom(createPlaceFromStopPoint(legBoard, start));
        leg.setTo(createPlaceFromStopPoint(legAlight, end));

        // ### TRIP LENGTH ###
        if (trackSections != null && !trackSections.isEmpty()) {
            // triplength is calculated by summing up all TrackSection - Length
            // if the field length is null then 0 is added
            var totalTrackLength = trackSections.stream()
                    .filter(s -> s.getLength() != null)
                    .mapToInt(s -> s.getLength().intValue())
                    .sum();

            leg.setDistance(totalTrackLength);
        }

        // ### MODE INFO ###
        var serviceSections = timedLeg.getService().getServiceSection();

        if (!serviceSections.isEmpty()) {
            leg.setMode(ptModeToMode(serviceSections.get(0).getMode().getPtMode()));
        }

        leg.setServiceId(serviceId);

        return leg;
    }

    public List<Options> extractMobilityOptionsFromTrias(Trias responseTrias) {

        // extract the Mobility - Options from responseTrias:
        var options = new ArrayList<Options>();

        for (var tripResult : responseTrias.getServiceDelivery().getDeliveryPayload().getTripResponse().getTripResult()) {
            // each tripResult from Trias represents a Mobility - Option from efsMaas
            var option = new Options();

            // each Options can store just one LegBaseItem
            var legBaseItem = new LegBaseItem();

            var meta = new TypeOfAsset();

            // Therefor the Details about subLegs are stored in a List and later convertet to a String which is stored in meta.other
            var legs = new ArrayList<Leg>();

            for (var tripLeg : tripResult.getTrip().getTripLeg()) {
                if (tripLeg.getContinuousLeg() != null) {
                    Leg leg = createLegFromContinuousLeg(tripLeg.getContinuousLeg());

                    //The Mobility Mode "WALK" should not be listest as own Mobility - Leg, even if WALK is performed with Legs :) 
                    if (leg.getMode() != Mode.WALK) {
                        legs.add(leg);
                    }
                }

                if (tripLeg.getTimedLeg() != null) {
                    Leg leg = createLegFromTimedLeg(tripLeg.getTimedLeg());

                    meta.setMode(leg.getMode());
                    meta.setName(leg.getServiceId());
                    meta.setTypeID(leg.getServiceId());
                    legs.add(leg);
                }
            }

            if (legs.size() > 0) {

                legBaseItem.setServiceId(serviceId);

                // since the efsMaas  Options- Object can contain just one Leg (LegBaseItem) a workaround is done here 
                //assign the StartTime and OriginPlace of the first Leg to the legBaseItem
                legBaseItem.setStartTime(legs.get(0).getStartTime());
                legBaseItem.setFrom(legs.get(0).getFrom());

                //assign the EndTime and DestinationPlace of the last Leg to the legBaseItem
                legBaseItem.setEndTime(legs.get(legs.size() - 1).getEndTime());
                legBaseItem.setTo(legs.get(legs.size() - 1).getTo());

                option.setLeg(legBaseItem);

                // now we are facing a problem here: the efsMaas  Options- Object can contain just one Leg (LegBaseItem) so a workaround has to be done here.
                // first we have to decide which Travel Mode should be displayed as the Main- Travelmode.
                // we use an simple solution here by assigning the Mode of the first Leg as the Main Mode. Maybe a better Solution is found here.
                meta.setMode(legs.get(0).getMode());

                // for the detailed Leg Information for the intermediate Legs we use a Sub Json which we store in the field Options-Meta-other
                // we assign "[]" that in case of an Mapping error, at least an empty JSON is returned here
                String optionsAsJsonString = "[]";

                // convert whole Leg - List  to JSON :
                try {
                    optionsAsJsonString = objectMapper.writeValueAsString(legs);
                } catch (IOException e) {

                }

                meta.setOther(optionsAsJsonString);

                log.info("subJSON##########################");
                log.info("");
                log.info(optionsAsJsonString);
                log.info("");
                option.setMeta(meta);

                options.add(option);
            }
        }

        return options;
    }

}
