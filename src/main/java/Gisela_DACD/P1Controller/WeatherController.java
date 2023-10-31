package Gisela_DACD.P1Controller;

import Gisela_DACD.P1Model.Location;
import Gisela_DACD.P1Model.Weather;

import java.util.ArrayList;

public class WeatherController {
    private final WeatherQuery weatherQuery;
    private final WeatherRepository weatherRepository;
    private final ArrayList<Location> locations;

    public WeatherController(WeatherQuery weatherQuery, WeatherRepository weatherRepository, ArrayList<Location> locations) {
        this.weatherQuery = weatherQuery;
        this.weatherRepository = weatherRepository;
        this.locations = locations;
    }

    public void execute(){
        for (Location location : locations) {
            Weather weather = weatherQuery.getWeatherData(location);
            weatherRepository.saveWeatherData(location, weather);
        }
    }
}
