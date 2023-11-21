package org.gisela.dacd.provider.controller;

import org.gisela.dacd.provider.model.Location;
import org.gisela.dacd.provider.model.Weather;
import java.util.List;

public interface WeatherProvider {
    List<Weather> getWeatherData(Location location);
}
