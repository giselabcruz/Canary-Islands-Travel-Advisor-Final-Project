package org.gisela.dacd.provider.application;

import org.gisela.dacd.provider.domain.events.WeatherEvent;

public interface Publisher {
    void start();
    void publish (WeatherEvent event);
    void close();
}
