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
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;choice>
 *         &lt;group ref="{http://www.siri.org.uk/siri}RequestGroup"/>
 *         &lt;group ref="{http://www.siri.org.uk/siri}ResponseGroup"/>
 *         &lt;element ref="{http://www.siri.org.uk/siri}Extensions" minOccurs="0"/>
 *       &lt;/choice>
 *       &lt;attribute name="version" use="required" type="{http://www.w3.org/2001/XMLSchema}NMTOKEN" fixed="1.4" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "serviceRequest",
    "subscriptionRequest",
    "terminateSubscriptionRequest",
    "dataReadyNotification",
    "dataSupplyRequest",
    "checkStatusRequest",
    "heartbeatNotification",
    "capabilitiesRequest",
    "stopPointsRequest",
    "linesRequest",
    "serviceFeaturesRequest",
    "productCategoriesRequest",
    "vehicleFeaturesRequest",
    "infoChannelRequest",
    "facilityRequest",
    "subscriptionResponse",
    "terminateSubscriptionResponse",
    "dataReadyAcknowledgement",
    "serviceDelivery",
    "dataReceivedAcknowledgement",
    "checkStatusResponse",
    "capabilitiesResponse",
    "stopPointsDelivery",
    "linesDelivery",
    "productCategoriesDelivery",
    "serviceFeaturesDelivery",
    "vehicleFeaturesDelivery",
    "infoChannelDelivery",
    "facilityDelivery",
    "extensions"
})
@XmlRootElement(name = "Siri", namespace = "http://www.siri.org.uk/siri")
@ToString
public class Siri {

