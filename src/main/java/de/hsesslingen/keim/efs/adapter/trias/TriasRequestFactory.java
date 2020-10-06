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

import de.hsesslingen.keim.efs.middleware.model.Place;
import de.hsesslingen.keim.efs.middleware.exception.MissingConfigParamException;
import de.hsesslingen.keim.efs.adapter.trias.factories.LocationInformationRequestFactory;
import static de.hsesslingen.keim.efs.adapter.trias.factories.LocationRefFactory.fromPlace;
import de.hsesslingen.keim.efs.adapter.trias.factories.TriasServiceRequest;
import de.hsesslingen.keim.efs.adapter.trias.factories.TripParamBuilder;
import de.hsesslingen.keim.efs.adapter.trias.factories.TripRequestBuilder;
import de.vdv.trias.LocationContext;
import de.vdv.trias.StopPointRef;
import de.vdv.trias.Trias;
import de.vdv.trias.TripRequest;
import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

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

    @Value("${trias.provider-time-zone-id:}")
    private String providerTimeZoneIdStr;
    private ZoneId providerTimeZoneId;

    @PostConstruct
    private void init() {
        if (triasVersion == null || triasVersion.isBlank()) {
            throw new MissingConfigParamException("trias.triasVersion");
        }

        if (apiUserReference == null || apiUserReference.isBlank()) {
            throw new MissingConfigParamException("trias.api-user-reference");
        }

        if (providerTimeZoneIdStr == null || providerTimeZoneIdStr.isBlank()) {
            providerTimeZoneId = ZoneId.systemDefault();
        } else {
            providerTimeZoneId = ZoneId.of(providerTimeZoneIdStr);
        }
    }

    public TriasServiceRequest newTriasServiceRequest() {
        return new TriasServiceRequest(triasVersion, apiUserReference);
    }

    public TripRequest createTripRequestPayload(Place from, Place to, Instant startTime, Instant endTime) {
        return TriasRequestFactory.this.createTripRequestPayload(
                from,
                to,
                startTime != null ? startTime.atZone(providerTimeZoneId) : null,
                endTime != null ? endTime.atZone(providerTimeZoneId) : null
        );
    }

    public TripRequest createTripRequestPayload(Place from, Place to, ZonedDateTime startTime, ZonedDateTime endTime) {
        return new TripRequestBuilder()
                .origin(new LocationContext()
                        .setLocationRef(fromPlace(from))
                        .setDepArrTime(startTime))
                .destination(new LocationContext()
                        .setLocationRef(fromPlace(to))
                        .setDepArrTime(endTime))
                .params(new TripParamBuilder()
                        .ptModeFilterByExclude(true)
                        .includeFares(true)
                        .immediateTripStart(false)
                        .includeIntermediateStops(false)
                        .includeLegProjection(true)
                        .includeTrackSections(true)
                        .numberOfResults(numberOfResults)
                        .build())
                .build();
    }

    public Trias createTripRequest(Place from, Place to, ZonedDateTime startTime, ZonedDateTime endTime) {
        return new TriasServiceRequest(triasVersion, apiUserReference)
                .tripRequest(createTripRequestPayload(from, to, startTime, endTime));
    }

    public Trias createLocationInformationRequest(StopPointRef stopPointRef) {
        return newTriasServiceRequest().locationInformationRequest(
                LocationInformationRequestFactory.byStopPointRef(stopPointRef)
        );
    }

}
