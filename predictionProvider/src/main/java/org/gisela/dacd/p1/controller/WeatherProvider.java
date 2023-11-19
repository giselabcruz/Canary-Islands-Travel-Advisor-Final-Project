package org.gisela.dacd.p1.controller;

import org.gisela.dacd.p1.model.Location;
import org.gisela.dacd.p1.model.Weather;
import java.util.List;

public interface WeatherProvider {
    List<Weather> getWeatherData(Location location);
}
