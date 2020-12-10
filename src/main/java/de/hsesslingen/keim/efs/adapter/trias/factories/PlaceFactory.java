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

import de.hsesslingen.keim.efs.adapter.trias.supertypes.ILegEnd;
import de.hsesslingen.keim.efs.middleware.model.Place;
import de.vdv.trias.Address;
import de.vdv.trias.GeoPosition;
import de.vdv.trias.Locality;
import de.vdv.trias.Location;
import de.vdv.trias.LocationRef;
import de.vdv.trias.PointOfInterest;
import de.vdv.trias.StopPlace;
import de.vdv.trias.StopPoint;
import de.vdv.trias.StopPointRef;
import java.util.function.Function;
import static org.apache.commons.lang3.StringUtils.isBlank;

/**
 *
 * @author keim
 */
public class PlaceFactory {

    public static Place from(StopPoint value, String serviceId) {
        var place = new Place().setServiceId(serviceId);

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

    public static Place from(StopPlace value, String serviceId) {
        var place = new Place().setServiceId(serviceId);

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

    public static Place from(Locality value, String serviceId) {
        var place = new Place().setServiceId(serviceId);

        if (value.getLocalityName() != null && !value.getLocalityName().isEmpty()) {
            place.setName(value.getLocalityName().get(0).getText());
        }

        if (value.getLocalityCode() != null) {
            place.setId(value.getLocalityCode());
        }

        return place;
    }

    public static Place from(PointOfInterest value, String serviceId) {
        var place = new Place().setServiceId(serviceId);

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

    public static Place from(Address value, String serviceId) {
        var place = new Place().setServiceId(serviceId);

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

    public static Place from(Location value, String serviceId) {
        Place place;

        if (value.getStopPoint() != null) {
            place = PlaceFactory.from(value.getStopPoint(), serviceId);
        } else if (value.getStopPlace() != null) {
            place = from(value.getStopPlace(), serviceId);
        } else if (value.getLocality() != null) {
            place = PlaceFactory.from(value.getLocality(), serviceId);
        } else if (value.getPointOfInterest() != null) {
            place = PlaceFactory.from(value.getPointOfInterest(), serviceId);
        } else if (value.getAddress() != null) {
            place = PlaceFactory.from(value.getAddress(), serviceId);
        } else {
            place = new Place().setServiceId(serviceId);
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

    public static Place from(LocationRef locationRef, String serviceId) {
        if (locationRef == null) {
            return null;
        }

        var place = new Place().setServiceId(serviceId);

        if (locationRef.getGeoPosition() != null) {
            place.setLat(locationRef.getGeoPosition().getLatitude());
            place.setLon(locationRef.getGeoPosition().getLongitude());
        }

        if (locationRef.getStopPointRef() != null) {
            place.setId(locationRef.getStopPointRef().getValue());
        }

        var names = locationRef.getLocationName(); // names is never null. See src.

        if (!names.isEmpty()) {
            place.setName(names.get(0).getText());
        }

        return place;
    }

    public static Place from(ILegEnd legEnd, GeoPosition geoPosition, String serviceId) {
        if (legEnd == null) {
            return null;
        }

        var place = new Place().setServiceId(serviceId);

        if (legEnd.getStopPointRef() != null) {
            place.setId(legEnd.getStopPointRef().getValue());
        }

        if (!legEnd.getStopPointName().isEmpty()) {
            place.setName(legEnd.getStopPointName().get(0).getText());

            if (geoPosition != null) {
                place.setLat(geoPosition.getLatitude());
                place.setLon(geoPosition.getLongitude());
            }
        }

        return place;
    }

    public static Place from(ILegEnd legEnd, Function<StopPointRef, GeoPosition> geoPositionGetter, String serviceId) {
        if (legEnd == null) {
            return null;
        }

        // First get the geo coordinates from the server.
        var geoPos = geoPositionGetter.apply(legEnd.getStopPointRef());

        // Then convert it to a place.
        return PlaceFactory.from(legEnd, geoPos, serviceId);
    }
}
