package Gisela_DACD.P1Controller;

import Gisela_DACD.P1Model.Location;
import Gisela_DACD.P1Model.Weather;

public interface WeatherQuery {
    Weather getWeatherData(Location location);

}
