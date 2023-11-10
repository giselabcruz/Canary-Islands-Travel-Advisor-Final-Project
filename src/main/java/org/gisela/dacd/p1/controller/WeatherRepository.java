package org.gisela.dacd.p1.controller;

import org.gisela.dacd.p1.model.Location;
import org.gisela.dacd.p1.model.Weather;


public interface WeatherRepository {
    void saveWeatherData(Location location, Weather weather);
}
