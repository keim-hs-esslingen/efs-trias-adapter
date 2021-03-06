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
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * Highway maintenance, installation and construction activities that may potentially affect traffic operations.
 * 
 * <p>Java class for Roadworks complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Roadworks">
 *   &lt;complexContent>
 *     &lt;extension base="{http://datex2.eu/schema/1_0/1_0}OperatorAction">
 *       &lt;sequence>
 *         &lt;element name="effectOnRoadLayout" type="{http://datex2.eu/schema/1_0/1_0}EffectOnRoadLayoutEnum" maxOccurs="unbounded"/>
 *         &lt;element name="roadworksDuration" type="{http://datex2.eu/schema/1_0/1_0}RoadworksDurationEnum" minOccurs="0"/>
 *         &lt;element name="roadworksScale" type="{http://datex2.eu/schema/1_0/1_0}RoadworksScaleEnum" minOccurs="0"/>
 *         &lt;element name="underTraffic" type="{http://datex2.eu/schema/1_0/1_0}Boolean" minOccurs="0"/>
 *         &lt;element name="urgentRoadworks" type="{http://datex2.eu/schema/1_0/1_0}Boolean" minOccurs="0"/>
 *         &lt;element name="mobility" type="{http://datex2.eu/schema/1_0/1_0}Mobility" minOccurs="0"/>
 *         &lt;element name="subjectTypeOfWorks" type="{http://datex2.eu/schema/1_0/1_0}SubjectTypeOfWorks" minOccurs="0"/>
 *         &lt;element name="associatedMaintenanceVehicles" type="{http://datex2.eu/schema/1_0/1_0}AssociatedMaintenanceVehicles" minOccurs="0"/>
 *         &lt;element name="roadworksExtension" type="{http://datex2.eu/schema/1_0/1_0}ExtensionType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Roadworks", namespace = "http://datex2.eu/schema/1_0/1_0", propOrder = {
    "effectOnRoadLayout",
    "roadworksDuration",
    "roadworksScale",
    "underTraffic",
    "urgentRoadworks",
    "mobility",
    "subjectTypeOfWorks",
    "associatedMaintenanceVehicles",
    "roadworksExtension"
})
@XmlSeeAlso({
    MaintenanceWorks.class,
    ConstructionWorks.class
})
public abstract class Roadworks
    extends OperatorAction
{

    @XmlElement(namespace = "http://datex2.eu/schema/1_0/1_0", required = true)
    @XmlSchemaType(name = "string")
    protected List<EffectOnRoadLayoutEnum> effectOnRoadLayout;
    @XmlElement(namespace = "http://datex2.eu/schema/1_0/1_0")
    @XmlSchemaType(name = "string")
    protected RoadworksDurationEnum roadworksDuration;
    @XmlElement(namespace = "http://datex2.eu/schema/1_0/1_0")
    @XmlSchemaType(name = "string")
    protected RoadworksScaleEnum roadworksScale;
    @XmlElement(namespace = "http://datex2.eu/schema/1_0/1_0")
    protected Boolean underTraffic;
    @XmlElement(namespace = "http://datex2.eu/schema/1_0/1_0")
    protected Boolean urgentRoadworks;
    @XmlElement(namespace = "http://datex2.eu/schema/1_0/1_0")
    protected Mobility mobility;
    @XmlElement(namespace = "http://datex2.eu/schema/1_0/1_0")
    protected SubjectTypeOfWorks subjectTypeOfWorks;
    @XmlElement(namespace = "http://datex2.eu/schema/1_0/1_0")
    protected AssociatedMaintenanceVehicles associatedMaintenanceVehicles;
    @XmlElement(namespace = "http://datex2.eu/schema/1_0/1_0")
    protected ExtensionType roadworksExtension;

    /**
     * Gets the value of the effectOnRoadLayout property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the effectOnRoadLayout property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getEffectOnRoadLayout().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link EffectOnRoadLayoutEnum }
     * 
     * 
     */
    public List<EffectOnRoadLayoutEnum> getEffectOnRoadLayout() {
        if (effectOnRoadLayout == null) {
            effectOnRoadLayout = new ArrayList<EffectOnRoadLayoutEnum>();
        }
        return this.effectOnRoadLayout;
    }

    /**
     * Gets the value of the roadworksDuration property.
     * 
     * @return
     *     possible object is
     *     {@link RoadworksDurationEnum }
     *     
     */
    public RoadworksDurationEnum getRoadworksDuration() {
        return roadworksDuration;
    }

    /**
     * Sets the value of the roadworksDuration property.
     * 
     * @param value
     *     allowed object is
     *     {@link RoadworksDurationEnum }
     *     
     */
    public Roadworks setRoadworksDuration(RoadworksDurationEnum value) {
        this.roadworksDuration = value;
        return this;
    }

    /**
     * Gets the value of the roadworksScale property.
     * 
     * @return
     *     possible object is
     *     {@link RoadworksScaleEnum }
     *     
     */
    public RoadworksScaleEnum getRoadworksScale() {
        return roadworksScale;
    }

    /**
     * Sets the value of the roadworksScale property.
     * 
     * @param value
     *     allowed object is
     *     {@link RoadworksScaleEnum }
     *     
     */
    public Roadworks setRoadworksScale(RoadworksScaleEnum value) {
        this.roadworksScale = value;
        return this;
    }

    /**
     * Gets the value of the underTraffic property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isUnderTraffic() {
        return underTraffic;
    }

    /**
     * Sets the value of the underTraffic property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public Roadworks setUnderTraffic(Boolean value) {
        this.underTraffic = value;
        return this;
    }

    /**
     * Gets the value of the urgentRoadworks property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isUrgentRoadworks() {
        return urgentRoadworks;
    }

    /**
     * Sets the value of the urgentRoadworks property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public Roadworks setUrgentRoadworks(Boolean value) {
        this.urgentRoadworks = value;
        return this;
    }

    /**
     * Gets the value of the mobility property.
     * 
     * @return
     *     possible object is
     *     {@link Mobility }
     *     
     */
    public Mobility getMobility() {
        return mobility;
    }

    /**
     * Sets the value of the mobility property.
     * 
     * @param value
     *     allowed object is
     *     {@link Mobility }
     *     
     */
    public Roadworks setMobility(Mobility value) {
        this.mobility = value;
        return this;
    }

    /**
     * Gets the value of the subjectTypeOfWorks property.
     * 
     * @return
     *     possible object is
     *     {@link SubjectTypeOfWorks }
     *     
     */
    public SubjectTypeOfWorks getSubjectTypeOfWorks() {
        return subjectTypeOfWorks;
    }

    /**
     * Sets the value of the subjectTypeOfWorks property.
     * 
     * @param value
     *     allowed object is
     *     {@link SubjectTypeOfWorks }
     *     
     */
    public Roadworks setSubjectTypeOfWorks(SubjectTypeOfWorks value) {
        this.subjectTypeOfWorks = value;
        return this;
    }

    /**
     * Gets the value of the associatedMaintenanceVehicles property.
     * 
     * @return
     *     possible object is
     *     {@link AssociatedMaintenanceVehicles }
     *     
     */
    public AssociatedMaintenanceVehicles getAssociatedMaintenanceVehicles() {
        return associatedMaintenanceVehicles;
    }

    /**
     * Sets the value of the associatedMaintenanceVehicles property.
     * 
     * @param value
     *     allowed object is
     *     {@link AssociatedMaintenanceVehicles }
     *     
     */
    public Roadworks setAssociatedMaintenanceVehicles(AssociatedMaintenanceVehicles value) {
        this.associatedMaintenanceVehicles = value;
        return this;
    }

    /**
     * Gets the value of the roadworksExtension property.
     * 
     * @return
     *     possible object is
     *     {@link ExtensionType }
     *     
     */
    public ExtensionType getRoadworksExtension() {
        return roadworksExtension;
    }

    /**
     * Sets the value of the roadworksExtension property.
     * 
     * @param value
     *     allowed object is
     *     {@link ExtensionType }
     *     
     */
    public Roadworks setRoadworksExtension(ExtensionType value) {
        this.roadworksExtension = value;
        return this;
    }

}
