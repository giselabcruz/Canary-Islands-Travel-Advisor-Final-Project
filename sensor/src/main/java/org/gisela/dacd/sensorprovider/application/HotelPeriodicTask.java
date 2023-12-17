package org.gisela.dacd.sensorprovider.application;

import org.gisela.dacd.sensorprovider.domain.Hotel;
import org.gisela.dacd.sensorprovider.infrastructure.XoteloProvider;
import org.gisela.dacd.sensorprovider.infrastructure.XoteloPublisher;
import java.util.ArrayList;
import java.util.TimerTask;

public class HotelPeriodicTask extends TimerTask {
    private final XoteloProvider xoteloProvider;
    private final ArrayList<Hotel> hotels;

    public HotelPeriodicTask(XoteloProvider xoteloProvider, ArrayList<Hotel> hotels)  {
        this.xoteloProvider = xoteloProvider;
        this.hotels = hotels;
    }

    @Override
    public void run() {
        XoteloPublisher xoteloPublisher = new XoteloPublisher();
        xoteloPublisher.start();
        HotelApplication weatherApplication = new HotelApplication(xoteloProvider, hotels, xoteloPublisher);
        weatherApplication.execute();
        xoteloPublisher.close();
    }
}
