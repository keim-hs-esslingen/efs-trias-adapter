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
package de.hsesslingen.keim.efs.adapter.trias.factories;

import de.hsesslingen.keim.efs.middleware.model.ICoordinates;
import de.vdv.trias.GeoPositionStructure;
import de.vdv.trias.GeoRestrictionsStructure;
import de.vdv.trias.InitialLocationInputStructure;
import de.vdv.trias.LocationInformationRequestStructure;
import de.vdv.trias.LocationParamStructure;
import de.vdv.trias.StopPointRefStructure;

/**
 *
 * @author keim
 */
public class LocationInformationRequestFactory {

    public static LocationInformationRequestStructure byInitialInput(InitialLocationInputStructure initialInput) {
        return byInitialInput(initialInput, null);
    }

    public static LocationInformationRequestStructure byInitialInput(InitialLocationInputStructure initialInput, LocationParamStructure restrictions) {
        var locationInformationRequest = new LocationInformationRequestStructure();
        locationInformationRequest.setInitialInput(initialInput);
        locationInformationRequest.setRestrictions(restrictions);
        return locationInformationRequest;
    }

    public static LocationInformationRequestStructure byStopPointRef(StopPointRefStructure value) {
        var locationInformationRequest = new LocationInformationRequestStructure();
        locationInformationRequest.setLocationRef(new LocationRefStructureBuilder().stopPointRef(value));
        return locationInformationRequest;
    }

    /**
     * Searching by location name is very general like a Search Engine Input
     * String (like Streetname, Point of Interest,...) to find a certain
     * Location. In this case we use as Input Sring for the built in Serach
     * Engine the StopPointRef an we hope that the GeoPositon is found
     * (therefore the nullPpinter check for the return Statement
     *
     * @param locationName
     * @return
     */
    public static LocationInformationRequestStructure byLocationName(String locationName) {
        var initialInput = new InitialLocationInputStructure();
        initialInput.setLocationName(locationName);

        return byInitialInput(initialInput);
    }

    public static LocationInformationRequestStructure byGeoPosition(GeoPositionStructure geoPosition) {
        var initialInput = new InitialLocationInputStructure();
        initialInput.setGeoPosition(geoPosition);

        return byInitialInput(initialInput);
    }

    public static LocationInformationRequestStructure byGeoPosition(ICoordinates geoPosition) {
        return byGeoPosition(GeoPositionStructureFactory.create(geoPosition));
    }

    public static LocationInformationRequestStructure byGeoPosition(double lat, double lon) {
        return byGeoPosition(GeoPositionStructureFactory.create(lat, lon));
    }

    public static LocationInformationRequestStructure byInitialInput(String locationName, GeoPositionStructure geoPosition, GeoRestrictionsStructure geoRestriction) {
        var initialInput = new InitialLocationInputStructure();
        initialInput.setLocationName(locationName);
        initialInput.setGeoPosition(geoPosition);
        initialInput.setGeoRestriction(geoRestriction);

        return byInitialInput(initialInput);
    }
}
