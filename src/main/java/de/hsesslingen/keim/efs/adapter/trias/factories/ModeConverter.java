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

import de.hsesslingen.keim.efs.mobility.service.Mode;
import de.vdv.trias.ContinuousLeg;
import de.vdv.trias.ContinuousModesEnumeration;
import de.vdv.trias.IndividualModesEnumeration;
import de.vdv.trias.PtModesEnumeration;
import de.vdv.trias.TimedLeg;

/**
 *
 * @author keim
 */
public class ModeConverter {

    public static Mode from(IndividualModesEnumeration mode) {
        switch (mode) {
            case WALK:
                return Mode.WALK;
            case CYCLE:
            case MOTORCYCLE:
                return Mode.BICYCLE;
            case TAXI:
                return Mode.TAXI;
            case SELF_DRIVE_CAR:
            case TRUCK:
                return Mode.CAR;
            case OTHERS_DRIVE_CAR:
                return Mode.BUSISH;
            default:
                return null;
        }
    }

    public static Mode from(ContinuousModesEnumeration mode) {
        switch (mode) {
            case WALK:
                return Mode.WALK;
            default:
                return null;
        }
    }

    public static Mode from(ContinuousLeg leg) {
        var mode = from(leg.getService().getIndividualMode());

        if (mode == null) {
            mode = from(leg.getService().getContinuousMode());
        }

        return mode;
    }

    public static Mode from(PtModesEnumeration mode) {
        switch (mode) {
            case BUS:
            case TROLLEY_BUS:
                return Mode.BUS;
            case COACH:
                return Mode.BUSISH;
            case TRAM:
                return Mode.TRAM;
            case TAXI:
                return Mode.TAXI;
            case METRO:
                return Mode.SUBWAY;
            case RAIL:
            case INTERCITY_RAIL:
                return Mode.RAIL;
            case FUNICULAR:
                return Mode.FUNICULAR;
            case WATER:
                return Mode.FERRY;
            case CABLEWAY:
                return Mode.GONDOLA;
            case URBAN_RAIL:
                return Mode.TRAINISH;
            default:
                return null;
        }
    }

    public static Mode from(de.vdv.trias.Mode mode) {
        return from(mode.getPtMode());
    }

    public static Mode from(TimedLeg leg) {
        return from(leg.getService().getServiceSection().get(0).getMode());
    }
}
