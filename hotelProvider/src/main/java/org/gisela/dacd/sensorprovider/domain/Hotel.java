package org.gisela.dacd.sensorprovider.domain;

import java.time.Instant;
import java.util.List;

public class Hotel {
    private Instant ts;
    private String ss;
    private String name;
    private String hotelKey;
    private Location location;
    private List<Rate> rates;
    private String checkIn;
    private String checkOut;

    public Hotel(String name, String hotelKey, Location location) {
        this.name = name;
        this.hotelKey = hotelKey;
        this.location = location;
    }

    public Hotel(Instant ts, String ss, String name, String hotelKey, Location location, List<Rate> rates,
                 String checkIn, String checkOut) {
        this.ts = ts;
        this.ss = ss;
        this.name = name;
        this.hotelKey = hotelKey;
        this.location = location;
        this.rates = rates;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
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

    public Instant getTs() {
        return ts;
    }

    public void setTs(Instant ts) {
        this.ts = ts;
    }

    public String getSs() {
        return ss;
    }

    public void setSs(String ss) {
        this.ss = ss;
    }

    public List<Rate> getRates() {
        return rates;
    }

    public void setRates(List<Rate> rate) {
        this.rates = rate;
    }

    public String getCheckIn() {
        return checkIn;
    }

    public void setCheckIn(String checkIn) {
        this.checkIn = checkIn;
    }

    public String getCheckOut() {
        return checkOut;
    }

    public void setCheckOut(String checkOut) {
        this.checkOut = checkOut;
    }
}
