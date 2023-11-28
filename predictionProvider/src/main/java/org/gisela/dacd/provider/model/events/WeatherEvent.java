package org.gisela.dacd.provider.model.events;

import org.gisela.dacd.provider.model.Location;
import java.time.Instant;

public class WeatherEvent {
    private Instant ts;
    private String ss;
    private Instant predictionTime;
    private Location location;
    private double humidity;
    private double temperature;
    private double precipitation;
    private double clouds;
    private double windSpeed;

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

    public void setTs(Instant ts) {
        this.ts = ts;
    }

    public String getSs() {
        return ss;
    }

    public void setSs(String ss) {
        this.ss = ss;
    }

    public Instant getPredictionTime() {
        return predictionTime;
    }

    public void setPredictionTime(Instant predictionTime) {
        this.predictionTime = predictionTime;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public double getHumidity() {
        return humidity;
    }

    public void setHumidity(double humidity) {
        this.humidity = humidity;
    }

    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    public double getPrecipitation() {
        return precipitation;
    }

    public void setPrecipitation(double precipitation) {
        this.precipitation = precipitation;
    }

    public double getClouds() {
        return clouds;
    }

    public void setClouds(double clouds) {
        this.clouds = clouds;
    }

    public double getWindSpeed() {
        return windSpeed;
    }

    public void setWindSpeed(double windSpeed) {
        this.windSpeed = windSpeed;
    }
}
