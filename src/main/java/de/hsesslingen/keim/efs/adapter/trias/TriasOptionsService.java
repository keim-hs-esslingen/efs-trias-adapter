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
import static de.hsesslingen.keim.efs.adapter.trias.Utils.tryGet;

import de.hsesslingen.keim.efs.adapter.trias.factories.LegFactory;

import static de.hsesslingen.keim.efs.adapter.trias.factories.LocationContextFactory.from;

import de.hsesslingen.keim.efs.adapter.trias.factories.TriasServiceRequest;
import de.hsesslingen.keim.efs.adapter.trias.factories.TripRequestBuilder;
import de.hsesslingen.keim.efs.mobility.exception.MissingConfigParamException;
import de.hsesslingen.keim.efs.middleware.provider.IBookingService;
import de.hsesslingen.keim.efs.middleware.model.Option;
import de.hsesslingen.keim.efs.middleware.model.Place;
import de.hsesslingen.keim.efs.middleware.provider.IOptionsService;

import static de.hsesslingen.keim.efs.mobility.exception.HttpException.*;

import de.hsesslingen.keim.efs.mobility.service.Mode;
import de.vdv.trias.*;

import java.math.BigInteger;

import static java.math.BigInteger.valueOf;

import java.time.ZonedDateTime;
import java.util.*;
import java.util.concurrent.Future;
import javax.annotation.PostConstruct;
import javax.xml.bind.JAXBException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import static de.hsesslingen.keim.efs.adapter.trias.factories.ModeConverter.toTriasMode;

import de.hsesslingen.keim.efs.middleware.model.Leg;

import static java.util.concurrent.CompletableFuture.supplyAsync;
import static java.util.stream.Collectors.toList;
import static org.apache.commons.lang3.ObjectUtils.isNotEmpty;
import static org.springframework.util.CollectionUtils.isEmpty;

/**
 * The class TriasAdapterService is the Implementation of the Interface
 * IBookingService for the VRN Service
 *
 * @author Ben Oesch and Emanuel Reichsöllner
 * @see IBookingService
 */
@Service
public class TriasOptionsService implements IOptionsService<TriasCredentials> {

    @Value("${trias.api-url}")
    private String apiUrl;

    @Value("${trias.api-user-reference}")
    private String apiUserReference;

    @Value("${trias.number-of-results:5}")
    private BigInteger defaultNumberOfResults;

    @Value("${trias.default-image-url:}")
    private String defaultImageUrl;

    @Value("${middleware.provider.mobility-service.id}")
    private String serviceId;

    @Autowired
    private TriasLocationInfoService locationService;

    @Autowired
    private PtModeFilterConfig ptModeFilterConfig;

    @PostConstruct
    public void init() {
        if (apiUserReference == null || apiUserReference.isBlank()) {
            throw new MissingConfigParamException("trias.api-user-reference");
        }
    }

    private TriasServiceRequest createTripRequestTrias(TripRequest request) {
        return new TriasServiceRequest(TRIAS_VERSION, apiUserReference).tripRequest(request);
    }

    /**
     * Adds the {@link PtModeEnumeration} and alls sub modes from {@link src} to
     * the filter, except for those, which are configured to be excluded in
     * {@link PtModeFilterConfig}.
     *
     * @param target
     * @param src
     */
    private void addAllExceptConfigured(PtModeFilter target, de.vdv.trias.Mode src) {
        // Add only those modes and submodes that are not excluded by configuration.
        if (!ptModeFilterConfig.getPtModes().contains(src.getPtMode())) {
            target.getPtMode().add(src.getPtMode());
        }

        var submodes = target.getPtSubmodeChoiceGroup();

        if (!ptModeFilterConfig.getAirSub().contains(src.getAirSubmode())) {
            submodes.add(src.getAirSubmode());
        }
        if (!ptModeFilterConfig.getBusSub().contains(src.getBusSubmode())) {
            submodes.add(src.getBusSubmode());
        }
        if (!ptModeFilterConfig.getCoachSub().contains(src.getCoachSubmode())) {
            submodes.add(src.getCoachSubmode());
        }
        if (!ptModeFilterConfig.getFunicularSub().contains(src.getFunicularSubmode())) {
            submodes.add(src.getFunicularSubmode());
        }
        if (!ptModeFilterConfig.getMetroSub().contains(src.getMetroSubmode())) {
            submodes.add(src.getMetroSubmode());
        }
        if (!ptModeFilterConfig.getRailSub().contains(src.getRailSubmode())) {
            submodes.add(src.getRailSubmode());
        }
        if (!ptModeFilterConfig.getTelecabinSub().contains(src.getTelecabinSubmode())) {
            submodes.add(src.getTelecabinSubmode());
        }
        if (!ptModeFilterConfig.getTramSub().contains(src.getTramSubmode())) {
            submodes.add(src.getTramSubmode());
        }
        if (!ptModeFilterConfig.getWaterSub().contains(src.getWaterSubmode())) {
            submodes.add(src.getWaterSubmode());
        }
    }

