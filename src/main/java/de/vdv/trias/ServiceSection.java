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
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * Properties of a service combined with a stop sequence interval.
 * 
 * <p>Java class for ServiceSection complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ServiceSectionStructure">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;group ref="{http://www.vdv.de/trias}StopSeqIntervalGroup"/>
 *         &lt;group ref="{http://www.vdv.de/trias}ServiceGroup"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ServiceSectionStructure", namespace = "http://www.vdv.de/trias", propOrder = {
    "fromStopSeqNumber",
    "toStopSeqNumber",
    "lineRef",
    "directionRef",
    "mode",
    "publishedLineName",
    "operatorRef",
    "routeDescription",
    "via"
})
@ToString
public class ServiceSection {

    @XmlElement(name = "FromStopSeqNumber", namespace = "http://www.vdv.de/trias")
    @XmlSchemaType(name = "positiveInteger")
    protected BigInteger fromStopSeqNumber;
    @XmlElement(name = "ToStopSeqNumber", namespace = "http://www.vdv.de/trias")
    @XmlSchemaType(name = "positiveInteger")
    protected BigInteger toStopSeqNumber;
    @XmlElement(name = "LineRef", namespace = "http://www.vdv.de/trias", required = true)
    protected LineRef lineRef;
    @XmlElement(name = "DirectionRef", namespace = "http://www.vdv.de/trias", required = true)
    protected DirectionRef directionRef;
    @XmlElement(name = "Mode", namespace = "http://www.vdv.de/trias", required = true)
    protected Mode mode;
    @XmlElement(name = "PublishedLineName", namespace = "http://www.vdv.de/trias", required = true)
    protected List<InternationalText> publishedLineName;
    @XmlElement(name = "OperatorRef", namespace = "http://www.vdv.de/trias")
    protected OperatorRef operatorRef;
    @XmlElement(name = "RouteDescription", namespace = "http://www.vdv.de/trias")
    protected List<InternationalText> routeDescription;
    @XmlElement(name = "Via", namespace = "http://www.vdv.de/trias")
    protected List<ServiceViaPoint> via;

    /**
     * Gets the value of the fromStopSeqNumber property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getFromStopSeqNumber() {
        return fromStopSeqNumber;
    }

    /**
     * Sets the value of the fromStopSeqNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public ServiceSection setFromStopSeqNumber(BigInteger value) {
        this.fromStopSeqNumber = value;
        return this;
    }

    /**
     * Gets the value of the toStopSeqNumber property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getToStopSeqNumber() {
        return toStopSeqNumber;
    }

    /**
     * Sets the value of the toStopSeqNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public ServiceSection setToStopSeqNumber(BigInteger value) {
        this.toStopSeqNumber = value;
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
    public ServiceSection setLineRef(LineRef value) {
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
    public ServiceSection setDirectionRef(DirectionRef value) {
        this.directionRef = value;
        return this;
    }

    /**
     * Gets the value of the mode property.
     * 
     * @return
     *     possible object is
     *     {@link Mode }
     *     
     */
    public Mode getMode() {
        return mode;
    }

    /**
     * Sets the value of the mode property.
     * 
     * @param value
     *     allowed object is
     *     {@link Mode }
     *     
     */
    public ServiceSection setMode(Mode value) {
        this.mode = value;
        return this;
    }

    /**
     * Gets the value of the publishedLineName property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the publishedLineName property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPublishedLineName().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link InternationalText }
     * 
     * 
     */
    public List<InternationalText> getPublishedLineName() {
        if (publishedLineName == null) {
            publishedLineName = new ArrayList<InternationalText>();
        }
        return this.publishedLineName;
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
    public ServiceSection setOperatorRef(OperatorRef value) {
        this.operatorRef = value;
        return this;
    }

    /**
     * Gets the value of the routeDescription property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the routeDescription property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getRouteDescription().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link InternationalText }
     * 
     * 
     */
    public List<InternationalText> getRouteDescription() {
        if (routeDescription == null) {
            routeDescription = new ArrayList<InternationalText>();
        }
        return this.routeDescription;
    }

    /**
     * Gets the value of the via property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the via property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getVia().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ServiceViaPoint }
     * 
     * 
     */
    public List<ServiceViaPoint> getVia() {
        if (via == null) {
            via = new ArrayList<ServiceViaPoint>();
        }
        return this.via;
    }

}