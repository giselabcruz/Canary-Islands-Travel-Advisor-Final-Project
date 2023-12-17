package org.gisela.dacd.sensorprovider.application;

import org.gisela.dacd.sensorprovider.domain.Hotel;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public class HotelApplication {
    private final HotelProvider xoteloProvider;
    private final ArrayList<Hotel> hotels;
    private final HotelPublisher publisher;

    public HotelApplication(HotelProvider xoteloProvider, ArrayList<Hotel> hotels, HotelPublisher publisher) {
        this.xoteloProvider = xoteloProvider;
        this.hotels = hotels;
        this.publisher = publisher;
    }
    public void execute() {
        for (Hotel hotel : hotels) {
            List<Hotel> hotelRates = xoteloProvider.getHotelRates(hotel.getHotelKey());
            List<Hotel> hotelHeatmap = xoteloProvider.getHotelHeatmap(hotel.getHotelKey());
            Instant instant = Instant.now();
//            for (Hotel weather : hotelList) {
//                Hotel event = new Weather(instant, "prediction-provider");
//                publisher.publish(event);
//            }
        }
    }
}
