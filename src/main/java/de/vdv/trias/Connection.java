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
import java.time.ZonedDateTime;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import de.hsesslingen.keim.efs.adapter.trias.jaxb.ZonedDateTimeAdapter;


/**
 * <p>Java class for Connection complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ConnectionStructure">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ConnectionRef" type="{http://www.w3.org/2001/XMLSchema}NMTOKEN"/>
 *         &lt;element name="ConnectionType" type="{http://www.vdv.de/trias}ConnectionTypeEnumeration"/>
 *         &lt;element name="DisplayContent" type="{http://www.vdv.de/trias}DisplayContentStructure"/>
 *         &lt;element name="DepartureStopPointRef" type="{http://www.w3.org/2001/XMLSchema}NMTOKEN"/>
 *         &lt;element name="Platform" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="ConnectionState" type="{http://www.vdv.de/trias}ConnectionStateEnumeration"/>
 *         &lt;element name="Transportmode" type="{http://www.vdv.de/trias}VehicleTypeStructure" minOccurs="0"/>
 *         &lt;element name="ExpectedDepartureTime" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ConnectionStructure", namespace = "http://www.vdv.de/trias", propOrder = {
    "connectionRef",
    "connectionType",
    "displayContent",
    "departureStopPointRef",
    "platform",
    "connectionState",
    "transportmode",
    "expectedDepartureTime"
})
@ToString
public class Connection {

    @XmlElement(name = "ConnectionRef", namespace = "http://www.vdv.de/trias", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "NMTOKEN")
    protected String connectionRef;
    @XmlElement(name = "ConnectionType", namespace = "http://www.vdv.de/trias", required = true)
    @XmlSchemaType(name = "string")
    protected ConnectionTypeEnumeration connectionType;
    @XmlElement(name = "DisplayContent", namespace = "http://www.vdv.de/trias", required = true)
    protected DisplayContent displayContent;
    @XmlElement(name = "DepartureStopPointRef", namespace = "http://www.vdv.de/trias", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "NMTOKEN")
    protected String departureStopPointRef;
    @XmlElement(name = "Platform", namespace = "http://www.vdv.de/trias", required = true)
    protected String platform;
    @XmlElement(name = "ConnectionState", namespace = "http://www.vdv.de/trias", required = true)
    @XmlSchemaType(name = "string")
    protected ConnectionStateEnumeration connectionState;
    @XmlElement(name = "Transportmode", namespace = "http://www.vdv.de/trias")
    protected VehicleType transportmode;
    @XmlElement(name = "ExpectedDepartureTime", namespace = "http://www.vdv.de/trias", type = String.class)
    @XmlJavaTypeAdapter(ZonedDateTimeAdapter.class)
    @XmlSchemaType(name = "dateTime")
    protected ZonedDateTime expectedDepartureTime;

    /**
     * Gets the value of the connectionRef property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getConnectionRef() {
        return connectionRef;
    }

    /**
     * Sets the value of the connectionRef property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public Connection setConnectionRef(String value) {
        this.connectionRef = value;
        return this;
    }

    /**
     * Gets the value of the connectionType property.
     * 
     * @return
     *     possible object is
     *     {@link ConnectionTypeEnumeration }
     *     
     */
    public ConnectionTypeEnumeration getConnectionType() {
        return connectionType;
    }

    /**
     * Sets the value of the connectionType property.
     * 
     * @param value
     *     allowed object is
     *     {@link ConnectionTypeEnumeration }
     *     
     */
    public Connection setConnectionType(ConnectionTypeEnumeration value) {
        this.connectionType = value;
        return this;
    }

    /**
     * Gets the value of the displayContent property.
     * 
     * @return
     *     possible object is
     *     {@link DisplayContent }
     *     
     */
    public DisplayContent getDisplayContent() {
        return displayContent;
    }

    /**
     * Sets the value of the displayContent property.
     * 
     * @param value
     *     allowed object is
     *     {@link DisplayContent }
     *     
     */
    public Connection setDisplayContent(DisplayContent value) {
        this.displayContent = value;
        return this;
    }

    /**
     * Gets the value of the departureStopPointRef property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDepartureStopPointRef() {
        return departureStopPointRef;
    }

    /**
     * Sets the value of the departureStopPointRef property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public Connection setDepartureStopPointRef(String value) {
        this.departureStopPointRef = value;
        return this;
    }

    /**
     * Gets the value of the platform property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPlatform() {
        return platform;
    }

    /**
     * Sets the value of the platform property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public Connection setPlatform(String value) {
        this.platform = value;
        return this;
    }

    /**
     * Gets the value of the connectionState property.
     * 
     * @return
     *     possible object is
     *     {@link ConnectionStateEnumeration }
     *     
     */
    public ConnectionStateEnumeration getConnectionState() {
        return connectionState;
    }

    /**
     * Sets the value of the connectionState property.
     * 
     * @param value
     *     allowed object is
     *     {@link ConnectionStateEnumeration }
     *     
     */
    public Connection setConnectionState(ConnectionStateEnumeration value) {
        this.connectionState = value;
        return this;
    }

    /**
     * Gets the value of the transportmode property.
     * 
     * @return
     *     possible object is
     *     {@link VehicleType }
     *     
     */
    public VehicleType getTransportmode() {
        return transportmode;
    }

    /**
     * Sets the value of the transportmode property.
     * 
     * @param value
     *     allowed object is
     *     {@link VehicleType }
     *     
     */
    public Connection setTransportmode(VehicleType value) {
        this.transportmode = value;
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
    public Connection setExpectedDepartureTime(ZonedDateTime value) {
        this.expectedDepartureTime = value;
        return this;
    }

}
