package org.gisela.dacd.eventstore.application;

public interface Subscriber {
    void start();
    void subscribe(String topicName);
}
