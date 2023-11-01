package Gisela_DACD.P1Model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Rain {
    private double hour;

    @JsonProperty("3h")
    public double getHour() {
        return hour;
    }

    @JsonProperty("3h")
    public void setHour(double hour) {
        this.hour = hour;
    }
}
