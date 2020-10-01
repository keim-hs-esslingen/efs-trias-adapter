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

import de.vdv.trias.BookingInfoRequest;
import de.vdv.trias.ConnectionDemandDeleteRequest;
import de.vdv.trias.ConnectionDemandRequest;
import de.vdv.trias.ConnectionReportRequest;
import de.vdv.trias.ConnectionStatusRequest;
import de.vdv.trias.FacilityRequest;
import de.vdv.trias.FacilityStatusReport;
import de.vdv.trias.FaresRequest;
import de.vdv.trias.GeoCoordinatesRequest;
import de.vdv.trias.ImageCoordinatesRequest;
import de.vdv.trias.IndividualRouteRequest;
import de.vdv.trias.LocationInformationRequest;
import de.vdv.trias.MapServiceRequest;
import de.vdv.trias.PersonalisationRequest;
import de.vdv.trias.PositioningRequest;
import de.vdv.trias.RefineRequest;
import de.vdv.trias.RequestPayload;
import de.vdv.trias.ServiceRegisterRequest;
import de.vdv.trias.ServiceRequest;
import de.vdv.trias.StopEventRequest;
import de.vdv.trias.Trias;
import de.vdv.trias.TripInfoRequest;
import de.vdv.trias.TripRequest;
import de.vdv.trias.VehicleDataRequest;
import de.vdv.trias.VehicleInteractionRequest;
import java.time.ZonedDateTime;
import uk.org.siri.siri.ParticipantRef;

/**
 * This class adds some convenience methods used on Trias service requests.
 *
 * @author keim
 */
public class TriasServiceRequest extends Trias {

    public TriasServiceRequest(String triasVersion, String apiUserReference) {
        this.version = triasVersion;
        this.serviceRequest = new ServiceRequest();

        serviceRequest.setRequestPayload(new RequestPayload());

        //set current TimeStamp
        serviceRequest.setRequestTimestamp(ZonedDateTime.now());

        // the API Maintainer want to know who is requesting
        serviceRequest.setRequestorRef(new ParticipantRef());
        serviceRequest.getRequestorRef().setValue(apiUserReference);
    }

    public RequestPayload getRequestPayload() {
        return this.serviceRequest.getRequestPayload();
    }

    public TriasServiceRequest bookingInfoRequest(BookingInfoRequest value) {
        getRequestPayload().setBookingInfoRequest(value);
        return this;
    }

    public TriasServiceRequest connectionDemandRequest(ConnectionDemandRequest value) {
        getRequestPayload().setConnectionDemandRequest(value);
        return this;
    }

    public TriasServiceRequest connectionDemandDeleteRequest(ConnectionDemandDeleteRequest value) {
        getRequestPayload().setConnectionDemandDeleteRequest(value);
        return this;
    }

    public TriasServiceRequest connectionReportRequest(ConnectionReportRequest value) {
        getRequestPayload().setConnectionReportRequest(value);
        return this;
    }

    public TriasServiceRequest connectionStatusRequest(ConnectionStatusRequest value) {
        getRequestPayload().setConnectionStatusRequest(value);
        return this;
    }

    public TriasServiceRequest facilityRequest(FacilityRequest value) {
        getRequestPayload().setFacilityRequest(value);
        return this;
    }

    public TriasServiceRequest facilityStatusReport(FacilityStatusReport value) {
        getRequestPayload().setFacilityStatusReport(value);
        return this;
    }

    public TriasServiceRequest faresRequest(FaresRequest value) {
        getRequestPayload().setFaresRequest(value);
        return this;
    }

    public TriasServiceRequest geoCoordinatesRequest(GeoCoordinatesRequest value) {
        getRequestPayload().setGeoCoordinatesRequest(value);
        return this;
    }

    public TriasServiceRequest imageCoordinatesRequest(ImageCoordinatesRequest value) {
        getRequestPayload().setImageCoordinatesRequest(value);
        return this;
    }

    public TriasServiceRequest individualRouteRequest(IndividualRouteRequest value) {
        getRequestPayload().setIndividualRouteRequest(value);
        return this;
    }

    public TriasServiceRequest locationInformationRequest(LocationInformationRequest value) {
        getRequestPayload().setLocationInformationRequest(value);
        return this;
    }

    public TriasServiceRequest mapServiceRequest(MapServiceRequest value) {
        getRequestPayload().setMapServiceRequest(value);
        return this;
    }

    public TriasServiceRequest personalisationRequest(PersonalisationRequest value) {
        getRequestPayload().setPersonalisationRequest(value);
        return this;
    }

    public TriasServiceRequest positioningRequest(PositioningRequest value) {
        getRequestPayload().setPositioningRequest(value);
        return this;
    }

    public TriasServiceRequest refineRequest(RefineRequest value) {
        getRequestPayload().setRefineRequest(value);
        return this;
    }

    public TriasServiceRequest serviceRegisterRequest(ServiceRegisterRequest value) {
        getRequestPayload().setServiceRegisterRequest(value);
        return this;
    }

    public TriasServiceRequest stopEventRequest(StopEventRequest value) {
        getRequestPayload().setStopEventRequest(value);
        return this;
    }

    public TriasServiceRequest tripInfoRequest(TripInfoRequest value) {
        getRequestPayload().setTripInfoRequest(value);
        return this;
    }

    public TriasServiceRequest tripRequest(TripRequest value) {
        getRequestPayload().setTripRequest(value);
        return this;
    }

    public TriasServiceRequest vehicleDataRequest(VehicleDataRequest value) {
        getRequestPayload().setVehicleDataRequest(value);
        return this;
    }

    public TriasServiceRequest vehicleInteractionRequest(VehicleInteractionRequest value) {
        getRequestPayload().setVehicleInteractionRequest(value);
        return this;
    }

}
