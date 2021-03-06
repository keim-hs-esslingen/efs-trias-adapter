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
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import de.hsesslingen.keim.efs.adapter.trias.jaxb.ZonedDateTimeAdapter;


/**
 * Type for Real time connection at a stop.
 * 
 * <p>Java class for MonitoredFeederArrival complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="MonitoredFeederArrivalStructure">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.siri.org.uk/siri}AbstractFeederItemStructure">
 *       &lt;sequence>
 *         &lt;element name="ClearDownRef" type="{http://www.siri.org.uk/siri}ClearDownRefStructure" minOccurs="0"/>
 *         &lt;element name="FeederJourney" type="{http://www.siri.org.uk/siri}InterchangeJourneyStructure"/>
 *         &lt;element ref="{http://www.siri.org.uk/siri}VehicleAtStop" minOccurs="0"/>
 *         &lt;element name="NumberOfTransferPassengers" type="{http://www.w3.org/2001/XMLSchema}nonNegativeInteger" minOccurs="0"/>
 *         &lt;element name="ExpectedArrivalTime" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element ref="{http://www.siri.org.uk/siri}Extensions" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "MonitoredFeederArrivalStructure", namespace = "http://www.siri.org.uk/siri", propOrder = {
    "clearDownRef",
    "feederJourney",
    "vehicleAtStop",
    "numberOfTransferPassengers",
    "expectedArrivalTime",
    "extensions"
})
@ToString
public class MonitoredFeederArrival
    extends AbstractFeederItem
{

    @XmlElement(name = "ClearDownRef", namespace = "http://www.siri.org.uk/siri")
    protected ClearDownRef clearDownRef;
    @XmlElement(name = "FeederJourney", namespace = "http://www.siri.org.uk/siri", required = true)
    protected InterchangeJourney feederJourney;
    @XmlElement(name = "VehicleAtStop", namespace = "http://www.siri.org.uk/siri")
    protected Boolean vehicleAtStop;
    @XmlElement(name = "NumberOfTransferPassengers", namespace = "http://www.siri.org.uk/siri")
    @XmlSchemaType(name = "nonNegativeInteger")
    protected BigInteger numberOfTransferPassengers;
    @XmlElement(name = "ExpectedArrivalTime", namespace = "http://www.siri.org.uk/siri", type = String.class)
    @XmlJavaTypeAdapter(ZonedDateTimeAdapter.class)
    @XmlSchemaType(name = "dateTime")
    protected ZonedDateTime expectedArrivalTime;
    @XmlElement(name = "Extensions", namespace = "http://www.siri.org.uk/siri")
    protected Extensions extensions;

    /**
     * Gets the value of the clearDownRef property.
     * 
     * @return
     *     possible object is
     *     {@link ClearDownRef }
     *     
     */
    public ClearDownRef getClearDownRef() {
        return clearDownRef;
    }

    /**
     * Sets the value of the clearDownRef property.
     * 
     * @param value
     *     allowed object is
     *     {@link ClearDownRef }
     *     
     */
    public MonitoredFeederArrival setClearDownRef(ClearDownRef value) {
        this.clearDownRef = value;
        return this;
    }

    /**
     * Gets the value of the feederJourney property.
     * 
     * @return
     *     possible object is
     *     {@link InterchangeJourney }
     *     
     */
    public InterchangeJourney getFeederJourney() {
        return feederJourney;
    }

    /**
     * Sets the value of the feederJourney property.
     * 
     * @param value
     *     allowed object is
     *     {@link InterchangeJourney }
     *     
     */
    public MonitoredFeederArrival setFeederJourney(InterchangeJourney value) {
        this.feederJourney = value;
        return this;
    }

    /**
     * Gets the value of the vehicleAtStop property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isVehicleAtStop() {
        return vehicleAtStop;
    }

    /**
     * Sets the value of the vehicleAtStop property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public MonitoredFeederArrival setVehicleAtStop(Boolean value) {
        this.vehicleAtStop = value;
        return this;
    }

    /**
     * Gets the value of the numberOfTransferPassengers property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getNumberOfTransferPassengers() {
        return numberOfTransferPassengers;
    }

    /**
     * Sets the value of the numberOfTransferPassengers property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public MonitoredFeederArrival setNumberOfTransferPassengers(BigInteger value) {
        this.numberOfTransferPassengers = value;
        return this;
    }

    /**
     * Gets the value of the expectedArrivalTime property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public ZonedDateTime getExpectedArrivalTime() {
        return expectedArrivalTime;
    }

    /**
     * Sets the value of the expectedArrivalTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public MonitoredFeederArrival setExpectedArrivalTime(ZonedDateTime value) {
        this.expectedArrivalTime = value;
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
    public MonitoredFeederArrival setExtensions(Extensions value) {
        this.extensions = value;
        return this;
    }

}
