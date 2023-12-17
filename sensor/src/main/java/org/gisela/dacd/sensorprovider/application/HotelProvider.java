package org.gisela.dacd.sensorprovider.application;

import org.gisela.dacd.sensorprovider.domain.Hotel;
import java.util.List;

public interface HotelProvider {
    List<Hotel> getHotelRates(String hotelKey);
    List<Hotel> getHotelHeatmap(String hotelKey);
}
