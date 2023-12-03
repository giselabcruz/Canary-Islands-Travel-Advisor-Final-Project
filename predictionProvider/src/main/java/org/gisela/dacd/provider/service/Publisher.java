package org.gisela.dacd.provider.service;

public interface Publisher {
    void start();
    void publish (String event, String topic);
    void close();
}