    @XmlElement(name = "ServiceRequest", namespace = "http://www.siri.org.uk/siri")
    protected ServiceRequest serviceRequest;
    @XmlElement(name = "SubscriptionRequest", namespace = "http://www.siri.org.uk/siri")
    protected SubscriptionRequest subscriptionRequest;
    @XmlElement(name = "TerminateSubscriptionRequest", namespace = "http://www.siri.org.uk/siri")
    protected TerminateSubscriptionRequest terminateSubscriptionRequest;
    @XmlElement(name = "DataReadyNotification", namespace = "http://www.siri.org.uk/siri")
    protected DataReadyRequest dataReadyNotification;
    @XmlElement(name = "DataSupplyRequest", namespace = "http://www.siri.org.uk/siri")
    protected DataSupplyRequest dataSupplyRequest;
    @XmlElement(name = "CheckStatusRequest", namespace = "http://www.siri.org.uk/siri")
    protected CheckStatusRequest checkStatusRequest;
    @XmlElement(name = "HeartbeatNotification", namespace = "http://www.siri.org.uk/siri")
    protected HeartbeatNotification heartbeatNotification;
    @XmlElement(name = "CapabilitiesRequest", namespace = "http://www.siri.org.uk/siri")
    protected CapabilitiesRequest capabilitiesRequest;
    @XmlElement(name = "StopPointsRequest", namespace = "http://www.siri.org.uk/siri")
    protected StopPointsRequest stopPointsRequest;
    @XmlElement(name = "LinesRequest", namespace = "http://www.siri.org.uk/siri")
    protected LinesDiscoveryRequest linesRequest;
    @XmlElement(name = "ServiceFeaturesRequest", namespace = "http://www.siri.org.uk/siri")
    protected ServiceFeaturesDiscoveryRequest serviceFeaturesRequest;
    @XmlElement(name = "ProductCategoriesRequest", namespace = "http://www.siri.org.uk/siri")
    protected ProductCategoriesDiscoveryRequest productCategoriesRequest;
    @XmlElement(name = "VehicleFeaturesRequest", namespace = "http://www.siri.org.uk/siri")
    protected VehicleFeaturesDiscoveryRequest vehicleFeaturesRequest;
    @XmlElement(name = "InfoChannelRequest", namespace = "http://www.siri.org.uk/siri")
    protected InfoChannelDiscoveryRequest infoChannelRequest;
    @XmlElement(name = "FacilityRequest", namespace = "http://www.siri.org.uk/siri")
    protected FacilityRequest facilityRequest;
    @XmlElement(name = "SubscriptionResponse", namespace = "http://www.siri.org.uk/siri")
    protected SubscriptionResponse subscriptionResponse;
    @XmlElement(name = "TerminateSubscriptionResponse", namespace = "http://www.siri.org.uk/siri")
    protected TerminateSubscriptionResponse terminateSubscriptionResponse;
    @XmlElement(name = "DataReadyAcknowledgement", namespace = "http://www.siri.org.uk/siri")
    protected DataReadyResponse dataReadyAcknowledgement;
    @XmlElement(name = "ServiceDelivery", namespace = "http://www.siri.org.uk/siri")
    protected ServiceDelivery serviceDelivery;
    @XmlElement(name = "DataReceivedAcknowledgement", namespace = "http://www.siri.org.uk/siri")
    protected DataReceivedResponse dataReceivedAcknowledgement;
    @XmlElement(name = "CheckStatusResponse", namespace = "http://www.siri.org.uk/siri")
    protected CheckStatusResponse checkStatusResponse;
    @XmlElement(name = "CapabilitiesResponse", namespace = "http://www.siri.org.uk/siri")
    protected CapabilitiesResponse capabilitiesResponse;
    @XmlElement(name = "StopPointsDelivery", namespace = "http://www.siri.org.uk/siri")
    protected StopPointsDelivery stopPointsDelivery;
    @XmlElement(name = "LinesDelivery", namespace = "http://www.siri.org.uk/siri")
    protected LinesDelivery linesDelivery;
    @XmlElement(name = "ProductCategoriesDelivery", namespace = "http://www.siri.org.uk/siri")
    protected ProductCategoriesDelivery productCategoriesDelivery;
    @XmlElement(name = "ServiceFeaturesDelivery", namespace = "http://www.siri.org.uk/siri")
    protected ServiceFeaturesDelivery serviceFeaturesDelivery;
    @XmlElement(name = "VehicleFeaturesDelivery", namespace = "http://www.siri.org.uk/siri")
    protected VehicleFeaturesDelivery vehicleFeaturesDelivery;
    @XmlElement(name = "InfoChannelDelivery", namespace = "http://www.siri.org.uk/siri")
    protected InfoChannelDelivery infoChannelDelivery;
    @XmlElement(name = "FacilityDelivery", namespace = "http://www.siri.org.uk/siri")
    protected FacilityDelivery facilityDelivery;
    @XmlElement(name = "Extensions", namespace = "http://www.siri.org.uk/siri")
    protected Extensions extensions;
    @XmlAttribute(name = "version", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "NMTOKEN")
    protected String version;

    /**
     * Gets the value of the serviceRequest property.
     * 
     * @return
     *     possible object is
     *     {@link ServiceRequest }
     *     
     */
    public ServiceRequest getServiceRequest() {
        return serviceRequest;
    }

    /**
     * Sets the value of the serviceRequest property.
     * 
     * @param value
     *     allowed object is
     *     {@link ServiceRequest }
     *     
     */
    public Siri setServiceRequest(ServiceRequest value) {
        this.serviceRequest = value;
        return this;
    }

    /**
     * Gets the value of the subscriptionRequest property.
     * 
     * @return
     *     possible object is
     *     {@link SubscriptionRequest }
     *     
     */
    public SubscriptionRequest getSubscriptionRequest() {
        return subscriptionRequest;
    }

    /**
     * Sets the value of the subscriptionRequest property.
     * 
     * @param value
     *     allowed object is
     *     {@link SubscriptionRequest }
     *     
     */
    public Siri setSubscriptionRequest(SubscriptionRequest value) {
        this.subscriptionRequest = value;
        return this;
    }

    /**
     * Gets the value of the terminateSubscriptionRequest property.
     * 
     * @return
     *     possible object is
     *     {@link TerminateSubscriptionRequest }
     *     
     */
    public TerminateSubscriptionRequest getTerminateSubscriptionRequest() {
        return terminateSubscriptionRequest;
    }

