package org.gisela.dacd.provider.controller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.gisela.dacd.provider.model.Location;
import org.gisela.dacd.provider.model.Weather;
import org.gisela.dacd.provider.model.events.WeatherEvent;
import javax.jms.JMSException;
import java.sql.SQLException;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public class WeatherController {
    private final OpenWeatherProvider openWeatherProvider;
    private final ArrayList<Location> locations;

    public WeatherController(OpenWeatherProvider openWeatherProvider, ArrayList<Location> locations) {
        this.openWeatherProvider = openWeatherProvider;
        this.locations = locations;
    }

    public void execute() throws SQLException, JMSException {
        List<Weather> allWeatherLocations = new ArrayList<>();
        for (Location location : locations) {
            List<Weather> weatherList = openWeatherProvider.getWeatherData(location);
            allWeatherLocations.addAll(weatherList);
        }
        Instant instant = Instant.now();
        WeatherEvent weatherEvent = new WeatherEvent(instant, "prediction-provider", allWeatherLocations);
        Gson gson = new GsonBuilder()
                .registerTypeAdapter(Instant.class, new InstantTypeAdapter())
                .create();
        Publisher publish = new Publisher();
        publish.publish(gson.toJson(weatherEvent));
    }
}
