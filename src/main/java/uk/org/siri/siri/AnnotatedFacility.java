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
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Summary information about a Facilities 
 * 
 * <p>Java class for AnnotatedFacility complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="AnnotatedFacilityStructure">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{http://www.siri.org.uk/siri}FacilityRef"/>
 *         &lt;element name="Monitored" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="Facility" type="{http://www.siri.org.uk/siri}FacilityStructure" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AnnotatedFacilityStructure", namespace = "http://www.siri.org.uk/siri", propOrder = {
    "facilityRef",
    "monitored",
    "facility"
})
@ToString
public class AnnotatedFacility {

    @XmlElement(name = "FacilityRef", namespace = "http://www.siri.org.uk/siri", required = true)
    protected FacilityRef facilityRef;
    @XmlElement(name = "Monitored", namespace = "http://www.siri.org.uk/siri", defaultValue = "true")
    protected Boolean monitored;
    @XmlElement(name = "Facility", namespace = "http://www.siri.org.uk/siri")
    protected Facility facility;

    /**
     * Gets the value of the facilityRef property.
     * 
     * @return
     *     possible object is
     *     {@link FacilityRef }
     *     
     */
    public FacilityRef getFacilityRef() {
        return facilityRef;
    }

    /**
     * Sets the value of the facilityRef property.
     * 
     * @param value
     *     allowed object is
     *     {@link FacilityRef }
     *     
     */
    public AnnotatedFacility setFacilityRef(FacilityRef value) {
        this.facilityRef = value;
        return this;
    }

    /**
     * Gets the value of the monitored property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isMonitored() {
        return monitored;
    }

    /**
     * Sets the value of the monitored property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public AnnotatedFacility setMonitored(Boolean value) {
        this.monitored = value;
        return this;
    }

    /**
     * Gets the value of the facility property.
     * 
     * @return
     *     possible object is
     *     {@link Facility }
     *     
     */
    public Facility getFacility() {
        return facility;
    }

    /**
     * Sets the value of the facility property.
     * 
     * @param value
     *     allowed object is
     *     {@link Facility }
     *     
     */
    public AnnotatedFacility setFacility(Facility value) {
        this.facility = value;
        return this;
    }

}