    /**
     * Creates a filter based on requested allowed modes and configured excluded
     * modes.
     * <p>
     * This method is protected to be able to run unit tests against it.
     *
     * @param modesAllowed
     * @return
     */
    protected PtModeFilter createFilter(Set<Mode> modesAllowed) {
        if (!isEmpty(modesAllowed)) {
            var filter = new PtModeFilter().setExclude(false);

            // We have a list of allowed modes. Add those as non-excluded filter modes.
            modesAllowed.stream()
                    .map(m -> toTriasMode(m))
                    .filter(tm -> tm != null)
                    .forEach(tm -> addAllExceptConfigured(filter, tm));

            return filter;

        } else if (ptModeFilterConfig.hasExcludedModes()) {
            var filter = new PtModeFilter().setExclude(true);
            // Simply add all configured excluded modes from ptModeFilterConfig to the filter.
            filter.getPtMode().addAll(ptModeFilterConfig.getPtModes());
            filter.getPtSubmodeChoiceGroup().addAll(ptModeFilterConfig.getAllSubmodes());
            return filter;
        }

        return null;
    }

    private boolean isWalkLeg(TripLeg l) {
        if (l.getContinuousLeg() != null) {
            var service = l.getContinuousLeg().getService();

            if (service.getIndividualMode() == IndividualModesEnumeration.WALK) {
                return false;
            } else if (service.getContinuousMode() == ContinuousModesEnumeration.WALK) {
                return false;
            }
        }

        if (l.getInterchangeLeg() != null) {
            var leg = l.getInterchangeLeg();

            if (leg.getInterchangeMode() == InterchangeModesEnumeration.WALK) {
                return false;
            } else if (leg.getContinuousMode() == ContinuousModesEnumeration.WALK) {
                return false;
            }
        }

        return true;
    }

    private int getLengthOfLeg(TripLeg l) {
        if (l.getContinuousLeg() != null) {
            var cl = l.getContinuousLeg();

            if (cl.getLength() != null) {
                return cl.getLength().intValue();

            } else if (cl.getLegTrack() != null) {
                var clt = cl.getLegTrack();

                if (isNotEmpty(clt.getTrackSection())) {
                    var addedLength = 0;

                    for (var sec : clt.getTrackSection()) {
                        if (sec.getLength() != null) {
                            addedLength += sec.getLength().intValue();
                        }
                    }

                    return addedLength;
                }
            }
        }

        if (l.getInterchangeLeg() != null) {
            var il = l.getInterchangeLeg();

            if (il.getLength() != null) {
                return il.getLength().intValue();
            }
        }

        return 0;
    }

