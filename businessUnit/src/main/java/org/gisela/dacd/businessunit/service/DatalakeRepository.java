package org.gisela.dacd.businessunit.service;

import org.gisela.dacd.businessunit.entity.Hotel;
import java.io.IOException;
import java.util.List;

public interface DatalakeRepository {
    List<Hotel> getHotelHistoricalData() throws IOException;
}
