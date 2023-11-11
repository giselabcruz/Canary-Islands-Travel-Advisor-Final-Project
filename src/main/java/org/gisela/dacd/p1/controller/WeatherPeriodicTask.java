package org.gisela.dacd.p1.controller;

import org.gisela.dacd.p1.model.Location;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.TimerTask;

public class WeatherPeriodicTask extends TimerTask {
    private final WeatherController weatherController;
    private String url;
    private OpenWeatherProvider weatherProvider;
    private ArrayList<Location> locations;

    public WeatherPeriodicTask(WeatherController weatherController, String url, OpenWeatherProvider weatherProvider, ArrayList<Location> locations) {
        this.weatherController = weatherController;
        this.url = url;
        this.weatherProvider = weatherProvider;
        this.locations = locations;
    }

    @Override
    public void run() {
        try {
            Connection connection = DriverManager.getConnection(url);
            WeatherRepository weatherRepository = new WeatherRepositorySQLite(connection);
            WeatherController weatherController = new WeatherController(weatherProvider, weatherRepository, locations);
            weatherController.execute();
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}