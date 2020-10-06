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

//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
//


package eu.datex2.schema._1_0._1_0;

import lombok.ToString;
import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for PollutantTypeEnum.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="PollutantTypeEnum">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="benzeneTolueneXylene"/>
 *     &lt;enumeration value="carbonMonoxide"/>
 *     &lt;enumeration value="lead"/>
 *     &lt;enumeration value="methane"/>
 *     &lt;enumeration value="nitricOxide"/>
 *     &lt;enumeration value="nitrogenDioxide"/>
 *     &lt;enumeration value="nitrogenMonoxide"/>
 *     &lt;enumeration value="nitrogenOxides"/>
 *     &lt;enumeration value="nonMethaneHydrocarbons"/>
 *     &lt;enumeration value="ozone"/>
 *     &lt;enumeration value="particulates10"/>
 *     &lt;enumeration value="polycyclicAromaticHydrocarbons"/>
 *     &lt;enumeration value="primaryParticulate"/>
 *     &lt;enumeration value="sulphurDioxide"/>
 *     &lt;enumeration value="totalHydrocarbons"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "PollutantTypeEnum", namespace = "http://datex2.eu/schema/1_0/1_0")
@XmlEnum
public enum PollutantTypeEnum {


    /**
     * Benzene, toluene or xylene.
     * 
     */
    @XmlEnumValue("benzeneTolueneXylene")
    BENZENE_TOLUENE_XYLENE("benzeneTolueneXylene"),

    /**
     * Carbon monoxide.
     * 
     */
    @XmlEnumValue("carbonMonoxide")
    CARBON_MONOXIDE("carbonMonoxide"),

    /**
     * Lead.
     * 
     */
    @XmlEnumValue("lead")
    LEAD("lead"),

    /**
     * Methane.
     * 
     */
    @XmlEnumValue("methane")
    METHANE("methane"),

    /**
     * Nitric oxide.
     * 
     */
    @XmlEnumValue("nitricOxide")
    NITRIC_OXIDE("nitricOxide"),

    /**
     * Nitrogen dioxide.
     * 
     */
    @XmlEnumValue("nitrogenDioxide")
    NITROGEN_DIOXIDE("nitrogenDioxide"),

    /**
     * Nitrogen monoxide.
     * 
     */
    @XmlEnumValue("nitrogenMonoxide")
    NITROGEN_MONOXIDE("nitrogenMonoxide"),

    /**
     * Nitrogen oxides.
     * 
     */
    @XmlEnumValue("nitrogenOxides")
    NITROGEN_OXIDES("nitrogenOxides"),

    /**
     * Non-methane hydrocarbons.
     * 
     */
    @XmlEnumValue("nonMethaneHydrocarbons")
    NON_METHANE_HYDROCARBONS("nonMethaneHydrocarbons"),

    /**
     * Ozone.
     * 
     */
    @XmlEnumValue("ozone")
    OZONE("ozone"),

    /**
     * Particulate matter which passes through a size-selective inlet with a 50% cut-off efficiency at an aerodynamic diameter of 10 µm (micrometres).
     * 
     */
    @XmlEnumValue("particulates10")
    PARTICULATES_10("particulates10"),

    /**
     * PolycyclicAromaticHydrocarbons.
     * 
     */
    @XmlEnumValue("polycyclicAromaticHydrocarbons")
    POLYCYCLIC_AROMATIC_HYDROCARBONS("polycyclicAromaticHydrocarbons"),

    /**
     * Primary particulate particles.
     * 
     */
    @XmlEnumValue("primaryParticulate")
    PRIMARY_PARTICULATE("primaryParticulate"),

    /**
     * Sulphur dioxide.
     * 
     */
    @XmlEnumValue("sulphurDioxide")
    SULPHUR_DIOXIDE("sulphurDioxide"),

    /**
     * Total hydrocarbons, i.e. including methane and non-methane.
     * 
     */
    @XmlEnumValue("totalHydrocarbons")
    TOTAL_HYDROCARBONS("totalHydrocarbons");
    private final String value;

    PollutantTypeEnum(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static PollutantTypeEnum fromValue(String v) {
        for (PollutantTypeEnum c: PollutantTypeEnum.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
