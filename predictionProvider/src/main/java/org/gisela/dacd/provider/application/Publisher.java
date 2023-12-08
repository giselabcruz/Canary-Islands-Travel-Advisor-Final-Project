package org.gisela.dacd.provider.application;

import org.gisela.dacd.provider.domain.Weather;

public interface Publisher {
    void start();
    void publish (Weather event);
    void close();
}
