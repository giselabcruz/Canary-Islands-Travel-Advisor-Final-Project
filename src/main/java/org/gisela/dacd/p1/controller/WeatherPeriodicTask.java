package org.gisela.dacd.p1.controller;

import org.gisela.dacd.p1.model.Location;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.TimerTask;

public class WeatherPeriodicTask extends TimerTask {
    private OpenWeatherProvider weatherProvider;
    private ArrayList<Location> locations;

    public WeatherPeriodicTask(OpenWeatherProvider weatherProvider, ArrayList<Location> locations) {
        this.weatherProvider = weatherProvider;
        this.locations = locations;
    }

    @Override
    public void run() {
        try {
            SQLiteConnector sqLiteConnector = new SQLiteConnector();
            WeatherRepository weatherRepository = new WeatherRepositorySQLite(sqLiteConnector.getConnection());
            WeatherController weatherController = new WeatherController(weatherProvider, weatherRepository, locations);
            weatherController.execute();
            sqLiteConnector.closeConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}