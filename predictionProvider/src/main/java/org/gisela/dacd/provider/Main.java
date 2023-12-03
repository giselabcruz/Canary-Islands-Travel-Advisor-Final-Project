package org.gisela.dacd.provider;

import org.gisela.dacd.provider.infrastructure.OpenWeatherProvider;
import org.gisela.dacd.provider.service.*;
import org.gisela.dacd.provider.domain.Location;
import java.util.ArrayList;
import java.util.Timer;

public class Main {
    public static void main(String[] args) {
        String apiKey = args[0];
        ArrayList<Location> locations = LocationSupplier.initializeIslands();
        OpenWeatherProvider weatherOpenWeatherApiQuery = new OpenWeatherProvider(apiKey);
        Timer timer = new Timer();
        WeatherPeriodicTask updaterTask = new WeatherPeriodicTask(weatherOpenWeatherApiQuery, locations);
        timer.scheduleAtFixedRate(updaterTask, 0, 6 * 60 * 60 * 1000);
    }
}
