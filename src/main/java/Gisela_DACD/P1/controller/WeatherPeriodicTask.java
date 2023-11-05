package Gisela_DACD.P1.controller;

import Gisela_DACD.P1.model.Location;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.TimerTask;

public class WeatherPeriodicTask extends TimerTask {
    private final WeatherController weatherController;
    private String url;

    private WeatherOpenWeatherProvider weatherOpenWeatherApiQuery;

    private ArrayList<Location> locations;


    public WeatherPeriodicTask(WeatherController weatherController, String url, WeatherOpenWeatherProvider weatherOpenWeatherApiQuery, ArrayList<Location> locations) {
        this.weatherController = weatherController;
        this.url = url;
        this.weatherOpenWeatherApiQuery = weatherOpenWeatherApiQuery ;
        this.locations = locations;
    }

    @Override
    public void run() {
        try {
            Connection connection = DriverManager.getConnection(url);
            WeatherRepository weatherRepository = new WeatherRepositorySQLite(connection);
            WeatherController weatherController = new WeatherController(weatherOpenWeatherApiQuery, weatherRepository, locations);
            weatherController.execute();
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}