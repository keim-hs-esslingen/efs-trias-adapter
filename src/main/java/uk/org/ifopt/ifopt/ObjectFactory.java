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


package uk.org.ifopt.ifopt;

import lombok.ToString;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the uk.org.ifopt.ifopt package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
@ToString
public class ObjectFactory {

    private final static QName _PointProjection_QNAME = new QName("http://www.ifopt.org.uk/ifopt", "PointProjection");
    private final static QName _PathJunctionRef_QNAME = new QName("http://www.ifopt.org.uk/ifopt", "PathJunctionRef");
    private final static QName _AccessLinkRef_QNAME = new QName("http://www.ifopt.org.uk/ifopt", "AccessLinkRef");
    private final static QName _NavigationPathRef_QNAME = new QName("http://www.ifopt.org.uk/ifopt", "NavigationPathRef");
    private final static QName _OtherPlaceEquipment_QNAME = new QName("http://www.ifopt.org.uk/ifopt", "OtherPlaceEquipment");
    private final static QName _ZoneProjection_QNAME = new QName("http://www.ifopt.org.uk/ifopt", "ZoneProjection");
    private final static QName _InfoLink_QNAME = new QName("http://www.ifopt.org.uk/ifopt", "InfoLink");
    private final static QName _LocalService_QNAME = new QName("http://www.ifopt.org.uk/ifopt", "LocalService");
    private final static QName _LinkProjection_QNAME = new QName("http://www.ifopt.org.uk/ifopt", "LinkProjection");
    private final static QName _StopPlaceRef_QNAME = new QName("http://www.ifopt.org.uk/ifopt", "StopPlaceRef");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: uk.org.ifopt.ifopt
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link ValidityCondition }
     * 
     */
    public ValidityCondition createValidityConditionStructure() {
        return new ValidityCondition();
    }

    /**
     * Create an instance of {@link AbstractProjection }
     * 
     */
    public AbstractProjection createAbstractProjection() {
        return new AbstractProjection();
    }

    /**
     * Create an instance of {@link LinkProjection }
     * 
     */
    public LinkProjection createLinkProjectionStructure() {
        return new LinkProjection();
    }

    /**
     * Create an instance of {@link LocalService }
     * 
     */
    public LocalService createLocalServiceStructure() {
        return new LocalService();
    }

    /**
     * Create an instance of {@link ZoneProjection }
     * 
     */
    public ZoneProjection createZoneProjectionStructure() {
        return new ZoneProjection();
    }

    /**
     * Create an instance of {@link PathJunctionRef }
     * 
     */
    public PathJunctionRef createPathJunctionRefStructure() {
        return new PathJunctionRef();
    }

    /**
     * Create an instance of {@link StopPlaceRef }
     * 
     */
    public StopPlaceRef createStopPlaceRefStructure() {
        return new StopPlaceRef();
    }

    /**
     * Create an instance of {@link AccessLinkRef }
     * 
     */
    public AccessLinkRef createAccessLinkRefStructure() {
        return new AccessLinkRef();
    }

    /**
     * Create an instance of {@link NavigationPathRef }
     * 
     */
    public NavigationPathRef createNavigationPathRefStructure() {
        return new NavigationPathRef();
    }

    /**
     * Create an instance of {@link InfoLink }
     * 
     */
    public InfoLink createInfoLinkStructure() {
        return new InfoLink();
    }

    /**
     * Create an instance of {@link PointProjection }
     * 
     */
    public PointProjection createPointProjectionStructure() {
        return new PointProjection();
    }

    /**
     * Create an instance of {@link PlaceEquipment }
     * 
     */
    public PlaceEquipment createPlaceEquipmentStructure() {
        return new PlaceEquipment();
    }

    /**
     * Create an instance of {@link Extensions }
     * 
     */
    public Extensions createExtensions() {
        return new Extensions();
    }

    /**
     * Create an instance of {@link StopPlaceSpaceRef }
     * 
     */
    public StopPlaceSpaceRef createStopPlaceSpaceRefStructure() {
        return new StopPlaceSpaceRef();
    }

    /**
     * Create an instance of {@link StopPlaceComponentRef }
     * 
     */
    public StopPlaceComponentRef createStopPlaceComponentRefStructure() {
        return new StopPlaceComponentRef();
    }

    /**
     * Create an instance of {@link Timeband }
     * 
     */
    public Timeband createTimebandStructure() {
        return new Timeband();
    }

    /**
     * Create an instance of {@link Alias }
     * 
     */
    public Alias createAliasStructure() {
        return new Alias();
    }

    /**
     * Create an instance of {@link CountryRef }
     * 
     */
    public CountryRef createCountryRefStructure() {
        return new CountryRef();
    }

    /**
     * Create an instance of {@link RegionRef }
     * 
     */
    public RegionRef createRegionRefStructure() {
        return new RegionRef();
    }

    /**
     * Create an instance of {@link FeatureIdRef }
     * 
     */
    public FeatureIdRef createFeatureIdRefStructure() {
        return new FeatureIdRef();
    }

    /**
     * Create an instance of {@link VehicleStoppingPositionRef }
     * 
     */
    public VehicleStoppingPositionRef createVehicleStoppingPositionRefStructure() {
        return new VehicleStoppingPositionRef();
    }

    /**
     * Create an instance of {@link AuthorityRef }
     * 
     */
    public AuthorityRef createAuthorityRefStructure() {
        return new AuthorityRef();
    }

    /**
     * Create an instance of {@link StopPathLinkRef }
     * 
     */
    public StopPathLinkRef createStopPathLinkRefStructure() {
        return new StopPathLinkRef();
    }

    /**
     * Create an instance of {@link AdministrativeAreaRef }
     * 
     */
    public AdministrativeAreaRef createAdministrativeAreaRefStructure() {
        return new AdministrativeAreaRef();
    }

    /**
     * Create an instance of {@link InfoLinks }
     * 
     */
    public InfoLinks createInfoLinksStructure() {
        return new InfoLinks();
    }

    /**
     * Create an instance of {@link AdministratorVersionedRef }
     * 
     */
    public AdministratorVersionedRef createAdministratorVersionedRefStructure() {
        return new AdministratorVersionedRef();
    }

    /**
     * Create an instance of {@link CheckPoint }
     * 
     */
    public CheckPoint createCheckPointStructure() {
        return new CheckPoint();
    }

    /**
     * Create an instance of {@link HalfOpenTimeRange }
     * 
     */
    public HalfOpenTimeRange createHalfOpenTimeRangeStructure() {
        return new HalfOpenTimeRange();
    }

    /**
     * Create an instance of {@link QuayRef }
     * 
     */
    public QuayRef createQuayRefStructure() {
        return new QuayRef();
    }

    /**
     * Create an instance of {@link AccessSpaceRef }
     * 
     */
    public AccessSpaceRef createAccessSpaceRefStructure() {
        return new AccessSpaceRef();
    }

    /**
     * Create an instance of {@link StopPlaceRefs }
     * 
     */
    public StopPlaceRefs createStopPlaceRefsStructure() {
        return new StopPlaceRefs();
    }

    /**
     * Create an instance of {@link CheckPointRef }
     * 
     */
    public CheckPointRef createCheckPointRefStructure() {
        return new CheckPointRef();
    }

    /**
     * Create an instance of {@link AdministratorRef }
     * 
     */
    public AdministratorRef createAdministratorRefStructure() {
        return new AdministratorRef();
    }

    /**
     * Create an instance of {@link NamespaceTypeRef }
     * 
     */
    public NamespaceTypeRef createNamespaceTypeRefStructure() {
        return new NamespaceTypeRef();
    }

    /**
     * Create an instance of {@link EquipmentTypeRef }
     * 
     */
    public EquipmentTypeRef createEquipmentTypeRefStructure() {
        return new EquipmentTypeRef();
    }

    /**
     * Create an instance of {@link AccessPathLinkRef }
     * 
     */
    public AccessPathLinkRef createAccessPathLinkRefStructure() {
        return new AccessPathLinkRef();
    }

    /**
     * Create an instance of {@link EquipmentRef }
     * 
     */
    public EquipmentRef createEquipmentRefStructure() {
        return new EquipmentRef();
    }

    /**
     * Create an instance of {@link AdministrativeAreaVersionedRef }
     * 
     */
    public AdministrativeAreaVersionedRef createAdministrativeAreaVersionedRefStructure() {
        return new AdministrativeAreaVersionedRef();
    }

    /**
     * Create an instance of {@link FeatureRef }
     * 
     */
    public FeatureRef createFeatureRefStructure() {
        return new FeatureRef();
    }

    /**
     * Create an instance of {@link StopPlaceEntranceRef }
     * 
     */
    public StopPlaceEntranceRef createStopPlaceEntranceRefStructure() {
        return new StopPlaceEntranceRef();
    }

    /**
     * Create an instance of {@link BoardingPositionRef }
     * 
     */
    public BoardingPositionRef createBoardingPositionRefStructure() {
        return new BoardingPositionRef();
    }

    /**
     * Create an instance of {@link ValidityConditions }
     * 
     */
    public ValidityConditions createValidityConditionsStructure() {
        return new ValidityConditions();
    }

    /**
     * Create an instance of {@link VehicleStoppingPlaceRef }
     * 
     */
    public VehicleStoppingPlaceRef createVehicleStoppingPlaceRefStructure() {
        return new VehicleStoppingPlaceRef();
    }

    /**
     * Create an instance of {@link AdministrativeAreaRefs }
     * 
     */
    public AdministrativeAreaRefs createAdministrativeAreaRefsStructure() {
        return new AdministrativeAreaRefs();
    }

    /**
     * Create an instance of {@link LevelRef }
     * 
     */
    public LevelRef createLevelRefStructure() {
        return new LevelRef();
    }

    /**
     * Create an instance of {@link ValidityCondition.Timebands }
     * 
     */
    public ValidityCondition.Timebands createValidityConditionStructureTimebands() {
        return new ValidityCondition.Timebands();
    }

    /**
     * Create an instance of {@link AbstractProjection.Features }
     * 
     */
    public AbstractProjection.Features createAbstractProjectionFeatures() {
        return new AbstractProjection.Features();
    }

    /**
     * Create an instance of {@link LinkProjection.Line }
     * 
     */
    public LinkProjection.Line createLinkProjectionStructureLine() {
        return new LinkProjection.Line();
    }

    /**
     * Create an instance of {@link LocalService.FeatureRefs }
     * 
     */
    public LocalService.FeatureRefs createLocalServiceStructureFeatureRefs() {
        return new LocalService.FeatureRefs();
    }

    /**
     * Create an instance of {@link ZoneProjection.Boundary }
     * 
     */
    public ZoneProjection.Boundary createZoneProjectionStructureBoundary() {
        return new ZoneProjection.Boundary();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PointProjection }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.ifopt.org.uk/ifopt", name = "PointProjection")
    public JAXBElement<PointProjection> createPointProjection(PointProjection value) {
        return new JAXBElement<PointProjection>(_PointProjection_QNAME, PointProjection.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PathJunctionRef }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.ifopt.org.uk/ifopt", name = "PathJunctionRef")
    public JAXBElement<PathJunctionRef> createPathJunctionRef(PathJunctionRef value) {
        return new JAXBElement<PathJunctionRef>(_PathJunctionRef_QNAME, PathJunctionRef.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AccessLinkRef }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.ifopt.org.uk/ifopt", name = "AccessLinkRef")
    public JAXBElement<AccessLinkRef> createAccessLinkRef(AccessLinkRef value) {
        return new JAXBElement<AccessLinkRef>(_AccessLinkRef_QNAME, AccessLinkRef.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link NavigationPathRef }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.ifopt.org.uk/ifopt", name = "NavigationPathRef")
    public JAXBElement<NavigationPathRef> createNavigationPathRef(NavigationPathRef value) {
        return new JAXBElement<NavigationPathRef>(_NavigationPathRef_QNAME, NavigationPathRef.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PlaceEquipment }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.ifopt.org.uk/ifopt", name = "OtherPlaceEquipment")
    public JAXBElement<PlaceEquipment> createOtherPlaceEquipment(PlaceEquipment value) {
        return new JAXBElement<PlaceEquipment>(_OtherPlaceEquipment_QNAME, PlaceEquipment.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ZoneProjection }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.ifopt.org.uk/ifopt", name = "ZoneProjection")
    public JAXBElement<ZoneProjection> createZoneProjection(ZoneProjection value) {
        return new JAXBElement<ZoneProjection>(_ZoneProjection_QNAME, ZoneProjection.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link InfoLink }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.ifopt.org.uk/ifopt", name = "InfoLink")
    public JAXBElement<InfoLink> createInfoLink(InfoLink value) {
        return new JAXBElement<InfoLink>(_InfoLink_QNAME, InfoLink.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LocalService }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.ifopt.org.uk/ifopt", name = "LocalService")
    public JAXBElement<LocalService> createLocalService(LocalService value) {
        return new JAXBElement<LocalService>(_LocalService_QNAME, LocalService.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LinkProjection }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.ifopt.org.uk/ifopt", name = "LinkProjection")
    public JAXBElement<LinkProjection> createLinkProjection(LinkProjection value) {
        return new JAXBElement<LinkProjection>(_LinkProjection_QNAME, LinkProjection.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link StopPlaceRef }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.ifopt.org.uk/ifopt", name = "StopPlaceRef")
    public JAXBElement<StopPlaceRef> createStopPlaceRef(StopPlaceRef value) {
        return new JAXBElement<StopPlaceRef>(_StopPlaceRef_QNAME, StopPlaceRef.class, null, value);
    }

}
