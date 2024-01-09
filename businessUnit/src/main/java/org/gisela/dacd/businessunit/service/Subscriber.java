package org.gisela.dacd.businessunit.service;

public interface Subscriber {
    void start();
    void subscribe(String topicName);
}

