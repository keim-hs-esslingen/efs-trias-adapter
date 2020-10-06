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
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Fares request structure.
 * 
 * <p>Java class for FaresRequest complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="FaresRequestStructure">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;choice>
 *           &lt;element name="StopFaresRequest" type="{http://www.vdv.de/trias}StopFaresRequestStructure"/>
 *           &lt;element name="StaticFaresRequest" type="{http://www.vdv.de/trias}StaticFaresRequestStructure"/>
 *           &lt;element name="TripFaresRequest" type="{http://www.vdv.de/trias}TripFaresRequestStructure"/>
 *           &lt;element name="MultiTripFaresRequest" type="{http://www.vdv.de/trias}MultiTripFaresRequestStructure"/>
 *         &lt;/choice>
 *         &lt;element name="Params" type="{http://www.vdv.de/trias}FaresParamStructure" minOccurs="0"/>
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
@XmlType(name = "FaresRequestStructure", namespace = "http://www.vdv.de/trias", propOrder = {
    "stopFaresRequest",
    "staticFaresRequest",
    "tripFaresRequest",
    "multiTripFaresRequest",
    "params",
    "extension"
})
@ToString
public class FaresRequest {

    @XmlElement(name = "StopFaresRequest", namespace = "http://www.vdv.de/trias")
    protected StopFaresRequest stopFaresRequest;
    @XmlElement(name = "StaticFaresRequest", namespace = "http://www.vdv.de/trias")
    protected StaticFaresRequest staticFaresRequest;
    @XmlElement(name = "TripFaresRequest", namespace = "http://www.vdv.de/trias")
    protected TripFaresRequest tripFaresRequest;
    @XmlElement(name = "MultiTripFaresRequest", namespace = "http://www.vdv.de/trias")
    protected MultiTripFaresRequest multiTripFaresRequest;
    @XmlElement(name = "Params", namespace = "http://www.vdv.de/trias")
    protected FaresParam params;
    @XmlElement(name = "Extension", namespace = "http://www.vdv.de/trias")
    protected Object extension;

    /**
     * Gets the value of the stopFaresRequest property.
     * 
     * @return
     *     possible object is
     *     {@link StopFaresRequest }
     *     
     */
    public StopFaresRequest getStopFaresRequest() {
        return stopFaresRequest;
    }

    /**
     * Sets the value of the stopFaresRequest property.
     * 
     * @param value
     *     allowed object is
     *     {@link StopFaresRequest }
     *     
     */
    public FaresRequest setStopFaresRequest(StopFaresRequest value) {
        this.stopFaresRequest = value;
        return this;
    }

    /**
     * Gets the value of the staticFaresRequest property.
     * 
     * @return
     *     possible object is
     *     {@link StaticFaresRequest }
     *     
     */
    public StaticFaresRequest getStaticFaresRequest() {
        return staticFaresRequest;
    }

    /**
     * Sets the value of the staticFaresRequest property.
     * 
     * @param value
     *     allowed object is
     *     {@link StaticFaresRequest }
     *     
     */
    public FaresRequest setStaticFaresRequest(StaticFaresRequest value) {
        this.staticFaresRequest = value;
        return this;
    }

    /**
     * Gets the value of the tripFaresRequest property.
     * 
     * @return
     *     possible object is
     *     {@link TripFaresRequest }
     *     
     */
    public TripFaresRequest getTripFaresRequest() {
        return tripFaresRequest;
    }

    /**
     * Sets the value of the tripFaresRequest property.
     * 
     * @param value
     *     allowed object is
     *     {@link TripFaresRequest }
     *     
     */
    public FaresRequest setTripFaresRequest(TripFaresRequest value) {
        this.tripFaresRequest = value;
        return this;
    }

    /**
     * Gets the value of the multiTripFaresRequest property.
     * 
     * @return
     *     possible object is
     *     {@link MultiTripFaresRequest }
     *     
     */
    public MultiTripFaresRequest getMultiTripFaresRequest() {
        return multiTripFaresRequest;
    }

    /**
     * Sets the value of the multiTripFaresRequest property.
     * 
     * @param value
     *     allowed object is
     *     {@link MultiTripFaresRequest }
     *     
     */
    public FaresRequest setMultiTripFaresRequest(MultiTripFaresRequest value) {
        this.multiTripFaresRequest = value;
        return this;
    }

    /**
     * Gets the value of the params property.
     * 
     * @return
     *     possible object is
     *     {@link FaresParam }
     *     
     */
    public FaresParam getParams() {
        return params;
    }

    /**
     * Sets the value of the params property.
     * 
     * @param value
     *     allowed object is
     *     {@link FaresParam }
     *     
     */
    public FaresRequest setParams(FaresParam value) {
        this.params = value;
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
    public FaresRequest setExtension(Object value) {
        this.extension = value;
        return this;
    }

}
