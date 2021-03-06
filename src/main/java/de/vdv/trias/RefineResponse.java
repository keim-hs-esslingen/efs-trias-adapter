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
 * Refine response structure.
 * 
 * <p>Java class for RefineResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="RefineResponseStructure">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="IndividualRouteRefineResponse" type="{http://www.vdv.de/trias}IndividualRouteRefineResponseStructure" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="LocationInformationRefineResponse" type="{http://www.vdv.de/trias}LocationInformationRefineResponseStructure" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="StopEventRefineResponse" type="{http://www.vdv.de/trias}StopEventRefineResponseStructure" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="TripInfoRefineResponse" type="{http://www.vdv.de/trias}TripInfoRefineResponseStructure" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="TripRefineResponse" type="{http://www.vdv.de/trias}TripRefineResponseStructure" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RefineResponseStructure", namespace = "http://www.vdv.de/trias", propOrder = {
    "individualRouteRefineResponse",
    "locationInformationRefineResponse",
    "stopEventRefineResponse",
    "tripInfoRefineResponse",
    "tripRefineResponse"
})
@ToString
public class RefineResponse {

    @XmlElement(name = "IndividualRouteRefineResponse", namespace = "http://www.vdv.de/trias")
    protected List<IndividualRouteRefineResponse> individualRouteRefineResponse;
    @XmlElement(name = "LocationInformationRefineResponse", namespace = "http://www.vdv.de/trias")
    protected List<LocationInformationRefineResponse> locationInformationRefineResponse;
    @XmlElement(name = "StopEventRefineResponse", namespace = "http://www.vdv.de/trias")
    protected List<StopEventRefineResponse> stopEventRefineResponse;
    @XmlElement(name = "TripInfoRefineResponse", namespace = "http://www.vdv.de/trias")
    protected List<TripInfoRefineResponse> tripInfoRefineResponse;
    @XmlElement(name = "TripRefineResponse", namespace = "http://www.vdv.de/trias")
    protected List<TripRefineResponse> tripRefineResponse;

    /**
     * Gets the value of the individualRouteRefineResponse property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the individualRouteRefineResponse property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getIndividualRouteRefineResponse().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link IndividualRouteRefineResponse }
     * 
     * 
     */
    public List<IndividualRouteRefineResponse> getIndividualRouteRefineResponse() {
        if (individualRouteRefineResponse == null) {
            individualRouteRefineResponse = new ArrayList<IndividualRouteRefineResponse>();
        }
        return this.individualRouteRefineResponse;
    }

    /**
     * Gets the value of the locationInformationRefineResponse property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the locationInformationRefineResponse property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getLocationInformationRefineResponse().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link LocationInformationRefineResponse }
     * 
     * 
     */
    public List<LocationInformationRefineResponse> getLocationInformationRefineResponse() {
        if (locationInformationRefineResponse == null) {
            locationInformationRefineResponse = new ArrayList<LocationInformationRefineResponse>();
        }
        return this.locationInformationRefineResponse;
    }

    /**
     * Gets the value of the stopEventRefineResponse property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the stopEventRefineResponse property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getStopEventRefineResponse().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link StopEventRefineResponse }
     * 
     * 
     */
    public List<StopEventRefineResponse> getStopEventRefineResponse() {
        if (stopEventRefineResponse == null) {
            stopEventRefineResponse = new ArrayList<StopEventRefineResponse>();
        }
        return this.stopEventRefineResponse;
    }

    /**
     * Gets the value of the tripInfoRefineResponse property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the tripInfoRefineResponse property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getTripInfoRefineResponse().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TripInfoRefineResponse }
     * 
     * 
     */
    public List<TripInfoRefineResponse> getTripInfoRefineResponse() {
        if (tripInfoRefineResponse == null) {
            tripInfoRefineResponse = new ArrayList<TripInfoRefineResponse>();
        }
        return this.tripInfoRefineResponse;
    }

    /**
     * Gets the value of the tripRefineResponse property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the tripRefineResponse property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getTripRefineResponse().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TripRefineResponse }
     * 
     * 
     */
    public List<TripRefineResponse> getTripRefineResponse() {
        if (tripRefineResponse == null) {
            tripRefineResponse = new ArrayList<TripRefineResponse>();
        }
        return this.tripRefineResponse;
    }

}
