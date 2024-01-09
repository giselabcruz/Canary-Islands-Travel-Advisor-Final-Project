package org.gisela.dacd.businessunit.entity;

public class Weather {

    private String location;
    private String date;
    private double precipitation;
    private double clouds;
    private double temperature;
    private double windSpeed;

    public Weather(double precipitation,String date, double clouds, double temperature, double windSpeed, String location) {
        this.precipitation = precipitation;
        this.date = date;
        this.clouds = clouds;
        this.temperature = temperature;
        this.windSpeed = windSpeed;
        this.location = location;
    }


    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public double getPrecipitation() {
        return precipitation;
    }

    public void setPrecipitation(double precipitation) {
        this.precipitation = precipitation;
    }

    public double getClouds() {
        return clouds;
    }

    public void setClouds(double clouds) {
        this.clouds = clouds;
    }

    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    public double getWindSpeed() {
        return windSpeed;
    }

    public void setWindSpeed(double windSpeed) {
        this.windSpeed = windSpeed;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
