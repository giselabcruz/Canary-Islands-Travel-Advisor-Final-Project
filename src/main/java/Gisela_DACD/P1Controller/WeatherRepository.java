package Gisela_DACD.P1Controller;

import Gisela_DACD.P1Model.Location;
import Gisela_DACD.P1Model.Weather;

public interface WeatherRepository {
    void saveWeatherData(Location location, Weather weather);

}
