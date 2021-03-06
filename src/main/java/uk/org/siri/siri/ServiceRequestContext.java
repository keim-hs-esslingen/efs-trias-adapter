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
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import javax.xml.datatype.Duration;


/**
 * Configurable context for requests. Intended Primarily as a documentation mechanism.
 * 
 * <p>Java class for ServiceRequestContext complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ServiceRequestContextStructure">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;group ref="{http://www.siri.org.uk/siri}ServiceEndpointAddressGroup"/>
 *         &lt;group ref="{http://www.siri.org.uk/siri}ClientEndpointAddressGroup"/>
 *         &lt;group ref="{http://www.siri.org.uk/siri}ReferenceContextGroup"/>
 *         &lt;group ref="{http://www.siri.org.uk/siri}TemporalContextGroup"/>
 *         &lt;group ref="{http://www.siri.org.uk/siri}DeliveryContextGroup"/>
 *         &lt;group ref="{http://www.siri.org.uk/siri}ResourceContextGroup"/>
 *         &lt;group ref="{http://www.siri.org.uk/siri}PredictionMethodGroup"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ServiceRequestContextStructure", namespace = "http://www.siri.org.uk/siri", propOrder = {
    "checkStatusAddress",
    "subscribeAddress",
    "manageSubscriptionAddress",
    "getDataAddress",
    "statusResponseAddress",
    "subscriberAddress",
    "notifyAddress",
    "consumerAddress",
    "dataNameSpaces",
    "language",
    "wgsDecimalDegrees",
    "gmlCoordinateFormat",
    "dataHorizon",
    "requestTimeout",
    "deliveryMethod",
    "multipartDespatch",
    "confirmDelivery",
    "maximimumNumberOfSubscriptions",
    "allowedPredictors",
    "predictionFunction"
})
@ToString
public class ServiceRequestContext {

    @XmlElement(name = "CheckStatusAddress", namespace = "http://www.siri.org.uk/siri")
    @XmlSchemaType(name = "anyURI")
    protected String checkStatusAddress;
    @XmlElement(name = "SubscribeAddress", namespace = "http://www.siri.org.uk/siri")
    @XmlSchemaType(name = "anyURI")
    protected String subscribeAddress;
    @XmlElement(name = "ManageSubscriptionAddress", namespace = "http://www.siri.org.uk/siri")
    @XmlSchemaType(name = "anyURI")
    protected String manageSubscriptionAddress;
    @XmlElement(name = "GetDataAddress", namespace = "http://www.siri.org.uk/siri")
    @XmlSchemaType(name = "anyURI")
    protected String getDataAddress;
    @XmlElement(name = "StatusResponseAddress", namespace = "http://www.siri.org.uk/siri")
    @XmlSchemaType(name = "anyURI")
    protected String statusResponseAddress;
    @XmlElement(name = "SubscriberAddress", namespace = "http://www.siri.org.uk/siri")
    @XmlSchemaType(name = "anyURI")
    protected String subscriberAddress;
    @XmlElement(name = "NotifyAddress", namespace = "http://www.siri.org.uk/siri")
    @XmlSchemaType(name = "anyURI")
    protected String notifyAddress;
    @XmlElement(name = "ConsumerAddress", namespace = "http://www.siri.org.uk/siri")
    @XmlSchemaType(name = "anyURI")
    protected String consumerAddress;
    @XmlElement(name = "DataNameSpaces", namespace = "http://www.siri.org.uk/siri")
    protected DataNameSpaces dataNameSpaces;
    @XmlElement(name = "Language", namespace = "http://www.siri.org.uk/siri", defaultValue = "en")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "language")
    protected String language;
    @XmlElement(name = "WgsDecimalDegrees", namespace = "http://www.siri.org.uk/siri")
    protected String wgsDecimalDegrees;
    @XmlElement(name = "GmlCoordinateFormat", namespace = "http://www.siri.org.uk/siri")
    protected String gmlCoordinateFormat;
    @XmlElement(name = "DataHorizon", namespace = "http://www.siri.org.uk/siri")
    protected Duration dataHorizon;
    @XmlElement(name = "RequestTimeout", namespace = "http://www.siri.org.uk/siri")
    protected Duration requestTimeout;
    @XmlElement(name = "DeliveryMethod", namespace = "http://www.siri.org.uk/siri", defaultValue = "direct")
    @XmlSchemaType(name = "NMTOKEN")
    protected DeliveryMethodEnumeration deliveryMethod;
    @XmlElement(name = "MultipartDespatch", namespace = "http://www.siri.org.uk/siri")
    protected Boolean multipartDespatch;
    @XmlElement(name = "ConfirmDelivery", namespace = "http://www.siri.org.uk/siri", defaultValue = "false")
    protected Boolean confirmDelivery;
    @XmlElement(name = "MaximimumNumberOfSubscriptions", namespace = "http://www.siri.org.uk/siri")
    @XmlSchemaType(name = "positiveInteger")
    protected BigInteger maximimumNumberOfSubscriptions;
    @XmlElement(name = "AllowedPredictors", namespace = "http://www.siri.org.uk/siri", defaultValue = "anyone")
    @XmlSchemaType(name = "NMTOKEN")
    protected PredictorsEnumeration allowedPredictors;
    @XmlElement(name = "PredictionFunction", namespace = "http://www.siri.org.uk/siri")
    protected String predictionFunction;

    /**
     * Gets the value of the checkStatusAddress property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCheckStatusAddress() {
        return checkStatusAddress;
    }

    /**
     * Sets the value of the checkStatusAddress property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public ServiceRequestContext setCheckStatusAddress(String value) {
        this.checkStatusAddress = value;
        return this;
    }

    /**
     * Gets the value of the subscribeAddress property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSubscribeAddress() {
        return subscribeAddress;
    }

    /**
     * Sets the value of the subscribeAddress property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public ServiceRequestContext setSubscribeAddress(String value) {
        this.subscribeAddress = value;
        return this;
    }

    /**
     * Gets the value of the manageSubscriptionAddress property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getManageSubscriptionAddress() {
        return manageSubscriptionAddress;
    }

    /**
     * Sets the value of the manageSubscriptionAddress property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public ServiceRequestContext setManageSubscriptionAddress(String value) {
        this.manageSubscriptionAddress = value;
        return this;
    }

    /**
     * Gets the value of the getDataAddress property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGetDataAddress() {
        return getDataAddress;
    }

    /**
     * Sets the value of the getDataAddress property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public ServiceRequestContext setGetDataAddress(String value) {
        this.getDataAddress = value;
        return this;
    }

    /**
     * Gets the value of the statusResponseAddress property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStatusResponseAddress() {
        return statusResponseAddress;
    }

    /**
     * Sets the value of the statusResponseAddress property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public ServiceRequestContext setStatusResponseAddress(String value) {
        this.statusResponseAddress = value;
        return this;
    }

    /**
     * Gets the value of the subscriberAddress property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSubscriberAddress() {
        return subscriberAddress;
    }

    /**
     * Sets the value of the subscriberAddress property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public ServiceRequestContext setSubscriberAddress(String value) {
        this.subscriberAddress = value;
        return this;
    }

    /**
     * Gets the value of the notifyAddress property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNotifyAddress() {
        return notifyAddress;
    }

    /**
     * Sets the value of the notifyAddress property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public ServiceRequestContext setNotifyAddress(String value) {
        this.notifyAddress = value;
        return this;
    }

    /**
     * Gets the value of the consumerAddress property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getConsumerAddress() {
        return consumerAddress;
    }

    /**
     * Sets the value of the consumerAddress property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public ServiceRequestContext setConsumerAddress(String value) {
        this.consumerAddress = value;
        return this;
    }

    /**
     * Gets the value of the dataNameSpaces property.
     * 
     * @return
     *     possible object is
     *     {@link DataNameSpaces }
     *     
     */
    public DataNameSpaces getDataNameSpaces() {
        return dataNameSpaces;
    }

    /**
     * Sets the value of the dataNameSpaces property.
     * 
     * @param value
     *     allowed object is
     *     {@link DataNameSpaces }
     *     
     */
    public ServiceRequestContext setDataNameSpaces(DataNameSpaces value) {
        this.dataNameSpaces = value;
        return this;
    }

    /**
     * Gets the value of the language property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLanguage() {
        return language;
    }

    /**
     * Sets the value of the language property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public ServiceRequestContext setLanguage(String value) {
        this.language = value;
        return this;
    }

    /**
     * Gets the value of the wgsDecimalDegrees property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getWgsDecimalDegrees() {
        return wgsDecimalDegrees;
    }

    /**
     * Sets the value of the wgsDecimalDegrees property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public ServiceRequestContext setWgsDecimalDegrees(String value) {
        this.wgsDecimalDegrees = value;
        return this;
    }

    /**
     * Gets the value of the gmlCoordinateFormat property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGmlCoordinateFormat() {
        return gmlCoordinateFormat;
    }

    /**
     * Sets the value of the gmlCoordinateFormat property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public ServiceRequestContext setGmlCoordinateFormat(String value) {
        this.gmlCoordinateFormat = value;
        return this;
    }

    /**
     * Gets the value of the dataHorizon property.
     * 
     * @return
     *     possible object is
     *     {@link Duration }
     *     
     */
    public Duration getDataHorizon() {
        return dataHorizon;
    }

    /**
     * Sets the value of the dataHorizon property.
     * 
     * @param value
     *     allowed object is
     *     {@link Duration }
     *     
     */
    public ServiceRequestContext setDataHorizon(Duration value) {
        this.dataHorizon = value;
        return this;
    }

    /**
     * Gets the value of the requestTimeout property.
     * 
     * @return
     *     possible object is
     *     {@link Duration }
     *     
     */
    public Duration getRequestTimeout() {
        return requestTimeout;
    }

    /**
     * Sets the value of the requestTimeout property.
     * 
     * @param value
     *     allowed object is
     *     {@link Duration }
     *     
     */
    public ServiceRequestContext setRequestTimeout(Duration value) {
        this.requestTimeout = value;
        return this;
    }

    /**
     * Gets the value of the deliveryMethod property.
     * 
     * @return
     *     possible object is
     *     {@link DeliveryMethodEnumeration }
     *     
     */
    public DeliveryMethodEnumeration getDeliveryMethod() {
        return deliveryMethod;
    }

    /**
     * Sets the value of the deliveryMethod property.
     * 
     * @param value
     *     allowed object is
     *     {@link DeliveryMethodEnumeration }
     *     
     */
    public ServiceRequestContext setDeliveryMethod(DeliveryMethodEnumeration value) {
        this.deliveryMethod = value;
        return this;
    }

    /**
     * Gets the value of the multipartDespatch property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isMultipartDespatch() {
        return multipartDespatch;
    }

    /**
     * Sets the value of the multipartDespatch property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public ServiceRequestContext setMultipartDespatch(Boolean value) {
        this.multipartDespatch = value;
        return this;
    }

    /**
     * Gets the value of the confirmDelivery property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isConfirmDelivery() {
        return confirmDelivery;
    }

    /**
     * Sets the value of the confirmDelivery property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public ServiceRequestContext setConfirmDelivery(Boolean value) {
        this.confirmDelivery = value;
        return this;
    }

    /**
     * Gets the value of the maximimumNumberOfSubscriptions property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getMaximimumNumberOfSubscriptions() {
        return maximimumNumberOfSubscriptions;
    }

    /**
     * Sets the value of the maximimumNumberOfSubscriptions property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public ServiceRequestContext setMaximimumNumberOfSubscriptions(BigInteger value) {
        this.maximimumNumberOfSubscriptions = value;
        return this;
    }

    /**
     * Gets the value of the allowedPredictors property.
     * 
     * @return
     *     possible object is
     *     {@link PredictorsEnumeration }
     *     
     */
    public PredictorsEnumeration getAllowedPredictors() {
        return allowedPredictors;
    }

    /**
     * Sets the value of the allowedPredictors property.
     * 
     * @param value
     *     allowed object is
     *     {@link PredictorsEnumeration }
     *     
     */
    public ServiceRequestContext setAllowedPredictors(PredictorsEnumeration value) {
        this.allowedPredictors = value;
        return this;
    }

    /**
     * Gets the value of the predictionFunction property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPredictionFunction() {
        return predictionFunction;
    }

    /**
     * Sets the value of the predictionFunction property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public ServiceRequestContext setPredictionFunction(String value) {
        this.predictionFunction = value;
        return this;
    }

}
