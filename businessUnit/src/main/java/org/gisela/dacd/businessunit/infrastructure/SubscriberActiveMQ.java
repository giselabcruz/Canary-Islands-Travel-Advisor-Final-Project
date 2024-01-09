package org.gisela.dacd.businessunit.infrastructure;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.gisela.dacd.businessunit.service.EventStore;
import org.gisela.dacd.businessunit.service.Subscriber;
import javax.jms.*;

public class SubscriberActiveMQ implements Subscriber {
    private final String brokerUrl;
    private final String clientId;
    private final String subscriberId;
    private final EventStore eventStore;
    private Connection connection;

    public SubscriberActiveMQ(String brokerUrl, String clientId, String subscriberId, EventStore eventStore) {
        this.brokerUrl = brokerUrl;
        this.clientId = clientId;
        this.subscriberId = subscriberId;
        this.eventStore = eventStore;
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
        try {
            Session session = createSession();
            Topic destination = createTopic(session, topicName);
            MessageConsumer consumer = createSubscriber(session, destination);
            setMessageListener(consumer, topicName);
        } catch (JMSException e) {
            handleError("Error during subscription:" + e.getMessage());
        }
        System.out.println("Running");
    }

    private Session createSession() throws JMSException {
        return this.connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
    }

    private Topic createTopic(Session session, String topicName) throws JMSException {
        return session.createTopic(topicName);
    }

    private MessageConsumer createSubscriber(Session session, Topic destination) throws JMSException {
        return session.createConsumer(destination);
    }

    private void setMessageListener(MessageConsumer consumer, String topicName) throws JMSException {
        consumer.setMessageListener(message -> {
            try {
                handleIncomingMessage(message,topicName);
            } catch (JMSException e) {
                handleError("Error processing JMS message: " + e.getMessage());
            }
        });
    }

    private void handleIncomingMessage(Message message, String topicName) throws JMSException {
        if (message instanceof TextMessage textMessage) {
            eventStore.storeEvent(textMessage.getText(), topicName);
        } else {
            System.err.println("Unrecognized message: " + message.getClass().getName());
        }
    }

    public static void handleError(String errorMessage) {
        System.err.println(errorMessage);
    }
}
