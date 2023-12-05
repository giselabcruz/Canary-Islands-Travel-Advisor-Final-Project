package org.gisela.dacd.provider.application;

public interface Publisher {
    void start();
    void publish (String event, String topic); //TODO: reducir acoplamiento Strings
    void close();
}
