package org.gisela.dacd.publisher;

import org.gisela.dacd.publisher.controller.*;
import org.gisela.dacd.publisher.model.Location;
import io.github.cdimascio.dotenv.Dotenv;
import java.util.ArrayList;
import java.util.Timer;

public class Main {
    public static void main(String[] args) {
        Dotenv dotenv = Dotenv.configure().load();
        String apiKey = dotenv.get("OPEN_WEATHER_APIKEY");
        ArrayList<Location> locations = LocationSupplier.initializeIslands();
        OpenWeatherProvider weatherOpenWeatherApiQuery = new OpenWeatherProvider(apiKey);
        SQLiteConnector connector = new SQLiteConnector();
        DatabaseInitializer.createWeatherTable(connector.getConnection(),locations);
        connector.closeConnection();
        Timer timer = new Timer();
        WeatherPeriodicTask updaterTask = new WeatherPeriodicTask(weatherOpenWeatherApiQuery, locations);
        timer.scheduleAtFixedRate(updaterTask, 0, 6 * 60 * 60 * 1000);
    }
}
