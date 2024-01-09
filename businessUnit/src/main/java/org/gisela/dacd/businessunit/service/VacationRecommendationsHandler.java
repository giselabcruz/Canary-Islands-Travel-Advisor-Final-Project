package org.gisela.dacd.businessunit.service;

import com.google.gson.Gson;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import org.gisela.dacd.businessunit.entity.Hotel;
import org.gisela.dacd.businessunit.entity.VacationRecommendation;
import org.gisela.dacd.businessunit.entity.Weather;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class VacationRecommendationsHandler implements HttpHandler {

    private final HotelRepository hotelRepository;
    private final WeatherRepository weatherRepository;
    private DatalakeRepository datalakeRepository;

    public VacationRecommendationsHandler(HotelRepository hotelRepository,
                                          WeatherRepository weatherRepository, DatalakeRepository datalakeRepository) {
        this.hotelRepository = hotelRepository;
        this.weatherRepository = weatherRepository;
        this.datalakeRepository = datalakeRepository;
    }

    @Override
    public void handle(HttpExchange exchange) throws IOException {
        String query = exchange.getRequestURI().getQuery();
        Gson gson = new Gson();
        Map<String, String> queryParams = queryToMap(query);
        String response;

        if (!"GET".equals(exchange.getRequestMethod())) {
            exchange.sendResponseHeaders(405, -1);
        } else {
            if (query == null && !queryParams.containsKey("location")) {
                List<Hotel> historicalData = datalakeRepository.getHotelHistoricalData();
                VacationRecommendation vacationRecommendation = new VacationRecommendation(historicalData, null);
                response = gson.toJson(vacationRecommendation);
                sendResponse(exchange, response);
            } else if (queryParams.containsKey("temperature")) {
                List<Weather> allWeather = weatherRepository.getWeatherByTemperature(queryParams.get("temperature"));
                List<String> locations = allWeather.stream().map(Weather::getLocation).toList();
                List<Hotel> hotels = new ArrayList<>();
                locations.forEach(location -> hotels.addAll(hotelRepository.getHotelByLocation(location)));
                VacationRecommendation vacationRecommendation = new VacationRecommendation(hotels, allWeather);
                response = gson.toJson(vacationRecommendation);
                sendResponse(exchange, response);
            } else {
                List<Hotel> hotels = hotelRepository.getHotelByLocation(queryParams.get("location"));
                List<Weather> allWeather = weatherRepository.getWeatherByLocation(queryParams.get("location"));
                VacationRecommendation vacationRecommendation = new VacationRecommendation(hotels, allWeather);
                response = gson.toJson(vacationRecommendation);
                sendResponse(exchange, response);
            }
        }
    }

    private void sendResponse(HttpExchange exchange, String response) throws IOException {
        exchange.getResponseHeaders().set("Content-Type", "application/json");
        exchange.sendResponseHeaders(200, response.getBytes().length);
        try (OutputStream os = exchange.getResponseBody()) {
            os.write(response.getBytes());
        }
    }

    private Map<String, String> queryToMap(String query) {
        Map<String, String> result = new HashMap<>();
        if (query != null) {
            for (String param : query.split("&")) {
                String[] entry = param.split("=");
                if (entry.length > 1) {
                    result.put(entry[0], entry[1]);
                } else {
                    result.put(entry[0], "");
                }
            }
        }
        return result;
    }
}
