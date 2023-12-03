package org.gisela.dacd.provider.controller;

import org.gisela.dacd.provider.model.Location;
import javax.jms.JMSException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.TimerTask;

public class WeatherPeriodicTask extends TimerTask {
    private final OpenWeatherProvider weatherProvider;
    private final ArrayList<Location> locations;

    public WeatherPeriodicTask(OpenWeatherProvider weatherProvider, ArrayList<Location> locations) {
        this.weatherProvider = weatherProvider;
        this.locations = locations;
    }

    @Override
    public void run() {
        try {
            WeatherController weatherController = new WeatherController(weatherProvider, locations);
            weatherController.execute();
        } catch (SQLException | JMSException e) {
            throw new RuntimeException(e);
        }
    }
}
