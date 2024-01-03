package org.gisela.dacd.sensorprovider.application;

import org.gisela.dacd.sensorprovider.domain.Rate;
import java.util.List;

public interface HotelProvider {
    List<Rate> getHotelRates(String hotelKey);
}
