package org.gisela.dacd.eventstore.application;

public interface EventStore {
    void storeEventToFile(String json, String topicName);
}
