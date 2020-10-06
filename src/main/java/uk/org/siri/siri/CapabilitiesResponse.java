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
 * Type for the capabilities of an implementation. 
 * 
 * <p>Java class for CapabilitiesResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="CapabilitiesResponseStructure">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.siri.org.uk/siri}ProducerResponseStructure">
 *       &lt;sequence>
 *         &lt;group ref="{http://www.siri.org.uk/siri}SiriServiceCapabilitiesResponseGroup"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CapabilitiesResponseStructure", namespace = "http://www.siri.org.uk/siri", propOrder = {
    "productionTimetableCapabilitiesResponse",
    "estimatedTimetableCapabilitiesResponse",
    "stopTimetableCapabilitiesResponse",
    "stopMonitoringCapabilitiesResponse",
    "vehicleMonitoringCapabilitiesResponse",
    "connectionTimetableCapabilitiesResponse",
    "connectionMonitoringCapabilitiesResponse",
    "generalMessageCapabilitiesResponse",
    "facilityMonitoringCapabilitiesResponse",
    "situationExchangeServiceCapabilities"
})
@ToString
public class CapabilitiesResponse
    extends ProducerResponse
{

    @XmlElement(name = "ProductionTimetableCapabilitiesResponse", namespace = "http://www.siri.org.uk/siri")
    protected ProductionTimetableCapabilitiesResponse productionTimetableCapabilitiesResponse;
    @XmlElement(name = "EstimatedTimetableCapabilitiesResponse", namespace = "http://www.siri.org.uk/siri")
    protected EstimatedTimetableCapabilitiesResponse estimatedTimetableCapabilitiesResponse;
    @XmlElement(name = "StopTimetableCapabilitiesResponse", namespace = "http://www.siri.org.uk/siri")
    protected StopTimetableCapabilitiesResponse stopTimetableCapabilitiesResponse;
    @XmlElement(name = "StopMonitoringCapabilitiesResponse", namespace = "http://www.siri.org.uk/siri")
    protected StopMonitoringCapabilitiesResponse stopMonitoringCapabilitiesResponse;
    @XmlElement(name = "VehicleMonitoringCapabilitiesResponse", namespace = "http://www.siri.org.uk/siri")
    protected VehicleMonitoringCapabilitiesResponse vehicleMonitoringCapabilitiesResponse;
    @XmlElement(name = "ConnectionTimetableCapabilitiesResponse", namespace = "http://www.siri.org.uk/siri")
    protected ConnectionTimetableCapabilitiesResponse connectionTimetableCapabilitiesResponse;
    @XmlElement(name = "ConnectionMonitoringCapabilitiesResponse", namespace = "http://www.siri.org.uk/siri")
    protected ConnectionMonitoringCapabilitiesResponse connectionMonitoringCapabilitiesResponse;
    @XmlElement(name = "GeneralMessageCapabilitiesResponse", namespace = "http://www.siri.org.uk/siri")
    protected GeneralMessageCapabilitiesResponse generalMessageCapabilitiesResponse;
    @XmlElement(name = "FacilityMonitoringCapabilitiesResponse", namespace = "http://www.siri.org.uk/siri")
    protected FacilityMonitoringCapabilitiesResponse facilityMonitoringCapabilitiesResponse;
    @XmlElement(name = "SituationExchangeServiceCapabilities", namespace = "http://www.siri.org.uk/siri")
    protected SituationExchangeServiceCapabilities situationExchangeServiceCapabilities;

    /**
     * Gets the value of the productionTimetableCapabilitiesResponse property.
     * 
     * @return
     *     possible object is
     *     {@link ProductionTimetableCapabilitiesResponse }
     *     
     */
    public ProductionTimetableCapabilitiesResponse getProductionTimetableCapabilitiesResponse() {
        return productionTimetableCapabilitiesResponse;
    }

    /**
     * Sets the value of the productionTimetableCapabilitiesResponse property.
     * 
     * @param value
     *     allowed object is
     *     {@link ProductionTimetableCapabilitiesResponse }
     *     
     */
    public CapabilitiesResponse setProductionTimetableCapabilitiesResponse(ProductionTimetableCapabilitiesResponse value) {
        this.productionTimetableCapabilitiesResponse = value;
        return this;
    }

    /**
     * Gets the value of the estimatedTimetableCapabilitiesResponse property.
     * 
     * @return
     *     possible object is
     *     {@link EstimatedTimetableCapabilitiesResponse }
     *     
     */
    public EstimatedTimetableCapabilitiesResponse getEstimatedTimetableCapabilitiesResponse() {
        return estimatedTimetableCapabilitiesResponse;
    }

    /**
     * Sets the value of the estimatedTimetableCapabilitiesResponse property.
     * 
     * @param value
     *     allowed object is
     *     {@link EstimatedTimetableCapabilitiesResponse }
     *     
     */
    public CapabilitiesResponse setEstimatedTimetableCapabilitiesResponse(EstimatedTimetableCapabilitiesResponse value) {
        this.estimatedTimetableCapabilitiesResponse = value;
        return this;
    }

    /**
     * Gets the value of the stopTimetableCapabilitiesResponse property.
     * 
     * @return
     *     possible object is
     *     {@link StopTimetableCapabilitiesResponse }
     *     
     */
    public StopTimetableCapabilitiesResponse getStopTimetableCapabilitiesResponse() {
        return stopTimetableCapabilitiesResponse;
    }

    /**
     * Sets the value of the stopTimetableCapabilitiesResponse property.
     * 
     * @param value
     *     allowed object is
     *     {@link StopTimetableCapabilitiesResponse }
     *     
     */
    public CapabilitiesResponse setStopTimetableCapabilitiesResponse(StopTimetableCapabilitiesResponse value) {
        this.stopTimetableCapabilitiesResponse = value;
        return this;
    }

    /**
     * Gets the value of the stopMonitoringCapabilitiesResponse property.
     * 
     * @return
     *     possible object is
     *     {@link StopMonitoringCapabilitiesResponse }
     *     
     */
    public StopMonitoringCapabilitiesResponse getStopMonitoringCapabilitiesResponse() {
        return stopMonitoringCapabilitiesResponse;
    }

    /**
     * Sets the value of the stopMonitoringCapabilitiesResponse property.
     * 
     * @param value
     *     allowed object is
     *     {@link StopMonitoringCapabilitiesResponse }
     *     
     */
    public CapabilitiesResponse setStopMonitoringCapabilitiesResponse(StopMonitoringCapabilitiesResponse value) {
        this.stopMonitoringCapabilitiesResponse = value;
        return this;
    }

    /**
     * Gets the value of the vehicleMonitoringCapabilitiesResponse property.
     * 
     * @return
     *     possible object is
     *     {@link VehicleMonitoringCapabilitiesResponse }
     *     
     */
    public VehicleMonitoringCapabilitiesResponse getVehicleMonitoringCapabilitiesResponse() {
        return vehicleMonitoringCapabilitiesResponse;
    }

    /**
     * Sets the value of the vehicleMonitoringCapabilitiesResponse property.
     * 
     * @param value
     *     allowed object is
     *     {@link VehicleMonitoringCapabilitiesResponse }
     *     
     */
    public CapabilitiesResponse setVehicleMonitoringCapabilitiesResponse(VehicleMonitoringCapabilitiesResponse value) {
        this.vehicleMonitoringCapabilitiesResponse = value;
        return this;
    }

    /**
     * Gets the value of the connectionTimetableCapabilitiesResponse property.
     * 
     * @return
     *     possible object is
     *     {@link ConnectionTimetableCapabilitiesResponse }
     *     
     */
    public ConnectionTimetableCapabilitiesResponse getConnectionTimetableCapabilitiesResponse() {
        return connectionTimetableCapabilitiesResponse;
    }

    /**
     * Sets the value of the connectionTimetableCapabilitiesResponse property.
     * 
     * @param value
     *     allowed object is
     *     {@link ConnectionTimetableCapabilitiesResponse }
     *     
     */
    public CapabilitiesResponse setConnectionTimetableCapabilitiesResponse(ConnectionTimetableCapabilitiesResponse value) {
        this.connectionTimetableCapabilitiesResponse = value;
        return this;
    }

    /**
     * Gets the value of the connectionMonitoringCapabilitiesResponse property.
     * 
     * @return
     *     possible object is
     *     {@link ConnectionMonitoringCapabilitiesResponse }
     *     
     */
    public ConnectionMonitoringCapabilitiesResponse getConnectionMonitoringCapabilitiesResponse() {
        return connectionMonitoringCapabilitiesResponse;
    }

    /**
     * Sets the value of the connectionMonitoringCapabilitiesResponse property.
     * 
     * @param value
     *     allowed object is
     *     {@link ConnectionMonitoringCapabilitiesResponse }
     *     
     */
    public CapabilitiesResponse setConnectionMonitoringCapabilitiesResponse(ConnectionMonitoringCapabilitiesResponse value) {
        this.connectionMonitoringCapabilitiesResponse = value;
        return this;
    }

    /**
     * Gets the value of the generalMessageCapabilitiesResponse property.
     * 
     * @return
     *     possible object is
     *     {@link GeneralMessageCapabilitiesResponse }
     *     
     */
    public GeneralMessageCapabilitiesResponse getGeneralMessageCapabilitiesResponse() {
        return generalMessageCapabilitiesResponse;
    }

    /**
     * Sets the value of the generalMessageCapabilitiesResponse property.
     * 
     * @param value
     *     allowed object is
     *     {@link GeneralMessageCapabilitiesResponse }
     *     
     */
    public CapabilitiesResponse setGeneralMessageCapabilitiesResponse(GeneralMessageCapabilitiesResponse value) {
        this.generalMessageCapabilitiesResponse = value;
        return this;
    }

    /**
     * Gets the value of the facilityMonitoringCapabilitiesResponse property.
     * 
     * @return
     *     possible object is
     *     {@link FacilityMonitoringCapabilitiesResponse }
     *     
     */
    public FacilityMonitoringCapabilitiesResponse getFacilityMonitoringCapabilitiesResponse() {
        return facilityMonitoringCapabilitiesResponse;
    }

    /**
     * Sets the value of the facilityMonitoringCapabilitiesResponse property.
     * 
     * @param value
     *     allowed object is
     *     {@link FacilityMonitoringCapabilitiesResponse }
     *     
     */
    public CapabilitiesResponse setFacilityMonitoringCapabilitiesResponse(FacilityMonitoringCapabilitiesResponse value) {
        this.facilityMonitoringCapabilitiesResponse = value;
        return this;
    }

    /**
     * Gets the value of the situationExchangeServiceCapabilities property.
     * 
     * @return
     *     possible object is
     *     {@link SituationExchangeServiceCapabilities }
     *     
     */
    public SituationExchangeServiceCapabilities getSituationExchangeServiceCapabilities() {
        return situationExchangeServiceCapabilities;
    }

    /**
     * Sets the value of the situationExchangeServiceCapabilities property.
     * 
     * @param value
     *     allowed object is
     *     {@link SituationExchangeServiceCapabilities }
     *     
     */
    public CapabilitiesResponse setSituationExchangeServiceCapabilities(SituationExchangeServiceCapabilities value) {
        this.situationExchangeServiceCapabilities = value;
        return this;
    }

}
