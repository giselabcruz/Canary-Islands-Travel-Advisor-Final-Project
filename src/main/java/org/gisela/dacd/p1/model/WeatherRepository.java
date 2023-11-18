package org.gisela.dacd.p1.model;

public interface WeatherRepository {
    void saveWeatherData(Location location, Weather weather);
}
