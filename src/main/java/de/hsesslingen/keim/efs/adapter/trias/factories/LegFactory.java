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

import static de.hsesslingen.keim.efs.adapter.trias.Utils.extract;
import static de.hsesslingen.keim.efs.adapter.trias.Utils.firstOf;
import static de.hsesslingen.keim.efs.adapter.trias.Utils.ifPresent;
import de.hsesslingen.keim.efs.middleware.model.Asset;
import de.hsesslingen.keim.efs.middleware.model.Coordinates;
import de.hsesslingen.keim.efs.middleware.model.ICoordinates;
import de.hsesslingen.keim.efs.middleware.model.Leg;
import static de.hsesslingen.keim.efs.middleware.utils.StringUtils.joinNonEmpty;
import static de.hsesslingen.keim.efs.mobility.exception.HttpException.internalServerError;
import de.hsesslingen.keim.efs.mobility.service.Mode;
import static de.hsesslingen.keim.efs.mobility.service.Mode.LEG_SWITCH;
import de.vdv.trias.ContinuousLeg;
import de.vdv.trias.GeoPosition;
import de.vdv.trias.InterchangeLeg;
import de.vdv.trias.LegTrack;
import de.vdv.trias.NavigationPath;
import de.vdv.trias.StopPointRef;
import de.vdv.trias.TimedLeg;
import de.vdv.trias.TrackSection;
import de.vdv.trias.TripLeg;
import java.util.ArrayList;
import java.util.concurrent.CompletableFuture;
import static java.util.concurrent.CompletableFuture.supplyAsync;
import java.util.concurrent.ExecutionException;
import java.util.function.Function;
import java.util.function.Supplier;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;
import java.util.stream.Stream;
import static org.apache.commons.lang3.ObjectUtils.isEmpty;
import static org.apache.commons.lang3.ObjectUtils.isNotEmpty;
import static org.apache.commons.lang3.StringUtils.isNotBlank;

/**
 *
 * @author ben
 */
public class LegFactory {

    private static void enrichLegWithTrackInformation(Leg leg, Stream<TrackSection> sectionsStream) {
        if (leg == null || isEmpty(sectionsStream)) {
            return;
        }

        var geoPath = new ArrayList<ICoordinates>();

        // triplength is calculated by summing up all TrackSection lengths.
        var totalTrackLength = sectionsStream
                // Filter null values, even though there should be any....
                .filter(s -> s.getLength() != null)
                // Copy all geo positions of this section to a single collection...
                .peek(s -> geoPath.addAll(s.getProjection().getPosition()))
                // Convert to length value for summing...
                .mapToInt(s -> s.getLength().intValue())
                .sum();

        // Set distance and geoPath in leg...
        leg.setDistanceMeter(totalTrackLength);

        if (isNotEmpty(geoPath)) {
            leg.setGeoPath(
                    geoPath.stream()
                            .map(Coordinates::copy)
                            .collect(toList())
            );
        }
    }

    private static void enrichLegWithTrackInformation(Leg leg, LegTrack track) {
        if (track == null) {
            return;
        }

        enrichLegWithTrackInformation(leg, track.getTrackSection().stream());
    }

    private static void enrichLegWithTrackInformation(Leg leg, NavigationPath path) {
        if (path == null || isEmpty(path.getNavigationSection())) {
            return;
        }

        // Prepare track sections stream...
        var trackSectionsStream = path.getNavigationSection().stream()
                .map(nsec -> nsec.getTrackSection())
                .filter(tsec -> tsec != null);

        enrichLegWithTrackInformation(leg, trackSectionsStream);
    }

    /**
     * Converts a {@link InterchangeLeg} to a {@link Leg}.
     *
     * @param interLeg
     * @param serviceId
     * @return
     */
    public static Leg from(InterchangeLeg interLeg, String serviceId) {
        var leg = new Leg();

        leg.setStartTime(interLeg.getTimeWindowStart());
        leg.setFrom(PlaceFactory.from(interLeg.getLegStart(), serviceId));
        leg.setEndTime(interLeg.getTimeWindowEnd());
        leg.setTo(PlaceFactory.from(interLeg.getLegEnd(), serviceId));

        // triplength
        ifPresent(interLeg.getLength(), length -> {
            leg.setDistanceMeter(length.intValue());
        });

        // Set mode to LEG_SWITCH for interchange legs.
        leg.setMode(LEG_SWITCH);

        // Add track information from interLeg to leg.
        enrichLegWithTrackInformation(leg, interLeg.getNavigationPath());

        return leg;
    }

