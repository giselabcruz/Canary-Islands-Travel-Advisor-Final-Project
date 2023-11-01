package Gisela_DACD.P1Model;


public class Weather {
    private Wind wind;
    private WeatherMain main;
    private Clouds clouds;
    private Rain rain;
    private long dt;

    public Wind getWind() {
        return wind;
    }

    public void setWind(Wind wind) {
        this.wind = wind;
    }

    public WeatherMain getMainData() {
        return main;
    }

    public void setMainData(WeatherMain main) {
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

    public long getDt() {
        return dt;
    }

    public void setDt(long dt) {
        this.dt = dt;
    }
}
