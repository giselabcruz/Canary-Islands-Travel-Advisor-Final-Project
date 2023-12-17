package org.gisela.dacd.sensorprovider.domain;

public class Hotel {

    private String name;
    private String hotelKey;
    private Location location;

    public Hotel(String name, String hotelKey, Location location) {
        this.name = name;
        this.hotelKey = hotelKey;
        this.location = location;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHotelKey() {
        return hotelKey;
    }

    public void setHotelKey(String hotelKey) {
        this.hotelKey = hotelKey;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }
}
