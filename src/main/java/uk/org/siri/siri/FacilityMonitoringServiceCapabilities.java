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
import javax.xml.datatype.Duration;


/**
 * Type for Vehicle Monitoring Capabilities
 * 
 * <p>Java class for FacilityMonitoringServiceCapabilities complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="FacilityMonitoringServiceCapabilitiesStructure">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.siri.org.uk/siri}AbstractCapabilitiesStructure">
 *       &lt;sequence>
 *         &lt;element name="TopicFiltering" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="DefaultPreviewInterval" type="{http://www.siri.org.uk/siri}PositiveDurationType"/>
 *                   &lt;element ref="{http://www.siri.org.uk/siri}FilterByFacilityRef"/>
 *                   &lt;element name="FilterByLocationRef" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *                   &lt;element ref="{http://www.siri.org.uk/siri}FilterByVehicleRef" minOccurs="0"/>
 *                   &lt;element ref="{http://www.siri.org.uk/siri}FilterByLineRef" minOccurs="0"/>
 *                   &lt;element ref="{http://www.siri.org.uk/siri}FilterByStopPointRef" minOccurs="0"/>
 *                   &lt;element ref="{http://www.siri.org.uk/siri}FilterByVehicleJourneyRef" minOccurs="0"/>
 *                   &lt;element ref="{http://www.siri.org.uk/siri}FilterByConnectionLinkRef" minOccurs="0"/>
 *                   &lt;element ref="{http://www.siri.org.uk/siri}FilterByInterchangeRef" minOccurs="0"/>
 *                   &lt;element name="FilterBySpecificNeed" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="RequestPolicy" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;extension base="{http://www.siri.org.uk/siri}CapabilityRequestPolicyStructure">
 *                 &lt;sequence>
 *                   &lt;group ref="{http://www.siri.org.uk/siri}FacilityMonitoringVolumeGroup"/>
 *                 &lt;/sequence>
 *               &lt;/extension>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="SubscriptionPolicy" type="{http://www.siri.org.uk/siri}CapabilitySubscriptionPolicyStructure" minOccurs="0"/>
 *         &lt;element name="AccessControl" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;extension base="{http://www.siri.org.uk/siri}CapabilityAccessControlStructure">
 *                 &lt;sequence>
 *                   &lt;element ref="{http://www.siri.org.uk/siri}CheckOperatorRef" minOccurs="0"/>
 *                   &lt;element ref="{http://www.siri.org.uk/siri}CheckLineRef" minOccurs="0"/>
 *                 &lt;/sequence>
 *               &lt;/extension>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="ResponseFeatures" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="HasRemedy" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *                   &lt;element name="HasFacilityLocation" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element ref="{http://www.siri.org.uk/siri}Extensions" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "FacilityMonitoringServiceCapabilitiesStructure", namespace = "http://www.siri.org.uk/siri", propOrder = {
    "topicFiltering",
    "requestPolicy",
    "subscriptionPolicy",
    "accessControl",
    "responseFeatures",
    "extensions"
})
@ToString
public class FacilityMonitoringServiceCapabilities
    extends AbstractCapabilities
{

    @XmlElement(name = "TopicFiltering", namespace = "http://www.siri.org.uk/siri")
    protected FacilityMonitoringServiceCapabilities.TopicFiltering topicFiltering;
    @XmlElement(name = "RequestPolicy", namespace = "http://www.siri.org.uk/siri")
    protected FacilityMonitoringServiceCapabilities.RequestPolicy requestPolicy;
    @XmlElement(name = "SubscriptionPolicy", namespace = "http://www.siri.org.uk/siri")
    protected CapabilitySubscriptionPolicy subscriptionPolicy;
    @XmlElement(name = "AccessControl", namespace = "http://www.siri.org.uk/siri")
    protected FacilityMonitoringServiceCapabilities.AccessControl accessControl;
    @XmlElement(name = "ResponseFeatures", namespace = "http://www.siri.org.uk/siri")
    protected FacilityMonitoringServiceCapabilities.ResponseFeatures responseFeatures;
    @XmlElement(name = "Extensions", namespace = "http://www.siri.org.uk/siri")
    protected Extensions extensions;

    /**
     * Gets the value of the topicFiltering property.
     * 
     * @return
     *     possible object is
     *     {@link FacilityMonitoringServiceCapabilities.TopicFiltering }
     *     
     */
    public FacilityMonitoringServiceCapabilities.TopicFiltering getTopicFiltering() {
        return topicFiltering;
    }

    /**
     * Sets the value of the topicFiltering property.
     * 
     * @param value
     *     allowed object is
     *     {@link FacilityMonitoringServiceCapabilities.TopicFiltering }
     *     
     */
    public void setTopicFiltering(FacilityMonitoringServiceCapabilities.TopicFiltering value) {
        this.topicFiltering = value;
    }

    /**
     * Gets the value of the requestPolicy property.
     * 
     * @return
     *     possible object is
     *     {@link FacilityMonitoringServiceCapabilities.RequestPolicy }
     *     
     */
    public FacilityMonitoringServiceCapabilities.RequestPolicy getRequestPolicy() {
        return requestPolicy;
    }

    /**
     * Sets the value of the requestPolicy property.
     * 
     * @param value
     *     allowed object is
     *     {@link FacilityMonitoringServiceCapabilities.RequestPolicy }
     *     
     */
    public void setRequestPolicy(FacilityMonitoringServiceCapabilities.RequestPolicy value) {
        this.requestPolicy = value;
    }

    /**
     * Gets the value of the subscriptionPolicy property.
     * 
     * @return
     *     possible object is
     *     {@link CapabilitySubscriptionPolicy }
     *     
     */
    public CapabilitySubscriptionPolicy getSubscriptionPolicy() {
        return subscriptionPolicy;
    }

    /**
     * Sets the value of the subscriptionPolicy property.
     * 
     * @param value
     *     allowed object is
     *     {@link CapabilitySubscriptionPolicy }
     *     
     */
    public FacilityMonitoringServiceCapabilities setSubscriptionPolicy(CapabilitySubscriptionPolicy value) {
        this.subscriptionPolicy = value;
        return this;
    }

    /**
     * Gets the value of the accessControl property.
     * 
     * @return
     *     possible object is
     *     {@link FacilityMonitoringServiceCapabilities.AccessControl }
     *     
     */
    public FacilityMonitoringServiceCapabilities.AccessControl getAccessControl() {
        return accessControl;
    }

    /**
     * Sets the value of the accessControl property.
     * 
     * @param value
     *     allowed object is
     *     {@link FacilityMonitoringServiceCapabilities.AccessControl }
     *     
     */
    public void setAccessControl(FacilityMonitoringServiceCapabilities.AccessControl value) {
        this.accessControl = value;
    }

    /**
     * Gets the value of the responseFeatures property.
     * 
     * @return
     *     possible object is
     *     {@link FacilityMonitoringServiceCapabilities.ResponseFeatures }
     *     
     */
    public FacilityMonitoringServiceCapabilities.ResponseFeatures getResponseFeatures() {
        return responseFeatures;
    }

    /**
     * Sets the value of the responseFeatures property.
     * 
     * @param value
     *     allowed object is
     *     {@link FacilityMonitoringServiceCapabilities.ResponseFeatures }
     *     
     */
    public void setResponseFeatures(FacilityMonitoringServiceCapabilities.ResponseFeatures value) {
        this.responseFeatures = value;
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
    public FacilityMonitoringServiceCapabilities setExtensions(Extensions value) {
        this.extensions = value;
        return this;
    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;extension base="{http://www.siri.org.uk/siri}CapabilityAccessControlStructure">
     *       &lt;sequence>
     *         &lt;element ref="{http://www.siri.org.uk/siri}CheckOperatorRef" minOccurs="0"/>
     *         &lt;element ref="{http://www.siri.org.uk/siri}CheckLineRef" minOccurs="0"/>
     *       &lt;/sequence>
     *     &lt;/extension>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "checkOperatorRef",
        "checkLineRef"
    })
    public static class AccessControl
        extends CapabilityAccessControl
    {

        @XmlElement(name = "CheckOperatorRef", namespace = "http://www.siri.org.uk/siri", defaultValue = "true")
        protected Boolean checkOperatorRef;
        @XmlElement(name = "CheckLineRef", namespace = "http://www.siri.org.uk/siri", defaultValue = "true")
        protected Boolean checkLineRef;

        /**
         * Gets the value of the checkOperatorRef property.
         * 
         * @return
         *     possible object is
         *     {@link Boolean }
         *     
         */
        public Boolean isCheckOperatorRef() {
            return checkOperatorRef;
        }

        /**
         * Sets the value of the checkOperatorRef property.
         * 
         * @param value
         *     allowed object is
         *     {@link Boolean }
         *     
         */
        public void setCheckOperatorRef(Boolean value) {
            this.checkOperatorRef = value;
        }

        /**
         * Gets the value of the checkLineRef property.
         * 
         * @return
         *     possible object is
         *     {@link Boolean }
         *     
         */
        public Boolean isCheckLineRef() {
            return checkLineRef;
        }

        /**
         * Sets the value of the checkLineRef property.
         * 
         * @param value
         *     allowed object is
         *     {@link Boolean }
         *     
         */
        public void setCheckLineRef(Boolean value) {
            this.checkLineRef = value;
        }

    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;extension base="{http://www.siri.org.uk/siri}CapabilityRequestPolicyStructure">
     *       &lt;sequence>
     *         &lt;group ref="{http://www.siri.org.uk/siri}FacilityMonitoringVolumeGroup"/>
     *       &lt;/sequence>
     *     &lt;/extension>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "hasMaximumFacilityStatus"
    })
    public static class RequestPolicy
        extends CapabilityRequestPolicy
    {

        @XmlElement(name = "HasMaximumFacilityStatus", namespace = "http://www.siri.org.uk/siri", defaultValue = "false")
        protected Boolean hasMaximumFacilityStatus;

        /**
         * Gets the value of the hasMaximumFacilityStatus property.
         * 
         * @return
         *     possible object is
         *     {@link Boolean }
         *     
         */
        public Boolean isHasMaximumFacilityStatus() {
            return hasMaximumFacilityStatus;
        }

        /**
         * Sets the value of the hasMaximumFacilityStatus property.
         * 
         * @param value
         *     allowed object is
         *     {@link Boolean }
         *     
         */
        public void setHasMaximumFacilityStatus(Boolean value) {
            this.hasMaximumFacilityStatus = value;
        }

    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="HasRemedy" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
     *         &lt;element name="HasFacilityLocation" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "hasRemedy",
        "hasFacilityLocation"
    })
    public static class ResponseFeatures {

        @XmlElement(name = "HasRemedy", namespace = "http://www.siri.org.uk/siri", defaultValue = "false")
        protected Boolean hasRemedy;
        @XmlElement(name = "HasFacilityLocation", namespace = "http://www.siri.org.uk/siri", defaultValue = "true")
        protected Boolean hasFacilityLocation;

        /**
         * Gets the value of the hasRemedy property.
         * 
         * @return
         *     possible object is
         *     {@link Boolean }
         *     
         */
        public Boolean isHasRemedy() {
            return hasRemedy;
        }

        /**
         * Sets the value of the hasRemedy property.
         * 
         * @param value
         *     allowed object is
         *     {@link Boolean }
         *     
         */
        public void setHasRemedy(Boolean value) {
            this.hasRemedy = value;
        }

        /**
         * Gets the value of the hasFacilityLocation property.
         * 
         * @return
         *     possible object is
         *     {@link Boolean }
         *     
         */
        public Boolean isHasFacilityLocation() {
            return hasFacilityLocation;
        }

        /**
         * Sets the value of the hasFacilityLocation property.
         * 
         * @param value
         *     allowed object is
         *     {@link Boolean }
         *     
         */
        public void setHasFacilityLocation(Boolean value) {
            this.hasFacilityLocation = value;
        }

    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="DefaultPreviewInterval" type="{http://www.siri.org.uk/siri}PositiveDurationType"/>
     *         &lt;element ref="{http://www.siri.org.uk/siri}FilterByFacilityRef"/>
     *         &lt;element name="FilterByLocationRef" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
     *         &lt;element ref="{http://www.siri.org.uk/siri}FilterByVehicleRef" minOccurs="0"/>
     *         &lt;element ref="{http://www.siri.org.uk/siri}FilterByLineRef" minOccurs="0"/>
     *         &lt;element ref="{http://www.siri.org.uk/siri}FilterByStopPointRef" minOccurs="0"/>
     *         &lt;element ref="{http://www.siri.org.uk/siri}FilterByVehicleJourneyRef" minOccurs="0"/>
     *         &lt;element ref="{http://www.siri.org.uk/siri}FilterByConnectionLinkRef" minOccurs="0"/>
     *         &lt;element ref="{http://www.siri.org.uk/siri}FilterByInterchangeRef" minOccurs="0"/>
     *         &lt;element name="FilterBySpecificNeed" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "defaultPreviewInterval",
        "filterByFacilityRef",
        "filterByLocationRef",
        "filterByVehicleRef",
        "filterByLineRef",
        "filterByStopPointRef",
        "filterByVehicleJourneyRef",
        "filterByConnectionLinkRef",
        "filterByInterchangeRef",
        "filterBySpecificNeed"
    })
    public static class TopicFiltering {

        @XmlElement(name = "DefaultPreviewInterval", namespace = "http://www.siri.org.uk/siri", required = true, defaultValue = "PT60M")
        protected Duration defaultPreviewInterval;
        @XmlElement(name = "FilterByFacilityRef", namespace = "http://www.siri.org.uk/siri", defaultValue = "true")
        protected boolean filterByFacilityRef;
        @XmlElement(name = "FilterByLocationRef", namespace = "http://www.siri.org.uk/siri")
        protected boolean filterByLocationRef;
        @XmlElement(name = "FilterByVehicleRef", namespace = "http://www.siri.org.uk/siri", defaultValue = "false")
        protected Boolean filterByVehicleRef;
        @XmlElement(name = "FilterByLineRef", namespace = "http://www.siri.org.uk/siri", defaultValue = "true")
        protected Boolean filterByLineRef;
        @XmlElement(name = "FilterByStopPointRef", namespace = "http://www.siri.org.uk/siri", defaultValue = "true")
        protected Boolean filterByStopPointRef;
        @XmlElement(name = "FilterByVehicleJourneyRef", namespace = "http://www.siri.org.uk/siri", defaultValue = "false")
        protected Boolean filterByVehicleJourneyRef;
        @XmlElement(name = "FilterByConnectionLinkRef", namespace = "http://www.siri.org.uk/siri", defaultValue = "true")
        protected Boolean filterByConnectionLinkRef;
        @XmlElement(name = "FilterByInterchangeRef", namespace = "http://www.siri.org.uk/siri", defaultValue = "false")
        protected Boolean filterByInterchangeRef;
        @XmlElement(name = "FilterBySpecificNeed", namespace = "http://www.siri.org.uk/siri", defaultValue = "true")
        protected Boolean filterBySpecificNeed;

        /**
         * Gets the value of the defaultPreviewInterval property.
         * 
         * @return
         *     possible object is
         *     {@link Duration }
         *     
         */
        public Duration getDefaultPreviewInterval() {
            return defaultPreviewInterval;
        }

        /**
         * Sets the value of the defaultPreviewInterval property.
         * 
         * @param value
         *     allowed object is
         *     {@link Duration }
         *     
         */
        public void setDefaultPreviewInterval(Duration value) {
            this.defaultPreviewInterval = value;
        }

        /**
         * Gets the value of the filterByFacilityRef property.
         * 
         */
        public boolean isFilterByFacilityRef() {
            return filterByFacilityRef;
        }

        /**
         * Sets the value of the filterByFacilityRef property.
         * 
         */
        public void setFilterByFacilityRef(boolean value) {
            this.filterByFacilityRef = value;
        }

        /**
         * Gets the value of the filterByLocationRef property.
         * 
         */
        public boolean isFilterByLocationRef() {
            return filterByLocationRef;
        }

        /**
         * Sets the value of the filterByLocationRef property.
         * 
         */
        public void setFilterByLocationRef(boolean value) {
            this.filterByLocationRef = value;
        }

        /**
         * Gets the value of the filterByVehicleRef property.
         * 
         * @return
         *     possible object is
         *     {@link Boolean }
         *     
         */
        public Boolean isFilterByVehicleRef() {
            return filterByVehicleRef;
        }

        /**
         * Sets the value of the filterByVehicleRef property.
         * 
         * @param value
         *     allowed object is
         *     {@link Boolean }
         *     
         */
        public void setFilterByVehicleRef(Boolean value) {
            this.filterByVehicleRef = value;
        }

        /**
         * Gets the value of the filterByLineRef property.
         * 
         * @return
         *     possible object is
         *     {@link Boolean }
         *     
         */
        public Boolean isFilterByLineRef() {
            return filterByLineRef;
        }

        /**
         * Sets the value of the filterByLineRef property.
         * 
         * @param value
         *     allowed object is
         *     {@link Boolean }
         *     
         */
        public void setFilterByLineRef(Boolean value) {
            this.filterByLineRef = value;
        }

        /**
         * Gets the value of the filterByStopPointRef property.
         * 
         * @return
         *     possible object is
         *     {@link Boolean }
         *     
         */
        public Boolean isFilterByStopPointRef() {
            return filterByStopPointRef;
        }

        /**
         * Sets the value of the filterByStopPointRef property.
         * 
         * @param value
         *     allowed object is
         *     {@link Boolean }
         *     
         */
        public void setFilterByStopPointRef(Boolean value) {
            this.filterByStopPointRef = value;
        }

        /**
         * Gets the value of the filterByVehicleJourneyRef property.
         * 
         * @return
         *     possible object is
         *     {@link Boolean }
         *     
         */
        public Boolean isFilterByVehicleJourneyRef() {
            return filterByVehicleJourneyRef;
        }

        /**
         * Sets the value of the filterByVehicleJourneyRef property.
         * 
         * @param value
         *     allowed object is
         *     {@link Boolean }
         *     
         */
        public void setFilterByVehicleJourneyRef(Boolean value) {
            this.filterByVehicleJourneyRef = value;
        }

        /**
         * Gets the value of the filterByConnectionLinkRef property.
         * 
         * @return
         *     possible object is
         *     {@link Boolean }
         *     
         */
        public Boolean isFilterByConnectionLinkRef() {
            return filterByConnectionLinkRef;
        }

        /**
         * Sets the value of the filterByConnectionLinkRef property.
         * 
         * @param value
         *     allowed object is
         *     {@link Boolean }
         *     
         */
        public void setFilterByConnectionLinkRef(Boolean value) {
            this.filterByConnectionLinkRef = value;
        }

        /**
         * Gets the value of the filterByInterchangeRef property.
         * 
         * @return
         *     possible object is
         *     {@link Boolean }
         *     
         */
        public Boolean isFilterByInterchangeRef() {
            return filterByInterchangeRef;
        }

        /**
         * Sets the value of the filterByInterchangeRef property.
         * 
         * @param value
         *     allowed object is
         *     {@link Boolean }
         *     
         */
        public void setFilterByInterchangeRef(Boolean value) {
            this.filterByInterchangeRef = value;
        }

        /**
         * Gets the value of the filterBySpecificNeed property.
         * 
         * @return
         *     possible object is
         *     {@link Boolean }
         *     
         */
        public Boolean isFilterBySpecificNeed() {
            return filterBySpecificNeed;
        }

        /**
         * Sets the value of the filterBySpecificNeed property.
         * 
         * @param value
         *     allowed object is
         *     {@link Boolean }
         *     
         */
        public void setFilterBySpecificNeed(Boolean value) {
            this.filterBySpecificNeed = value;
        }

    }

}
