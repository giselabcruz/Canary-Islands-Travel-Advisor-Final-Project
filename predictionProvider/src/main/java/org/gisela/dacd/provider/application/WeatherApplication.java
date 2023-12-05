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
        for (Location location : locations) {
            List<Weather> weatherList = openWeatherProvider.getWeatherData(location);
            Instant instant = Instant.now();
            for (Weather weather : weatherList) {
                WeatherEvent event = new WeatherEvent(instant, "prediction-provider", weather.getPredictionTime(),
                        weather.getLocation(), weather.getHumidity(), weather.getTemperature(), weather.getPrecipitation(),
                        weather.getClouds(), weather.getWindSpeed());
                Gson gson = new GsonBuilder()
                        .registerTypeAdapter(Instant.class, new InstantTypeAdapter())
                        .create();
                publisher.publish(gson.toJson(event), "prediction.Weather");
                // TODO: reducir acoplamiento para la interfaz de la String(que se encargue el Publisher)
            }
        }
    }
}
