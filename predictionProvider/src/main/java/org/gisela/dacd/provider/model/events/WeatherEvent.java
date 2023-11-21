package org.gisela.dacd.provider.model.events;

import org.gisela.dacd.provider.model.Location;
import java.time.Instant;

public class WeatherEvent {
    private final Instant ts;
    private final String ss;
    private final Instant predictionTime;
    private final Location location;
    private final double humidity;
    private final double temperature;
    private final double precipitation;
    private final double clouds;
    private final double windSpeed;

    public WeatherEvent(Instant ts, String ss, Instant predictionTime, Location location,
                        double humidity, double temperature, double precipitation, double clouds, double windSpeed) {
        this.ts = ts;
        this.ss = ss;
        this.predictionTime = predictionTime;
        this.location = location;
        this.humidity = humidity;
        this.temperature = temperature;
        this.precipitation = precipitation;
        this.clouds = clouds;
        this.windSpeed = windSpeed;
    }

    public Instant getTs() {
        return ts;
    }

    public String getSs() {
        return ss;
    }

    public Instant getPredictionTime() {
        return predictionTime;
    }

    public Location getLocation() {
        return location;
    }

    public double getHumidity() {
        return humidity;
    }

    public double getTemperature() {
        return temperature;
    }

    public double getPrecipitation() {
        return precipitation;
    }

    public double getClouds() {
        return clouds;
    }

    public double getWindSpeed() {
        return windSpeed;
    }
}
