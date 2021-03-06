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


package eu.datex2.schema._1_0._1_0;

import lombok.ToString;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * Accidents are events in which one or more vehicles lose control and do not recover.  They include collisions between vehicle(s) or other road user(s), between vehicle(s) and any obstacle(s), or they result from a vehicle running off the road.
 * 
 * <p>Java class for Accident complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Accident">
 *   &lt;complexContent>
 *     &lt;extension base="{http://datex2.eu/schema/1_0/1_0}TrafficElement">
 *       &lt;sequence>
 *         &lt;element name="accidentCause" type="{http://datex2.eu/schema/1_0/1_0}AccidentCauseEnum" minOccurs="0"/>
 *         &lt;element name="accidentType" type="{http://datex2.eu/schema/1_0/1_0}AccidentTypeEnum" maxOccurs="unbounded"/>
 *         &lt;element name="vehicleInvolved" type="{http://datex2.eu/schema/1_0/1_0}Vehicle" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="overviewOfVehiclesInvolved" type="{http://datex2.eu/schema/1_0/1_0}VehiclesInvolved" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="overviewOfPeopleInvolved" type="{http://datex2.eu/schema/1_0/1_0}PeopleInvolved" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="accidentExtension" type="{http://datex2.eu/schema/1_0/1_0}ExtensionType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Accident", namespace = "http://datex2.eu/schema/1_0/1_0", propOrder = {
    "accidentCause",
    "accidentType",
    "vehicleInvolved",
    "overviewOfVehiclesInvolved",
    "overviewOfPeopleInvolved",
    "accidentExtension"
})
@ToString
public class Accident
    extends TrafficElement
{

    @XmlElement(namespace = "http://datex2.eu/schema/1_0/1_0")
    @XmlSchemaType(name = "string")
    protected AccidentCauseEnum accidentCause;
    @XmlElement(namespace = "http://datex2.eu/schema/1_0/1_0", required = true)
    @XmlSchemaType(name = "string")
    protected List<AccidentTypeEnum> accidentType;
    @XmlElement(namespace = "http://datex2.eu/schema/1_0/1_0")
    protected List<Vehicle> vehicleInvolved;
    @XmlElement(namespace = "http://datex2.eu/schema/1_0/1_0")
    protected List<VehiclesInvolved> overviewOfVehiclesInvolved;
    @XmlElement(namespace = "http://datex2.eu/schema/1_0/1_0")
    protected List<PeopleInvolved> overviewOfPeopleInvolved;
    @XmlElement(namespace = "http://datex2.eu/schema/1_0/1_0")
    protected ExtensionType accidentExtension;

    /**
     * Gets the value of the accidentCause property.
     * 
     * @return
     *     possible object is
     *     {@link AccidentCauseEnum }
     *     
     */
    public AccidentCauseEnum getAccidentCause() {
        return accidentCause;
    }

    /**
     * Sets the value of the accidentCause property.
     * 
     * @param value
     *     allowed object is
     *     {@link AccidentCauseEnum }
     *     
     */
    public Accident setAccidentCause(AccidentCauseEnum value) {
        this.accidentCause = value;
        return this;
    }

    /**
     * Gets the value of the accidentType property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the accidentType property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAccidentType().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link AccidentTypeEnum }
     * 
     * 
     */
    public List<AccidentTypeEnum> getAccidentType() {
        if (accidentType == null) {
            accidentType = new ArrayList<AccidentTypeEnum>();
        }
        return this.accidentType;
    }

    /**
     * Gets the value of the vehicleInvolved property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the vehicleInvolved property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getVehicleInvolved().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Vehicle }
     * 
     * 
     */
    public List<Vehicle> getVehicleInvolved() {
        if (vehicleInvolved == null) {
            vehicleInvolved = new ArrayList<Vehicle>();
        }
        return this.vehicleInvolved;
    }

    /**
     * Gets the value of the overviewOfVehiclesInvolved property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the overviewOfVehiclesInvolved property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getOverviewOfVehiclesInvolved().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link VehiclesInvolved }
     * 
     * 
     */
    public List<VehiclesInvolved> getOverviewOfVehiclesInvolved() {
        if (overviewOfVehiclesInvolved == null) {
            overviewOfVehiclesInvolved = new ArrayList<VehiclesInvolved>();
        }
        return this.overviewOfVehiclesInvolved;
    }

    /**
     * Gets the value of the overviewOfPeopleInvolved property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the overviewOfPeopleInvolved property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getOverviewOfPeopleInvolved().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link PeopleInvolved }
     * 
     * 
     */
    public List<PeopleInvolved> getOverviewOfPeopleInvolved() {
        if (overviewOfPeopleInvolved == null) {
            overviewOfPeopleInvolved = new ArrayList<PeopleInvolved>();
        }
        return this.overviewOfPeopleInvolved;
    }

    /**
     * Gets the value of the accidentExtension property.
     * 
     * @return
     *     possible object is
     *     {@link ExtensionType }
     *     
     */
    public ExtensionType getAccidentExtension() {
        return accidentExtension;
    }

    /**
     * Sets the value of the accidentExtension property.
     * 
     * @param value
     *     allowed object is
     *     {@link ExtensionType }
     *     
     */
    public Accident setAccidentExtension(ExtensionType value) {
        this.accidentExtension = value;
        return this;
    }

}
