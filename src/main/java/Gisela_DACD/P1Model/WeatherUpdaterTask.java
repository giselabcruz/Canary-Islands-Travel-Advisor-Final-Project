package Gisela_DACD.P1Model;

import java.util.ArrayList;
import java.util.TimerTask;

public class WeatherUpdaterTask extends TimerTask {
    private WeatherDataFetcher dataFetcher;
    private WeatherDataRepository dataSaver;
    private ArrayList<Island> islands;

    public WeatherUpdaterTask(WeatherDataFetcher dataFetcher, WeatherDataRepository dataSaver, ArrayList<Island> islands) {
        this.dataFetcher = dataFetcher;
        this.dataSaver = dataSaver;
        this.islands = islands;
    }

    @Override
    public void run() {
        for (Island island : islands) {
            WeatherDTO weatherDTO = dataFetcher.getWeatherData(island);
            dataSaver.saveWeatherData(island, weatherDTO);
        }
    }
}