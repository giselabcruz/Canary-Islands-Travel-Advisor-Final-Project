package org.gisela.dacd.provider.controller;

import org.gisela.dacd.provider.model.Location;
import org.gisela.dacd.provider.model.Weather;
import org.gisela.dacd.provider.model.WeatherRepository;
import org.gisela.dacd.provider.model.events.WeatherEvent;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
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
                WeatherEvent event = new WeatherEvent(new Date().toInstant(), "prediction-provider", weather.getTs(),
                        weather.getLocation(), weather.getHumidity(), weather.getTemperature(), weather.getPrecipitation(),
                        weather.getClouds(), weather.getWindSpeed());
            }
        }
    }
}
