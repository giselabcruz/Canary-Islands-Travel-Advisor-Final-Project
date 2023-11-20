package org.gisela.dacd.publisher.controller;

import org.gisela.dacd.publisher.model.Location;
import org.gisela.dacd.publisher.model.Weather;
import java.util.List;

public interface WeatherProvider {
    List<Weather> getWeatherData(Location location);
}
