package org.gisela.dacd.businessunit.repository;

import org.gisela.dacd.businessunit.entity.Hotel;
import java.util.List;

public interface HotelRepository {

    void saveHotel(Hotel hotel);
    List<Hotel> getAllHotels();
    List<Hotel> getHotelByLocation(String location);
    List<Hotel> getHotelByDate(String location, String checkIn, String checkOut);
}
