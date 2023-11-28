package org.gisela.dacd.provider.controller;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;
import org.apache.activemq.ActiveMQConnectionFactory;

public class Publisher {
    private static String url = "tcp://localhost:61616";
    private static String topic = "prediction.Weather";

    public void publish (String event) throws JMSException {
        ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(url);
        Connection connection = connectionFactory.createConnection();
        connection.start();

        Session session = connection.createSession(false,
                Session.AUTO_ACKNOWLEDGE);

        Destination destination = session.createTopic(topic);

        MessageProducer producer = session.createProducer(destination);

        TextMessage message = session
                .createTextMessage(event);

        producer.send(message);

        System.out.println("JCG printing@@ '" + message.getText() + "'");
        connection.close();
    }
}
