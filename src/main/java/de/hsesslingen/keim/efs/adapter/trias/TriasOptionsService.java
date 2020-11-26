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
import static de.hsesslingen.keim.efs.adapter.trias.factories.LocationContextFactory.from;
import de.hsesslingen.keim.efs.adapter.trias.factories.TriasServiceRequest;
import de.hsesslingen.keim.efs.adapter.trias.factories.TripRequestBuilder;
import de.hsesslingen.keim.efs.middleware.exception.MissingConfigParamException;
import de.hsesslingen.keim.efs.middleware.provider.IBookingService;
import de.hsesslingen.keim.efs.middleware.model.Option;
import de.hsesslingen.keim.efs.middleware.model.Place;
import de.hsesslingen.keim.efs.middleware.provider.IOptionsService;
import static de.hsesslingen.keim.efs.mobility.exception.HttpException.*;
import de.hsesslingen.keim.efs.mobility.service.Mode;
import de.vdv.trias.PtModeFilter;
import de.vdv.trias.TripParam;
import de.vdv.trias.TripRequest;
import java.math.BigInteger;
import static java.math.BigInteger.valueOf;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import javax.annotation.PostConstruct;
import javax.xml.bind.JAXBException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import static de.hsesslingen.keim.efs.adapter.trias.factories.ModeConverter.toTriasMode;
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

    @Autowired
    private TriasResponseConverter responseConverter;

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

    private PtModeFilter createFilter(Set<Mode> modesAllowed) {
        if (!isEmpty(modesAllowed)) {
            var filter = new PtModeFilter().setExclude(false);

            // We have a list of allowed modes. Add those as non-excluded filter modes.
            modesAllowed.stream()
                    .map(m -> toTriasMode(m))
                    .filter(tm -> tm != null)
                    .forEach(tm -> addAllExceptConfigured(filter, tm));

            return filter;

        } else if (ptModeFilterConfig.hasExcludedSubModes()) {
            var filter = new PtModeFilter().setExclude(true);
            // Simply add all configured excluded modes from ptModeFilterConfig to the filter.
            filter.getPtMode().addAll(ptModeFilterConfig.getPtModes());
            filter.getPtSubmodeChoiceGroup().addAll(ptModeFilterConfig.getAllSubmodes());
            return filter;
        }

        return null;
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

            return responseConverter.extractOptions(responseTrias, limitTo);
        } catch (JAXBException ex) {
            throw internalServerError("An error occured when converting to or from XML.");
        }
    }

}
