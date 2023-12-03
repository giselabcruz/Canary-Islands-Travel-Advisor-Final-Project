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
        for (Location location : locations) {
            List<Weather> weatherlist = openWeatherProvider.getWeatherData(location);
            for (Weather weather : weatherlist) {
                Instant instant = Instant.now();
                WeatherEvent event = new WeatherEvent(instant, "prediction-provider", weather.getTs(),
                        weather.getLocation(), weather.getHumidity(), weather.getTemperature(), weather.getPrecipitation(),
                        weather.getClouds(), weather.getWindSpeed());
                Publisher publish = new Publisher();
                Gson gson = new GsonBuilder()
                        .registerTypeAdapter(Instant.class, new InstantTypeAdapter())
                        .create();
                publish.publish(gson.toJson(event));
            }
        }
    }
}
