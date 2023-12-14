package org.gisela.dacd.predictionprovider.application;

import org.gisela.dacd.predictionprovider.domain.Location;
import org.gisela.dacd.predictionprovider.domain.Weather;
import java.util.List;

public interface WeatherProvider {
    List<Weather> getWeatherData(Location location);
}
