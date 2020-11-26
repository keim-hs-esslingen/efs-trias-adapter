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
import lombok.Getter;
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

    @Getter
    @Setter
    private List<PtModesEnumeration> ptModes;

    @Getter
    @Setter
    private List<AirSubmodeEnumeration> airSub;

    @Getter
    @Setter
    private List<BusSubmodeEnumeration> busSub;

    @Getter
    @Setter
    private List<CoachSubmodeEnumeration> coachSub;

    @Getter
    @Setter
    private List<FunicularSubmodeEnumeration> funicularSub;

    @Getter
    @Setter
    private List<MetroSubmodeEnumeration> metroSub;

    @Getter
    @Setter
    private List<RailSubmodeEnumeration> railSub;

    @Getter
    @Setter
    private List<TelecabinSubmodeEnumeration> telecabinSub;

    @Getter
    @Setter
    private List<TramSubmodeEnumeration> tramSub;

    @Getter
    @Setter
    private List<WaterSubmodeEnumeration> waterSub;

    private boolean hasCollectedSubmodes = false;
    private List<Object> allSubmodes;

    public synchronized List<Object> getAllSubmodes() {
        if (!hasCollectedSubmodes) {
            // If all is not null, keep same object.
            allSubmodes = (allSubmodes != null) ? allSubmodes : new ArrayList<>();
            allSubmodes.clear(); // Clear once.

            allSubmodes.addAll(airSub);
            allSubmodes.addAll(busSub);
            allSubmodes.addAll(coachSub);
            allSubmodes.addAll(funicularSub);
            allSubmodes.addAll(metroSub);
            allSubmodes.addAll(railSub);
            allSubmodes.addAll(telecabinSub);
            allSubmodes.addAll(tramSub);
            allSubmodes.addAll(waterSub);

            hasCollectedSubmodes = true;
        }

        return allSubmodes;
    }

    public boolean hasExcludedSubModes() {
        return getAllSubmodes().size() > 0;
    }
}
