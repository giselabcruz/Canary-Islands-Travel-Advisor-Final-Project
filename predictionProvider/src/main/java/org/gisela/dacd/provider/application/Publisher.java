package org.gisela.dacd.provider.application;

public interface Publisher {
    void start();
    void publish (String event, String topic);
    void close();
}
