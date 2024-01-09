package org.gisela.dacd.flightprovider.application;

import org.gisela.dacd.flightprovider.domain.Flight;

public interface Publisher {
    void start();
    void publish (Flight event);
    void close();
}
