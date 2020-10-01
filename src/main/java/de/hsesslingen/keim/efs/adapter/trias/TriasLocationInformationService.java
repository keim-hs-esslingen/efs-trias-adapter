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
import de.hsesslingen.keim.efs.middleware.provider.IPlacesService;
import de.vdv.trias.InitialLocationInput;
import de.vdv.trias.LocationInformationResponse;
import de.vdv.trias.LocationParam;
import de.vdv.trias.LocationResult;
import java.util.stream.Stream;

/**
 * The class TriasLocationInformationService is a Service to covert public
 * transport Stationnames to GeoPostions
 *
 * @author Ben Oesch and Emanuel Reichsöllner
 */
@Service
public class TriasLocationInformationService implements IPlacesService<TriasCredentials> {

    @Value("${trias.defaults.place-search-radius-meter:500}")
    private int defaultSearchRadius;

    @Value("${trias.icon-urls.default-stop-place:}")
    private String stopPlaceIconUrl;

    @Autowired
    private TriasRequestFactory requestFactory;

    @Autowired
    private TriasProxy proxy;

    /**
     * In the Method getGeoPositionFromStopPoint a API - call is performed to
     * convert a stopPointRef (eg. Stationname) to a GeoPosition
     *
     * @param stopPointRef
     * @return GeoPosition
     * @throws AbstractEfsException
     */
    public GeoPosition getGeoPositionFromStopPoint(StopPointRef stopPointRef) throws AbstractEfsException {

        Trias locationRequestTrias = requestFactory.createLocationInformationRequest(stopPointRef);

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

    @Override
    public List<Place> search(String query, ICoordinates areaCenter, Integer radiusMeter, TriasCredentials credentials) {

        GeoRestrictions restrictions = null;

        if (areaCenter != null) {
            var radius = radiusMeter != null ? radiusMeter : defaultSearchRadius;

            var circle = new GeoCircle();
            circle.setCenter(GeoPositionFactory.create(areaCenter));
            circle.setRadius(BigInteger.valueOf(radius));

            restrictions = new GeoRestrictions();
            restrictions.setCircle(circle);
        }

        // Query TRIAS api for some initial results...
        var results = queryInitialLocationInformation(query, null, restrictions, 2)
                .limit(5)
                .collect(Collectors.toList());

        var places = results.stream()
                .map(locRes -> locRes.getLocation())
                .filter(location -> location != null)
                .map(location -> {
                    var place = new Place();

                    place.setCoordinates(location.getGeoPosition());

                    // StopPlace represent the stop location in general.
                    place.setName(nullsafe(() -> location.getStopPlace().getStopPlaceName().get(0).getText()));
                    place.setPlaceId(nullsafe(() -> location.getStopPlace().getStopPlaceRef().getValue()));
                    // StopPoint represents the exact stop point at the location, e.g. at which platform the train departs.
                    place.setStopId(nullsafe(() -> location.getStopPoint().getStopPointRef().getValue()));

                    place.setIconUrl(stopPlaceIconUrl);

                    return place;
                })
                .collect(Collectors.toList());

        return places;
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
        var initialInput = new InitialLocationInput();

        initialInput.setLocationName(searchText);
        initialInput.setGeoPosition(geoPos);
        initialInput.setGeoRestriction(restrictions);

        var params = new LocationParam();

        var request = requestFactory.newTriasServiceRequest()
                .locationInformationRequest(byInitialInput(initialInput, params));

        var requests = new ContinuingTriasRequests(proxy, request,
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

        return requests.stream()
                .map(response -> nullsafe(()
                -> response
                        .getServiceDelivery()
                        .getDeliveryPayload()
                        .getLocationInformationResponse())
                )
                .filter(value -> value != null);
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
