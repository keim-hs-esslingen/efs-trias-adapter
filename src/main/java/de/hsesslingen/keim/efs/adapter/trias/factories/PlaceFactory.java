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
import de.vdv.trias.Address;
import de.vdv.trias.Locality;
import de.vdv.trias.Location;
import de.vdv.trias.PointOfInterest;
import de.vdv.trias.StopPlace;
import de.vdv.trias.StopPoint;
import static org.apache.commons.lang3.StringUtils.isBlank;

/**
 *
 * @author keim
 */
public class PlaceFactory {

    public static Place fromStopPoint(StopPoint value) {
        var place = new Place();

        if (value.getStopPointName() != null && !value.getStopPointName().isEmpty()) {
            var name = value.getStopPointName().get(0).getText();

            if (value.getNameSuffix() != null && !value.getNameSuffix().isEmpty()) {
                name += value.getNameSuffix().get(0).getText();
            }

            place.setName(name);
        }

        if (value.getStopPointRef() != null) {
            place.setId(value.getStopPointRef().getValue());
        }

        return place;
    }

    public static Place fromStopPlace(StopPlace value) {
        var place = new Place();

        if (value.getStopPlaceName() != null && !value.getStopPlaceName().isEmpty()) {
            var name = value.getStopPlaceName().get(0).getText();

            if (value.getNameSuffix() != null && !value.getNameSuffix().isEmpty()) {
                name += value.getNameSuffix().get(0).getText();
            }

            place.setName(name);
        }

        if (value.getStopPlaceRef() != null) {
            place.setId(value.getStopPlaceRef().getValue());
        }

        return place;
    }

    public static Place fromLocality(Locality value) {
        var place = new Place();

        if (value.getLocalityName() != null && !value.getLocalityName().isEmpty()) {
            place.setName(value.getLocalityName().get(0).getText());
        }

        if (value.getLocalityCode() != null) {
            place.setId(value.getLocalityCode());
        }

        return place;
    }

    public static Place fromPOI(PointOfInterest value) {
        var place = new Place();

        if (value.getPointOfInterestName() != null && !value.getPointOfInterestName().isEmpty()) {
            var name = value.getPointOfInterestName().get(0).getText();

            if (value.getNameSuffix() != null && !value.getNameSuffix().isEmpty()) {
                name += value.getNameSuffix().get(0).getText();
            }

            place.setName(name);
        }

        if (value.getPointOfInterestCode() != null) {
            place.setId(value.getPointOfInterestCode());
        }

        return place;
    }

    public static Place fromAddress(Address value) {
        var place = new Place();

        if (value.getAddressName() != null && !value.getAddressName().isEmpty()) {
            var name = value.getAddressName().get(0).getText();

            if (value.getNameSuffix() != null && !value.getNameSuffix().isEmpty()) {
                name += value.getNameSuffix().get(0).getText();
            }

            place.setName(name);
        }

        if (value.getAddressCode() != null) {
            place.setId(value.getAddressCode());
        }

        return place;
    }

    public static Place fromLocation(Location value) {
        Place place;

        if (value.getStopPoint() != null) {
            place = fromStopPoint(value.getStopPoint());
        } else if (value.getStopPlace() != null) {
            place = fromStopPlace(value.getStopPlace());
        } else if (value.getLocality() != null) {
            place = fromLocality(value.getLocality());
        } else if (value.getPointOfInterest() != null) {
            place = fromPOI(value.getPointOfInterest());
        } else if (value.getAddress() != null) {
            place = fromAddress(value.getAddress());
        } else {
            place = new Place();
        }

        if (value.getLocationName() != null && !value.getLocationName().isEmpty()) {
            var locationName = value.getLocationName().get(0).getText();

            if (isBlank(place.getName())) {
                place.setName(locationName);
            } else {
                place.setParentName(locationName);
            }
        }

        if (value.getGeoPosition() != null) {
            place.setCoordinates(value.getGeoPosition());
        }

        return place;
    }

}
