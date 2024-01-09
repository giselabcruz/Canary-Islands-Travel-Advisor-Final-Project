package org.gisela.dacd.flightprovider.application;

import org.gisela.dacd.flightprovider.domain.Location;
import org.gisela.dacd.flightprovider.infrastructure.PublisherActiveMQ;
import java.util.ArrayList;
import java.util.TimerTask;

public class FlightPeriodicTask extends TimerTask {
    private final FlightProvider flightProvider;
    private final ArrayList<Location> locations;

    public FlightPeriodicTask(FlightProvider flightProvider, ArrayList<Location> locations) {
        this.flightProvider = flightProvider;
        this.locations = locations;
    }

    @Override
    public void run() {
        PublisherActiveMQ publisherActiveMQ = new PublisherActiveMQ();
        publisherActiveMQ.start();
        FlightApplication weatherApplication = new FlightApplication(flightProvider, locations, publisherActiveMQ);
        weatherApplication.execute();
        publisherActiveMQ.close();
    }
}
