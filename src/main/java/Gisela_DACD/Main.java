package Gisela_DACD;

import Gisela_DACD.Infrastructure.SQLite.SQLiteConnector;
import Gisela_DACD.P1Controller.*;
import Gisela_DACD.P1Model.*;
import io.github.cdimascio.dotenv.Dotenv;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Timer;

public class Main {
    public static void main(String[] args) throws SQLException {
        Dotenv dotenv = Dotenv.configure().load();
        String apiKey = dotenv.get("OPEN_WEATHER_APIKEY");
        ArrayList<Island> islands = IslandProvider.initializeIslands();

        WeatherController dataFetcher = new WeatherController(apiKey);
        WeatherRepository dataSaver = new WeatherRepositorySQLite(new SQLiteConnector());

        Timer timer = new Timer();
        WeatherPeriodicTask updaterTask = new WeatherPeriodicTask(dataFetcher, dataSaver, islands);
        timer.schedule(updaterTask, 0, 6 * 60 * 60 * 1000);
    }
}