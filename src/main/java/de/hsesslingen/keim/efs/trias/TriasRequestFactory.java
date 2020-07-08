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
import de.hsesslingen.keim.efs.middleware.exception.MissingConfigParamException;
import de.hsesslingen.keim.efs.trias.factories.LocationContextStructureBuilder;
import de.hsesslingen.keim.efs.trias.factories.LocationRefStructureFactory;
import de.hsesslingen.keim.efs.trias.factories.TripParamStructureBuilder;
import de.hsesslingen.keim.efs.trias.factories.TripRequestStructureBuilder;
import de.vdv.trias.InitialLocationInputStructure;
import de.vdv.trias.LocationInformationRequestStructure;
import de.vdv.trias.PtModeFilterStructure;
import de.vdv.trias.RequestPayloadStructure;
import de.vdv.trias.ServiceRequestStructure;
import de.vdv.trias.StopPointRefStructure;
import de.vdv.trias.Trias;
import de.vdv.trias.TripRequestStructure;
import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import javax.annotation.PostConstruct;
import org.apache.commons.lang.StringUtils;
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

    @Value("${trias.number-of-results:5}")
    private long numberOfResults;

    @Value("${trias.trias-version}")
    private String triasVersion;

    @Value("${trias.api-user-reference}")
    private String apiUserReference;

    @PostConstruct
    private void init() {
        if (StringUtils.isBlank(triasVersion)) {
            throw new MissingConfigParamException("trias.triasVersion");
        }

        if (StringUtils.isBlank(apiUserReference)) {
            throw new MissingConfigParamException("trias.api-user-reference");
        }
    }

    public Trias createBaseRequestTrias() {
        var baseRequestTrias = new Trias();

        // to set the Version is important, otherwise the API will return null 
        baseRequestTrias.setVersion(triasVersion);

        var serviceRequest = new ServiceRequestStructure();

        serviceRequest.setRequestPayload(new RequestPayloadStructure());

        //set current TimeStamp
        serviceRequest.setRequestTimestamp(ZonedDateTime.now());

        // the API Maintainer want to know who is requesting
        serviceRequest.setRequestorRef(new ParticipantRefStructure());
        serviceRequest.getRequestorRef().setValue(apiUserReference);

        baseRequestTrias.setServiceRequest(serviceRequest);

        return baseRequestTrias;
    }

    public TripRequestStructure createTripRequestStructure(Place from, Place to, Instant startTime, Instant endTime) {

        var origin = new LocationContextStructureBuilder()
                .locationRef(LocationRefStructureFactory.fromCoordinates(from))
                .depArrTime(startTime.atZone(ZoneId.of("Europe/Berlin")))
                .build();

        var destination = new LocationContextStructureBuilder()
                .locationRef(LocationRefStructureFactory.fromCoordinates(to))
                .depArrTime(endTime.atZone(ZoneId.of("Europe/Berlin")))
                .build();

        var ptModeFilter = new PtModeFilterStructure();
        ptModeFilter.setExclude(true);

        var params = new TripParamStructureBuilder()
                .ptModeFilter(ptModeFilter)
                .includeFares(true)
                .immediateTripStart(false)
                .includeIntermediateStops(false)
                .includeLegProjection(false)
                .includeTrackSections(true)
                .numberOfResults(numberOfResults)
                .build();

        return new TripRequestStructureBuilder()
                .origin(origin)
                .destination(destination)
                .params(params)
                .build();
    }

    public Trias buildTripRequestTrias(Place from, Place to, Instant startTime, Instant endTime) {
        var tripRequest = createTripRequestStructure(from, to, startTime, endTime);

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
