package org.gisela.dacd.sensorprovider.domain;

public class Hotel {

    private String name;
    private String apikey;
    private Location location;

    public Hotel(String name, String apikey, Location location) {
        this.name = name;
        this.apikey = apikey;
        this.location = location;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getApikey() {
        return apikey;
    }

    public void setApikey(String apikey) {
        this.apikey = apikey;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }
}
