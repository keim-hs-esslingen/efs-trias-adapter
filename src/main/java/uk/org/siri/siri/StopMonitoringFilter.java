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
import java.math.BigInteger;
import java.time.ZonedDateTime;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import javax.xml.datatype.Duration;
import de.hsesslingen.keim.efs.adapter.trias.jaxb.ZonedDateTimeAdapter;


/**
 * Type for an individual Stop Monitoring  a Multiple Request
 * 
 * <p>Java class for StopMonitoringFilter complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="StopMonitoringFilterStructure">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;group ref="{http://www.siri.org.uk/siri}StopMonitoringTopicGroup"/>
 *         &lt;group ref="{http://www.siri.org.uk/siri}StopMonitoringRequestPolicyGroup"/>
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
@XmlType(name = "StopMonitoringFilterStructure", namespace = "http://www.siri.org.uk/siri", propOrder = {
    "previewInterval",
    "startTime",
    "monitoringRef",
    "operatorRef",
    "lineRef",
    "directionRef",
    "destinationRef",
    "stopVisitTypes",
    "language",
    "maximumStopVisits",
    "minimumStopVisitsPerLine",
    "maximumTextLength",
    "stopMonitoringDetailLevel",
    "maximumNumberOfCalls",
    "extensions"
})
@ToString
public class StopMonitoringFilter {

    @XmlElement(name = "PreviewInterval", namespace = "http://www.siri.org.uk/siri")
    protected Duration previewInterval;
    @XmlElement(name = "StartTime", namespace = "http://www.siri.org.uk/siri", type = String.class)
    @XmlJavaTypeAdapter(ZonedDateTimeAdapter.class)
    @XmlSchemaType(name = "dateTime")
    protected ZonedDateTime startTime;
    @XmlElement(name = "MonitoringRef", namespace = "http://www.siri.org.uk/siri", required = true)
    protected MonitoringRef monitoringRef;
    @XmlElement(name = "OperatorRef", namespace = "http://www.siri.org.uk/siri")
    protected OperatorRef operatorRef;
    @XmlElement(name = "LineRef", namespace = "http://www.siri.org.uk/siri")
    protected LineRef lineRef;
    @XmlElement(name = "DirectionRef", namespace = "http://www.siri.org.uk/siri")
    protected DirectionRef directionRef;
    @XmlElement(name = "DestinationRef", namespace = "http://www.siri.org.uk/siri")
    protected DestinationRef destinationRef;
    @XmlElement(name = "StopVisitTypes", namespace = "http://www.siri.org.uk/siri", defaultValue = "all")
    @XmlSchemaType(name = "NMTOKEN")
    protected StopVisitTypeEnumeration stopVisitTypes;
    @XmlElement(name = "Language", namespace = "http://www.siri.org.uk/siri", defaultValue = "en")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "language")
    protected String language;
    @XmlElement(name = "MaximumStopVisits", namespace = "http://www.siri.org.uk/siri")
    @XmlSchemaType(name = "nonNegativeInteger")
    protected BigInteger maximumStopVisits;
    @XmlElement(name = "MinimumStopVisitsPerLine", namespace = "http://www.siri.org.uk/siri")
    @XmlSchemaType(name = "nonNegativeInteger")
    protected BigInteger minimumStopVisitsPerLine;
    @XmlElement(name = "MaximumTextLength", namespace = "http://www.siri.org.uk/siri", defaultValue = "30")
    @XmlSchemaType(name = "positiveInteger")
    protected BigInteger maximumTextLength;
    @XmlElement(name = "StopMonitoringDetailLevel", namespace = "http://www.siri.org.uk/siri", defaultValue = "normal")
    @XmlSchemaType(name = "NMTOKEN")
    protected StopMonitoringDetailEnumeration stopMonitoringDetailLevel;
    @XmlElement(name = "MaximumNumberOfCalls", namespace = "http://www.siri.org.uk/siri")
    protected StopMonitoringFilter.MaximumNumberOfCalls maximumNumberOfCalls;
    @XmlElement(name = "Extensions", namespace = "http://www.siri.org.uk/siri")
    protected Extensions extensions;

    /**
     * Gets the value of the previewInterval property.
     * 
     * @return
     *     possible object is
     *     {@link Duration }
     *     
     */
    public Duration getPreviewInterval() {
        return previewInterval;
    }

    /**
     * Sets the value of the previewInterval property.
     * 
     * @param value
     *     allowed object is
     *     {@link Duration }
     *     
     */
    public StopMonitoringFilter setPreviewInterval(Duration value) {
        this.previewInterval = value;
        return this;
    }

    /**
     * Gets the value of the startTime property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public ZonedDateTime getStartTime() {
        return startTime;
    }

    /**
     * Sets the value of the startTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public StopMonitoringFilter setStartTime(ZonedDateTime value) {
        this.startTime = value;
        return this;
    }

    /**
     * Gets the value of the monitoringRef property.
     * 
     * @return
     *     possible object is
     *     {@link MonitoringRef }
     *     
     */
    public MonitoringRef getMonitoringRef() {
        return monitoringRef;
    }

    /**
     * Sets the value of the monitoringRef property.
     * 
     * @param value
     *     allowed object is
     *     {@link MonitoringRef }
     *     
     */
    public StopMonitoringFilter setMonitoringRef(MonitoringRef value) {
        this.monitoringRef = value;
        return this;
    }

    /**
     * Gets the value of the operatorRef property.
     * 
     * @return
     *     possible object is
     *     {@link OperatorRef }
     *     
     */
    public OperatorRef getOperatorRef() {
        return operatorRef;
    }

    /**
     * Sets the value of the operatorRef property.
     * 
     * @param value
     *     allowed object is
     *     {@link OperatorRef }
     *     
     */
    public StopMonitoringFilter setOperatorRef(OperatorRef value) {
        this.operatorRef = value;
        return this;
    }

    /**
     * Gets the value of the lineRef property.
     * 
     * @return
     *     possible object is
     *     {@link LineRef }
     *     
     */
    public LineRef getLineRef() {
        return lineRef;
    }

    /**
     * Sets the value of the lineRef property.
     * 
     * @param value
     *     allowed object is
     *     {@link LineRef }
     *     
     */
    public StopMonitoringFilter setLineRef(LineRef value) {
        this.lineRef = value;
        return this;
    }

    /**
     * Gets the value of the directionRef property.
     * 
     * @return
     *     possible object is
     *     {@link DirectionRef }
     *     
     */
    public DirectionRef getDirectionRef() {
        return directionRef;
    }

    /**
     * Sets the value of the directionRef property.
     * 
     * @param value
     *     allowed object is
     *     {@link DirectionRef }
     *     
     */
    public StopMonitoringFilter setDirectionRef(DirectionRef value) {
        this.directionRef = value;
        return this;
    }

    /**
     * Gets the value of the destinationRef property.
     * 
     * @return
     *     possible object is
     *     {@link DestinationRef }
     *     
     */
    public DestinationRef getDestinationRef() {
        return destinationRef;
    }

    /**
     * Sets the value of the destinationRef property.
     * 
     * @param value
     *     allowed object is
     *     {@link DestinationRef }
     *     
     */
    public StopMonitoringFilter setDestinationRef(DestinationRef value) {
        this.destinationRef = value;
        return this;
    }

    /**
     * Gets the value of the stopVisitTypes property.
     * 
     * @return
     *     possible object is
     *     {@link StopVisitTypeEnumeration }
     *     
     */
    public StopVisitTypeEnumeration getStopVisitTypes() {
        return stopVisitTypes;
    }

    /**
     * Sets the value of the stopVisitTypes property.
     * 
     * @param value
     *     allowed object is
     *     {@link StopVisitTypeEnumeration }
     *     
     */
    public StopMonitoringFilter setStopVisitTypes(StopVisitTypeEnumeration value) {
        this.stopVisitTypes = value;
        return this;
    }

    /**
     * Gets the value of the language property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLanguage() {
        return language;
    }

    /**
     * Sets the value of the language property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public StopMonitoringFilter setLanguage(String value) {
        this.language = value;
        return this;
    }

    /**
     * Gets the value of the maximumStopVisits property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getMaximumStopVisits() {
        return maximumStopVisits;
    }

    /**
     * Sets the value of the maximumStopVisits property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public StopMonitoringFilter setMaximumStopVisits(BigInteger value) {
        this.maximumStopVisits = value;
        return this;
    }

    /**
     * Gets the value of the minimumStopVisitsPerLine property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getMinimumStopVisitsPerLine() {
        return minimumStopVisitsPerLine;
    }

    /**
     * Sets the value of the minimumStopVisitsPerLine property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public StopMonitoringFilter setMinimumStopVisitsPerLine(BigInteger value) {
        this.minimumStopVisitsPerLine = value;
        return this;
    }

    /**
     * Gets the value of the maximumTextLength property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getMaximumTextLength() {
        return maximumTextLength;
    }

    /**
     * Sets the value of the maximumTextLength property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public StopMonitoringFilter setMaximumTextLength(BigInteger value) {
        this.maximumTextLength = value;
        return this;
    }

    /**
     * Gets the value of the stopMonitoringDetailLevel property.
     * 
     * @return
     *     possible object is
     *     {@link StopMonitoringDetailEnumeration }
     *     
     */
    public StopMonitoringDetailEnumeration getStopMonitoringDetailLevel() {
        return stopMonitoringDetailLevel;
    }

    /**
     * Sets the value of the stopMonitoringDetailLevel property.
     * 
     * @param value
     *     allowed object is
     *     {@link StopMonitoringDetailEnumeration }
     *     
     */
    public StopMonitoringFilter setStopMonitoringDetailLevel(StopMonitoringDetailEnumeration value) {
        this.stopMonitoringDetailLevel = value;
        return this;
    }

    /**
     * Gets the value of the maximumNumberOfCalls property.
     * 
     * @return
     *     possible object is
     *     {@link StopMonitoringFilter.MaximumNumberOfCalls }
     *     
     */
    public StopMonitoringFilter.MaximumNumberOfCalls getMaximumNumberOfCalls() {
        return maximumNumberOfCalls;
    }

    /**
     * Sets the value of the maximumNumberOfCalls property.
     * 
     * @param value
     *     allowed object is
     *     {@link StopMonitoringFilter.MaximumNumberOfCalls }
     *     
     */
    public void setMaximumNumberOfCalls(StopMonitoringFilter.MaximumNumberOfCalls value) {
        this.maximumNumberOfCalls = value;
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
    public StopMonitoringFilter setExtensions(Extensions value) {
        this.extensions = value;
        return this;
    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="Previous" type="{http://www.w3.org/2001/XMLSchema}nonNegativeInteger" minOccurs="0"/>
     *         &lt;element name="Onwards" type="{http://www.w3.org/2001/XMLSchema}nonNegativeInteger" minOccurs="0"/>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "previous",
        "onwards"
    })
    public static class MaximumNumberOfCalls {

        @XmlElement(name = "Previous", namespace = "http://www.siri.org.uk/siri")
        @XmlSchemaType(name = "nonNegativeInteger")
        protected BigInteger previous;
        @XmlElement(name = "Onwards", namespace = "http://www.siri.org.uk/siri")
        @XmlSchemaType(name = "nonNegativeInteger")
        protected BigInteger onwards;

        /**
         * Gets the value of the previous property.
         * 
         * @return
         *     possible object is
         *     {@link BigInteger }
         *     
         */
        public BigInteger getPrevious() {
            return previous;
        }

        /**
         * Sets the value of the previous property.
         * 
         * @param value
         *     allowed object is
         *     {@link BigInteger }
         *     
         */
        public void setPrevious(BigInteger value) {
            this.previous = value;
        }

        /**
         * Gets the value of the onwards property.
         * 
         * @return
         *     possible object is
         *     {@link BigInteger }
         *     
         */
        public BigInteger getOnwards() {
            return onwards;
        }

        /**
         * Sets the value of the onwards property.
         * 
         * @param value
         *     allowed object is
         *     {@link BigInteger }
         *     
         */
        public void setOnwards(BigInteger value) {
            this.onwards = value;
        }

    }

}
