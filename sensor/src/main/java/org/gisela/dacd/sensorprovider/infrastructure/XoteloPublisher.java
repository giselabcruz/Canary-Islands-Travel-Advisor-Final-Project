package org.gisela.dacd.sensorprovider.infrastructure;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.gisela.dacd.sensorprovider.application.HotelPublisher;
import org.gisela.dacd.sensorprovider.domain.Hotel;
import javax.jms.*;


public class XoteloPublisher implements HotelPublisher {

    private static final String url = "tcp://localhost:61616";
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
    public void publish(Hotel event) {
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
