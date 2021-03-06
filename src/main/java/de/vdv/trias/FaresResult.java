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
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


/**
 * Wrapper element for fares results.
 * 
 * <p>Java class for FaresResult complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="FaresResultStructure">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ResultId" type="{http://www.w3.org/2001/XMLSchema}NMTOKEN"/>
 *         &lt;choice>
 *           &lt;element name="StopFaresResult" type="{http://www.vdv.de/trias}StopFaresResultStructure"/>
 *           &lt;element name="StaticFaresResult" type="{http://www.vdv.de/trias}StaticFaresResultStructure"/>
 *           &lt;element name="TripFaresResult" type="{http://www.vdv.de/trias}TripFaresResultStructure" maxOccurs="unbounded"/>
 *           &lt;element name="MultiTripFaresResult" type="{http://www.vdv.de/trias}MultiTripFaresResultStructure" maxOccurs="unbounded"/>
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
@XmlType(name = "FaresResultStructure", namespace = "http://www.vdv.de/trias", propOrder = {
    "resultId",
    "stopFaresResult",
    "staticFaresResult",
    "tripFaresResult",
    "multiTripFaresResult"
})
@ToString
public class FaresResult {

    @XmlElement(name = "ResultId", namespace = "http://www.vdv.de/trias", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "NMTOKEN")
    protected String resultId;
    @XmlElement(name = "StopFaresResult", namespace = "http://www.vdv.de/trias")
    protected StopFaresResult stopFaresResult;
    @XmlElement(name = "StaticFaresResult", namespace = "http://www.vdv.de/trias")
    protected StaticFaresResult staticFaresResult;
    @XmlElement(name = "TripFaresResult", namespace = "http://www.vdv.de/trias")
    protected List<TripFaresResult> tripFaresResult;
    @XmlElement(name = "MultiTripFaresResult", namespace = "http://www.vdv.de/trias")
    protected List<MultiTripFaresResult> multiTripFaresResult;

    /**
     * Gets the value of the resultId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getResultId() {
        return resultId;
    }

    /**
     * Sets the value of the resultId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public FaresResult setResultId(String value) {
        this.resultId = value;
        return this;
    }

    /**
     * Gets the value of the stopFaresResult property.
     * 
     * @return
     *     possible object is
     *     {@link StopFaresResult }
     *     
     */
    public StopFaresResult getStopFaresResult() {
        return stopFaresResult;
    }

    /**
     * Sets the value of the stopFaresResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link StopFaresResult }
     *     
     */
    public FaresResult setStopFaresResult(StopFaresResult value) {
        this.stopFaresResult = value;
        return this;
    }

    /**
     * Gets the value of the staticFaresResult property.
     * 
     * @return
     *     possible object is
     *     {@link StaticFaresResult }
     *     
     */
    public StaticFaresResult getStaticFaresResult() {
        return staticFaresResult;
    }

    /**
     * Sets the value of the staticFaresResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link StaticFaresResult }
     *     
     */
    public FaresResult setStaticFaresResult(StaticFaresResult value) {
        this.staticFaresResult = value;
        return this;
    }

    /**
     * Gets the value of the tripFaresResult property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the tripFaresResult property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getTripFaresResult().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TripFaresResult }
     * 
     * 
     */
    public List<TripFaresResult> getTripFaresResult() {
        if (tripFaresResult == null) {
            tripFaresResult = new ArrayList<TripFaresResult>();
        }
        return this.tripFaresResult;
    }

    /**
     * Gets the value of the multiTripFaresResult property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the multiTripFaresResult property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getMultiTripFaresResult().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link MultiTripFaresResult }
     * 
     * 
     */
    public List<MultiTripFaresResult> getMultiTripFaresResult() {
        if (multiTripFaresResult == null) {
            multiTripFaresResult = new ArrayList<MultiTripFaresResult>();
        }
        return this.multiTripFaresResult;
    }

}
