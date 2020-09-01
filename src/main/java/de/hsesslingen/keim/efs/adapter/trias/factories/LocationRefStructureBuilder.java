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

import de.hsesslingen.keim.efs.mobility.ICoordinates;
import de.vdv.trias.AddressRefStructure;
import de.vdv.trias.GeoPositionStructure;
import de.vdv.trias.InternationalTextStructure;
import de.vdv.trias.LocalityRefStructure;
import de.vdv.trias.LocationRefStructure;
import de.vdv.trias.PointOfInterestRefStructure;
import de.vdv.trias.StopPlaceRefStructure;
import de.vdv.trias.StopPointRefStructure;
import java.util.Collection;

/**
 *
 * @author ben
 */
public class LocationRefStructureBuilder extends LocationRefStructure {

    public LocationRefStructureBuilder stopPointRef(StopPointRefStructure value) {
        this.stopPointRef = value;
        return this;
    }

    public LocationRefStructureBuilder stopPlaceRef(StopPlaceRefStructure value) {
        this.stopPlaceRef = value;
        return this;
    }

    public LocationRefStructureBuilder geoPosition(GeoPositionStructure value) {
        this.geoPosition = value;
        return this;
    }

    public LocationRefStructureBuilder geoPosition(ICoordinates value) {
        this.geoPosition = GeoPositionStructureFactory.create(value);
        return this;
    }

    public LocationRefStructureBuilder geoPosition(double lat, double lon) {
        this.geoPosition = GeoPositionStructureFactory.create(lat, lon);
        return this;
    }

    public LocationRefStructureBuilder localityRef(LocalityRefStructure value) {
        this.localityRef = value;
        return this;
    }

    public LocationRefStructureBuilder pointOfInterest(PointOfInterestRefStructure value) {
        this.pointOfInterestRef = value;
        return this;
    }

    public LocationRefStructureBuilder addressRef(AddressRefStructure value) {
        this.addressRef = value;
        return this;
    }

    public LocationRefStructureBuilder locationName(InternationalTextStructure value) {
        this.getLocationName().add(value);
        return this;
    }

    public LocationRefStructureBuilder locationName(Collection<InternationalTextStructure> value) {
        this.getLocationName().addAll(value);
        return this;
    }

}
