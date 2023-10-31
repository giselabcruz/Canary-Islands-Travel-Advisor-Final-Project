package Gisela_DACD.P1Controller;

import Gisela_DACD.P1Model.Island;
import Gisela_DACD.P1Model.Weather;

public interface WeatherRepository {
    void saveWeatherData(Island island, Weather weather);

}
