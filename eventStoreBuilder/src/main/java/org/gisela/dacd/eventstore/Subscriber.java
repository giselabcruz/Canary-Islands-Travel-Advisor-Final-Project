package org.gisela.dacd.eventstore;

public interface Subscriber {
    void start();
    void subscribe(String topicName);
}
