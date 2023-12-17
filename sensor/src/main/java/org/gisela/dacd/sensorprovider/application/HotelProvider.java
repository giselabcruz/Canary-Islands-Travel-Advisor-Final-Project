package org.gisela.dacd.sensorprovider.application;

import org.gisela.dacd.sensorprovider.domain.Hotel;
import org.gisela.dacd.sensorprovider.domain.Location;
import java.util.List;

public interface HotelProvider {

    List<Hotel> getHotelData(Location location);

}
