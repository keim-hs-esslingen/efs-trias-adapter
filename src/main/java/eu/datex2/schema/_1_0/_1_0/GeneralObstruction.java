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

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * Any stationary or moving obstacle of a physical nature, other than of an animal, vehicle, environmental, or damaged equipment nature.
 * 
 * <p>Java class for GeneralObstruction complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="GeneralObstruction">
 *   &lt;complexContent>
 *     &lt;extension base="{http://datex2.eu/schema/1_0/1_0}Obstruction">
 *       &lt;sequence>
 *         &lt;element name="obstructionType" type="{http://datex2.eu/schema/1_0/1_0}ObstructionTypeEnum" maxOccurs="unbounded"/>
 *         &lt;element name="generalObstructionExtension" type="{http://datex2.eu/schema/1_0/1_0}ExtensionType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GeneralObstruction", namespace = "http://datex2.eu/schema/1_0/1_0", propOrder = {
    "obstructionType",
    "generalObstructionExtension"
})
public class GeneralObstruction
    extends Obstruction
{

    @XmlElement(namespace = "http://datex2.eu/schema/1_0/1_0", required = true)
    @XmlSchemaType(name = "string")
    protected List<ObstructionTypeEnum> obstructionType;
    @XmlElement(namespace = "http://datex2.eu/schema/1_0/1_0")
    protected ExtensionType generalObstructionExtension;

    /**
     * Gets the value of the obstructionType property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the obstructionType property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getObstructionType().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ObstructionTypeEnum }
     * 
     * 
     */
    public List<ObstructionTypeEnum> getObstructionType() {
        if (obstructionType == null) {
            obstructionType = new ArrayList<ObstructionTypeEnum>();
        }
        return this.obstructionType;
    }

    /**
     * Gets the value of the generalObstructionExtension property.
     * 
     * @return
     *     possible object is
     *     {@link ExtensionType }
     *     
     */
    public ExtensionType getGeneralObstructionExtension() {
        return generalObstructionExtension;
    }

    /**
     * Sets the value of the generalObstructionExtension property.
     * 
     * @param value
     *     allowed object is
     *     {@link ExtensionType }
     *     
     */
    public GeneralObstruction setGeneralObstructionExtension(ExtensionType value) {
        this.generalObstructionExtension = value;
        return this;
    }

}
