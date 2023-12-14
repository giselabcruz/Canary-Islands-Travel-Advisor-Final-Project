package org.gisela.dacd.predictionprovider.application;

import org.gisela.dacd.predictionprovider.domain.Location;
import org.gisela.dacd.predictionprovider.infrastructure.OpenWeatherProvider;
import org.gisela.dacd.predictionprovider.infrastructure.PublisherActiveMQ;
import java.util.ArrayList;
import java.util.TimerTask;

public class WeatherPeriodicTask extends TimerTask {
    private final OpenWeatherProvider weatherProvider;
    private final ArrayList<Location> locations;

    public WeatherPeriodicTask(OpenWeatherProvider weatherProvider, ArrayList<Location> locations) {
        this.weatherProvider = weatherProvider;
        this.locations = locations;
    }

    @Override
    public void run() {
        PublisherActiveMQ publisherActiveMQ = new PublisherActiveMQ();
        publisherActiveMQ.start();
        WeatherApplication weatherApplication = new WeatherApplication(weatherProvider, locations, publisherActiveMQ);
        weatherApplication.execute();
        publisherActiveMQ.close();
    }
}
