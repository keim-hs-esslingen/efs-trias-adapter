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
package ptmodefilter;

import de.hsesslingen.keim.efs.mobility.service.Mode;
import de.vdv.trias.PtModesEnumeration;
import de.vdv.trias.TramSubmodeEnumeration;
import de.vdv.trias.WaterSubmodeEnumeration;
import java.util.Set;
import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

/**
 *
 * @author ben
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = {TestApplication.class})
@ActiveProfiles("ptmodes")
public class PtFilterTest {

    @Autowired
    private TestOptionsService optionsService;

    @Test
    public void testFilterCreation1() {
        var filter = optionsService.createFilter(Set.of());

        assertTrue(filter.isExclude());

        assertTrue(filter.getPtMode().contains(PtModesEnumeration.AIR));
        assertTrue(filter.getPtMode().contains(PtModesEnumeration.INTERCITY_RAIL));
        assertFalse(filter.getPtMode().contains(PtModesEnumeration.RAIL));
        assertFalse(filter.getPtMode().contains(PtModesEnumeration.TRAM));

        assertTrue(filter.getPtSubmodeChoiceGroup().contains(WaterSubmodeEnumeration.POST_BOAT));
        assertFalse(filter.getPtSubmodeChoiceGroup().contains(TramSubmodeEnumeration.SHUTTLE_TRAM));
    }

    @Test
    public void testFilterCreation2() {
        var filter = optionsService.createFilter(Set.of(Mode.METRO));

        assertFalse(filter.isExclude());

        assertFalse(filter.getPtMode().contains(PtModesEnumeration.AIR));
        assertFalse(filter.getPtMode().contains(PtModesEnumeration.INTERCITY_RAIL));
        assertFalse(filter.getPtMode().contains(PtModesEnumeration.RAIL));
        assertFalse(filter.getPtMode().contains(PtModesEnumeration.TRAM));
        assertTrue(filter.getPtMode().contains(PtModesEnumeration.METRO));

        assertFalse(filter.getPtSubmodeChoiceGroup().contains(WaterSubmodeEnumeration.POST_BOAT));
        assertFalse(filter.getPtSubmodeChoiceGroup().contains(TramSubmodeEnumeration.SHUTTLE_TRAM));
    }

}
