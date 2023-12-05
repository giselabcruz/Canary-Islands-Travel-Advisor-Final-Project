package org.gisela.dacd.eventstore.infrastructure;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.gisela.dacd.eventstore.application.EventStoreManager;
import org.gisela.dacd.eventstore.application.Subscriber;
import javax.jms.*;

public class SubscriberActiveMQ implements Subscriber {
    private final String brokerUrl;
    private final String clientId;
    private final String subscriberId;
    private final EventStoreManager eventStoreManager;
    private Connection connection;

    public SubscriberActiveMQ(String brokerUrl, String clientId, String subscriberId, EventStoreManager eventStoreManager) {
        this.brokerUrl = brokerUrl;
        this.clientId = clientId;
        this.subscriberId = subscriberId;
        this.eventStoreManager = eventStoreManager;
    }

    @Override
    public void start() {
        try {
            ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(this.brokerUrl);
            connection = connectionFactory.createConnection();
            connection.setClientID(this.clientId);
            connection.start();
        } catch (JMSException e) {
            handleError("Error establishing JMS connection: " + e.getMessage());
        }
    }

    @Override
    public void subscribe(String topicName) {
        // TODO: refactor code try/catch
        // TODO: allow new sessions

        try {
            Session session = this.connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
            Topic destination = session.createTopic(topicName);
            MessageConsumer consumer = session.createDurableSubscriber(destination, this.subscriberId);
            try {
                consumer.setMessageListener(message -> {
                    try {
                        handleIncomingMessage(message);
                    } catch (JMSException e) {
                        handleError("Error processing JMS message: " + e.getMessage());
                    }
                });
            } catch (JMSException e) {
                throw new RuntimeException(e);
            }
        } catch (JMSException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Running");
    }

    private void handleIncomingMessage(Message message) throws JMSException {
        if (message instanceof TextMessage textMessage) {
            eventStoreManager.storeEventToFile(textMessage.getText());
        } else {
            System.err.println("Unrecognized message: " + message.getClass().getName());
        }
    }

    public static void handleError(String errorMessage) {
        System.err.println(errorMessage);
    }
}
