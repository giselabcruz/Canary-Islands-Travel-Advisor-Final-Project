package Gisela_DACD.P1.controller;

import Gisela_DACD.P1.model.Location;
import Gisela_DACD.P1.model.Weather;

import java.util.List;

public interface WeatherProvider {
    List<Weather> getWeatherData(Location location);
}
