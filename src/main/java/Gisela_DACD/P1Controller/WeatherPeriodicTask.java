package Gisela_DACD.P1Controller;

import Gisela_DACD.P1Model.Location;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.TimerTask;

public class WeatherPeriodicTask extends TimerTask {
    private final WeatherController weatherController;
    private String url;

    private WeatherOpenWeatherApiQuery weatherOpenWeatherApiQuery;

    private ArrayList<Location> locations;


    public WeatherPeriodicTask(WeatherController weatherController, String url, WeatherOpenWeatherApiQuery weatherOpenWeatherApiQuery, ArrayList<Location> locations) {
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