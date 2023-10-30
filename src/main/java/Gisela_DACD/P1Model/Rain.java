package Gisela_DACD.P1Model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Rain {
    private double hour;

    @JsonProperty("1h")
    public double getHour() {
        return hour;
    }

    @JsonProperty("1h")
    public void setHour(double hour) {
        this.hour = hour;
    }
}