    private boolean isRoundTrip(TripLeg l) {
        if (l.getContinuousLeg() != null) {
            var cl = l.getContinuousLeg();
            var start = cl.getLegStart();
            var end = cl.getLegEnd();

            if (start != null && end != null) {
                if (start.getStopPointRef() != null
                        && end.getStopPointRef() != null
                        && Objects.equals(start.getStopPointRef().getValue(), end.getStopPointRef().getValue())
                ) {
                    return true;
                }

                if (start.getStopPlaceRef() != null
                        && end.getStopPlaceRef() != null
                        && Objects.equals(start.getStopPlaceRef().getValue(), end.getStopPlaceRef().getValue())
                ) {
                    return true;
                }
            }
        } else if (l.getTimedLeg() != null) {
            var cl = l.getTimedLeg();
            var start = cl.getLegAlight();
            var end = cl.getLegBoard();

            if (start != null && end != null) {
                if (start.getStopPointRef() != null
                        && end.getStopPointRef() != null
                        && Objects.equals(start.getStopPointRef().getValue(), end.getStopPointRef().getValue())
                ) {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean canConvertTripResultToOption(TripResult tripResult, int allowedWalkingLegLength) {
        var legsItr = tripResult.getTrip().getTripLeg().stream().iterator();

        var containsNonWalkLeg = false;

        while (legsItr.hasNext()) {
            var l = legsItr.next();

            if (isWalkLeg(l)) {
                var length = getLengthOfLeg(l);

                if (length > allowedWalkingLegLength) {
                    return false;
                }
            } else {
                containsNonWalkLeg = true;
            }

            if (isRoundTrip(l)) {
                return false;
            }
        }

        return containsNonWalkLeg;
    }

    /**
     * Each trip result from TRIAS represents an Option from EFS
     *
     * @param tripResult
     * @return
     */
    private Option createOption(TripResult tripResult) {

        // First run an async conversion of TripLeg to Leg.
        // This operation might involve API-Calls, therefore it is parallelized.
        // We are not using a parallel stream because this might mess up the order of the legs.
        var futures = tripResult.getTrip().getTripLeg().stream()
                // Converting tripLeg to leg, which might include a TRIAS-API call.
                // Using tryGet to catch exceptions arising from those API calls.
                .map(leg ->
                        supplyAsync(() ->
                                tryGet(() -> LegFactory.from(leg, serviceId, locationService::getGeoPosition, defaultImageUrl))
                        )
                )
                .collect(toList());

        // Initializing some one-value-arrays that will be populated in the following stream.
        var nonWalkLegsCount = new int[]{0};

        // Initialize an array of legs to collect special legs.
        // 0 = first non-walk leg, 1 = last non-walk leg
        var specialLegs = new Leg[2];

        var legs = futures.stream()
                .map(f -> {
                    try {
                        return f.get();
                    } catch (Exception ex) {
                        return Optional.<Leg>empty();
                    }
                })
                // Filtering out the failed conversions.
                .filter(Optional::isPresent)
                .map(Optional::get)
                // Allowing only options with legs whose from and to values have coordinates.
                .filter((Leg leg) -> leg.getFrom().hasCoordinates() && leg.getTo().hasCoordinates())
                // Collecting come values...
                .peek(leg -> {
                    if (leg.getMode() != Mode.WALK) {
                        ++nonWalkLegsCount[0];

                        // Set first leg...
                        if (specialLegs[0] == null) {
                            specialLegs[0] = leg;
                        }

                        // Set last leg... (can be same as first leg)
                        specialLegs[1] = leg;
                    }
                })
                .collect(toList());

        var numberOfNonWalkLegs = nonWalkLegsCount[0];

        if (numberOfNonWalkLegs == 0) {
            return null;
        }

        var first = specialLegs[0];
        var last = specialLegs[1];

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

        if (numberOfNonWalkLegs > 1) {
            superLeg.setMode(Mode.MULTIPLE);
        } else {
            superLeg.setMode(first.getMode());
            superLeg.setAsset(first.getAsset());
        }

        return new Option(serviceId, superLeg, false);
    }

    private List<Option> extractOptions(Trias responseTrias, Integer limitTo, int allowedMaxWalkDistance) {
        // Convert the trip results in parallel to options...
        var tripResultStream = responseTrias.getServiceDelivery()
                .getDeliveryPayload()
                .getTripResponse()
                .getTripResult()
                .stream()
                .filter(r -> canConvertTripResultToOption(r, allowedMaxWalkDistance));

        // If required, limit to given value.
        if (limitTo != null) {
            tripResultStream = tripResultStream.limit(limitTo);
        }

        return tripResultStream.map(this::createOption)
                .filter(Objects::nonNull)
                .collect(toList());
    }

    @Override
    public List<Option> getOptions(
            Place from,
            Place to,
            ZonedDateTime startTime,
            ZonedDateTime endTime,
            Integer radiusMeter,
            Boolean sharingAllowed,
            Set<Mode> modesAllowed,
            Integer limitTo,
            Boolean includeGeoPaths,
            TriasCredentials credentials
    ) {
        // if no destination is specified an empty options-list is returned
        if (to == null) {
            return new ArrayList<>();
        }

        var radius = radiusMeter != null ? radiusMeter : 500;

        var params = new TripParam()
                .setIncludeEstimatedTimes(true)
                .setIncludeLegProjection(includeGeoPaths)
                .setIncludeTrackSections(includeGeoPaths)
                .setNumberOfResults(limitTo != null ? valueOf(limitTo) : defaultNumberOfResults)
                .setPtModeFilter(createFilter(modesAllowed));

        var tripRequest = new TripRequestBuilder()
                .origin(from(from, startTime))
                .destination(from(to, endTime))
                .params(params)
                .build();

        try {
            var responseTrias = TriasHttpRequest.post(apiUrl)
                    .body(createTripRequestTrias(tripRequest))
                    .go()
                    .getBody();

            return extractOptions(responseTrias, limitTo, radius);
        } catch (JAXBException ex) {
            throw internalServerError("An error occured when converting to or from XML.");
        }
    }

}
