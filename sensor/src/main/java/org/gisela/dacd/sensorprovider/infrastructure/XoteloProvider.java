package org.gisela.dacd.sensorprovider.infrastructure;

import org.gisela.dacd.sensorprovider.application.HotelProvider;
import org.gisela.dacd.sensorprovider.domain.Hotel;
import org.gisela.dacd.sensorprovider.domain.Location;
import java.util.List;

public class XoteloProvider implements HotelProvider {

    private final String apiKey;

    public XoteloProvider(String apiKey) {
            this.apiKey = apiKey;
    }

    @Override
    public List<Hotel> getHotelData(Location location) {
        return null;
    }

    private String getRates(Location location) {
        return String.format("https://data.xotelo.com/api/rates?hotel_key=%s&chk_in=%s&chk_out=%s",
                apiKey,"2024-02-25","2024-02-26");
    }

    private String getHeatmap(Location location) {
        return String.format("https://data.xotelo.com/api/heatmap?hotel_key=%s&chk_out=%s",
                apiKey,"2024-02-26");
    }

}
