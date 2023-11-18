package org.gisela.dacd.p1.controller;

import org.gisela.dacd.p1.model.Location;
import org.gisela.dacd.p1.model.Weather;
import org.gisela.dacd.p1.model.WeatherRepository;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class WeatherController {
    private final OpenWeatherProvider openWeatherProvider;
    private final WeatherRepository weatherRepository;
    private final ArrayList<Location> locations;

    public WeatherController(OpenWeatherProvider openWeatherProvider, WeatherRepository weatherRepository, ArrayList<Location> locations) {
        this.openWeatherProvider = openWeatherProvider;
        this.weatherRepository = weatherRepository;
        this.locations = locations;
    }

    public void execute() throws SQLException {
        for (Location location : locations) {
            List<Weather> weatherlist = openWeatherProvider.getWeatherData(location);
            for (Weather weather : weatherlist) {
                weatherRepository.saveWeatherData(location, weather);
            }
        }
    }
}
