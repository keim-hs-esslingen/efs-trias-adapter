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
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Data type for Subscription Request for Vehicle Monitoring Service.
 * 
 * <p>Java class for FacilityMonitoringSubscription complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="FacilityMonitoringSubscriptionStructure">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.siri.org.uk/siri}AbstractSubscriptionStructure">
 *       &lt;sequence>
 *         &lt;element ref="{http://www.siri.org.uk/siri}FacilityMonitoringRequest"/>
 *         &lt;group ref="{http://www.siri.org.uk/siri}FacilityMonitoringSubscriptionPolicyGroup"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "FacilityMonitoringSubscriptionStructure", namespace = "http://www.siri.org.uk/siri", propOrder = {
    "facilityMonitoringRequest",
    "incrementalUpdates"
})
@ToString
public class FacilityMonitoringSubscription
    extends AbstractSubscription
{

    @XmlElement(name = "FacilityMonitoringRequest", namespace = "http://www.siri.org.uk/siri", required = true)
    protected FacilityMonitoringRequest facilityMonitoringRequest;
    @XmlElement(name = "IncrementalUpdates", namespace = "http://www.siri.org.uk/siri", defaultValue = "false")
    protected Boolean incrementalUpdates;

    /**
     * Gets the value of the facilityMonitoringRequest property.
     * 
     * @return
     *     possible object is
     *     {@link FacilityMonitoringRequest }
     *     
     */
    public FacilityMonitoringRequest getFacilityMonitoringRequest() {
        return facilityMonitoringRequest;
    }

    /**
     * Sets the value of the facilityMonitoringRequest property.
     * 
     * @param value
     *     allowed object is
     *     {@link FacilityMonitoringRequest }
     *     
     */
    public FacilityMonitoringSubscription setFacilityMonitoringRequest(FacilityMonitoringRequest value) {
        this.facilityMonitoringRequest = value;
        return this;
    }

    /**
     * Gets the value of the incrementalUpdates property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isIncrementalUpdates() {
        return incrementalUpdates;
    }

    /**
     * Sets the value of the incrementalUpdates property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public FacilityMonitoringSubscription setIncrementalUpdates(Boolean value) {
        this.incrementalUpdates = value;
        return this;
    }

}
