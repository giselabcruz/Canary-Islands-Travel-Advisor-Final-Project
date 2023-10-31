package Gisela_DACD.P1Controller;

import Gisela_DACD.P1Model.Location;
import Gisela_DACD.P1Model.Weather;

import java.util.ArrayList;

public class WeatherController {
    private final WeatherOpenWeatherApiQuery weatherOpenWeatherApiQuery;
    private final WeatherRepository weatherRepository;
    private final ArrayList<Location> locations;

    public WeatherController(WeatherOpenWeatherApiQuery weatherOpenWeatherApiQuery, WeatherRepository weatherRepository, ArrayList<Location> locations) {
        this.weatherOpenWeatherApiQuery = weatherOpenWeatherApiQuery;
        this.weatherRepository = weatherRepository;
        this.locations = locations;
    }

    public void execute(){
        for (Location location : locations) {
            Weather weather = weatherOpenWeatherApiQuery.getWeatherData(location);
            weatherRepository.saveWeatherData(location, weather);
        }
    }
}
