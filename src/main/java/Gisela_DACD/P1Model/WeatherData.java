package Gisela_DACD.P1Model;

public class WeatherData {
    private Wind wind;
    private MainData main;
    private Clouds clouds;
    private Rain rain;

    public Wind getWind() {
        return wind;
    }

    public void setWind(Wind wind) {
        this.wind = wind;
    }
    public MainData getMainData() {
        return main;
    }
    public void setMainData(MainData main) {
        this.main = main;
    }

    public Clouds getClouds() {
        return clouds;
    }

    public void setClouds(Clouds clouds) {
        this.clouds = clouds;
    }

    public Rain getRain() {
        return rain;
    }

    public void setRain(Rain rain) {
        this.rain = rain;
    }
}
