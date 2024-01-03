package org.gisela.dacd.sensorprovider.application;

import org.gisela.dacd.sensorprovider.domain.Hotel;

public interface HotelPublisher {
    void start();
    void publish (Hotel event);
    void close();
}