    /**
     * Sets the value of the terminateSubscriptionRequest property.
     * 
     * @param value
     *     allowed object is
     *     {@link TerminateSubscriptionRequest }
     *     
     */
    public Siri setTerminateSubscriptionRequest(TerminateSubscriptionRequest value) {
        this.terminateSubscriptionRequest = value;
        return this;
    }

    /**
     * Gets the value of the dataReadyNotification property.
     * 
     * @return
     *     possible object is
     *     {@link DataReadyRequest }
     *     
     */
    public DataReadyRequest getDataReadyNotification() {
        return dataReadyNotification;
    }

    /**
     * Sets the value of the dataReadyNotification property.
     * 
     * @param value
     *     allowed object is
     *     {@link DataReadyRequest }
     *     
     */
    public Siri setDataReadyNotification(DataReadyRequest value) {
        this.dataReadyNotification = value;
        return this;
    }

    /**
     * Gets the value of the dataSupplyRequest property.
     * 
     * @return
     *     possible object is
     *     {@link DataSupplyRequest }
     *     
     */
    public DataSupplyRequest getDataSupplyRequest() {
        return dataSupplyRequest;
    }

    /**
     * Sets the value of the dataSupplyRequest property.
     * 
     * @param value
     *     allowed object is
     *     {@link DataSupplyRequest }
     *     
     */
    public Siri setDataSupplyRequest(DataSupplyRequest value) {
        this.dataSupplyRequest = value;
        return this;
    }

    /**
     * Gets the value of the checkStatusRequest property.
     * 
     * @return
     *     possible object is
     *     {@link CheckStatusRequest }
     *     
     */
    public CheckStatusRequest getCheckStatusRequest() {
        return checkStatusRequest;
    }

    /**
     * Sets the value of the checkStatusRequest property.
     * 
     * @param value
     *     allowed object is
     *     {@link CheckStatusRequest }
     *     
     */
    public Siri setCheckStatusRequest(CheckStatusRequest value) {
        this.checkStatusRequest = value;
        return this;
    }

    /**
     * Gets the value of the heartbeatNotification property.
     * 
     * @return
     *     possible object is
     *     {@link HeartbeatNotification }
     *     
     */
    public HeartbeatNotification getHeartbeatNotification() {
        return heartbeatNotification;
    }

    /**
     * Sets the value of the heartbeatNotification property.
     * 
     * @param value
     *     allowed object is
     *     {@link HeartbeatNotification }
     *     
     */
    public Siri setHeartbeatNotification(HeartbeatNotification value) {
        this.heartbeatNotification = value;
        return this;
    }

    /**
     * Gets the value of the capabilitiesRequest property.
     * 
     * @return
     *     possible object is
     *     {@link CapabilitiesRequest }
     *     
     */
    public CapabilitiesRequest getCapabilitiesRequest() {
        return capabilitiesRequest;
    }

    /**
     * Sets the value of the capabilitiesRequest property.
     * 
     * @param value
     *     allowed object is
     *     {@link CapabilitiesRequest }
     *     
     */
    public Siri setCapabilitiesRequest(CapabilitiesRequest value) {
        this.capabilitiesRequest = value;
        return this;
    }

    /**
     * Gets the value of the stopPointsRequest property.
     * 
     * @return
     *     possible object is
     *     {@link StopPointsRequest }
     *     
     */
    public StopPointsRequest getStopPointsRequest() {
        return stopPointsRequest;
    }

    /**
     * Sets the value of the stopPointsRequest property.
     * 
     * @param value
     *     allowed object is
     *     {@link StopPointsRequest }
     *     
     */
    public Siri setStopPointsRequest(StopPointsRequest value) {
        this.stopPointsRequest = value;
        return this;
    }

    /**
     * Gets the value of the linesRequest property.
     * 
     * @return
     *     possible object is
     *     {@link LinesDiscoveryRequest }
     *     
     */
    public LinesDiscoveryRequest getLinesRequest() {
        return linesRequest;
    }

