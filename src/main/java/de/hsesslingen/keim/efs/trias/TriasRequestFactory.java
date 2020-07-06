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

import de.hsesslingen.keim.efs.middleware.common.Place;
import de.vdv.trias.GeoPositionStructure;
import de.vdv.trias.InitialLocationInputStructure;
import de.vdv.trias.LocationContextStructure;
import de.vdv.trias.LocationInformationRequestStructure;
import de.vdv.trias.LocationRefStructure;
import de.vdv.trias.PtModeFilterStructure;
import de.vdv.trias.RequestPayloadStructure;
import de.vdv.trias.ServiceRequestStructure;
import de.vdv.trias.StopPointRefStructure;
import de.vdv.trias.Trias;
import de.vdv.trias.TripParamStructure;
import de.vdv.trias.TripRequestStructure;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import uk.org.siri.siri.ParticipantRefStructure;

/**
 * This class creates Trias Request - Objects from input - parameters and
 * constant values from application,yml
 *
 * @author Ben Oesch and Emanuel Reichsöllner
 */
@Component
public class TriasRequestFactory {

    @Value("${trias.number-of-results}")
    private String numberOfResults;

    @Value("${trias.trias-version}")
    private String triasVersion;

    @Value("${trias.api-user-reference}")
    private String apiUserReference;

    public Trias createBaseRequestTrias() {
        var baseRequestTrias = new Trias();

        // to set the Version is important, otherwise the API will return null 
        baseRequestTrias.setVersion(triasVersion);

        var requestPayLoad = new RequestPayloadStructure();
        var serviceRequest = new ServiceRequestStructure();

        serviceRequest.setRequestPayload(requestPayLoad);
        //set current TimeStamp
        serviceRequest.setRequestTimestamp(ZonedDateTime.now());

        var requestorRef = new ParticipantRefStructure();

        // the API Maintainer want to know how is requesting
        requestorRef.setValue(apiUserReference);
        serviceRequest.setRequestorRef(requestorRef);
        baseRequestTrias.setServiceRequest(serviceRequest);

        return baseRequestTrias;
    }

    public Trias buildTripRequestTrias(Place from, Place to, Instant startTime, Instant endTime) {

        var tripRequest = new TripRequestStructure();

        var origin = new LocationContextStructure();
        var locationRefOrigin = new LocationRefStructure();
        var geoPositionOrigin = new GeoPositionStructure();
        geoPositionOrigin.setLatitude(new BigDecimal(from.getLat()));
        geoPositionOrigin.setLongitude(new BigDecimal(from.getLon()));
        locationRefOrigin.setGeoPosition(geoPositionOrigin);
        origin.setLocationRef(locationRefOrigin);

        // The Departure- and ArrivalTime can be specified in the Origin / Destination  (LocationRefStructure)
        // If there is both a Departure- and an ArrivalTime defined then the  DepartureTime is fully ignored
        if (startTime != null) {
            origin.setDepArrTime(startTime.atZone(ZoneId.of("Europe/Berlin")));
        }

        // Note from the documentation: Usually there's only one origin and one destination object.
        // Only in case you want to provide multiple origins and destinations with individual time stamps,
        // you can add all of those in to this list. The server will then choose the best fit.
        tripRequest.getOrigin().add(origin);

        var destination = new LocationContextStructure();
        var locationRefDestination = new LocationRefStructure();
        var geoPositionDestination = new GeoPositionStructure();

//        if (to == null) {
//            geoPositionDestination.setLatitude(new BigDecimal(49.414072));
//            geoPositionDestination.setLongitude(new BigDecimal(8.717618));
//        } else {
        geoPositionDestination.setLatitude(new BigDecimal(to.getLat()));
        geoPositionDestination.setLongitude(new BigDecimal(to.getLon()));
//        }

        locationRefDestination.setGeoPosition(geoPositionDestination);
        destination.setLocationRef(locationRefDestination);

        // The Departure- and ArrivalTime can be specified in the Origin / Destination  (LocationRefStructure)
        // If there is both a Departure- and an ArrivalTime defined then the  DepartureTime is fully ignored
        if (endTime != null) {
            destination.setDepArrTime(endTime.atZone(ZoneId.of("Europe/Berlin")));
        }

        tripRequest.getDestination().add(destination);

        var ptModeFilter = new PtModeFilterStructure();
        ptModeFilter.setExclude(Boolean.TRUE);

        var params = new TripParamStructure();

        params.setPtModeFilter(ptModeFilter);
        params.setIncludeFares(Boolean.TRUE);
        params.setImmediateTripStart(Boolean.FALSE);
        params.setIncludeIntermediateStops(Boolean.FALSE);
        params.setIncludeLegProjection(Boolean.FALSE);
        params.setIncludeTrackSections(Boolean.TRUE);
        params.setNumberOfResults(new BigInteger(numberOfResults));
        tripRequest.setParams(params);

        var tripRequestTrias = createBaseRequestTrias();

        tripRequestTrias.getServiceRequest().getRequestPayload().setTripRequest(tripRequest);

        return tripRequestTrias;
    }

    public Trias buildLocationRequestTrias(StopPointRefStructure stopPointRef) {
        var locationInformationRequest = new LocationInformationRequestStructure();

        var initialInput = new InitialLocationInputStructure();

        // LocationName is very general like a Search  Engine Input String  (like Streetname, Point of Interest,...) to find a certain Location
        // In this case we use as Input Sring for the built in Serach Engine the StopPointRef an we hope that the GeoPositon is found (therefore the nullPpinter check for the return Statement
        initialInput.setLocationName(stopPointRef.getValue());

        locationInformationRequest.setInitialInput(initialInput);

        var locationRequestTrias = createBaseRequestTrias();

        locationRequestTrias.getServiceRequest().getRequestPayload().setLocationInformationRequest(locationInformationRequest);

        return locationRequestTrias;

    }

}
