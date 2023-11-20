package org.gisela.dacd.publisher.model;

public interface WeatherRepository {
    void saveWeatherData(Location location, Weather weather);
}
