package org.gisela.dacd.predictionprovider.application;

import org.gisela.dacd.predictionprovider.domain.Weather;

public interface Publisher {
    void start();
    void publish (Weather event);
    void close();
}
