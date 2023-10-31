package Gisela_DACD.P1Controller;

import Gisela_DACD.P1Model.Location;
import Gisela_DACD.P1Model.Weather;

import java.util.ArrayList;
import java.util.TimerTask;

public class WeatherPeriodicTask extends TimerTask {
    private WeatherController weatherController;
    private WeatherRepository weatherRepository;
    private ArrayList<Location> locations;

    public WeatherPeriodicTask(WeatherController weatherController, WeatherRepository weatherRepository, ArrayList<Location> locations) {
        this.weatherController = weatherController;
        this.weatherRepository = weatherRepository;
        this.locations = locations;
    }

    @Override
    public void run() {
        for (Location location : locations) {
            Weather weather = weatherController.getWeatherData(location);
            weatherRepository.saveWeatherData(location, weather);
        }
    }
}