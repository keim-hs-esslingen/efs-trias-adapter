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

import static de.hsesslingen.keim.efs.adapter.trias.TriasConfig.TRIAS_VERSION;
import de.hsesslingen.keim.efs.adapter.trias.factories.GeoPositionFactory;
import de.hsesslingen.keim.efs.middleware.model.ICoordinates;
import de.hsesslingen.keim.efs.middleware.model.Place;
import de.hsesslingen.keim.efs.mobility.exception.AbstractEfsException;
import de.vdv.trias.GeoCircle;
import de.vdv.trias.GeoPosition;
import de.vdv.trias.GeoRestrictions;
import de.vdv.trias.StopPointRef;
import de.vdv.trias.Trias;
import java.math.BigInteger;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import static de.hsesslingen.keim.efs.adapter.trias.Utils.nullsafe;
import static de.hsesslingen.keim.efs.adapter.trias.factories.LocationInformationRequestFactory.byInitialInput;
import static de.hsesslingen.keim.efs.adapter.trias.factories.LocationInformationRequestFactory.byLocationRef;
import static de.hsesslingen.keim.efs.adapter.trias.factories.LocationInformationRequestFactory.byStopPointRef;
import de.hsesslingen.keim.efs.adapter.trias.factories.PlaceFactory;
import de.hsesslingen.keim.efs.middleware.provider.IPlacesService;
import de.vdv.trias.InitialLocationInput;
import de.vdv.trias.LocationInformationRequest;
import de.vdv.trias.LocationInformationResponse;
import de.vdv.trias.LocationParam;
import de.vdv.trias.LocationRef;
import de.vdv.trias.LocationResult;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.stream.Stream;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Qualifier;
import static de.hsesslingen.keim.efs.adapter.trias.factories.LocationRefFactory.from;
import de.hsesslingen.keim.efs.adapter.trias.factories.TriasServiceRequest;
import static org.slf4j.LoggerFactory.getLogger;

/**
 * The class TriasLocationInformationService is a Service to covert public
 * transport Stationnames to GeoPostions
 *
 * @author Ben Oesch and Emanuel Reichsöllner
 */
@Service
public class TriasLocationInformationService implements IPlacesService<TriasCredentials> {

    private static final Logger logger = getLogger(TriasLocationInformationService.class);

    @Value("${trias.api-user-reference}")
    private String apiUserReference;

    @Value("${trias.defaults.place-search-radius-meter:500}")
    private int defaultSearchRadius;

    @Autowired
    private TriasProxy proxy;

    @Autowired
    @Qualifier("trias-parallel-request-thread-pool")
    private ExecutorService executor;

    public Trias createInfoRequest(LocationInformationRequest request) {
        return new TriasServiceRequest(TRIAS_VERSION, apiUserReference).locationInformationRequest(request);
    }

    public Trias createInfoRequest(StopPointRef stopPointRef) {
        return createInfoRequest(byStopPointRef(stopPointRef));
    }

    public Trias createInfoRequest(LocationRef locationRef) {
        return createInfoRequest(byLocationRef(locationRef));
    }

    public Trias createInfoRequest(LocationRef locationRef, LocationParam restrictions) {
        return createInfoRequest(byLocationRef(locationRef, restrictions));
    }

    /**
     * In the Method getGeoPositionFromStopPoint a API - call is performed to
     * convert a stopPointRef (eg. Stationname) to a GeoPosition
     *
     * @param stopPointRef
     * @return GeoPosition
     * @throws AbstractEfsException
     */
    public GeoPosition getGeoPositionFromStopPoint(StopPointRef stopPointRef) throws AbstractEfsException {

        Trias locationRequestTrias = TriasLocationInformationService.this.createInfoRequest(stopPointRef);

        Trias responseLocationTrias = proxy.send(locationRequestTrias);

        if (responseLocationTrias == null) {
            return null;
        }

        var locationRes = responseLocationTrias.getServiceDelivery().getDeliveryPayload().getLocationInformationResponse().getLocationResult();

        if (locationRes != null) {
            if (locationRes.get(0) != null) {
                return locationRes.get(0).getLocation().getGeoPosition();
            }
        }

        return null;
    }

    private <R> Future<R> asyncFuture(Callable<R> callable) {
        return executor.submit(callable);
    }

    private GeoRestrictions createCircleGeoRestrictions(ICoordinates circleCenter, Integer radiusMeter) {
        GeoRestrictions restrictions = null;

        if (circleCenter != null) {
            var radius = radiusMeter != null ? radiusMeter : defaultSearchRadius;

            var circle = new GeoCircle();
            circle.setCenter(GeoPositionFactory.create(circleCenter));
            circle.setRadius(BigInteger.valueOf(radius));

            restrictions = new GeoRestrictions().setCircle(circle);
        }

        return restrictions;
    }

