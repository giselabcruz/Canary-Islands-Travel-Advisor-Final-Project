package Gisela_DACD.P1;

import Gisela_DACD.P1.controller.*;
import Gisela_DACD.P1.model.Location;
import io.github.cdimascio.dotenv.Dotenv;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Timer;

public class Main {
    public static void main(String[] args) throws SQLException {
        Dotenv dotenv = Dotenv.configure().load();
        String apiKey = dotenv.get("OPEN_WEATHER_APIKEY");
        ArrayList<Location> locations = LocationSupplier.initializeIslands();

        OpenWeatherProvider weatherOpenWeatherApiQuery = new OpenWeatherProvider(apiKey);
        SQLiteConnector connector = new SQLiteConnector();
        connector.createOrUpdateTable();
        WeatherRepository weatherRepository = new WeatherRepositorySQLite(connector.getConnection());

        WeatherController weatherController = new WeatherController(weatherOpenWeatherApiQuery, weatherRepository, locations);

        Timer timer = new Timer();
        WeatherPeriodicTask updaterTask = new WeatherPeriodicTask(weatherController, "jdbc:sqlite:canary_islands_weather.db", weatherOpenWeatherApiQuery, locations);
        timer.schedule(updaterTask, 0, 6 * 60 * 60 * 1000);

        connector.closeConnection();
    }
}