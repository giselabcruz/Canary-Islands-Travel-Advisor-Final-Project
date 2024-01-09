package org.gisela.dacd.businessunit.entity;

public class Hotel {
    private String name;
    private String location;
    private String platformName;
    private double price;
    private String checkIn;
    private String checkOut;

    public Hotel(String name, String location, double price, String platformName, String checkIn, String checkOut) {
        this.name = name;
        this.location = location;
        this.price = price;
        this.platformName = platformName;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPlatformName() {
        return platformName;
    }

    public void setPlatformName(String platformName) {
        this.platformName = platformName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
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

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
