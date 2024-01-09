package org.gisela.dacd.predictionprovider.application;

import org.gisela.dacd.predictionprovider.domain.Location;
import org.gisela.dacd.predictionprovider.domain.Weather;
import org.gisela.dacd.predictionprovider.infrastructure.OpenWeatherProvider;
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
                Weather event = new Weather(instant, "prediction-provider", weather.getHumidity(), weather.getTemperature(),
                        weather.getPrecipitation(), weather.getClouds(), weather.getWindSpeed(), weather.getLocation(), weather.getPredictionTime());
                publisher.publish(event);
            }
        }
    }
}