    /**
     * Sets the value of the linesRequest property.
     * 
     * @param value
     *     allowed object is
     *     {@link LinesDiscoveryRequest }
     *     
     */
    public Siri setLinesRequest(LinesDiscoveryRequest value) {
        this.linesRequest = value;
        return this;
    }

    /**
     * Gets the value of the serviceFeaturesRequest property.
     * 
     * @return
     *     possible object is
     *     {@link ServiceFeaturesDiscoveryRequest }
     *     
     */
    public ServiceFeaturesDiscoveryRequest getServiceFeaturesRequest() {
        return serviceFeaturesRequest;
    }

    /**
     * Sets the value of the serviceFeaturesRequest property.
     * 
     * @param value
     *     allowed object is
     *     {@link ServiceFeaturesDiscoveryRequest }
     *     
     */
    public Siri setServiceFeaturesRequest(ServiceFeaturesDiscoveryRequest value) {
        this.serviceFeaturesRequest = value;
        return this;
    }

    /**
     * Gets the value of the productCategoriesRequest property.
     * 
     * @return
     *     possible object is
     *     {@link ProductCategoriesDiscoveryRequest }
     *     
     */
    public ProductCategoriesDiscoveryRequest getProductCategoriesRequest() {
        return productCategoriesRequest;
    }

    /**
     * Sets the value of the productCategoriesRequest property.
     * 
     * @param value
     *     allowed object is
     *     {@link ProductCategoriesDiscoveryRequest }
     *     
     */
    public Siri setProductCategoriesRequest(ProductCategoriesDiscoveryRequest value) {
        this.productCategoriesRequest = value;
        return this;
    }

    /**
     * Gets the value of the vehicleFeaturesRequest property.
     * 
     * @return
     *     possible object is
     *     {@link VehicleFeaturesDiscoveryRequest }
     *     
     */
    public VehicleFeaturesDiscoveryRequest getVehicleFeaturesRequest() {
        return vehicleFeaturesRequest;
    }

    /**
     * Sets the value of the vehicleFeaturesRequest property.
     * 
     * @param value
     *     allowed object is
     *     {@link VehicleFeaturesDiscoveryRequest }
     *     
     */
    public Siri setVehicleFeaturesRequest(VehicleFeaturesDiscoveryRequest value) {
        this.vehicleFeaturesRequest = value;
        return this;
    }

    /**
     * Gets the value of the infoChannelRequest property.
     * 
     * @return
     *     possible object is
     *     {@link InfoChannelDiscoveryRequest }
     *     
     */
    public InfoChannelDiscoveryRequest getInfoChannelRequest() {
        return infoChannelRequest;
    }

    /**
     * Sets the value of the infoChannelRequest property.
     * 
     * @param value
     *     allowed object is
     *     {@link InfoChannelDiscoveryRequest }
     *     
     */
    public Siri setInfoChannelRequest(InfoChannelDiscoveryRequest value) {
        this.infoChannelRequest = value;
        return this;
    }

    /**
     * Gets the value of the facilityRequest property.
     * 
     * @return
     *     possible object is
     *     {@link FacilityRequest }
     *     
     */
    public FacilityRequest getFacilityRequest() {
        return facilityRequest;
    }

    /**
     * Sets the value of the facilityRequest property.
     * 
     * @param value
     *     allowed object is
     *     {@link FacilityRequest }
     *     
     */
    public Siri setFacilityRequest(FacilityRequest value) {
        this.facilityRequest = value;
        return this;
    }

    /**
     * Gets the value of the subscriptionResponse property.
     * 
     * @return
     *     possible object is
     *     {@link SubscriptionResponse }
     *     
     */
    public SubscriptionResponse getSubscriptionResponse() {
        return subscriptionResponse;
    }

    /**
     * Sets the value of the subscriptionResponse property.
     * 
     * @param value
     *     allowed object is
     *     {@link SubscriptionResponse }
     *     
     */
    public Siri setSubscriptionResponse(SubscriptionResponse value) {
        this.subscriptionResponse = value;
        return this;
    }

