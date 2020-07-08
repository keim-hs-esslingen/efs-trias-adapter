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
import de.vdv.trias.NoChangeAtStructure;
import de.vdv.trias.NotViaStructure;
import de.vdv.trias.TripParamStructure;
import de.vdv.trias.TripRequestStructure;
import de.vdv.trias.ViaStructure;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Stream;

/**
 *
 * @author ben
 */
public class TripRequestStructureBuilder {

    private LocationContextStructure origin;
    private LocationContextStructure destination;
    private TripParamStructure params;

    // Using list of streams for generic way of adding locations.
    // We have to iterate over them anyways, if we want to add them to the 
    // target object. Therefore it doesn't matter if we use a collection or
    // a stream.
    private List<Stream<LocationContextStructure>> origins;
    private List<Stream<LocationContextStructure>> destinations;
    private List<Stream<ViaStructure>> vias;
    private List<Stream<NotViaStructure>> notVias;
    private List<Stream<NoChangeAtStructure>> noChangeAts;

    private <T> void addIfPresent(T member, Consumer<T> consumer) {
        if (member != null) {
            consumer.accept(member);
        }
    }

    public TripRequestStructure build() {
        var req = new TripRequestStructure();

        addIfPresent(origin, req.getOrigin()::add);
        addIfPresent(destination, req.getDestination()::add);
        addIfPresent(params, req::setParams);

        if (origins != null) {
            origins.stream()
                    .flatMap(s -> s)
                    .forEachOrdered(req.getOrigin()::add);
        }

        if (destinations != null) {
            destinations.stream()
                    .flatMap(s -> s)
                    .forEachOrdered(req.getDestination()::add);
        }

        if (vias != null) {
            vias.stream()
                    .flatMap(s -> s)
                    .forEachOrdered(req.getVia()::add);
        }

        if (notVias != null) {
            notVias.stream()
                    .flatMap(s -> s)
                    .forEachOrdered(req.getNotVia()::add);
        }

        if (noChangeAts != null) {
            noChangeAts.stream()
                    .flatMap(s -> s)
                    .forEachOrdered(req.getNoChangeAt()::add);
        }

        return req;
    }

    public TripRequestStructureBuilder origin(LocationContextStructure origin) {
        this.origin = origin;
        return this;
    }

    public TripRequestStructureBuilder destination(LocationContextStructure destination) {
        this.destination = destination;
        return this;
    }

    public TripRequestStructureBuilder params(TripParamStructure params) {
        this.params = params;
        return this;
    }

    public TripRequestStructureBuilder addOrigins(Stream<LocationContextStructure> origins) {
        if (this.origins == null) {
            this.origins = new ArrayList<>(1);
        }

        this.origins.add(origins);

        return this;
    }

    public TripRequestStructureBuilder addDestinations(Stream<LocationContextStructure> destinations) {
        if (this.destinations == null) {
            this.destinations = new ArrayList<>(1);
        }

        this.destinations.add(destinations);

        return this;
    }

    public TripRequestStructureBuilder addVias(Stream<ViaStructure> vias) {
        if (this.vias == null) {
            this.vias = new ArrayList<>(1);
        }

        this.vias.add(vias);

        return this;
    }

    public TripRequestStructureBuilder addNotVias(Stream<NotViaStructure> notVias) {
        if (this.notVias == null) {
            this.notVias = new ArrayList<>(1);
        }

        this.notVias.add(notVias);

        return this;
    }

    public TripRequestStructureBuilder addNoChangeAts(Stream<NoChangeAtStructure> noChangeAts) {
        if (this.noChangeAts == null) {
            this.noChangeAts = new ArrayList<>(1);
        }

        this.noChangeAts.add(noChangeAts);

        return this;
    }

}
