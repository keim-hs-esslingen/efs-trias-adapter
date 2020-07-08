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
package de.hsesslingen.keim.efs.trias.factories;

import de.vdv.trias.LocationContextStructure;
import de.vdv.trias.LocationRefStructure;
import java.time.ZonedDateTime;

/**
 *
 * @author ben
 */
public class LocationContextStructureBuilder {

    private LocationRefStructure locationRef;

    /**
     * The Departure- and ArrivalTime can be specified in the Origin /
     * Destination (LocationRefStructure) If there is both a Departure- and an
     * ArrivalTime defined then the DepartureTime is fully ignored
     */
    private ZonedDateTime depArrTime;

    public LocationContextStructure build() {
        var location = new LocationContextStructure();

        if (locationRef != null) {
            location.setLocationRef(locationRef);
        }

        if (depArrTime != null) {
            location.setDepArrTime(depArrTime);
        }

        return location;
    }

    public LocationContextStructureBuilder locationRef(LocationRefStructure locationRef) {
        this.locationRef = locationRef;
        return this;
    }

    public LocationContextStructureBuilder depArrTime(ZonedDateTime depArrTime) {
        this.depArrTime = depArrTime;
        return this;
    }

}
