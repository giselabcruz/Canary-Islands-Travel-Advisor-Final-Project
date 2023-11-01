package Gisela_DACD.P1Controller;

import Gisela_DACD.P1Model.Location;
import Gisela_DACD.P1Model.WeatherList;

public interface WeatherQuery {
    WeatherList getWeatherData(Location location);

}
