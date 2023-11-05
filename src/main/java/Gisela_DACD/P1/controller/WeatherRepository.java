package Gisela_DACD.P1.controller;

import Gisela_DACD.P1.model.Location;
import Gisela_DACD.P1.model.Weather;

import java.sql.SQLException;

public interface WeatherRepository {
    void saveWeatherData(Location location, Weather weatherDTO) throws SQLException;

}
