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
 * Description of any change concernin g a facility. New structure defined in SIRI XSD 1.1 for Faclities Management
 * 
 * <p>Java class for FacilityCondition complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="FacilityConditionStructure">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;choice>
 *           &lt;element name="Facility" type="{http://www.siri.org.uk/siri}FacilityStructure"/>
 *           &lt;element ref="{http://www.siri.org.uk/siri}FacilityRef"/>
 *         &lt;/choice>
 *         &lt;element name="FacilityStatus" type="{http://www.siri.org.uk/siri}FacilityStatusStructure"/>
 *         &lt;element ref="{http://www.siri.org.uk/siri}SituationRef" minOccurs="0"/>
 *         &lt;element name="Remedy" type="{http://www.siri.org.uk/siri}RemedyStructure" minOccurs="0"/>
 *         &lt;element name="MonitoringInfo" type="{http://www.siri.org.uk/siri}MonitoringInformationStructure" minOccurs="0"/>
 *         &lt;element name="ValidityPeriod" type="{http://www.siri.org.uk/siri}HalfOpenTimestampRangeStructure" minOccurs="0"/>
 *         &lt;element ref="{http://www.siri.org.uk/siri}Extensions" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "FacilityConditionStructure", namespace = "http://www.siri.org.uk/siri", propOrder = {
    "facility",
    "facilityRef",
    "facilityStatus",
    "situationRef",
    "remedy",
    "monitoringInfo",
    "validityPeriod",
    "extensions"
})
@ToString
public class FacilityCondition {

    @XmlElement(name = "Facility", namespace = "http://www.siri.org.uk/siri")
    protected Facility facility;
    @XmlElement(name = "FacilityRef", namespace = "http://www.siri.org.uk/siri")
    protected FacilityRef facilityRef;
    @XmlElement(name = "FacilityStatus", namespace = "http://www.siri.org.uk/siri", required = true)
    protected FacilityStatus facilityStatus;
    @XmlElement(name = "SituationRef", namespace = "http://www.siri.org.uk/siri")
    protected SituationRef situationRef;
    @XmlElement(name = "Remedy", namespace = "http://www.siri.org.uk/siri")
    protected Remedy remedy;
    @XmlElement(name = "MonitoringInfo", namespace = "http://www.siri.org.uk/siri")
    protected MonitoringInformation monitoringInfo;
    @XmlElement(name = "ValidityPeriod", namespace = "http://www.siri.org.uk/siri")
    protected HalfOpenTimestampRange validityPeriod;
    @XmlElement(name = "Extensions", namespace = "http://www.siri.org.uk/siri")
    protected Extensions extensions;

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
    public FacilityCondition setFacility(Facility value) {
        this.facility = value;
        return this;
    }

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
    public FacilityCondition setFacilityRef(FacilityRef value) {
        this.facilityRef = value;
        return this;
    }

    /**
     * Gets the value of the facilityStatus property.
     * 
     * @return
     *     possible object is
     *     {@link FacilityStatus }
     *     
     */
    public FacilityStatus getFacilityStatus() {
        return facilityStatus;
    }

    /**
     * Sets the value of the facilityStatus property.
     * 
     * @param value
     *     allowed object is
     *     {@link FacilityStatus }
     *     
     */
    public FacilityCondition setFacilityStatus(FacilityStatus value) {
        this.facilityStatus = value;
        return this;
    }

    /**
     * Gets the value of the situationRef property.
     * 
     * @return
     *     possible object is
     *     {@link SituationRef }
     *     
     */
    public SituationRef getSituationRef() {
        return situationRef;
    }

    /**
     * Sets the value of the situationRef property.
     * 
     * @param value
     *     allowed object is
     *     {@link SituationRef }
     *     
     */
    public FacilityCondition setSituationRef(SituationRef value) {
        this.situationRef = value;
        return this;
    }

    /**
     * Gets the value of the remedy property.
     * 
     * @return
     *     possible object is
     *     {@link Remedy }
     *     
     */
    public Remedy getRemedy() {
        return remedy;
    }

    /**
     * Sets the value of the remedy property.
     * 
     * @param value
     *     allowed object is
     *     {@link Remedy }
     *     
     */
    public FacilityCondition setRemedy(Remedy value) {
        this.remedy = value;
        return this;
    }

    /**
     * Gets the value of the monitoringInfo property.
     * 
     * @return
     *     possible object is
     *     {@link MonitoringInformation }
     *     
     */
    public MonitoringInformation getMonitoringInfo() {
        return monitoringInfo;
    }

    /**
     * Sets the value of the monitoringInfo property.
     * 
     * @param value
     *     allowed object is
     *     {@link MonitoringInformation }
     *     
     */
    public FacilityCondition setMonitoringInfo(MonitoringInformation value) {
        this.monitoringInfo = value;
        return this;
    }

    /**
     * Gets the value of the validityPeriod property.
     * 
     * @return
     *     possible object is
     *     {@link HalfOpenTimestampRange }
     *     
     */
    public HalfOpenTimestampRange getValidityPeriod() {
        return validityPeriod;
    }

    /**
     * Sets the value of the validityPeriod property.
     * 
     * @param value
     *     allowed object is
     *     {@link HalfOpenTimestampRange }
     *     
     */
    public FacilityCondition setValidityPeriod(HalfOpenTimestampRange value) {
        this.validityPeriod = value;
        return this;
    }

    /**
     * Gets the value of the extensions property.
     * 
     * @return
     *     possible object is
     *     {@link Extensions }
     *     
     */
    public Extensions getExtensions() {
        return extensions;
    }

    /**
     * Sets the value of the extensions property.
     * 
     * @param value
     *     allowed object is
     *     {@link Extensions }
     *     
     */
    public FacilityCondition setExtensions(Extensions value) {
        this.extensions = value;
        return this;
    }

}