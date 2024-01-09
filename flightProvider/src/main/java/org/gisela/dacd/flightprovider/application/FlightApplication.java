package org.gisela.dacd.flightprovider.application;

import org.gisela.dacd.flightprovider.domain.Flight;
import org.gisela.dacd.flightprovider.domain.Location;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public class FlightApplication {
    private final FlightProvider flightProvider;
    private final ArrayList<Location> locations;
    private final Publisher publisher;

    public FlightApplication(FlightProvider flightProvider, ArrayList<Location> locations, Publisher publisher) {
        this.flightProvider = flightProvider;
        this.locations = locations;
        this.publisher = publisher;
    }

    public void execute() {
        for (Location location : locations) {
            List<Flight> weatherList = flightProvider.getWeatherData(location);
            Instant instant = Instant.now();
            for (Flight flight : weatherList) {
                Flight event = new Flight(instant, "flight-provider", flight.getPrice(), flight.getAgent(),
                        flight.getOriginPlaceId(), flight.getDestinationPlaceId(), flight.getStopCount(), flight.getDurationInMinutes()
                        , flight.getArrivalDateTime());
                publisher.publish(event);
            }
        }
    }
}
