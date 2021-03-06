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
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


/**
 * Type for Distributor Delivery for Connection Monitoring Service.
 * 
 * <p>Java class for ConnectionMonitoringDistributorDelivery complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ConnectionMonitoringDistributorDeliveryStructure">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.siri.org.uk/siri}AbstractServiceDeliveryStructure">
 *       &lt;sequence>
 *         &lt;group ref="{http://www.siri.org.uk/siri}ConnectionMonitoringDistributorPayloadGroup"/>
 *         &lt;element ref="{http://www.siri.org.uk/siri}Extensions" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="version" use="required" type="{http://www.siri.org.uk/siri}VersionString" fixed="1.4" />
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ConnectionMonitoringDistributorDeliveryStructure", namespace = "http://www.siri.org.uk/siri", propOrder = {
    "waitProlongedDeparture",
    "stoppingPositionChangedDeparture",
    "distributorDepartureCancellation",
    "extensions"
})
@ToString
public class ConnectionMonitoringDistributorDelivery
    extends AbstractServiceDelivery
{

    @XmlElement(name = "WaitProlongedDeparture", namespace = "http://www.siri.org.uk/siri")
    protected List<WaitProlongedDeparture> waitProlongedDeparture;
    @XmlElement(name = "StoppingPositionChangedDeparture", namespace = "http://www.siri.org.uk/siri")
    protected List<StoppingPositionChangedDeparture> stoppingPositionChangedDeparture;
    @XmlElement(name = "DistributorDepartureCancellation", namespace = "http://www.siri.org.uk/siri")
    protected List<DistributorDepartureCancellation> distributorDepartureCancellation;
    @XmlElement(name = "Extensions", namespace = "http://www.siri.org.uk/siri")
    protected Extensions extensions;
    @XmlAttribute(name = "version", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String version;

    /**
     * Gets the value of the waitProlongedDeparture property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the waitProlongedDeparture property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getWaitProlongedDeparture().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link WaitProlongedDeparture }
     * 
     * 
     */
    public List<WaitProlongedDeparture> getWaitProlongedDeparture() {
        if (waitProlongedDeparture == null) {
            waitProlongedDeparture = new ArrayList<WaitProlongedDeparture>();
        }
        return this.waitProlongedDeparture;
    }

    /**
     * Gets the value of the stoppingPositionChangedDeparture property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the stoppingPositionChangedDeparture property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getStoppingPositionChangedDeparture().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link StoppingPositionChangedDeparture }
     * 
     * 
     */
    public List<StoppingPositionChangedDeparture> getStoppingPositionChangedDeparture() {
        if (stoppingPositionChangedDeparture == null) {
            stoppingPositionChangedDeparture = new ArrayList<StoppingPositionChangedDeparture>();
        }
        return this.stoppingPositionChangedDeparture;
    }

    /**
     * Gets the value of the distributorDepartureCancellation property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the distributorDepartureCancellation property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDistributorDepartureCancellation().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link DistributorDepartureCancellation }
     * 
     * 
     */
    public List<DistributorDepartureCancellation> getDistributorDepartureCancellation() {
        if (distributorDepartureCancellation == null) {
            distributorDepartureCancellation = new ArrayList<DistributorDepartureCancellation>();
        }
        return this.distributorDepartureCancellation;
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
    public ConnectionMonitoringDistributorDelivery setExtensions(Extensions value) {
        this.extensions = value;
        return this;
    }

    /**
     * Gets the value of the version property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVersion() {
        if (version == null) {
            return "1.4";
        } else {
            return version;
        }
    }

    /**
     * Sets the value of the version property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public ConnectionMonitoringDistributorDelivery setVersion(String value) {
        this.version = value;
        return this;
    }

}
