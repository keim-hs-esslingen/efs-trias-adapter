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
import de.hsesslingen.keim.efs.mobility.service.Mode;
import de.vdv.trias.ContinuousLegStructure;
import de.vdv.trias.GeoPositionStructure;
import static de.vdv.trias.IndividualModesEnumeration.CYCLE;
import static de.vdv.trias.IndividualModesEnumeration.MOTORCYCLE;
import static de.vdv.trias.IndividualModesEnumeration.OTHERS_DRIVE_CAR;
import static de.vdv.trias.IndividualModesEnumeration.SELF_DRIVE_CAR;
import static de.vdv.trias.IndividualModesEnumeration.TRUCK;
import de.vdv.trias.InternationalTextStructure;
import de.vdv.trias.LocationRefStructure;
import static de.vdv.trias.PtModesEnumeration.CABLEWAY;
import static de.vdv.trias.PtModesEnumeration.COACH;
import static de.vdv.trias.PtModesEnumeration.INTERCITY_RAIL;
import static de.vdv.trias.PtModesEnumeration.METRO;
import static de.vdv.trias.PtModesEnumeration.TROLLEY_BUS;
import static de.vdv.trias.PtModesEnumeration.URBAN_RAIL;
import static de.vdv.trias.PtModesEnumeration.WATER;
import de.vdv.trias.StopPointRefStructure;
import de.vdv.trias.TimedLegStructure;
import de.vdv.trias.Trias;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

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
            place.setLat(locationRef.getGeoPosition().getLatitude().doubleValue());
            place.setLon(locationRef.getGeoPosition().getLongitude().doubleValue());
        }

        if (locationRef.getStopPointRef() != null) {
            place.setStopId(locationRef.getStopPointRef().getValue());
            // Here we face the Problem, that if a stopPointRef (StationName. StationId) is given we don't get the GeoPosition for the Station.
            // This is not very convenent for further processing and therefore we use the LocationInformationService from the Trias API to convert SationIDs to GeoPositions

            //TODO: Here seems to be a Problem     
//                GeoPositionStructure geoPosition = triasLocationInformationService.getGeoPositionFromStopPoint(locationRef.getStopPointRef());
//                if (geoPosition!=null){
//                    place.setLat(geoPosition.getLatitude().doubleValue());
//                    place.setLon(geoPosition.getLongitude().doubleValue());
//                 }
//            
        }

        if (locationRef.getLocationName() != null) {
            if (locationRef.getLocationName().get(0) != null) {
                place.setName(locationRef.getLocationName().get(0).getText());
            }
        }

        return place;
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
            switch (continuousLeg.getService().getIndividualMode()) {
                case WALK:
                    leg.setMode(Mode.WALK);
                case CYCLE:
                    leg.setMode(Mode.BICYCLE);
                case TAXI:
                    leg.setMode(Mode.TAXI);
                case SELF_DRIVE_CAR:
                    leg.setMode(Mode.CAR);
                case OTHERS_DRIVE_CAR:
                    leg.setMode(Mode.BUSISH);
                case MOTORCYCLE:
                    leg.setMode(Mode.BICYCLE);
                case TRUCK:
                    leg.setMode(Mode.CAR);
                default:
                    leg.setMode(null);
            }
        }

        leg.setServiceId(serviceId);
        
        return leg;

    }

    public Place createPlaceFromStopPoint(StopPointRefStructure stopPointRef, List<InternationalTextStructure> stopPointName) {
        var place = new Place();

        if (stopPointRef != null) {
            place.setStopId(stopPointRef.getValue());

            //place.setLat(Double.NaN)
        }

        if (stopPointName != null) {
            if (stopPointName.get(0) != null) {
                place.setName(stopPointName.get(0).getText());
                // Here we face the Problem, that for TimedLegs we only get the stopPointRef (StationName. StationId) but no GeoPosition for the Station.
                // This is not very convenent for further processing and therefore we use the LocationInformationService from the Trias API to convert SationIDs to GeoPositions
                GeoPositionStructure geoPosition = triasLocationInformationService.getGeoPositionFromStopPoint(stopPointRef);
                if (geoPosition != null) {
                    place.setLat(geoPosition.getLatitude().doubleValue());
                    place.setLon(geoPosition.getLongitude().doubleValue());
                }
            }
        }

        return place;
    }

    // A Trias - timed Leg means a Leg with timetabled schedule like Bus, Tram, Train,...
    public Leg createLegFromTimedLeg(TimedLegStructure timedLeg) {
        var leg = new Leg();

        // The Trias Object LegBoard contains Information about boarding the vehicle 
        if (timedLeg.getLegBoard().getServiceDeparture().getTimetabledTime() != null) {
            leg.setStartTime(timedLeg.getLegBoard().getServiceDeparture().getTimetabledTime().toInstant());
        }

        leg.setFrom(createPlaceFromStopPoint(timedLeg.getLegBoard().getStopPointRef(), timedLeg.getLegBoard().getStopPointName()));

        // The Trias Object LegAlight contains Information about getting off (alighting) the vehicle 
        if (timedLeg.getLegAlight().getServiceArrival().getTimetabledTime() != null) {
            leg.setEndTime(timedLeg.getLegAlight().getServiceArrival().getTimetabledTime().toInstant());
        }

        leg.setTo(createPlaceFromStopPoint(timedLeg.getLegAlight().getStopPointRef(), timedLeg.getLegAlight().getStopPointName()));

        // triplength is calculated by summing up all TrackSection - Length
        if (timedLeg.getLegTrack() != null) {
            if (timedLeg.getLegTrack().getTrackSection() != null) {
                // if the field length is null then 0 is added
                var totalTrackLength = timedLeg.getLegTrack().getTrackSection().stream().map(s -> (s.getLength() != null) ? s.getLength().intValue() : 0).reduce(0, (a, b) -> a + b);
                leg.setDistance(totalTrackLength);
            }
        }

        if (timedLeg.getService().getServiceSection().get(0) != null) {

            // set Service-ID (eg. Bus Number):
            if (timedLeg.getService().getServiceSection().get(0).getPublishedLineName().get(0) != null) {
                leg.setServiceId(timedLeg.getService().getServiceSection().get(0).getPublishedLineName().get(0).getText());
            }

            // set Mode
            switch (timedLeg.getService().getServiceSection().get(0).getMode().getPtMode()) {
                case BUS:
                    leg.setMode(Mode.BUS);
                case TROLLEY_BUS:
                    leg.setMode(Mode.BUS);
                case COACH:
                    leg.setMode(Mode.BUSISH);
                case TRAM:
                    leg.setMode(Mode.TRAM);
                case TAXI:
                    leg.setMode(Mode.TAXI);
                case METRO:
                    leg.setMode(Mode.SUBWAY);
                case RAIL:
                    leg.setMode(Mode.RAIL);
                case FUNICULAR:
                    leg.setMode(Mode.FUNICULAR);
                case WATER:
                    leg.setMode(Mode.FERRY);
                case CABLEWAY:
                    leg.setMode(Mode.GONDOLA);
                case URBAN_RAIL:
                    leg.setMode(Mode.TRAINISH);
                case INTERCITY_RAIL:
                    leg.setMode(Mode.TRAINISH);
                default:
                    leg.setMode(null);
            }
        }

        leg.setServiceId(serviceId);
        
        return leg;
    }

    public List<Options> extractMobilityOptionsFromTrias(Trias responseTrias) {

        // extract the Mobility - Options from responseTrias:
        var options = new ArrayList<Options>();

        for (var tripResult : responseTrias.getServiceDelivery().getDeliveryPayload().getTripResponse().getTripResult().stream().collect(Collectors.toList())) {
            // each tripResult from Trias represents a Mobility - Option from efsMaas
            var option = new Options();

            // each Options can store just one LegBaseItem
            var legBaseItem = new LegBaseItem();

            var meta = new TypeOfAsset();

            // Therefor the Details about subLegs are stored in a List and later convertet to a String which is stored in meta.other
            var legs = new ArrayList<Leg>();

            for (var tripLeg : tripResult.getTrip().getTripLeg().stream().collect(Collectors.toList())) {
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
