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
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for StopRequestRequest complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="StopRequestRequestStructure">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="StopRef" type="{http://www.vdv.de/trias}StopPointRefStructure"/>
 *         &lt;element name="StopName" type="{http://www.vdv.de/trias}InternationalTextStructure" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="Intention" type="{http://www.vdv.de/trias}BoardingIntentionEnumeration" minOccurs="0"/>
 *         &lt;element name="AssistanceRequired" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;group ref="{http://www.vdv.de/trias}PassengerProfileGroup"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "StopRequestRequestStructure", namespace = "http://www.vdv.de/trias", propOrder = {
    "stopRef",
    "stopName",
    "intention",
    "assistanceRequired",
    "wheelchairUser",
    "walkingFrame",
    "walkingStick",
    "walkingImpaired",
    "pram",
    "heavyLuggage",
    "visuallyImpaired",
    "hearingImpaired",
    "readingImpaired"
})
@ToString
public class StopRequestRequest {

    @XmlElement(name = "StopRef", namespace = "http://www.vdv.de/trias", required = true)
    protected StopPointRef stopRef;
    @XmlElement(name = "StopName", namespace = "http://www.vdv.de/trias")
    protected List<InternationalText> stopName;
    @XmlElement(name = "Intention", namespace = "http://www.vdv.de/trias")
    @XmlSchemaType(name = "string")
    protected BoardingIntentionEnumeration intention;
    @XmlElement(name = "AssistanceRequired", namespace = "http://www.vdv.de/trias")
    protected Boolean assistanceRequired;
    @XmlElement(name = "WheelchairUser", namespace = "http://www.vdv.de/trias")
    protected Boolean wheelchairUser;
    @XmlElement(name = "WalkingFrame", namespace = "http://www.vdv.de/trias")
    protected Boolean walkingFrame;
    @XmlElement(name = "WalkingStick", namespace = "http://www.vdv.de/trias")
    protected Boolean walkingStick;
    @XmlElement(name = "WalkingImpaired", namespace = "http://www.vdv.de/trias")
    protected Boolean walkingImpaired;
    @XmlElement(name = "Pram", namespace = "http://www.vdv.de/trias")
    protected Boolean pram;
    @XmlElement(name = "HeavyLuggage", namespace = "http://www.vdv.de/trias")
    protected Boolean heavyLuggage;
    @XmlElement(name = "VisuallyImpaired", namespace = "http://www.vdv.de/trias")
    protected Boolean visuallyImpaired;
    @XmlElement(name = "HearingImpaired", namespace = "http://www.vdv.de/trias")
    protected Boolean hearingImpaired;
    @XmlElement(name = "ReadingImpaired", namespace = "http://www.vdv.de/trias")
    protected Boolean readingImpaired;

    /**
     * Gets the value of the stopRef property.
     * 
     * @return
     *     possible object is
     *     {@link StopPointRef }
     *     
     */
    public StopPointRef getStopRef() {
        return stopRef;
    }

    /**
     * Sets the value of the stopRef property.
     * 
     * @param value
     *     allowed object is
     *     {@link StopPointRef }
     *     
     */
    public StopRequestRequest setStopRef(StopPointRef value) {
        this.stopRef = value;
        return this;
    }

    /**
     * Gets the value of the stopName property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the stopName property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getStopName().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link InternationalText }
     * 
     * 
     */
    public List<InternationalText> getStopName() {
        if (stopName == null) {
            stopName = new ArrayList<InternationalText>();
        }
        return this.stopName;
    }

    /**
     * Gets the value of the intention property.
     * 
     * @return
     *     possible object is
     *     {@link BoardingIntentionEnumeration }
     *     
     */
    public BoardingIntentionEnumeration getIntention() {
        return intention;
    }

    /**
     * Sets the value of the intention property.
     * 
     * @param value
     *     allowed object is
     *     {@link BoardingIntentionEnumeration }
     *     
     */
    public StopRequestRequest setIntention(BoardingIntentionEnumeration value) {
        this.intention = value;
        return this;
    }

    /**
     * Gets the value of the assistanceRequired property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isAssistanceRequired() {
        return assistanceRequired;
    }

    /**
     * Sets the value of the assistanceRequired property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public StopRequestRequest setAssistanceRequired(Boolean value) {
        this.assistanceRequired = value;
        return this;
    }

    /**
     * Gets the value of the wheelchairUser property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isWheelchairUser() {
        return wheelchairUser;
    }

    /**
     * Sets the value of the wheelchairUser property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public StopRequestRequest setWheelchairUser(Boolean value) {
        this.wheelchairUser = value;
        return this;
    }

    /**
     * Gets the value of the walkingFrame property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isWalkingFrame() {
        return walkingFrame;
    }

    /**
     * Sets the value of the walkingFrame property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public StopRequestRequest setWalkingFrame(Boolean value) {
        this.walkingFrame = value;
        return this;
    }

    /**
     * Gets the value of the walkingStick property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isWalkingStick() {
        return walkingStick;
    }

    /**
     * Sets the value of the walkingStick property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public StopRequestRequest setWalkingStick(Boolean value) {
        this.walkingStick = value;
        return this;
    }

    /**
     * Gets the value of the walkingImpaired property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isWalkingImpaired() {
        return walkingImpaired;
    }

    /**
     * Sets the value of the walkingImpaired property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public StopRequestRequest setWalkingImpaired(Boolean value) {
        this.walkingImpaired = value;
        return this;
    }

    /**
     * Gets the value of the pram property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isPram() {
        return pram;
    }

    /**
     * Sets the value of the pram property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public StopRequestRequest setPram(Boolean value) {
        this.pram = value;
        return this;
    }

    /**
     * Gets the value of the heavyLuggage property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isHeavyLuggage() {
        return heavyLuggage;
    }

    /**
     * Sets the value of the heavyLuggage property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public StopRequestRequest setHeavyLuggage(Boolean value) {
        this.heavyLuggage = value;
        return this;
    }

    /**
     * Gets the value of the visuallyImpaired property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isVisuallyImpaired() {
        return visuallyImpaired;
    }

    /**
     * Sets the value of the visuallyImpaired property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public StopRequestRequest setVisuallyImpaired(Boolean value) {
        this.visuallyImpaired = value;
        return this;
    }

    /**
     * Gets the value of the hearingImpaired property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isHearingImpaired() {
        return hearingImpaired;
    }

    /**
     * Sets the value of the hearingImpaired property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public StopRequestRequest setHearingImpaired(Boolean value) {
        this.hearingImpaired = value;
        return this;
    }

    /**
     * Gets the value of the readingImpaired property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isReadingImpaired() {
        return readingImpaired;
    }

    /**
     * Sets the value of the readingImpaired property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public StopRequestRequest setReadingImpaired(Boolean value) {
        this.readingImpaired = value;
        return this;
    }

}