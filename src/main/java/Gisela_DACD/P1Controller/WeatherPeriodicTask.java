package Gisela_DACD.P1Controller;

import Gisela_DACD.P1Model.Island;
import Gisela_DACD.P1Model.Weather;

import java.util.ArrayList;
import java.util.TimerTask;

public class WeatherPeriodicTask extends TimerTask {
    private WeatherController weatherController;
    private WeatherRepository weatherRepository;
    private ArrayList<Island> islands;

    public WeatherPeriodicTask(WeatherController weatherController, WeatherRepository weatherRepository, ArrayList<Island> islands) {
        this.weatherController = weatherController;
        this.weatherRepository = weatherRepository;
        this.islands = islands;
    }

    @Override
    public void run() {
        for (Island island : islands) {
            Weather weather = weatherController.getWeatherData(island);
            weatherRepository.saveWeatherData(island, weather);
        }
    }
}