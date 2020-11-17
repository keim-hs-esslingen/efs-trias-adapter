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
import de.vdv.trias.InterchangeLeg;
import de.vdv.trias.InterchangeModesEnumeration;
import de.vdv.trias.PtModesEnumeration;
import de.vdv.trias.TelecabinSubmodeEnumeration;
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
                return Mode.BICYCLE;
            case TAXI:
            case OTHERS_DRIVE_CAR:
                return Mode.TAXI;
            case SELF_DRIVE_CAR:
            case TRUCK:
            case MOTORCYCLE:
                return Mode.CAR;
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

    public static Mode from(InterchangeModesEnumeration mode, Mode fallback) {
        switch (mode) {
            case BIKE_AND_RIDE:
            case BIKE_HIRE:
                return Mode.BICYCLE;
            case CAR_HIRE:
                return Mode.CAR;
            case WALK:
                return Mode.WALK;
            default:
                return fallback;
        }
    }

    public static Mode from(InterchangeModesEnumeration mode) {
        return from(mode, null);
    }

    public static Mode from(InterchangeLeg leg, Mode fallback) {
        var mode = from(leg.getInterchangeMode());

        if (mode == null) {
            mode = from(leg.getContinuousMode());
        }

        if (mode == null) {
            mode = fallback;
        }

        return mode;
    }

    public static Mode from(InterchangeLeg leg) {
        return from(leg, null);
    }

    public static Mode from(de.vdv.trias.Mode mode, Mode fallback) {
        var ptMode = mode.getPtMode();

        switch (ptMode) {
            case BUS:
            case TROLLEY_BUS:
                return Mode.BUS;
            case COACH:
                return Mode.OTHER;
            case TRAM:
                return Mode.TRAM;
            case TAXI:
                return Mode.TAXI;
            case METRO:
                return Mode.METRO;
            case RAIL:
            case INTERCITY_RAIL:
            case URBAN_RAIL:
                return Mode.RAIL;
            case FUNICULAR:
                return Mode.FUNICULAR;
            case WATER:
                return Mode.FERRY;
            case CABLEWAY:
                switch (mode.getTelecabinSubmode()) {
                    case CABLE_CAR:
                    case UNDEFINED:
                    case UNKNOWN:
                        return Mode.CABLE_TRAM;
                    default:
                        return Mode.AERIAL_LIFT;
                }
            case AIR:
                return Mode.FLIGHT;
            case ALL:
                return Mode.MULTIPLE;
            default:
                return fallback;
        }
    }

    public static Mode from(de.vdv.trias.Mode mode) {
        return from(mode, null);
    }

    public static Mode from(TimedLeg leg, Mode fallback) {
        return from(leg.getService().getServiceSection().get(0).getMode(), fallback);
    }

    public static Mode from(TimedLeg leg) {
        return from(leg.getService().getServiceSection().get(0).getMode(), null);
    }

    public static de.vdv.trias.Mode toTriasMode(Mode mode) {
        var res = new de.vdv.trias.Mode();

        switch (mode) {
            case BUS:
                res.setPtMode(PtModesEnumeration.BUS);
                break;
            case CABLE_TRAM:
                res.setPtMode(PtModesEnumeration.CABLEWAY);
                res.setTelecabinSubmode(TelecabinSubmodeEnumeration.CABLE_CAR);
                break;
            case AERIAL_LIFT:
                res.setPtMode(PtModesEnumeration.CABLEWAY);
                res.setTelecabinSubmode(TelecabinSubmodeEnumeration.TELECABIN);
                break;
            case FUNICULAR:
                res.setPtMode(PtModesEnumeration.FUNICULAR);
                break;
            case FERRY:
            case GONDOLA:
                res.setPtMode(PtModesEnumeration.WATER);
                break;
            case RAIL:
                res.setPtMode(PtModesEnumeration.RAIL);
                break;
            case TRAM:
                res.setPtMode(PtModesEnumeration.TRAM);
                break;
            case METRO:
                res.setPtMode(PtModesEnumeration.METRO);
                break;
            case TAXI:
                res.setPtMode(PtModesEnumeration.TAXI);
                break;
            case FLIGHT:
                res.setPtMode(PtModesEnumeration.AIR);
                break;
            case CAR:
            case WALK:
            case BICYCLE:
            case LEG_SWITCH:
            case KICK_SCOOTER:
            case OTHER:
            case MULTIPLE:
            default:
                res.setPtMode(PtModesEnumeration.UNKNOWN);
        }

        return res;
    }
}
