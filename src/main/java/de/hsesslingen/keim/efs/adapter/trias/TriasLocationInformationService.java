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

import de.hsesslingen.keim.efs.mobility.exception.AbstractEfsException;
import static de.hsesslingen.keim.efs.mobility.exception.HttpException.*;
import de.vdv.trias.GeoPositionStructure;
import de.vdv.trias.StopPointRefStructure;
import de.vdv.trias.Trias;
import javax.xml.bind.JAXBException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * The class TriasLocationInformationService is a Service to covert public
 * transport Stationnames to GeoPostions
 *
 * @author Ben Oesch and Emanuel Reichsöllner
 */
@Service
public class TriasLocationInformationService {

    // get the custom settings from application.yml
    @Value("${trias.api-url}")
    private String API_URL;

    @Autowired
    private TriasRequestFactory triasRequestFactory;

    /**
     * In the Method getGeoPositionFromStopPoint a API - call is performed to
     * convert a stopPointRef (eg. Stationname) to a GeoPosition
     *
     * @param stopPointRef
     * @return GeoPositionStructure
     * @throws AbstractEfsException
     */
    public GeoPositionStructure getGeoPositionFromStopPoint(StopPointRefStructure stopPointRef) throws AbstractEfsException {

        Trias locationRequestTrias = triasRequestFactory.createLocationInformationRequest(stopPointRef);

        Trias responseLocationTrias;

        try {
            responseLocationTrias = TriasHttpRequest.post(API_URL)
                    .body(locationRequestTrias)
                    .go()
                    .getBody();
        } catch (JAXBException ex) {
            throw internalServerError("An error occured when converting to or from XML.");
        }

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

}
