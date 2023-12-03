package org.gisela.dacd.provider.controller;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;
import org.apache.activemq.ActiveMQConnectionFactory;

public class PublisherActiveMQ implements Publisher {
    private static String url = "tcp://localhost:61616";
    private Connection connection;

    @Override
    public void start() {
        ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(url);
        try {
            connection = connectionFactory.createConnection();
            connection.start();
        } catch (JMSException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void publish (String event, String topic) {

        Session session = null;
        try {
            session = connection.createSession(false,
                    Session.AUTO_ACKNOWLEDGE);
        } catch (JMSException e) {
            throw new RuntimeException(e);
        }

        Destination destination = null;
        try {
            destination = session.createTopic(topic);
        } catch (JMSException e) {
            throw new RuntimeException(e);
        }

        MessageProducer producer = null;
        try {
            producer = session.createProducer(destination);
        } catch (JMSException e) {
            throw new RuntimeException(e);
        }

        TextMessage message = null;
        try {
            message = session
                    .createTextMessage(event);
        } catch (JMSException e) {
            throw new RuntimeException(e);
        }

        try {
            producer.send(message);
        } catch (JMSException e) {
            throw new RuntimeException(e);
        }

        try {
            System.out.println("JCG printing@@ '" + message.getText() + "'");
        } catch (JMSException e) {
            throw new RuntimeException(e);
        }
        try {
            connection.close();
        } catch (JMSException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void close(){
        try {
            connection.close();
        } catch (JMSException e) {
            throw new RuntimeException(e);
        }
    }
}
