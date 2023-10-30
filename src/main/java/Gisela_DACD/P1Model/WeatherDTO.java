package Gisela_DACD.P1Model;

public class WeatherDTO {
    private Wind wind;
    private WeatherMainDTO main;
    private Clouds clouds;
    private Rain rain;

    public Wind getWind() {
        return wind;
    }

    public void setWind(Wind wind) {
        this.wind = wind;
    }
    public WeatherMainDTO getMainData() {
        return main;
    }
    public void setMainData(WeatherMainDTO main) {
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
