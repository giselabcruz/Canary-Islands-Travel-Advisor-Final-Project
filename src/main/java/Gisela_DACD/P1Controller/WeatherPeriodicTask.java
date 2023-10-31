package Gisela_DACD.P1Controller;

import Gisela_DACD.P1Model.Island;
import Gisela_DACD.P1Model.Weather;

import java.util.ArrayList;
import java.util.TimerTask;

public class WeatherPeriodicTask extends TimerTask {
    private WeatherController dataFetcher;
    private WeatherRepository dataSaver;
    private ArrayList<Island> islands;

    public WeatherPeriodicTask(WeatherController dataFetcher, WeatherRepository dataSaver, ArrayList<Island> islands) {
        this.dataFetcher = dataFetcher;
        this.dataSaver = dataSaver;
        this.islands = islands;
    }

    @Override
    public void run() {
        for (Island island : islands) {
            Weather weather = dataFetcher.getWeatherData(island);
            dataSaver.saveWeatherData(island, weather);
        }
    }
}