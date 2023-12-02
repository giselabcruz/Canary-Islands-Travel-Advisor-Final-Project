package org.gisela.dacd.eventstore;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import org.apache.activemq.ActiveMQConnectionFactory;
import javax.jms.*;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.Instant;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;

public class Subscriber {
    private static final String BROKER_URL = "tcp://localhost:61616";
    private static final String CLIENT_ID = "Gisela";
    private static final String TOPIC_NAME = "prediction.Weather";
    private static final String SUBSCRIBER_ID = "Gisela";

    public static void main(String[] args) {
        Subscriber subscriber = new Subscriber();
        subscriber.start();
    }

    private void start() {
        try {
            ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(BROKER_URL);
            Connection connection = connectionFactory.createConnection();
            connection.setClientID(CLIENT_ID);
            connection.start();
            Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
            Topic destination = session.createTopic(TOPIC_NAME);
            MessageConsumer consumer = session.createDurableSubscriber(destination, SUBSCRIBER_ID);
            consumer.setMessageListener(message -> {
                try {
                    handleIncomingMessage(message);
                } catch (JMSException e) {
                    handleError("Error processing JMS message: " + e.getMessage());
                }
            });
            System.out.println("Running");
        } catch (JMSException e) {
            handleError("Error establishing JMS connection: " + e.getMessage());
        }
    }

    private void processEvent(String json) {
        Gson gson = new Gson();
        JsonObject jsonObject = gson.fromJson(json, JsonObject.class);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");
        String formattedTimestamp = Instant.now().atOffset(ZoneOffset.UTC).format(formatter);
        File directory = new File("eventstore/prediction.Weather/" +
                jsonObject.get("ss").getAsString().replace("\"", "") + "/");
        if (!directory.exists() && !directory.mkdirs()) {
            handleError("Error creating directory: " + directory.getAbsolutePath());
            return;
        }
        File file = new File(directory, formattedTimestamp + ".events");
        try (FileWriter writer = new FileWriter(file);
             BufferedWriter bufferedWriter = new BufferedWriter(writer)) {

            gson.toJson(jsonObject, bufferedWriter);
            System.out.println("Event stored successfully at: " + file.getAbsolutePath());
        } catch (IOException e) {
            handleError("Error writing event to file: " + e.getMessage());
        }
    }

    private void handleIncomingMessage(Message message) throws JMSException {
        if (message instanceof TextMessage textMessage) {
            processEvent(textMessage.getText());
        } else {
            System.err.println("Unrecognized message: " + message.getClass().getName());
        }
    }

    private void handleError(String errorMessage) {
        System.err.println(errorMessage);
    }
}
