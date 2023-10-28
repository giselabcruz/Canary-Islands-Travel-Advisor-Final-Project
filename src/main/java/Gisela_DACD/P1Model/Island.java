package Gisela_DACD.P1Model;

public class Island {
    private String name;
    private double lat;
    private double longitude;

    public Island(String name, double lat, double longitude) {
        this.name = name;
        this.lat = lat;
        this.longitude = longitude;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }
}
