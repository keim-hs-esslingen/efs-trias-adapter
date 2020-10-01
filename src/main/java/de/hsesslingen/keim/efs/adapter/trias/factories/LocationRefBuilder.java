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
import de.vdv.trias.AddressRef;
import de.vdv.trias.GeoPosition;
import de.vdv.trias.InternationalText;
import de.vdv.trias.LocalityRef;
import de.vdv.trias.LocationRef;
import de.vdv.trias.PointOfInterestRef;
import de.vdv.trias.StopPlaceRef;
import de.vdv.trias.StopPointRef;
import java.util.Collection;

/**
 *
 * @author ben
 */
public class LocationRefBuilder extends LocationRef {

    public LocationRefBuilder stopPointRef(StopPointRef value) {
        this.stopPointRef = value;
        return this;
    }

    public LocationRefBuilder stopPointRef(String value) {
        var pointRef = new StopPointRef();
        pointRef.setValue(value);
        this.stopPointRef = pointRef;
        return this;
    }

    public LocationRefBuilder stopPlaceRef(StopPlaceRef value) {
        this.stopPlaceRef = value;
        return this;
    }

    public LocationRefBuilder stopPlaceRef(String value) {
        var placeRef = new StopPlaceRef();
        placeRef.setValue(value);
        this.stopPlaceRef = placeRef;
        return this;
    }

    public LocationRefBuilder geoPosition(GeoPosition value) {
        this.geoPosition = value;
        return this;
    }

    public LocationRefBuilder geoPosition(ICoordinates value) {
        this.geoPosition = GeoPositionFactory.create(value);
        return this;
    }

    public LocationRefBuilder geoPosition(double lat, double lon) {
        this.geoPosition = GeoPositionFactory.create(lat, lon);
        return this;
    }

    public LocationRefBuilder localityRef(LocalityRef value) {
        this.localityRef = value;
        return this;
    }

    public LocationRefBuilder pointOfInterest(PointOfInterestRef value) {
        this.pointOfInterestRef = value;
        return this;
    }

    public LocationRefBuilder addressRef(AddressRef value) {
        this.addressRef = value;
        return this;
    }

    public LocationRefBuilder locationName(InternationalText value) {
        this.getLocationName().add(value);
        return this;
    }

    public LocationRefBuilder locationName(Collection<InternationalText> value) {
        this.getLocationName().addAll(value);
        return this;
    }

}
