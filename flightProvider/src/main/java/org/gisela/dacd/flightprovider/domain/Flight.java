package org.gisela.dacd.flightprovider.domain;

import java.time.Instant;

public class Flight {
    private Instant ts;
    private String ss;

    private double price;
    private String agent;
    private String originPlaceId;
    private String destinationPlaceId;
    private String stopCount;
    private String durationInMinutes;
    private String arrivalDateTime;


    public Flight(Instant ts, String ss, double price, String agent, String originPlaceId, String destinationPlaceId, String stopCount, String durationInMinutes, String arrivalDateTime) {
        this.ts = ts;
        this.ss = ss;
        this.price = price;
        this.agent = agent;
        this.originPlaceId = originPlaceId;
        this.destinationPlaceId = destinationPlaceId;
        this.stopCount = stopCount;
        this.durationInMinutes = durationInMinutes;
        this.arrivalDateTime = arrivalDateTime;
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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getAgent() {
        return agent;
    }

    public void setAgent(String agent) {
        this.agent = agent;
    }

    public String getOriginPlaceId() {
        return originPlaceId;
    }

    public void setOriginPlaceId(String originPlaceId) {
        this.originPlaceId = originPlaceId;
    }

    public String getDestinationPlaceId() {
        return destinationPlaceId;
    }

    public void setDestinationPlaceId(String destinationPlaceId) {
        this.destinationPlaceId = destinationPlaceId;
    }

    public String getStopCount() {
        return stopCount;
    }

    public void setStopCount(String stopCount) {
        this.stopCount = stopCount;
    }

    public String getDurationInMinutes() {
        return durationInMinutes;
    }

    public void setDurationInMinutes(String durationInMinutes) {
        this.durationInMinutes = durationInMinutes;
    }

    public String getArrivalDateTime() {
        return arrivalDateTime;
    }

    public void setArrivalDateTime(String arrivalDateTime) {
        this.arrivalDateTime = arrivalDateTime;
    }
}
