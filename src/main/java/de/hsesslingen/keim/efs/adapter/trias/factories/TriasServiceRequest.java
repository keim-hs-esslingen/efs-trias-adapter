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
package de.hsesslingen.keim.efs.adapter.trias.factories;

import de.vdv.trias.BookingInfoRequestStructure;
import de.vdv.trias.ConnectionDemandDeleteRequestStructure;
import de.vdv.trias.ConnectionDemandRequestStructure;
import de.vdv.trias.ConnectionReportRequestStructure;
import de.vdv.trias.ConnectionStatusRequestStructure;
import de.vdv.trias.FacilityRequestStructure;
import de.vdv.trias.FacilityStatusReportStructure;
import de.vdv.trias.FaresRequestStructure;
import de.vdv.trias.GeoCoordinatesRequestStructure;
import de.vdv.trias.ImageCoordinatesRequestStructure;
import de.vdv.trias.IndividualRouteRequestStructure;
import de.vdv.trias.LocationInformationRequestStructure;
import de.vdv.trias.MapServiceRequestStructure;
import de.vdv.trias.PersonalisationRequestStructure;
import de.vdv.trias.PositioningRequestStructure;
import de.vdv.trias.RefineRequestStructure;
import de.vdv.trias.RequestPayloadStructure;
import de.vdv.trias.ServiceRegisterRequestStructure;
import de.vdv.trias.ServiceRequestStructure;
import de.vdv.trias.StopEventRequestStructure;
import de.vdv.trias.Trias;
import de.vdv.trias.TripInfoRequestStructure;
import de.vdv.trias.TripRequestStructure;
import de.vdv.trias.VehicleDataRequestStructure;
import de.vdv.trias.VehicleInteractionRequestStructure;
import java.time.ZonedDateTime;
import uk.org.siri.siri.ParticipantRefStructure;

/**
 * This class adds some convenience methods used on Trias service requests.
 *
 * @author keim
 */
public class TriasServiceRequest extends Trias {

    public TriasServiceRequest(String triasVersion, String apiUserReference) {
        this.version = triasVersion;
        this.serviceRequest = new ServiceRequestStructure();

        serviceRequest.setRequestPayload(new RequestPayloadStructure());

        //set current TimeStamp
        serviceRequest.setRequestTimestamp(ZonedDateTime.now());

        // the API Maintainer want to know who is requesting
        serviceRequest.setRequestorRef(new ParticipantRefStructure());
        serviceRequest.getRequestorRef().setValue(apiUserReference);
    }

    public RequestPayloadStructure getRequestPayload() {
        return this.serviceRequest.getRequestPayload();
    }

    public TriasServiceRequest bookingInfoRequest(BookingInfoRequestStructure value) {
        getRequestPayload().setBookingInfoRequest(value);
        return this;
    }

    public TriasServiceRequest connectionDemandRequest(ConnectionDemandRequestStructure value) {
        getRequestPayload().setConnectionDemandRequest(value);
        return this;
    }

    public TriasServiceRequest connectionDemandDeleteRequest(ConnectionDemandDeleteRequestStructure value) {
        getRequestPayload().setConnectionDemandDeleteRequest(value);
        return this;
    }

    public TriasServiceRequest connectionReportRequest(ConnectionReportRequestStructure value) {
        getRequestPayload().setConnectionReportRequest(value);
        return this;
    }

    public TriasServiceRequest connectionStatusRequest(ConnectionStatusRequestStructure value) {
        getRequestPayload().setConnectionStatusRequest(value);
        return this;
    }

    public TriasServiceRequest facilityRequest(FacilityRequestStructure value) {
        getRequestPayload().setFacilityRequest(value);
        return this;
    }

    public TriasServiceRequest facilityStatusReport(FacilityStatusReportStructure value) {
        getRequestPayload().setFacilityStatusReport(value);
        return this;
    }

    public TriasServiceRequest faresRequest(FaresRequestStructure value) {
        getRequestPayload().setFaresRequest(value);
        return this;
    }

    public TriasServiceRequest geoCoordinatesRequest(GeoCoordinatesRequestStructure value) {
        getRequestPayload().setGeoCoordinatesRequest(value);
        return this;
    }

    public TriasServiceRequest imageCoordinatesRequest(ImageCoordinatesRequestStructure value) {
        getRequestPayload().setImageCoordinatesRequest(value);
        return this;
    }

    public TriasServiceRequest individualRouteRequest(IndividualRouteRequestStructure value) {
        getRequestPayload().setIndividualRouteRequest(value);
        return this;
    }

    public TriasServiceRequest locationInformationRequest(LocationInformationRequestStructure value) {
        getRequestPayload().setLocationInformationRequest(value);
        return this;
    }

    public TriasServiceRequest mapServiceRequest(MapServiceRequestStructure value) {
        getRequestPayload().setMapServiceRequest(value);
        return this;
    }

    public TriasServiceRequest personalisationRequest(PersonalisationRequestStructure value) {
        getRequestPayload().setPersonalisationRequest(value);
        return this;
    }

    public TriasServiceRequest positioningRequest(PositioningRequestStructure value) {
        getRequestPayload().setPositioningRequest(value);
        return this;
    }

    public TriasServiceRequest refineRequest(RefineRequestStructure value) {
        getRequestPayload().setRefineRequest(value);
        return this;
    }

    public TriasServiceRequest serviceRegisterRequest(ServiceRegisterRequestStructure value) {
        getRequestPayload().setServiceRegisterRequest(value);
        return this;
    }

    public TriasServiceRequest stopEventRequest(StopEventRequestStructure value) {
        getRequestPayload().setStopEventRequest(value);
        return this;
    }

    public TriasServiceRequest tripInfoRequest(TripInfoRequestStructure value) {
        getRequestPayload().setTripInfoRequest(value);
        return this;
    }

    public TriasServiceRequest tripRequest(TripRequestStructure value) {
        getRequestPayload().setTripRequest(value);
        return this;
    }

    public TriasServiceRequest vehicleDataRequest(VehicleDataRequestStructure value) {
        getRequestPayload().setVehicleDataRequest(value);
        return this;
    }

    public TriasServiceRequest vehicleInteractionRequest(VehicleInteractionRequestStructure value) {
        getRequestPayload().setVehicleInteractionRequest(value);
        return this;
    }

}
