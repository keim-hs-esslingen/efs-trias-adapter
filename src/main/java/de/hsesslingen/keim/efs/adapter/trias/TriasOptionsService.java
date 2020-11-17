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
import static de.hsesslingen.keim.efs.adapter.trias.factories.ModeConverter.toPtMode;
import de.hsesslingen.keim.efs.adapter.trias.factories.TriasServiceRequest;
import de.hsesslingen.keim.efs.adapter.trias.factories.TripRequestBuilder;
import de.hsesslingen.keim.efs.middleware.exception.MissingConfigParamException;
import de.hsesslingen.keim.efs.middleware.provider.IBookingService;
import de.hsesslingen.keim.efs.middleware.model.Option;
import de.hsesslingen.keim.efs.middleware.model.Place;
import de.hsesslingen.keim.efs.middleware.provider.IOptionsService;
import static de.hsesslingen.keim.efs.mobility.exception.HttpException.*;
import de.hsesslingen.keim.efs.mobility.service.MobilityType;
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
import static org.apache.commons.lang3.ObjectUtils.isNotEmpty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

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

    @PostConstruct
    public void init() {
        if (apiUserReference == null || apiUserReference.isBlank()) {
            throw new MissingConfigParamException("trias.api-user-reference");
        }
    }

    private TriasServiceRequest createTripRequestTrias(TripRequest request) {
        return new TriasServiceRequest(TRIAS_VERSION, apiUserReference).tripRequest(request);
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
            Set<MobilityType> mobilityTypesAllowed,
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
                .setNumberOfResults(limitTo != null ? valueOf(limitTo) : defaultNumberOfResults);

        if (isNotEmpty(modesAllowed)) {
            var filter = new PtModeFilter();

            modesAllowed.stream()
                    .map(m -> toPtMode(m))
                    .filter(pt -> pt != null)
                    .forEach(filter.getPtMode()::add);

            params.setPtModeFilter(filter);
        }

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
