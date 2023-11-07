package Gisela_DACD.P1;

import Gisela_DACD.P1.controller.*;
import Gisela_DACD.P1.model.Location;
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
        connector.createOrUpdateTable();
        WeatherRepository weatherRepository = new WeatherRepositorySQLite(connector.getConnection());
        //TODO: get connection can't be here. Improve encapsulating WeatherRepositorySQLite.

        WeatherController weatherController = new WeatherController(weatherOpenWeatherApiQuery, weatherRepository, locations);

        Timer timer = new Timer();
        WeatherPeriodicTask updaterTask = new WeatherPeriodicTask(weatherController, "jdbc:sqlite:canary_islands_weather.db", weatherOpenWeatherApiQuery, locations);
        timer.schedule(updaterTask, 0, 6 * 60 * 60 * 1000);
        //TODO: Implement timer.scheduleAtFixedRate to maintain a consistent time interval between task executions.
        // It attempts to ensure that the task is executed at the specified rate, even if previous executions took longer.
        connector.closeConnection();


        //TODO: Delete spaces in all code.
        // Change packages to lower case.(Gisela_dacd.p1).

        //TODO: change var environment to args.
    }
}