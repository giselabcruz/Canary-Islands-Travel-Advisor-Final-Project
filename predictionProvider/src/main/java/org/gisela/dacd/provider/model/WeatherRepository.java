package org.gisela.dacd.provider.model;

public interface WeatherRepository {
    void saveWeatherData(Location location, Weather weather);
}
