package org.gisela.dacd.flightprovider.application;

import org.gisela.dacd.flightprovider.domain.Flight;
import org.gisela.dacd.flightprovider.domain.Location;
import java.util.List;

public interface FlightProvider {
    List<Flight> getWeatherData(Location location);
}
