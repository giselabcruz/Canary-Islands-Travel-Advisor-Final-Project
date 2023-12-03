package org.gisela.dacd.provider.controller;

public interface Publisher {
    void start();
    void publish (String event, String topic);
    void close();
}
