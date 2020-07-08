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

import de.vdv.trias.PtModeFilterStructure;
import de.vdv.trias.PtModesEnumeration;
import de.vdv.trias.TripParamStructure;
import java.math.BigInteger;
import java.util.Collection;
import java.util.stream.Stream;

/**
 *
 * @author ben
 */
public class TripParamStructureBuilder extends TripParamStructure {

    public TripParamStructure build() {
        return this;
    }

    public TripParamStructureBuilder ptModeFilter(PtModeFilterStructure ptModeFilter) {
        this.ptModeFilter = ptModeFilter;
        return this;
    }

    public TripParamStructureBuilder ptModeFilterByExclude(boolean exclude) {
        this.ptModeFilter = new PtModeFilterStructure();
        ptModeFilter.setExclude(exclude);
        return this;
    }

    public TripParamStructureBuilder ptModeFilter(boolean exclude, Collection<PtModesEnumeration> modes, Collection<Object> subModeChoiceGroups) {
        this.ptModeFilter = new PtModeFilterStructure();
        ptModeFilter.setExclude(exclude);

        if (modes != null) {
            ptModeFilter.getPtMode().addAll(modes);
        }

        if (subModeChoiceGroups != null) {
            ptModeFilter.getPtSubmodeChoiceGroup().addAll(subModeChoiceGroups);
        }

        return this;
    }

    public TripParamStructureBuilder ptModeFilter(boolean exclude, Stream<PtModesEnumeration> modes, Stream<Object> subModeChoiceGroups) {
        this.ptModeFilter = new PtModeFilterStructure();
        ptModeFilter.setExclude(exclude);

        if (modes != null) {
            modes.forEachOrdered(ptModeFilter.getPtMode()::add);
        }

        if (subModeChoiceGroups != null) {
            subModeChoiceGroups.forEachOrdered(ptModeFilter.getPtSubmodeChoiceGroup()::add);
        }

        return this;
    }

    public TripParamStructureBuilder includeFares(boolean value) {
        this.includeFares = value;
        return this;
    }

    public TripParamStructureBuilder immediateTripStart(boolean value) {
        this.immediateTripStart = value;
        return this;
    }

    public TripParamStructureBuilder includeIntermediateStops(boolean value) {
        this.includeIntermediateStops = value;
        return this;
    }

    public TripParamStructureBuilder includeLegProjection(boolean value) {
        this.includeLegProjection = value;
        return this;
    }

    public TripParamStructureBuilder includeTrackSections(boolean value) {
        this.includeTrackSections = value;
        return this;
    }

    public TripParamStructureBuilder numberOfResults(long value) {
        this.numberOfResults = BigInteger.valueOf(value);
        return this;
    }

    public TripParamStructureBuilder numberOfResults(int value) {
        this.numberOfResults = BigInteger.valueOf(value);
        return this;
    }

    public TripParamStructureBuilder numberOfResults(String value) {
        this.numberOfResults = new BigInteger(value);
        return this;
    }

    public TripParamStructureBuilder numberOfResults(BigInteger value) {
        this.numberOfResults = value;
        return this;
    }
}
