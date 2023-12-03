package org.gisela.dacd.provider.model.events;

import org.gisela.dacd.provider.model.Weather;

import java.time.Instant;
import java.util.List;

public class WeatherEvent {
    private Instant ts;
    private String ss;
    private final List<Weather> predictionWeather;


    public WeatherEvent(Instant ts, String ss, List<Weather> predictionWeather) {
        this.ts = ts;
        this.ss = ss;
        this.predictionWeather = predictionWeather;
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

    public List<Weather> getPredictionWeather() {
        return predictionWeather;
    }
}
