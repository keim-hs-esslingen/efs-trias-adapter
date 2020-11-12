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

import de.hsesslingen.keim.efs.middleware.model.Place;
import de.vdv.trias.AddressRef;
import de.vdv.trias.Location;
import de.vdv.trias.LocationRef;
import de.vdv.trias.PointOfInterestRef;
import de.vdv.trias.StopPlaceRef;
import de.vdv.trias.StopPointRef;

/**
 *
 * @author keim
 */
public class LocationRefFactory {

    public static LocationRef fromPlace(Place place) {
        var ref = new LocationRef();

        if (place.getId() != null) {
            return ref.setStopPointRef(new StopPointRef().setValue(place.getId()));
        }

        if (place.getId() != null) {
            return ref.setStopPlaceRef(new StopPlaceRef().setValue(place.getId()));
        }

        if (place.hasCoordinates()) {
            return ref.setGeoPosition(GeoPositionFactory.create(place));
        }

        return ref;
    }

    public static LocationRef fromLocation(Location location) {
        var ref = new LocationRef();

        if (location.getStopPoint() != null) {
            return ref.setStopPointRef(location.getStopPoint().getStopPointRef());
        }

        if (location.getStopPlace() != null) {
            return ref.setStopPlaceRef(location.getStopPlace().getStopPlaceRef());
        }

        if (location.getPointOfInterest() != null) {
            return ref.setPointOfInterestRef(new PointOfInterestRef().setValue(location.getPointOfInterest().getPointOfInterestCode()));
        }

        if (location.getAddress() != null) {
            return ref.setAddressRef(new AddressRef().setValue(location.getAddress().getAddressCode()));
        }

        if (location.getGeoPosition() != null) {
            return ref.setGeoPosition(location.getGeoPosition());
        }

        return ref;
    }
}
