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


package uk.org.siri.siri;

import lombok.ToString;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


/**
 * Type for Common Request Policy capabilities.
 * 
 * <p>Java class for CapabilityRequestPolicy complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="CapabilityRequestPolicyStructure">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="NationalLanguage" type="{http://www.w3.org/2001/XMLSchema}language" maxOccurs="unbounded"/>
 *         &lt;choice>
 *           &lt;element name="GmlCoordinateFormat" type="{http://www.siri.org.uk/siri}SrsNameType"/>
 *           &lt;element name="WgsDecimalDegrees" type="{http://www.siri.org.uk/siri}EmptyType"/>
 *         &lt;/choice>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CapabilityRequestPolicyStructure", namespace = "http://www.siri.org.uk/siri", propOrder = {
    "nationalLanguage",
    "gmlCoordinateFormat",
    "wgsDecimalDegrees"
})
@XmlSeeAlso({
    uk.org.siri.siri.SituationExchangeServiceCapabilities.RequestPolicy.class,
    uk.org.siri.siri.ProductionTimetableServiceCapabilities.RequestPolicy.class,
    uk.org.siri.siri.VehicleMonitoringServiceCapabilities.RequestPolicy.class,
    uk.org.siri.siri.ConnectionTimetableServiceCapabilities.RequestPolicy.class,
    uk.org.siri.siri.FacilityMonitoringServiceCapabilities.RequestPolicy.class,
    uk.org.siri.siri.EstimatedTimetableServiceCapabilities.RequestPolicy.class,
    EstimatedTimetableCapabilityRequestPolicy.class,
    VehicleMonitoringCapabilityRequestPolicy.class,
    uk.org.siri.siri.ConnectionMonitoringServiceCapabilities.RequestPolicy.class,
    ConnectionTimetableCapabilityRequestPolicy.class,
    ConnectionMonitoringCapabilityRequestPolicy.class,
    ProductionTimetableCapabilityRequestPolicy.class,
    StopMonitoringCapabilityRequestPolicy.class
})
@ToString
public class CapabilityRequestPolicy {

    @XmlElement(name = "NationalLanguage", namespace = "http://www.siri.org.uk/siri", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "language")
    protected List<String> nationalLanguage;
    @XmlElement(name = "GmlCoordinateFormat", namespace = "http://www.siri.org.uk/siri")
    protected String gmlCoordinateFormat;
    @XmlElement(name = "WgsDecimalDegrees", namespace = "http://www.siri.org.uk/siri")
    protected String wgsDecimalDegrees;

    /**
     * Gets the value of the nationalLanguage property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the nationalLanguage property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getNationalLanguage().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getNationalLanguage() {
        if (nationalLanguage == null) {
            nationalLanguage = new ArrayList<String>();
        }
        return this.nationalLanguage;
    }

    /**
     * Gets the value of the gmlCoordinateFormat property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGmlCoordinateFormat() {
        return gmlCoordinateFormat;
    }

    /**
     * Sets the value of the gmlCoordinateFormat property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public CapabilityRequestPolicy setGmlCoordinateFormat(String value) {
        this.gmlCoordinateFormat = value;
        return this;
    }

    /**
     * Gets the value of the wgsDecimalDegrees property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getWgsDecimalDegrees() {
        return wgsDecimalDegrees;
    }

    /**
     * Sets the value of the wgsDecimalDegrees property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public CapabilityRequestPolicy setWgsDecimalDegrees(String value) {
        this.wgsDecimalDegrees = value;
        return this;
    }

}