    /**
     * Converts a {@link ContinuousLeg} to a {@link Leg}.A ContinuousLeg means a
     * leg that is not bound to a timetable like walking, bicycle- or carride,
     * ...
     *
     * @param contiLeg
     * @param serviceId
     * @param defaultImageUrl A default URL for asset images.
     * @return
     */
    public static Leg from(ContinuousLeg contiLeg, String serviceId, String defaultImageUrl) {
        var leg = new Leg();

        // origin Time
        leg.setStartTime(contiLeg.getTimeWindowStart());
        leg.setFrom(PlaceFactory.from(contiLeg.getLegStart(), serviceId));
        leg.setEndTime(contiLeg.getTimeWindowEnd());
        leg.setTo(PlaceFactory.from(contiLeg.getLegEnd(), serviceId));

        // triplength
        ifPresent(contiLeg.getLength(), length -> {
            leg.setDistanceMeter(length.intValue());
        });

        Mode mode = ModeConverter.from(contiLeg);
        leg.setMode(mode);

        // Add track information from contiLeg to leg.
        enrichLegWithTrackInformation(leg, contiLeg.getLegTrack());

        if (mode != Mode.WALK) {
            var asset = new Asset()
                    .setServiceId(serviceId)
                    .setImageUrl(defaultImageUrl)
                    .setMode(mode);

            var service = contiLeg.getService();

            ifPresent(service.getJourneyRef(), ref -> {
                asset.setId(ref.getValue());
            });

            var section = firstOf(service.getServiceSection());

            if (section != null) {
                var lineName = extract(section.getPublishedLineName(), null);
                var dstTxt = extract(service.getDestinationText(), null);

                asset.setName(joinNonEmpty(" ", lineName, dstTxt));
            }

            leg.setAsset(asset);
            leg.setAssetId(asset.getId());
        }

        return leg;
    }

    /**
     * Converts a {@link TimedLeg} to a {@link Leg}.A TimedLeg means a leg with
     * timetabled schedule like Bus, Tram, Train,...
     * <p>
     * This function will asynchronously fetch geo position data using
     * {@link geoPositionGetter}. Method for async kickoff is
     * {@link CompletableFuture#supplyAsync(Supplier)}.
     *
     * @param timedLeg
     * @param serviceId
     * @param geoPositionGetter A function that allows retrieval of GeoPosition
     * information for a given StopPointRef, as a TimedLeg does not contain this
     * information elsewhere.
     * @param defaultImageUrl A default URL for asset images.
     * @return
     */
    public static Leg from(
            TimedLeg timedLeg,
            String serviceId,
            Function<StopPointRef, GeoPosition> geoPositionGetter,
            String defaultImageUrl
    ) {
        var leg = new Leg();
        var asset = new Asset()
                .setServiceId(serviceId)
                .setImageUrl(defaultImageUrl);

        // ### PLACE INFO ###
        // Kick of async retrieval of place creation, which involves a call to the TRIAS api for geo coordinates.
        var placeFromFuture = supplyAsync(() -> PlaceFactory.from(timedLeg.getLegBoard(), geoPositionGetter, serviceId));
        var placeToFuture = supplyAsync(() -> PlaceFactory.from(timedLeg.getLegAlight(), geoPositionGetter, serviceId));

        // ### TIME INFO ###
        leg.setStartTime(timedLeg.getLegBoard().getServiceDeparture().getTimetabledTime());
        leg.setEndTime(timedLeg.getLegAlight().getServiceArrival().getTimetabledTime());

        var service = timedLeg.getService(); // Service is not-null according to docs.

        asset.setId(service.getJourneyRef().getValue()); // JourneyRef is not-null according to docs.

        firstOf(service.getServiceSection(), section -> {
            var lineName = extract(section.getPublishedLineName());
            var dstTxt = extract(service.getDestinationText());
            asset.setName(joinNonEmpty(" ", lineName, dstTxt));
        });

        if (isNotEmpty(service.getAttribute())) {
            var description = service.getAttribute().stream()
                    .map(attr -> extract(attr.getText()))
                    .collect(joining("</p><p>"));

            if (isNotBlank(description)) {
                description = "<p>" + description + "</p>";
            }

            asset.setDescription(description);
        }

        Mode mode = ModeConverter.from(timedLeg);
        asset.setMode(mode);
        leg.setMode(mode);

        // Add track information from timedLeg to leg.
        enrichLegWithTrackInformation(leg, timedLeg.getLegTrack());

        // ### REST OF PLACE INFO ###
        try {
            // Wait for the asynchronous creation of place data to finish and then insert the gained information...
            leg.setFrom(placeFromFuture.get().setServiceId(serviceId));
            leg.setTo(placeToFuture.get().setServiceId(serviceId));
        } catch (InterruptedException | ExecutionException ex) {
            throw internalServerError(ex, "Unable to retrieve geo location for start or end point or both.");
        }

        leg.setAsset(asset);
        leg.setAssetId(asset.getId());

        return leg;
    }

    /**
     * Converts a {@link TripLeg} to a {@link Leg}.
     *
     * @param tripLeg
     * @param serviceId
     * @param geoPositionGetter A function that allows retrieval of GeoPosition
     * information for a given StopPointRef. This is needed if {@link tripLeg}
     * contains a {@link TimedLeg} which does not contain a GeoPosition for its
     * leg ends.
     * @param defaultImageUrl A default URL for asset images.
     * @return
     */
    public static Leg from(TripLeg tripLeg, String serviceId, Function<StopPointRef, GeoPosition> geoPositionGetter, String defaultImageUrl) {
        if (tripLeg.getContinuousLeg() != null) {
            return LegFactory.from(tripLeg.getContinuousLeg(), serviceId, defaultImageUrl);
        }

        if (tripLeg.getTimedLeg() != null) {
            return LegFactory.from(tripLeg.getTimedLeg(), serviceId, geoPositionGetter, defaultImageUrl);
        }

        if (tripLeg.getInterchangeLeg() != null) {
            return LegFactory.from(tripLeg.getInterchangeLeg(), serviceId);
        }

        return null;
    }
}
