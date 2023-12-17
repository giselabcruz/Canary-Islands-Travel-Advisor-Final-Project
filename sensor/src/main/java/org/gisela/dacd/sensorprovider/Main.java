package org.gisela.dacd.sensorprovider;

import org.gisela.dacd.sensorprovider.application.HotelPeriodicTask;
import org.gisela.dacd.sensorprovider.application.HotelSupplier;
import org.gisela.dacd.sensorprovider.domain.Hotel;
import org.gisela.dacd.sensorprovider.infrastructure.XoteloProvider;
import java.util.ArrayList;
import java.util.Timer;

public class Main {

    public static void main(String[] args){
        ArrayList<Hotel> hotels = HotelSupplier.canaryIslandsHotels();
        XoteloProvider xoteloProvider = new XoteloProvider();
        Timer timer = new Timer();
        HotelPeriodicTask updaterTask = new HotelPeriodicTask(xoteloProvider, hotels);
        timer.scheduleAtFixedRate(updaterTask, 0, 6 * 60 * 60 * 1000);
    }
}
