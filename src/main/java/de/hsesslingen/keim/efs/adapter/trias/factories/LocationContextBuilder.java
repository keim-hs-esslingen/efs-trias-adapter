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
import de.hsesslingen.keim.efs.middleware.model.Place;
import de.vdv.trias.LocationContext;
import de.vdv.trias.LocationRef;
import java.time.ZonedDateTime;
import static org.apache.commons.lang.StringUtils.isBlank;

/**
 *
 * @author ben
 */
public class LocationContextBuilder extends LocationContext {

    public LocationContext build() {
        return this;
    }

    public LocationContextBuilder locationRef(LocationRef locationRef) {
        this.locationRef = locationRef;
        return this;
    }

    public LocationContextBuilder coordinates(ICoordinates coordinates) {
        this.locationRef = new LocationRefBuilder().geoPosition(coordinates);
        return this;
    }

    public LocationContextBuilder place(Place place) {
        var builder = new LocationRefBuilder();

        if (!isBlank(place.getPlaceId())) {
            builder.stopPlaceRef(place.getPlaceId());
        }

        if (!isBlank(place.getStopId())) {
            builder.stopPointRef(place.getStopId());
        }

        if (place.hasCoordinates()) {
            builder.geoPosition(place);
        }

        this.locationRef = builder;
        return this;
    }

    public LocationContextBuilder depArrTime(ZonedDateTime depArrTime) {
        this.depArrTime = depArrTime;
        return this;
    }

}
