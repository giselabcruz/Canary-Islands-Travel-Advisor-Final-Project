package org.gisela.dacd.sensorprovider.domain;

public class Rate {
    private double price;
    private String platformName;

    public Rate(double price, String platformName) {
        this.price = price;
        this.platformName = platformName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getPlatformName() {
        return platformName;
    }

    public void setPlatformName(String platformName) {
        this.platformName = platformName;
    }
}
