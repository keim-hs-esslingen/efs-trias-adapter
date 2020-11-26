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
package de.hsesslingen.keim.efs.adapter.trias;

import de.vdv.trias.AirSubmodeEnumeration;
import de.vdv.trias.BusSubmodeEnumeration;
import de.vdv.trias.CoachSubmodeEnumeration;
import de.vdv.trias.FunicularSubmodeEnumeration;
import de.vdv.trias.MetroSubmodeEnumeration;
import de.vdv.trias.PtModesEnumeration;
import de.vdv.trias.RailSubmodeEnumeration;
import de.vdv.trias.TelecabinSubmodeEnumeration;
import de.vdv.trias.TramSubmodeEnumeration;
import de.vdv.trias.WaterSubmodeEnumeration;
import java.util.ArrayList;
import java.util.List;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.annotation.Validated;

/**
 *
 * @author ben
 */
@Validated
@Configuration
@ConfigurationProperties(prefix = "trias.excluded-pt-modes")
public class PtModeFilterConfig {

    @Setter
    private List<PtModesEnumeration> ptModes;

    @Setter
    private List<AirSubmodeEnumeration> airSub;

    @Setter
    private List<BusSubmodeEnumeration> busSub;

    @Setter
    private List<CoachSubmodeEnumeration> coachSub;

    @Setter
    private List<FunicularSubmodeEnumeration> funicularSub;

    @Setter
    private List<MetroSubmodeEnumeration> metroSub;

    @Setter
    private List<RailSubmodeEnumeration> railSub;

    @Setter
    private List<TelecabinSubmodeEnumeration> telecabinSub;

    @Setter
    private List<TramSubmodeEnumeration> tramSub;

    @Setter
    private List<WaterSubmodeEnumeration> waterSub;

    public List<PtModesEnumeration> getPtModes() {
        if (ptModes == null) {
            ptModes = new ArrayList<>();
        }

        return ptModes;
    }

    public List<AirSubmodeEnumeration> getAirSub() {
        if (airSub == null) {
            airSub = new ArrayList<>();
        }

        return airSub;
    }

    public List<BusSubmodeEnumeration> getBusSub() {
        if (busSub == null) {
            busSub = new ArrayList<>();
        }

        return busSub;
    }

    public List<CoachSubmodeEnumeration> getCoachSub() {
        if (coachSub == null) {
            coachSub = new ArrayList<>();
        }

        return coachSub;
    }

    public List<FunicularSubmodeEnumeration> getFunicularSub() {
        if (funicularSub == null) {
            funicularSub = new ArrayList<>();
        }

        return funicularSub;
    }

    public List<MetroSubmodeEnumeration> getMetroSub() {
        if (metroSub == null) {
            metroSub = new ArrayList<>();
        }

        return metroSub;
    }

    public List<RailSubmodeEnumeration> getRailSub() {
        if (railSub == null) {
            railSub = new ArrayList<>();
        }

        return railSub;
    }

    public List<TelecabinSubmodeEnumeration> getTelecabinSub() {
        if (telecabinSub == null) {
            telecabinSub = new ArrayList<>();
        }

        return telecabinSub;
    }

    public List<TramSubmodeEnumeration> getTramSub() {
        if (tramSub == null) {
            tramSub = new ArrayList<>();
        }

        return tramSub;
    }

    public List<WaterSubmodeEnumeration> getWaterSub() {
        if (waterSub == null) {
            waterSub = new ArrayList<>();
        }

        return waterSub;
    }

    private boolean hasCollectedSubmodes = false;
    private List<Object> allSubmodes;

    public synchronized List<Object> getAllSubmodes() {
        if (!hasCollectedSubmodes) {
            // If all is not null, keep same object.
            allSubmodes = (allSubmodes != null) ? allSubmodes : new ArrayList<>();
            allSubmodes.clear(); // Clear once.

            allSubmodes.addAll(getAirSub());
            allSubmodes.addAll(getBusSub());
            allSubmodes.addAll(getCoachSub());
            allSubmodes.addAll(getFunicularSub());
            allSubmodes.addAll(getMetroSub());
            allSubmodes.addAll(getRailSub());
            allSubmodes.addAll(getTelecabinSub());
            allSubmodes.addAll(getTramSub());
            allSubmodes.addAll(getWaterSub());

            hasCollectedSubmodes = true;
        }

        return allSubmodes;
    }

    public boolean hasExcludedModes() {
        return getPtModes().size() > 0 || getAllSubmodes().size() > 0;
    }
}
