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

import de.vdv.trias.LocationContext;
import de.vdv.trias.NoChangeAt;
import de.vdv.trias.NotVia;
import de.vdv.trias.TripParam;
import de.vdv.trias.TripRequest;
import de.vdv.trias.Via;
import java.util.stream.Stream;

/**
 *
 * @author ben
 */
public class TripRequestBuilder extends TripRequest {

    public TripRequest build() {
        // Simply returning this, because we already ARE a TripRequest.
        // This is equal to making a cast on the TripRequestBuilder object
        // but calling build() is more convenient.
        return this;
    }

    public TripRequestBuilder origin(LocationContext origin) {
        this.getOrigin().add(origin);
        return this;
    }

    public TripRequestBuilder destination(LocationContext destination) {
        this.getDestination().add(destination);
        return this;
    }

    public TripRequestBuilder params(TripParam params) {
        this.params = params;
        return this;
    }

    public TripRequestBuilder addOrigins(Stream<LocationContext> origins) {
        this.getOrigin(); // Using getter once to make sure the list is not null.
        origins.forEachOrdered(this.origin::add);
        return this;
    }

    public TripRequestBuilder addDestinations(Stream<LocationContext> destinations) {
        this.getDestination(); // Using getter once to make sure the list is not null.
        destinations.forEachOrdered(this.destination::add);
        return this;
    }

    public TripRequestBuilder addVias(Stream<Via> vias) {
        this.getVia(); // Using getter once to make sure the list is not null.
        vias.forEachOrdered(this.via::add);
        return this;
    }

    public TripRequestBuilder addNotVias(Stream<NotVia> notVias) {
        this.getNotVia(); // Using getter once to make sure the list is not null.
        notVias.forEachOrdered(this.notVia::add);
        return this;
    }

    public TripRequestBuilder addNoChangeAts(Stream<NoChangeAt> noChangeAts) {
        this.getNoChangeAt(); // Using getter once to make sure the list is not null.
        noChangeAts.forEachOrdered(this.noChangeAt::add);
        return this;
    }

}
