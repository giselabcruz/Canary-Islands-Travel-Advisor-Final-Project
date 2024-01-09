package org.gisela.dacd.businessunit.service;

public interface EventStore {
    void storeEvent(String json, String topicName);
}
