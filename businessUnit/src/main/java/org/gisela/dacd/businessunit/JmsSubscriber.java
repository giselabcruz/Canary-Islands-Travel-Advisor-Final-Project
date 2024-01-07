package org.gisela.dacd.businessunit;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class JmsSubscriber {

    @JmsListener(destination = "prediction.Weather", containerFactory = "myJmsContainerFactory")
    public void receiveWeatherMessage(String message) {
        System.out.println("Received <" + message + ">");
    }

    @JmsListener(destination = "sensor.Hotel", containerFactory = "myJmsContainerFactory")
    public void receiveHotelMessage(String message) {
        System.out.println("Received <" + message + ">");
    }
}