    /**
     * Gets the value of the terminateSubscriptionResponse property.
     * 
     * @return
     *     possible object is
     *     {@link TerminateSubscriptionResponse }
     *     
     */
    public TerminateSubscriptionResponse getTerminateSubscriptionResponse() {
        return terminateSubscriptionResponse;
    }

    /**
     * Sets the value of the terminateSubscriptionResponse property.
     * 
     * @param value
     *     allowed object is
     *     {@link TerminateSubscriptionResponse }
     *     
     */
    public Siri setTerminateSubscriptionResponse(TerminateSubscriptionResponse value) {
        this.terminateSubscriptionResponse = value;
        return this;
    }

    /**
     * Gets the value of the dataReadyAcknowledgement property.
     * 
     * @return
     *     possible object is
     *     {@link DataReadyResponse }
     *     
     */
    public DataReadyResponse getDataReadyAcknowledgement() {
        return dataReadyAcknowledgement;
    }

    /**
     * Sets the value of the dataReadyAcknowledgement property.
     * 
     * @param value
     *     allowed object is
     *     {@link DataReadyResponse }
     *     
     */
    public Siri setDataReadyAcknowledgement(DataReadyResponse value) {
        this.dataReadyAcknowledgement = value;
        return this;
    }

    /**
     * Gets the value of the serviceDelivery property.
     * 
     * @return
     *     possible object is
     *     {@link ServiceDelivery }
     *     
     */
    public ServiceDelivery getServiceDelivery() {
        return serviceDelivery;
    }

    /**
     * Sets the value of the serviceDelivery property.
     * 
     * @param value
     *     allowed object is
     *     {@link ServiceDelivery }
     *     
     */
    public Siri setServiceDelivery(ServiceDelivery value) {
        this.serviceDelivery = value;
        return this;
    }

    /**
     * Gets the value of the dataReceivedAcknowledgement property.
     * 
     * @return
     *     possible object is
     *     {@link DataReceivedResponse }
     *     
     */
    public DataReceivedResponse getDataReceivedAcknowledgement() {
        return dataReceivedAcknowledgement;
    }

    /**
     * Sets the value of the dataReceivedAcknowledgement property.
     * 
     * @param value
     *     allowed object is
     *     {@link DataReceivedResponse }
     *     
     */
    public Siri setDataReceivedAcknowledgement(DataReceivedResponse value) {
        this.dataReceivedAcknowledgement = value;
        return this;
    }

    /**
     * Gets the value of the checkStatusResponse property.
     * 
     * @return
     *     possible object is
     *     {@link CheckStatusResponse }
     *     
     */
    public CheckStatusResponse getCheckStatusResponse() {
        return checkStatusResponse;
    }

    /**
     * Sets the value of the checkStatusResponse property.
     * 
     * @param value
     *     allowed object is
     *     {@link CheckStatusResponse }
     *     
     */
    public Siri setCheckStatusResponse(CheckStatusResponse value) {
        this.checkStatusResponse = value;
        return this;
    }

    /**
     * Responses with  the capabilities of an implementation. Answers a CapabilityRequest 
     * 
     * @return
     *     possible object is
     *     {@link CapabilitiesResponse }
     *     
     */
    public CapabilitiesResponse getCapabilitiesResponse() {
        return capabilitiesResponse;
    }

    /**
     * Sets the value of the capabilitiesResponse property.
     * 
     * @param value
     *     allowed object is
     *     {@link CapabilitiesResponse }
     *     
     */
    public Siri setCapabilitiesResponse(CapabilitiesResponse value) {
        this.capabilitiesResponse = value;
        return this;
    }

    /**
     * Gets the value of the stopPointsDelivery property.
     * 
     * @return
     *     possible object is
     *     {@link StopPointsDelivery }
     *     
     */
    public StopPointsDelivery getStopPointsDelivery() {
        return stopPointsDelivery;
    }