    @Override
    public List<Place> search(String query, ICoordinates areaCenter, Integer radiusMeter, Integer limitTo, TriasCredentials credentials) {

        GeoRestrictions restrictions = createCircleGeoRestrictions(areaCenter, radiusMeter);

        // Query TRIAS api for location information:
        // First we need to query it for some initial input based on a search string...
        Stream<LocationResult> initialResults;

        // If limitTo is given, use that as limiter, otherwise simply limit to 1 request for initial results.
        if (limitTo != null) {
            initialResults = queryInitialLocationInformation(query, null, restrictions).limit(limitTo);
        } else {
            initialResults = queryInitialLocationInformation(query, null, restrictions, 1);
        }

        // The initial results do not contain much information.
        // Therefore we request more information about each of the result locations.
        // We do this in asynchronously so the source stream does not wait for the results
        // to be retrieved from the API but keeps asking for more initial results if necessary.
        var futures = initialResults
                // The following map function returns a future that is collected in a list.
                // In a second stream, these futures are resolved using the get() method.
                .map(result -> asyncFuture(() -> getLocationInformation(from(result.getLocation()), null)))
                .collect(Collectors.toList());

        // Resolve futures with more information about result locations.
        // The resolved results are covnerted to places on the fly.
        var places = futures.stream()
                .map(future -> {
                    try {
                        return future.get();
                    } catch (InterruptedException | ExecutionException ex) {
                        return null;
                    }
                })
                // Filter null values due to exceptions in previous map function...
                .filter(result -> result != null)
                // Map to contained object and filter again for null results...
                .map(result -> result.getLocation())
                .filter(location -> location != null)
                // Convert location result to place...
                .map(location -> PlaceFactory.fromLocation(location))
                .collect(Collectors.toList());

        return places;
    }

    private LocationResult getLocationInformation(LocationRef reference, LocationParam restrictions) {

        var request = TriasLocationInformationService.this.createInfoRequest(reference, restrictions);

        var response = proxy.send(request);

        var result = nullsafe(() -> response.getServiceDelivery().getDeliveryPayload().getLocationInformationResponse().getLocationResult().get(0));

        logger.trace("Received location information for location ref:\n{}\n{}", reference, result);

        return result;
    }

    /**
     * Creates a stream of location information responses by sending more and
     * more Trias location information requests one after the other using the
     * ContinueAt mechanism. The resulting stream can be flatmapped to the
     * actual results.
     *
     * @param searchText
     * @param geoPos
     * @param restrictions
     * @return
     */
    private Stream<LocationInformationResponse> initialLocationInformationStream(
            String searchText, GeoPosition geoPos, GeoRestrictions restrictions
    ) {
        logger.debug("Requesting initial location information for search text \"{}\".", searchText);

        var initialInput = new InitialLocationInput();

        initialInput.setLocationName(searchText);
        initialInput.setGeoPosition(geoPos);
        initialInput.setGeoRestriction(restrictions);

        var params = new LocationParam();

        var request = createInfoRequest(byInitialInput(initialInput, params));

        var requests = new ContinuousTriasRequests(proxy, request,
                previousResponse -> {
                    var continueAtValue = nullsafe(()
                            -> previousResponse.getServiceDelivery()
                            .getDeliveryPayload()
                            .getLocationInformationResponse()
                            .getContinueAt()
                    );

                    if (continueAtValue == null) {
                        return false;
                    }

                    params.setContinueAt(continueAtValue);
                    return true;
                }
        );

        var stream = requests.stream()
                .map(response -> nullsafe(()
                -> response
                        .getServiceDelivery()
                        .getDeliveryPayload()
                        .getLocationInformationResponse())
                )
                .filter(value -> value != null);

        // Log some debug stuff if enabled...
        if (logger.isDebugEnabled()) {
            stream = stream.peek(response -> {
                var locRes = response.getLocationResult();

                if (locRes == null) {
                    if (response.getErrorMessage() != null && !response.getErrorMessage().isEmpty()) {
                        final var error = response.getErrorMessage().get(0);
                        logger.debug("Received a null list as result for search text \"{}\" with continueAt={}. Error={}",
                                searchText, response.getContinueAt(),
                                // Get potential error safely...
                                nullsafe(() -> error.getText().get(0).getText()));
                    } else {
                        logger.debug("Received a null list as result for search text \"{}\" with continueAt={}. No error provided.",
                                searchText, response.getContinueAt());
                    }
                } else {
                    logger.debug("Received {} initial location information results for search text \"{}\" with continueAt={}.",
                            locRes.size(), searchText, response.getContinueAt());
                }
            });
        }

        return stream;
    }

    /**
     * Keeps querying the Trias API for more and more location results matching
     * the given input, until either the stream stops taking, or no more results
     * are provided from the API.
     *
     * @param searchText
     * @param geoPos
     * @param restrictions
     * @return
     */
    public Stream<LocationResult> queryInitialLocationInformation(
            String searchText, GeoPosition geoPos, GeoRestrictions restrictions
    ) {
        return initialLocationInformationStream(searchText, geoPos, restrictions)
                .map(locResponse -> locResponse.getLocationResult())
                .filter(value -> value != null)
                .flatMap(resultList -> resultList.stream());
    }

    /**
     * Keeps querying the Trias API for more and more location results matching
     * the given input, until either the stream stops taking, or the limited
     * number of requests has been sent.
     *
     * @param searchText
     * @param geoPos
     * @param restrictions
     * @param requestLimit The number of requests to send at most.
     * @return
     */
    public Stream<LocationResult> queryInitialLocationInformation(
            String searchText, GeoPosition geoPos,
            GeoRestrictions restrictions, long requestLimit
    ) {
        return initialLocationInformationStream(searchText, geoPos, restrictions)
                .limit(requestLimit)
                .map(locResponse -> locResponse.getLocationResult())
                .filter(value -> value != null)
                .flatMap(resultList -> resultList.stream());
    }

}
