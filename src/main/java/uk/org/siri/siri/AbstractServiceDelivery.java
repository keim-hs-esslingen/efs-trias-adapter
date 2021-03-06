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
import java.time.ZonedDateTime;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import javax.xml.datatype.Duration;
import de.hsesslingen.keim.efs.adapter.trias.jaxb.ZonedDateTimeAdapter;
import de.vdv.trias.TripMonitoringDelivery;


/**
 * Type for Common elementd for a SIRI service delivery of the Form xxxDelivery.
 * 
 * <p>Java class for AbstractServiceDelivery complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="AbstractServiceDeliveryStructure">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.siri.org.uk/siri}ResponseStructure">
 *       &lt;sequence>
 *         &lt;choice>
 *           &lt;group ref="{http://www.siri.org.uk/siri}ContextualisedResponseEndpointGroup"/>
 *           &lt;group ref="{http://www.siri.org.uk/siri}SubscriptionIdentifierResourcePropertyGroup"/>
 *         &lt;/choice>
 *         &lt;group ref="{http://www.siri.org.uk/siri}DeliveryStatusGroup"/>
 *         &lt;group ref="{http://www.siri.org.uk/siri}DeliveryDefaultGroup"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AbstractServiceDeliveryStructure", namespace = "http://www.siri.org.uk/siri", propOrder = {
    "requestMessageRef",
    "subscriberRef",
    "subscriptionFilterRef",
    "subscriptionRef",
    "status",
    "errorCondition",
    "validUntil",
    "shortestPossibleCycle",
    "defaultLanguage"
})
@XmlSeeAlso({
    FacilityMonitoringDelivery.class,
    SituationExchangeDelivery.class,
    TripMonitoringDelivery.class,
    ConnectionMonitoringDistributorDelivery.class,
    EstimatedTimetableDelivery.class,
    GeneralMessageDelivery.class,
    VehicleMonitoringDelivery.class,
    ProductionTimetableDelivery.class,
    StopTimetableDelivery.class,
    StopMonitoringDelivery.class,
    ConnectionTimetableDelivery.class,
    ConnectionMonitoringFeederDelivery.class
})
@ToString
public class AbstractServiceDelivery
    extends Response
{

    @XmlElement(name = "RequestMessageRef", namespace = "http://www.siri.org.uk/siri")
    protected MessageQualifier requestMessageRef;
    @XmlElement(name = "SubscriberRef", namespace = "http://www.siri.org.uk/siri")
    protected ParticipantRef subscriberRef;
    @XmlElement(name = "SubscriptionFilterRef", namespace = "http://www.siri.org.uk/siri")
    protected SubscriptionFilterRef subscriptionFilterRef;
    @XmlElement(name = "SubscriptionRef", namespace = "http://www.siri.org.uk/siri")
    protected SubscriptionQualifier subscriptionRef;
    @XmlElement(name = "Status", namespace = "http://www.siri.org.uk/siri", defaultValue = "true")
    protected Boolean status;
    @XmlElement(name = "ErrorCondition", namespace = "http://www.siri.org.uk/siri")
    protected ServiceDeliveryErrorCondition errorCondition;
    @XmlElement(name = "ValidUntil", namespace = "http://www.siri.org.uk/siri", type = String.class)
    @XmlJavaTypeAdapter(ZonedDateTimeAdapter.class)
    @XmlSchemaType(name = "dateTime")
    protected ZonedDateTime validUntil;
    @XmlElement(name = "ShortestPossibleCycle", namespace = "http://www.siri.org.uk/siri")
    protected Duration shortestPossibleCycle;
    @XmlElement(name = "DefaultLanguage", namespace = "http://www.siri.org.uk/siri")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "language")
    protected String defaultLanguage;

    /**
     * Gets the value of the requestMessageRef property.
     * 
     * @return
     *     possible object is
     *     {@link MessageQualifier }
     *     
     */
    public MessageQualifier getRequestMessageRef() {
        return requestMessageRef;
    }

    /**
     * Sets the value of the requestMessageRef property.
     * 
     * @param value
     *     allowed object is
     *     {@link MessageQualifier }
     *     
     */
    public AbstractServiceDelivery setRequestMessageRef(MessageQualifier value) {
        this.requestMessageRef = value;
        return this;
    }

    /**
     * Gets the value of the subscriberRef property.
     * 
     * @return
     *     possible object is
     *     {@link ParticipantRef }
     *     
     */
    public ParticipantRef getSubscriberRef() {
        return subscriberRef;
    }

    /**
     * Sets the value of the subscriberRef property.
     * 
     * @param value
     *     allowed object is
     *     {@link ParticipantRef }
     *     
     */
    public AbstractServiceDelivery setSubscriberRef(ParticipantRef value) {
        this.subscriberRef = value;
        return this;
    }

    /**
     * Gets the value of the subscriptionFilterRef property.
     * 
     * @return
     *     possible object is
     *     {@link SubscriptionFilterRef }
     *     
     */
    public SubscriptionFilterRef getSubscriptionFilterRef() {
        return subscriptionFilterRef;
    }

    /**
     * Sets the value of the subscriptionFilterRef property.
     * 
     * @param value
     *     allowed object is
     *     {@link SubscriptionFilterRef }
     *     
     */
    public AbstractServiceDelivery setSubscriptionFilterRef(SubscriptionFilterRef value) {
        this.subscriptionFilterRef = value;
        return this;
    }

    /**
     * Gets the value of the subscriptionRef property.
     * 
     * @return
     *     possible object is
     *     {@link SubscriptionQualifier }
     *     
     */
    public SubscriptionQualifier getSubscriptionRef() {
        return subscriptionRef;
    }

    /**
     * Sets the value of the subscriptionRef property.
     * 
     * @param value
     *     allowed object is
     *     {@link SubscriptionQualifier }
     *     
     */
    public AbstractServiceDelivery setSubscriptionRef(SubscriptionQualifier value) {
        this.subscriptionRef = value;
        return this;
    }

    /**
     * Gets the value of the status property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isStatus() {
        return status;
    }

    /**
     * Sets the value of the status property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public AbstractServiceDelivery setStatus(Boolean value) {
        this.status = value;
        return this;
    }

    /**
     * Gets the value of the errorCondition property.
     * 
     * @return
     *     possible object is
     *     {@link ServiceDeliveryErrorCondition }
     *     
     */
    public ServiceDeliveryErrorCondition getErrorCondition() {
        return errorCondition;
    }

    /**
     * Sets the value of the errorCondition property.
     * 
     * @param value
     *     allowed object is
     *     {@link ServiceDeliveryErrorCondition }
     *     
     */
    public AbstractServiceDelivery setErrorCondition(ServiceDeliveryErrorCondition value) {
        this.errorCondition = value;
        return this;
    }

    /**
     * Gets the value of the validUntil property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public ZonedDateTime getValidUntil() {
        return validUntil;
    }

    /**
     * Sets the value of the validUntil property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public AbstractServiceDelivery setValidUntil(ZonedDateTime value) {
        this.validUntil = value;
        return this;
    }

    /**
     * Gets the value of the shortestPossibleCycle property.
     * 
     * @return
     *     possible object is
     *     {@link Duration }
     *     
     */
    public Duration getShortestPossibleCycle() {
        return shortestPossibleCycle;
    }

    /**
     * Sets the value of the shortestPossibleCycle property.
     * 
     * @param value
     *     allowed object is
     *     {@link Duration }
     *     
     */
    public AbstractServiceDelivery setShortestPossibleCycle(Duration value) {
        this.shortestPossibleCycle = value;
        return this;
    }

    /**
     * Gets the value of the defaultLanguage property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDefaultLanguage() {
        return defaultLanguage;
    }

    /**
     * Sets the value of the defaultLanguage property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public AbstractServiceDelivery setDefaultLanguage(String value) {
        this.defaultLanguage = value;
        return this;
    }

}
