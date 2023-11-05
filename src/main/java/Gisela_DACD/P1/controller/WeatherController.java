package Gisela_DACD.P1.controller;

import Gisela_DACD.P1.model.Location;
import Gisela_DACD.P1.model.Weather;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class WeatherController {
    private final WeatherOpenWeatherProvider weatherOpenWeatherApiQuery;
    private final WeatherRepository weatherRepository;
    private final ArrayList<Location> locations;

    public WeatherController(WeatherOpenWeatherProvider weatherOpenWeatherApiQuery, WeatherRepository weatherRepository, ArrayList<Location> locations) {
        this.weatherOpenWeatherApiQuery = weatherOpenWeatherApiQuery;
        this.weatherRepository = weatherRepository;
        this.locations = locations;
    }

    public void execute() throws SQLException {
        for (Location location : locations) {
            List<Weather> weatherlist = weatherOpenWeatherApiQuery.getWeatherData(location);
            for (Weather weatherDTO : weatherlist) {
                weatherRepository.saveWeatherData(location, weatherDTO);
            }
        }
    }
}
