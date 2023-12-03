package org.gisela.dacd.provider.application;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.gisela.dacd.provider.domain.Location;
import org.gisela.dacd.provider.domain.Weather;
import org.gisela.dacd.provider.domain.events.WeatherEvent;
import org.gisela.dacd.provider.infrastructure.OpenWeatherProvider;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public class WeatherApplication {
    private final OpenWeatherProvider openWeatherProvider;
    private final ArrayList<Location> locations;
    private final Publisher publisher;

    public WeatherApplication(OpenWeatherProvider openWeatherProvider, ArrayList<Location> locations, Publisher publisher) {
        this.openWeatherProvider = openWeatherProvider;
        this.locations = locations;
        this.publisher = publisher;
    }

    public void execute() {
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
        publisher.publish(gson.toJson(weatherEvent),"prediction.Weather");
    }
}
