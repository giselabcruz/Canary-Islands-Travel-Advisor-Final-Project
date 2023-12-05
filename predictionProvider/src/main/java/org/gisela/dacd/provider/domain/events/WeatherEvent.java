package org.gisela.dacd.provider.domain.events;

import org.gisela.dacd.provider.domain.Location;

import java.time.Instant;

// TODO: change to Weather class. Only in one. Suena raro tener dos clases que tienen esquemas muy similares.

public record WeatherEvent(Instant ts, String ss, Instant predictionTime, Location location, double humidity,
                           double temperature, double precipitation, double clouds, double windSpeed) {
}
