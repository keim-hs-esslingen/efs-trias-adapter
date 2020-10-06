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
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import javax.xml.datatype.Duration;
import de.hsesslingen.keim.efs.adapter.trias.jaxb.ZonedDateTimeAdapter;


/**
 * Data type for Rea-ltime info about a Vehicle Journey Stop.
 * 
 * <p>Java class for EstimatedCall complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="EstimatedCallStructure">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;group ref="{http://www.siri.org.uk/siri}StopPointInSequenceGroup"/>
 *         &lt;choice minOccurs="0">
 *           &lt;element name="ExtraCall" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *           &lt;element name="Cancellation" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;/choice>
 *         &lt;group ref="{http://www.siri.org.uk/siri}CallRealTimeInfoGroup"/>
 *         &lt;group ref="{http://www.siri.org.uk/siri}CallPropertyGroup"/>
 *         &lt;group ref="{http://www.siri.org.uk/siri}CallNoteGroup"/>
 *         &lt;group ref="{http://www.siri.org.uk/siri}DisruptionGroup"/>
 *         &lt;group ref="{http://www.siri.org.uk/siri}OnwardsCallGroup"/>
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
@XmlType(name = "EstimatedCallStructure", namespace = "http://www.siri.org.uk/siri", propOrder = {
    "stopPointRef",
    "visitNumber",
    "order",
    "stopPointName",
    "extraCall",
    "cancellation",
    "predictionInaccurate",
    "occupancy",
    "timingPoint",
    "boardingStretch",
    "requestStop",
    "destinationDisplay",
    "callNote",
    "facilityConditionElement",
    "facilityChangeElement",
    "situationRef",
    "aimedArrivalTime",
    "expectedArrivalTime",
    "arrivalStatus",
    "arrivalPlatformName",
    "arrivalBoardingActivity",
    "aimedDepartureTime",
    "expectedDepartureTime",
    "departureStatus",
    "departurePlatformName",
    "departureBoardingActivity",
    "aimedHeadwayInterval",
    "expectedHeadwayInterval",
    "extensions"
})
@ToString
public class EstimatedCall {

    @XmlElement(name = "StopPointRef", namespace = "http://www.siri.org.uk/siri", required = true)
    protected StopPointRef stopPointRef;
    @XmlElement(name = "VisitNumber", namespace = "http://www.siri.org.uk/siri")
    @XmlSchemaType(name = "positiveInteger")
    protected BigInteger visitNumber;
    @XmlElement(name = "Order", namespace = "http://www.siri.org.uk/siri")
    @XmlSchemaType(name = "positiveInteger")
    protected BigInteger order;
    @XmlElement(name = "StopPointName", namespace = "http://www.siri.org.uk/siri")
    protected NaturalLanguageString stopPointName;
    @XmlElement(name = "ExtraCall", namespace = "http://www.siri.org.uk/siri")
    protected Boolean extraCall;
    @XmlElement(name = "Cancellation", namespace = "http://www.siri.org.uk/siri")
    protected Boolean cancellation;
    @XmlElement(name = "PredictionInaccurate", namespace = "http://www.siri.org.uk/siri")
    protected Boolean predictionInaccurate;
    @XmlElement(name = "Occupancy", namespace = "http://www.siri.org.uk/siri")
    @XmlSchemaType(name = "NMTOKEN")
    protected OccupancyEnumeration occupancy;
    @XmlElement(name = "TimingPoint", namespace = "http://www.siri.org.uk/siri", defaultValue = "true")
    protected Boolean timingPoint;
    @XmlElement(name = "BoardingStretch", namespace = "http://www.siri.org.uk/siri", defaultValue = "false")
    protected Boolean boardingStretch;
    @XmlElement(name = "RequestStop", namespace = "http://www.siri.org.uk/siri", defaultValue = "false")
    protected Boolean requestStop;
    @XmlElement(name = "DestinationDisplay", namespace = "http://www.siri.org.uk/siri")
    protected NaturalLanguageString destinationDisplay;
    @XmlElement(name = "CallNote", namespace = "http://www.siri.org.uk/siri")
    protected List<NaturalLanguageString> callNote;
    @XmlElement(name = "FacilityConditionElement", namespace = "http://www.siri.org.uk/siri")
    protected List<FacilityCondition> facilityConditionElement;
    @XmlElement(name = "FacilityChangeElement", namespace = "http://www.siri.org.uk/siri")
    protected FacilityChange facilityChangeElement;
    @XmlElement(name = "SituationRef", namespace = "http://www.siri.org.uk/siri")
    protected List<SituationRef> situationRef;
    @XmlElement(name = "AimedArrivalTime", namespace = "http://www.siri.org.uk/siri", type = String.class)
    @XmlJavaTypeAdapter(ZonedDateTimeAdapter.class)
    @XmlSchemaType(name = "dateTime")
    protected ZonedDateTime aimedArrivalTime;
    @XmlElement(name = "ExpectedArrivalTime", namespace = "http://www.siri.org.uk/siri", type = String.class)
    @XmlJavaTypeAdapter(ZonedDateTimeAdapter.class)
    @XmlSchemaType(name = "dateTime")
    protected ZonedDateTime expectedArrivalTime;
    @XmlElement(name = "ArrivalStatus", namespace = "http://www.siri.org.uk/siri")
    @XmlSchemaType(name = "NMTOKEN")
    protected ProgressStatusEnumeration arrivalStatus;
    @XmlElement(name = "ArrivalPlatformName", namespace = "http://www.siri.org.uk/siri")
    protected NaturalLanguageString arrivalPlatformName;
    @XmlElement(name = "ArrivalBoardingActivity", namespace = "http://www.siri.org.uk/siri", defaultValue = "alighting")
    @XmlSchemaType(name = "NMTOKEN")
    protected ArrivalBoardingActivityEnumeration arrivalBoardingActivity;
    @XmlElement(name = "AimedDepartureTime", namespace = "http://www.siri.org.uk/siri", type = String.class)
    @XmlJavaTypeAdapter(ZonedDateTimeAdapter.class)
    @XmlSchemaType(name = "dateTime")
    protected ZonedDateTime aimedDepartureTime;
    @XmlElement(name = "ExpectedDepartureTime", namespace = "http://www.siri.org.uk/siri", type = String.class)
    @XmlJavaTypeAdapter(ZonedDateTimeAdapter.class)
    @XmlSchemaType(name = "dateTime")
    protected ZonedDateTime expectedDepartureTime;
    @XmlElement(name = "DepartureStatus", namespace = "http://www.siri.org.uk/siri")
    @XmlSchemaType(name = "NMTOKEN")
    protected ProgressStatusEnumeration departureStatus;
    @XmlElement(name = "DeparturePlatformName", namespace = "http://www.siri.org.uk/siri")
    protected NaturalLanguageString departurePlatformName;
    @XmlElement(name = "DepartureBoardingActivity", namespace = "http://www.siri.org.uk/siri", defaultValue = "boarding")
    @XmlSchemaType(name = "NMTOKEN")
    protected DepartureBoardingActivityEnumeration departureBoardingActivity;
    @XmlElement(name = "AimedHeadwayInterval", namespace = "http://www.siri.org.uk/siri")
    protected Duration aimedHeadwayInterval;
    @XmlElement(name = "ExpectedHeadwayInterval", namespace = "http://www.siri.org.uk/siri")
    protected Duration expectedHeadwayInterval;
    @XmlElement(name = "Extensions", namespace = "http://www.siri.org.uk/siri")
    protected Extensions extensions;

    /**
     * Gets the value of the stopPointRef property.
     * 
     * @return
     *     possible object is
     *     {@link StopPointRef }
     *     
     */
    public StopPointRef getStopPointRef() {
        return stopPointRef;
    }

    /**
     * Sets the value of the stopPointRef property.
     * 
     * @param value
     *     allowed object is
     *     {@link StopPointRef }
     *     
     */
    public EstimatedCall setStopPointRef(StopPointRef value) {
        this.stopPointRef = value;
        return this;
    }

    /**
     * Gets the value of the visitNumber property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getVisitNumber() {
        return visitNumber;
    }

    /**
     * Sets the value of the visitNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public EstimatedCall setVisitNumber(BigInteger value) {
        this.visitNumber = value;
        return this;
    }

    /**
     * Gets the value of the order property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getOrder() {
        return order;
    }

    /**
     * Sets the value of the order property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public EstimatedCall setOrder(BigInteger value) {
        this.order = value;
        return this;
    }

    /**
     * Gets the value of the stopPointName property.
     * 
     * @return
     *     possible object is
     *     {@link NaturalLanguageString }
     *     
     */
    public NaturalLanguageString getStopPointName() {
        return stopPointName;
    }

    /**
     * Sets the value of the stopPointName property.
     * 
     * @param value
     *     allowed object is
     *     {@link NaturalLanguageString }
     *     
     */
    public EstimatedCall setStopPointName(NaturalLanguageString value) {
        this.stopPointName = value;
        return this;
    }

    /**
     * Gets the value of the extraCall property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isExtraCall() {
        return extraCall;
    }

    /**
     * Sets the value of the extraCall property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public EstimatedCall setExtraCall(Boolean value) {
        this.extraCall = value;
        return this;
    }

    /**
     * Gets the value of the cancellation property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isCancellation() {
        return cancellation;
    }

    /**
     * Sets the value of the cancellation property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public EstimatedCall setCancellation(Boolean value) {
        this.cancellation = value;
        return this;
    }

    /**
     * Gets the value of the predictionInaccurate property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isPredictionInaccurate() {
        return predictionInaccurate;
    }

    /**
     * Sets the value of the predictionInaccurate property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public EstimatedCall setPredictionInaccurate(Boolean value) {
        this.predictionInaccurate = value;
        return this;
    }

    /**
     * Gets the value of the occupancy property.
     * 
     * @return
     *     possible object is
     *     {@link OccupancyEnumeration }
     *     
     */
    public OccupancyEnumeration getOccupancy() {
        return occupancy;
    }

    /**
     * Sets the value of the occupancy property.
     * 
     * @param value
     *     allowed object is
     *     {@link OccupancyEnumeration }
     *     
     */
    public EstimatedCall setOccupancy(OccupancyEnumeration value) {
        this.occupancy = value;
        return this;
    }

    /**
     * Gets the value of the timingPoint property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isTimingPoint() {
        return timingPoint;
    }

    /**
     * Sets the value of the timingPoint property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public EstimatedCall setTimingPoint(Boolean value) {
        this.timingPoint = value;
        return this;
    }

    /**
     * Gets the value of the boardingStretch property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isBoardingStretch() {
        return boardingStretch;
    }

    /**
     * Sets the value of the boardingStretch property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public EstimatedCall setBoardingStretch(Boolean value) {
        this.boardingStretch = value;
        return this;
    }

    /**
     * Gets the value of the requestStop property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isRequestStop() {
        return requestStop;
    }

    /**
     * Sets the value of the requestStop property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public EstimatedCall setRequestStop(Boolean value) {
        this.requestStop = value;
        return this;
    }

    /**
     * Gets the value of the destinationDisplay property.
     * 
     * @return
     *     possible object is
     *     {@link NaturalLanguageString }
     *     
     */
    public NaturalLanguageString getDestinationDisplay() {
        return destinationDisplay;
    }

    /**
     * Sets the value of the destinationDisplay property.
     * 
     * @param value
     *     allowed object is
     *     {@link NaturalLanguageString }
     *     
     */
    public EstimatedCall setDestinationDisplay(NaturalLanguageString value) {
        this.destinationDisplay = value;
        return this;
    }

    /**
     * Gets the value of the callNote property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the callNote property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCallNote().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link NaturalLanguageString }
     * 
     * 
     */
    public List<NaturalLanguageString> getCallNote() {
        if (callNote == null) {
            callNote = new ArrayList<NaturalLanguageString>();
        }
        return this.callNote;
    }

    /**
     * Information about a change of Equipment availabiltiy at stop that may affect access or use.Gets the value of the facilityConditionElement property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the facilityConditionElement property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getFacilityConditionElement().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link FacilityCondition }
     * 
     * 
     */
    public List<FacilityCondition> getFacilityConditionElement() {
        if (facilityConditionElement == null) {
            facilityConditionElement = new ArrayList<FacilityCondition>();
        }
        return this.facilityConditionElement;
    }

    /**
     * Gets the value of the facilityChangeElement property.
     * 
     * @return
     *     possible object is
     *     {@link FacilityChange }
     *     
     */
    public FacilityChange getFacilityChangeElement() {
        return facilityChangeElement;
    }

    /**
     * Sets the value of the facilityChangeElement property.
     * 
     * @param value
     *     allowed object is
     *     {@link FacilityChange }
     *     
     */
    public EstimatedCall setFacilityChangeElement(FacilityChange value) {
        this.facilityChangeElement = value;
        return this;
    }

    /**
     * Gets the value of the situationRef property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the situationRef property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSituationRef().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link SituationRef }
     * 
     * 
     */
    public List<SituationRef> getSituationRef() {
        if (situationRef == null) {
            situationRef = new ArrayList<SituationRef>();
        }
        return this.situationRef;
    }

    /**
     * Gets the value of the aimedArrivalTime property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public ZonedDateTime getAimedArrivalTime() {
        return aimedArrivalTime;
    }

    /**
     * Sets the value of the aimedArrivalTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public EstimatedCall setAimedArrivalTime(ZonedDateTime value) {
        this.aimedArrivalTime = value;
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
    public EstimatedCall setExpectedArrivalTime(ZonedDateTime value) {
        this.expectedArrivalTime = value;
        return this;
    }

    /**
     * Gets the value of the arrivalStatus property.
     * 
     * @return
     *     possible object is
     *     {@link ProgressStatusEnumeration }
     *     
     */
    public ProgressStatusEnumeration getArrivalStatus() {
        return arrivalStatus;
    }

    /**
     * Sets the value of the arrivalStatus property.
     * 
     * @param value
     *     allowed object is
     *     {@link ProgressStatusEnumeration }
     *     
     */
    public EstimatedCall setArrivalStatus(ProgressStatusEnumeration value) {
        this.arrivalStatus = value;
        return this;
    }

    /**
     * Gets the value of the arrivalPlatformName property.
     * 
     * @return
     *     possible object is
     *     {@link NaturalLanguageString }
     *     
     */
    public NaturalLanguageString getArrivalPlatformName() {
        return arrivalPlatformName;
    }

    /**
     * Sets the value of the arrivalPlatformName property.
     * 
     * @param value
     *     allowed object is
     *     {@link NaturalLanguageString }
     *     
     */
    public EstimatedCall setArrivalPlatformName(NaturalLanguageString value) {
        this.arrivalPlatformName = value;
        return this;
    }

    /**
     * Gets the value of the arrivalBoardingActivity property.
     * 
     * @return
     *     possible object is
     *     {@link ArrivalBoardingActivityEnumeration }
     *     
     */
    public ArrivalBoardingActivityEnumeration getArrivalBoardingActivity() {
        return arrivalBoardingActivity;
    }

    /**
     * Sets the value of the arrivalBoardingActivity property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrivalBoardingActivityEnumeration }
     *     
     */
    public EstimatedCall setArrivalBoardingActivity(ArrivalBoardingActivityEnumeration value) {
        this.arrivalBoardingActivity = value;
        return this;
    }

    /**
     * Gets the value of the aimedDepartureTime property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public ZonedDateTime getAimedDepartureTime() {
        return aimedDepartureTime;
    }

    /**
     * Sets the value of the aimedDepartureTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public EstimatedCall setAimedDepartureTime(ZonedDateTime value) {
        this.aimedDepartureTime = value;
        return this;
    }

    /**
     * Gets the value of the expectedDepartureTime property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public ZonedDateTime getExpectedDepartureTime() {
        return expectedDepartureTime;
    }

    /**
     * Sets the value of the expectedDepartureTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public EstimatedCall setExpectedDepartureTime(ZonedDateTime value) {
        this.expectedDepartureTime = value;
        return this;
    }

    /**
     * Gets the value of the departureStatus property.
     * 
     * @return
     *     possible object is
     *     {@link ProgressStatusEnumeration }
     *     
     */
    public ProgressStatusEnumeration getDepartureStatus() {
        return departureStatus;
    }

    /**
     * Sets the value of the departureStatus property.
     * 
     * @param value
     *     allowed object is
     *     {@link ProgressStatusEnumeration }
     *     
     */
    public EstimatedCall setDepartureStatus(ProgressStatusEnumeration value) {
        this.departureStatus = value;
        return this;
    }

    /**
     * Gets the value of the departurePlatformName property.
     * 
     * @return
     *     possible object is
     *     {@link NaturalLanguageString }
     *     
     */
    public NaturalLanguageString getDeparturePlatformName() {
        return departurePlatformName;
    }

    /**
     * Sets the value of the departurePlatformName property.
     * 
     * @param value
     *     allowed object is
     *     {@link NaturalLanguageString }
     *     
     */
    public EstimatedCall setDeparturePlatformName(NaturalLanguageString value) {
        this.departurePlatformName = value;
        return this;
    }

    /**
     * Gets the value of the departureBoardingActivity property.
     * 
     * @return
     *     possible object is
     *     {@link DepartureBoardingActivityEnumeration }
     *     
     */
    public DepartureBoardingActivityEnumeration getDepartureBoardingActivity() {
        return departureBoardingActivity;
    }

    /**
     * Sets the value of the departureBoardingActivity property.
     * 
     * @param value
     *     allowed object is
     *     {@link DepartureBoardingActivityEnumeration }
     *     
     */
    public EstimatedCall setDepartureBoardingActivity(DepartureBoardingActivityEnumeration value) {
        this.departureBoardingActivity = value;
        return this;
    }

    /**
     * Gets the value of the aimedHeadwayInterval property.
     * 
     * @return
     *     possible object is
     *     {@link Duration }
     *     
     */
    public Duration getAimedHeadwayInterval() {
        return aimedHeadwayInterval;
    }

    /**
     * Sets the value of the aimedHeadwayInterval property.
     * 
     * @param value
     *     allowed object is
     *     {@link Duration }
     *     
     */
    public EstimatedCall setAimedHeadwayInterval(Duration value) {
        this.aimedHeadwayInterval = value;
        return this;
    }

    /**
     * Gets the value of the expectedHeadwayInterval property.
     * 
     * @return
     *     possible object is
     *     {@link Duration }
     *     
     */
    public Duration getExpectedHeadwayInterval() {
        return expectedHeadwayInterval;
    }

    /**
     * Sets the value of the expectedHeadwayInterval property.
     * 
     * @param value
     *     allowed object is
     *     {@link Duration }
     *     
     */
    public EstimatedCall setExpectedHeadwayInterval(Duration value) {
        this.expectedHeadwayInterval = value;
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
    public EstimatedCall setExtensions(Extensions value) {
        this.extensions = value;
        return this;
    }

}
