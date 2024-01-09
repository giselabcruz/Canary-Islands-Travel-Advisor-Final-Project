package org.gisela.dacd.businessunit.service;

import com.google.gson.Gson;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import org.gisela.dacd.businessunit.entity.Hotel;
import org.gisela.dacd.businessunit.entity.VacationRecommendation;
import org.gisela.dacd.businessunit.entity.Weather;
import org.gisela.dacd.businessunit.repository.HotelRepository;
import org.gisela.dacd.businessunit.repository.WeatherRepository;
import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class VacationRecommendationsHandler implements HttpHandler {

    private final HotelRepository hotelRepository;
    private final WeatherRepository weatherRepository;

    public VacationRecommendationsHandler(HotelRepository hotelRepository, WeatherRepository weatherRepository) {
        this.hotelRepository = hotelRepository;
        this.weatherRepository = weatherRepository;
    }

    @Override
    public void handle(HttpExchange exchange) throws IOException {
        String query = exchange.getRequestURI().getQuery();
        Gson gson = new Gson();
        Map<String, String> queryParams = queryToMap(query);
        if ("GET".equals(exchange.getRequestMethod())) {
            List<Hotel> hotels = hotelRepository.getHotelByLocation(queryParams.get("location"));
            List<Weather> allWeather = weatherRepository.getWeatherByLocation(queryParams.get("location"));
            VacationRecommendation vacationRecommendation = new VacationRecommendation(hotels, allWeather);
            String response = gson.toJson(vacationRecommendation);
            exchange.getResponseHeaders().set("Content-Type", "application/json");
            exchange.sendResponseHeaders(200, response.getBytes().length);
            OutputStream os = exchange.getResponseBody();
            os.write(response.getBytes());
            os.close();
        }

    }

    private Map<String, String> queryToMap(String query) {
        Map<String, String> result = new HashMap<>();
        for (String param : query.split("&")) {
            String[] entry = param.split("=");
            if (entry.length > 1) {
                result.put(entry[0], entry[1]);
            }else{
                result.put(entry[0], "");
            }
        }
        return result;
    }
}
