package Gisela_DACD;

import Gisela_DACD.P1Model.*;
import io.github.cdimascio.dotenv.Dotenv;

import java.util.ArrayList;
import java.util.Timer;

public class Main {
    public static void main(String[] args) {
        Dotenv dotenv = Dotenv.configure().load();
        String apiKey = dotenv.get("OPEN_WEATHER_APIKEY");
        ArrayList<Island> islands = IslandProvider.initializeIslands();

        WeatherDataFetcher dataFetcher = new WeatherDataFetcher(apiKey);
        WeatherDataRepository dataSaver = new WeatherDataSaverInSQLite();

        Timer timer = new Timer();
        WeatherUpdaterTask updaterTask = new WeatherUpdaterTask(dataFetcher, dataSaver, islands);
        timer.schedule(updaterTask, 0, 300_000); //5 minutes in milliseconds
        //timer.schedule(updaterTask, 0, 6 * 60 * 60 * 1000);
    }
}