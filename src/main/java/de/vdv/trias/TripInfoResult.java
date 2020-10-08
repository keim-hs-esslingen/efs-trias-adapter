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


package de.vdv.trias;

import lombok.ToString;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * TripInfo result structure containing the current status of a trip.
 * 
 * <p>Java class for TripInfoResult complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="TripInfoResultStructure">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="PreviousCall" type="{http://www.vdv.de/trias}CallAtStopStructure" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="CurrentPosition" type="{http://www.vdv.de/trias}VehiclePositionStructure" minOccurs="0"/>
 *         &lt;element name="OnwardCall" type="{http://www.vdv.de/trias}CallAtStopStructure" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="Service" type="{http://www.vdv.de/trias}DatedJourneyStructure" minOccurs="0"/>
 *         &lt;group ref="{http://www.vdv.de/trias}OperatingDaysGroup" minOccurs="0"/>
 *         &lt;element name="ParallelService" type="{http://www.vdv.de/trias}ParallelServiceStructure" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="JourneyTrack" type="{http://www.vdv.de/trias}LegTrackStructure" minOccurs="0"/>
 *         &lt;element name="Extension" type="{http://www.w3.org/2001/XMLSchema}anyType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TripInfoResultStructure", namespace = "http://www.vdv.de/trias", propOrder = {
    "previousCall",
    "currentPosition",
    "onwardCall",
    "service",
    "operatingDays",
    "operatingDaysDescription",
    "parallelService",
    "journeyTrack",
    "extension"
})
@ToString
public class TripInfoResult {

    @XmlElement(name = "PreviousCall", namespace = "http://www.vdv.de/trias")
    protected List<CallAtStop> previousCall;
    @XmlElement(name = "CurrentPosition", namespace = "http://www.vdv.de/trias")
    protected VehiclePosition currentPosition;
    @XmlElement(name = "OnwardCall", namespace = "http://www.vdv.de/trias")
    protected List<CallAtStop> onwardCall;
    @XmlElement(name = "Service", namespace = "http://www.vdv.de/trias")
    protected DatedJourney service;
    @XmlElement(name = "OperatingDays", namespace = "http://www.vdv.de/trias")
    protected OperatingDays operatingDays;
    @XmlElement(name = "OperatingDaysDescription", namespace = "http://www.vdv.de/trias")
    protected List<InternationalText> operatingDaysDescription;
    @XmlElement(name = "ParallelService", namespace = "http://www.vdv.de/trias")
    protected List<ParallelService> parallelService;
    @XmlElement(name = "JourneyTrack", namespace = "http://www.vdv.de/trias")
    protected LegTrack journeyTrack;
    @XmlElement(name = "Extension", namespace = "http://www.vdv.de/trias")
    protected Object extension;

    /**
     * Gets the value of the previousCall property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the previousCall property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPreviousCall().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CallAtStop }
     * 
     * 
     */
    public List<CallAtStop> getPreviousCall() {
        if (previousCall == null) {
            previousCall = new ArrayList<CallAtStop>();
        }
        return this.previousCall;
    }

    /**
     * Gets the value of the currentPosition property.
     * 
     * @return
     *     possible object is
     *     {@link VehiclePosition }
     *     
     */
    public VehiclePosition getCurrentPosition() {
        return currentPosition;
    }

    /**
     * Sets the value of the currentPosition property.
     * 
     * @param value
     *     allowed object is
     *     {@link VehiclePosition }
     *     
     */
    public TripInfoResult setCurrentPosition(VehiclePosition value) {
        this.currentPosition = value;
        return this;
    }

    /**
     * Gets the value of the onwardCall property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the onwardCall property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getOnwardCall().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CallAtStop }
     * 
     * 
     */
    public List<CallAtStop> getOnwardCall() {
        if (onwardCall == null) {
            onwardCall = new ArrayList<CallAtStop>();
        }
        return this.onwardCall;
    }

    /**
     * Gets the value of the service property.
     * 
     * @return
     *     possible object is
     *     {@link DatedJourney }
     *     
     */
    public DatedJourney getService() {
        return service;
    }

    /**
     * Sets the value of the service property.
     * 
     * @param value
     *     allowed object is
     *     {@link DatedJourney }
     *     
     */
    public TripInfoResult setService(DatedJourney value) {
        this.service = value;
        return this;
    }

    /**
     * Gets the value of the operatingDays property.
     * 
     * @return
     *     possible object is
     *     {@link OperatingDays }
     *     
     */
    public OperatingDays getOperatingDays() {
        return operatingDays;
    }

    /**
     * Sets the value of the operatingDays property.
     * 
     * @param value
     *     allowed object is
     *     {@link OperatingDays }
     *     
     */
    public TripInfoResult setOperatingDays(OperatingDays value) {
        this.operatingDays = value;
        return this;
    }

    /**
     * Gets the value of the operatingDaysDescription property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the operatingDaysDescription property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getOperatingDaysDescription().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link InternationalText }
     * 
     * 
     */
    public List<InternationalText> getOperatingDaysDescription() {
        if (operatingDaysDescription == null) {
            operatingDaysDescription = new ArrayList<InternationalText>();
        }
        return this.operatingDaysDescription;
    }

    /**
     * Gets the value of the parallelService property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the parallelService property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getParallelService().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ParallelService }
     * 
     * 
     */
    public List<ParallelService> getParallelService() {
        if (parallelService == null) {
            parallelService = new ArrayList<ParallelService>();
        }
        return this.parallelService;
    }

    /**
     * Gets the value of the journeyTrack property.
     * 
     * @return
     *     possible object is
     *     {@link LegTrack }
     *     
     */
    public LegTrack getJourneyTrack() {
        return journeyTrack;
    }

    /**
     * Sets the value of the journeyTrack property.
     * 
     * @param value
     *     allowed object is
     *     {@link LegTrack }
     *     
     */
    public TripInfoResult setJourneyTrack(LegTrack value) {
        this.journeyTrack = value;
        return this;
    }

    /**
     * Gets the value of the extension property.
     * 
     * @return
     *     possible object is
     *     {@link Object }
     *     
     */
    public Object getExtension() {
        return extension;
    }

    /**
     * Sets the value of the extension property.
     * 
     * @param value
     *     allowed object is
     *     {@link Object }
     *     
     */
    public TripInfoResult setExtension(Object value) {
        this.extension = value;
        return this;
    }

}