    /**
     * Sets the value of the stopPointsDelivery property.
     * 
     * @param value
     *     allowed object is
     *     {@link StopPointsDelivery }
     *     
     */
    public Siri setStopPointsDelivery(StopPointsDelivery value) {
        this.stopPointsDelivery = value;
        return this;
    }

    /**
     * Gets the value of the linesDelivery property.
     * 
     * @return
     *     possible object is
     *     {@link LinesDelivery }
     *     
     */
    public LinesDelivery getLinesDelivery() {
        return linesDelivery;
    }

    /**
     * Sets the value of the linesDelivery property.
     * 
     * @param value
     *     allowed object is
     *     {@link LinesDelivery }
     *     
     */
    public Siri setLinesDelivery(LinesDelivery value) {
        this.linesDelivery = value;
        return this;
    }

    /**
     * Gets the value of the productCategoriesDelivery property.
     * 
     * @return
     *     possible object is
     *     {@link ProductCategoriesDelivery }
     *     
     */
    public ProductCategoriesDelivery getProductCategoriesDelivery() {
        return productCategoriesDelivery;
    }

    /**
     * Sets the value of the productCategoriesDelivery property.
     * 
     * @param value
     *     allowed object is
     *     {@link ProductCategoriesDelivery }
     *     
     */
    public Siri setProductCategoriesDelivery(ProductCategoriesDelivery value) {
        this.productCategoriesDelivery = value;
        return this;
    }

    /**
     * Gets the value of the serviceFeaturesDelivery property.
     * 
     * @return
     *     possible object is
     *     {@link ServiceFeaturesDelivery }
     *     
     */
    public ServiceFeaturesDelivery getServiceFeaturesDelivery() {
        return serviceFeaturesDelivery;
    }

    /**
     * Sets the value of the serviceFeaturesDelivery property.
     * 
     * @param value
     *     allowed object is
     *     {@link ServiceFeaturesDelivery }
     *     
     */
    public Siri setServiceFeaturesDelivery(ServiceFeaturesDelivery value) {
        this.serviceFeaturesDelivery = value;
        return this;
    }

    /**
     * Gets the value of the vehicleFeaturesDelivery property.
     * 
     * @return
     *     possible object is
     *     {@link VehicleFeaturesDelivery }
     *     
     */
    public VehicleFeaturesDelivery getVehicleFeaturesDelivery() {
        return vehicleFeaturesDelivery;
    }

    /**
     * Sets the value of the vehicleFeaturesDelivery property.
     * 
     * @param value
     *     allowed object is
     *     {@link VehicleFeaturesDelivery }
     *     
     */
    public Siri setVehicleFeaturesDelivery(VehicleFeaturesDelivery value) {
        this.vehicleFeaturesDelivery = value;
        return this;
    }

    /**
     * Gets the value of the infoChannelDelivery property.
     * 
     * @return
     *     possible object is
     *     {@link InfoChannelDelivery }
     *     
     */
    public InfoChannelDelivery getInfoChannelDelivery() {
        return infoChannelDelivery;
    }

    /**
     * Sets the value of the infoChannelDelivery property.
     * 
     * @param value
     *     allowed object is
     *     {@link InfoChannelDelivery }
     *     
     */
    public Siri setInfoChannelDelivery(InfoChannelDelivery value) {
        this.infoChannelDelivery = value;
        return this;
    }

    /**
     * Gets the value of the facilityDelivery property.
     * 
     * @return
     *     possible object is
     *     {@link FacilityDelivery }
     *     
     */
    public FacilityDelivery getFacilityDelivery() {
        return facilityDelivery;
    }

    /**
     * Sets the value of the facilityDelivery property.
     * 
     * @param value
     *     allowed object is
     *     {@link FacilityDelivery }
     *     
     */
    public Siri setFacilityDelivery(FacilityDelivery value) {
        this.facilityDelivery = value;
        return this;
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
    public Siri setExtensions(Extensions value) {
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
    public Siri setVersion(String value) {
        this.version = value;
        return this;
    }

}
