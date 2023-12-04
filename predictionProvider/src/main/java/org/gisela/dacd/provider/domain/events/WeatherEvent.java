package org.gisela.dacd.provider.domain.events;

import org.gisela.dacd.provider.domain.Location;

import java.time.Instant;

public record WeatherEvent(Instant ts, String ss, Instant predictionTime, Location location, double humidity,
                           double temperature, double precipitation, double clouds, double windSpeed) {
}
