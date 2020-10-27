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

import de.hsesslingen.keim.efs.middleware.provider.IBookingService;
import de.hsesslingen.keim.efs.middleware.model.Options;
import de.hsesslingen.keim.efs.middleware.model.Place;
import de.hsesslingen.keim.efs.middleware.provider.IOptionsService;
import static de.hsesslingen.keim.efs.mobility.exception.HttpException.*;
import de.hsesslingen.keim.efs.mobility.service.MobilityType;
import de.hsesslingen.keim.efs.mobility.service.Mode;
import de.vdv.trias.Trias;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import javax.xml.bind.JAXBException;
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

    // get the custom settings from application.yml
    @Value("${trias.api-url}")
    private String API_URL;

    @Autowired
    private TriasRequestFactory requestFactory;

    @Autowired
    private TriasResponseConverter responseConverter;

    @Override
    public List<Options> getOptions(
            Place from,
            Place to,
            ZonedDateTime startTime,
            ZonedDateTime endTime,
            Integer radiusMeter,
            Boolean sharingAllowed,
            Set<Mode> modesAllowed,
            Set<MobilityType> mobilityTypesAllowed,
            Integer limitTo,
            TriasCredentials credentials
    ) {

        // if no destination is specified an empty options-list is returned
        if (to == null) {
            return new ArrayList<>();
        }

        var requestTrias = requestFactory.createTripRequest(from, to, startTime, endTime);

        Trias responseTrias;

        try {
            responseTrias = TriasHttpRequest.post(API_URL)
                    .body(requestTrias)
                    .go()
                    .getBody();
        } catch (JAXBException ex) {
            throw internalServerError("An error occured when converting to or from XML.");
        } 

        return responseConverter.extractMobilityOptionsFromTrias(responseTrias, limitTo);
    }

}
