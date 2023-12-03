package org.gisela.dacd.eventstore;

import org.gisela.dacd.eventstore.application.Subscriber;
import org.gisela.dacd.eventstore.utils.FileManager;
import org.gisela.dacd.eventstore.infrastructure.SubscriberActiveMQ;

public class Main {
    private static final String BROKER_URL = "tcp://localhost:61616";
    private static final String CLIENT_ID = "Gisela";
    private static final String TOPIC_NAME = "prediction.Weather";
    private static final String SUBSCRIBER_ID = "Gisela";

    public static void main(String[] args) {
        FileManager fileManager = new FileManager();
        Subscriber subscriber = new SubscriberActiveMQ(BROKER_URL,CLIENT_ID, SUBSCRIBER_ID, fileManager);
        subscriber.start();
        subscriber.subscribe(TOPIC_NAME);
    }
}
