package org.gisela.dacd.flightprovider;

import org.gisela.dacd.flightprovider.application.FlightPeriodicTask;
import org.gisela.dacd.flightprovider.application.LocationSupplier;
import org.gisela.dacd.flightprovider.domain.Location;
import org.gisela.dacd.flightprovider.infrastructure.SkyScannerProvider;
import java.util.ArrayList;
import java.util.Timer;

public class Main {
    public static void main(String[] args) {
        String apiKey = args[0];
        ArrayList<Location> locations = LocationSupplier.initializeIslands();
        SkyScannerProvider skyScannerProvider = new SkyScannerProvider(apiKey);
        Timer timer = new Timer();
        FlightPeriodicTask updaterTask = new FlightPeriodicTask(skyScannerProvider, locations);
        timer.scheduleAtFixedRate(updaterTask, 0, 6 * 60 * 60 * 1000);
    }
}
