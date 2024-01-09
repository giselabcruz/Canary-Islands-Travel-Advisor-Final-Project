package org.gisela.dacd.sensorprovider.application;

import org.gisela.dacd.sensorprovider.domain.Rate;
import java.time.LocalDate;
import java.util.List;

public interface HotelProvider {
    List<Rate> getHotelRates(String hotelKey, LocalDate currentDate );
}
