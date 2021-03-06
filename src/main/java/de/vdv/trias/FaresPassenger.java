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
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * Structure of a passenger profile for fares calculation.
 * 
 * <p>Java class for FaresPassenger complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="FaresPassengerStructure">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;choice>
 *           &lt;element name="Age" type="{http://www.w3.org/2001/XMLSchema}nonNegativeInteger"/>
 *           &lt;element name="PassengerCategory" type="{http://www.vdv.de/trias}PassengerCategoryEnumeration"/>
 *         &lt;/choice>
 *         &lt;element name="TravellerCard" type="{http://www.vdv.de/trias}TravellerCardRefStructure" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;choice minOccurs="0">
 *           &lt;element name="ZonesAlreadyPaid" type="{http://www.vdv.de/trias}FareZoneRefListStructure"/>
 *           &lt;element name="OwnedTicket" type="{http://www.vdv.de/trias}TicketRefStructure" maxOccurs="unbounded"/>
 *         &lt;/choice>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "FaresPassengerStructure", namespace = "http://www.vdv.de/trias", propOrder = {
    "age",
    "passengerCategory",
    "travellerCard",
    "zonesAlreadyPaid",
    "ownedTicket"
})
@ToString
public class FaresPassenger {

    @XmlElement(name = "Age", namespace = "http://www.vdv.de/trias")
    @XmlSchemaType(name = "nonNegativeInteger")
    protected BigInteger age;
    @XmlElement(name = "PassengerCategory", namespace = "http://www.vdv.de/trias")
    @XmlSchemaType(name = "string")
    protected PassengerCategoryEnumeration passengerCategory;
    @XmlElement(name = "TravellerCard", namespace = "http://www.vdv.de/trias")
    protected List<TravellerCardRef> travellerCard;
    @XmlElement(name = "ZonesAlreadyPaid", namespace = "http://www.vdv.de/trias")
    protected FareZoneRefList zonesAlreadyPaid;
    @XmlElement(name = "OwnedTicket", namespace = "http://www.vdv.de/trias")
    protected List<TicketRef> ownedTicket;

    /**
     * Gets the value of the age property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getAge() {
        return age;
    }

    /**
     * Sets the value of the age property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public FaresPassenger setAge(BigInteger value) {
        this.age = value;
        return this;
    }

    /**
     * Gets the value of the passengerCategory property.
     * 
     * @return
     *     possible object is
     *     {@link PassengerCategoryEnumeration }
     *     
     */
    public PassengerCategoryEnumeration getPassengerCategory() {
        return passengerCategory;
    }

    /**
     * Sets the value of the passengerCategory property.
     * 
     * @param value
     *     allowed object is
     *     {@link PassengerCategoryEnumeration }
     *     
     */
    public FaresPassenger setPassengerCategory(PassengerCategoryEnumeration value) {
        this.passengerCategory = value;
        return this;
    }

    /**
     * Gets the value of the travellerCard property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the travellerCard property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getTravellerCard().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TravellerCardRef }
     * 
     * 
     */
    public List<TravellerCardRef> getTravellerCard() {
        if (travellerCard == null) {
            travellerCard = new ArrayList<TravellerCardRef>();
        }
        return this.travellerCard;
    }

    /**
     * Gets the value of the zonesAlreadyPaid property.
     * 
     * @return
     *     possible object is
     *     {@link FareZoneRefList }
     *     
     */
    public FareZoneRefList getZonesAlreadyPaid() {
        return zonesAlreadyPaid;
    }

    /**
     * Sets the value of the zonesAlreadyPaid property.
     * 
     * @param value
     *     allowed object is
     *     {@link FareZoneRefList }
     *     
     */
    public FaresPassenger setZonesAlreadyPaid(FareZoneRefList value) {
        this.zonesAlreadyPaid = value;
        return this;
    }

    /**
     * Gets the value of the ownedTicket property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the ownedTicket property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getOwnedTicket().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TicketRef }
     * 
     * 
     */
    public List<TicketRef> getOwnedTicket() {
        if (ownedTicket == null) {
            ownedTicket = new ArrayList<TicketRef>();
        }
        return this.ownedTicket;
    }

}
