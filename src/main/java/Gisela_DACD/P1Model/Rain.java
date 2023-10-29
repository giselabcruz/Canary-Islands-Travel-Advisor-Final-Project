package Gisela_DACD.P1Model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Rain {
    private String hour;
    @JsonProperty("1h")
    public String getHour() {
        return hour;
    }
    @JsonProperty("1h")
    public void setHour(String hour) {
        this.hour = hour;
    }
}
