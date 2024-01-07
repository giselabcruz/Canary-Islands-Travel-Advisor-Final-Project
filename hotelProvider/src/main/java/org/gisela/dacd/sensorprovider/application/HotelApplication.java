package org.gisela.dacd.sensorprovider.application;

import org.gisela.dacd.sensorprovider.domain.Hotel;
import org.gisela.dacd.sensorprovider.domain.Rate;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public class HotelApplication {
    private final HotelProvider xoteloProvider;
    private final ArrayList<Hotel> hotels;
    private final HotelPublisher publisher;

    public HotelApplication(HotelProvider hotelProvider, ArrayList<Hotel> hotels, HotelPublisher publisher) {
        this.xoteloProvider = hotelProvider;
        this.hotels = hotels;
        this.publisher = publisher;
    }
    public void execute() {
        for (Hotel hotel : hotels) {
            List<Rate> hotelRates = xoteloProvider.getHotelRates(hotel.getHotelKey());
            Instant instant = Instant.now();
            Hotel event = new Hotel(instant, "hotel-provider",hotel.getName(),hotel.getHotelKey(),
                    hotel.getLocation(), hotelRates);
            publisher.publish(event);
        }
    }
}
