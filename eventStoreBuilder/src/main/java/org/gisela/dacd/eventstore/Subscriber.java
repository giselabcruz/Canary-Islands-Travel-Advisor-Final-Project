package org.gisela.dacd.eventstore;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import org.apache.activemq.ActiveMQConnectionFactory;
import javax.jms.*;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Subscriber {
    private static String url = "tcp://localhost:61616";

    public static void main(String[] args) throws JMSException {
        ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(url);
        Connection connection = connectionFactory.createConnection();
        connection.setClientID("Gisela");
        connection.start();

        Session session = connection.createSession(false,
                Session.AUTO_ACKNOWLEDGE);

        Topic destination = session.createTopic("prediction.Weather");

        MessageConsumer consumer = session.createDurableSubscriber(destination, "Cristian");

        consumer.setMessageListener(message -> {
            try {
                System.out.println(((TextMessage)message).getText());
                Gson gson = new Gson();
                JsonObject jsonObject = gson.fromJson(((TextMessage)message).getText(), JsonObject.class);

                File saverData = new File( jsonObject.get("ts") + "_prediction_weather.json");

                FileWriter writer = new FileWriter(saverData);

                BufferedWriter bufferedWriter = new BufferedWriter(writer);
                gson.toJson(jsonObject, bufferedWriter);

                bufferedWriter.close();
                writer.close();
            } catch (JMSException | IOException e) {
                throw new RuntimeException(e);
            }
        });

        System.out.println("running");
    }
}