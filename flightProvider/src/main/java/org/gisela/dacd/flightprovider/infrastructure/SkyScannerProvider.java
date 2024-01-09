package org.gisela.dacd.flightprovider.infrastructure;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import org.apache.hc.client5.http.classic.methods.HttpPost;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.CloseableHttpResponse;
import org.apache.hc.client5.http.impl.classic.HttpClients;
import org.apache.hc.core5.http.HttpEntity;
import org.apache.hc.core5.http.ParseException;
import org.apache.hc.core5.http.io.entity.EntityUtils;
import org.apache.hc.core5.http.io.entity.StringEntity;
import org.gisela.dacd.flightprovider.application.FlightProvider;
import org.gisela.dacd.flightprovider.domain.Flight;
import org.gisela.dacd.flightprovider.domain.Location;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SkyScannerProvider implements FlightProvider {

    private final String apiKey;

    public SkyScannerProvider(String apiKey) {
        this.apiKey = apiKey;
    }
    @Override
    public List<Flight> getWeatherData(Location location) {
        String url = buildApiUrl(location);
        try (CloseableHttpClient httpclient = HttpClients.createDefault()) {
            HttpPost httpPost = new HttpPost(url);
            httpPost.addHeader(" x-api-key ",this.apiKey);
            FlightQuery flightQuery = new FlightQuery();
            flightQuery.setData();
            final StringEntity entity = new StringEntity(flightQuery.toJson());
            httpPost.setEntity(entity);
            httpPost.setHeader("Accept", "application/json");
            httpPost.setHeader("Content-type", "application/json");
            try (CloseableHttpResponse response = httpclient.execute(httpPost)) {
                String responseBody = obtainResponseBody(response);
                return obtainFlightFromJson(responseBody);
            } catch (ParseException e) {
                throw new RuntimeException(e);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private String buildApiUrl(Location location) {
        return String.format("https://partners.api.skyscanner.net/apiservices/v3/flights/live/search/create",
                location.getLat(), location.getLongitude(), apiKey);
    }

    private String obtainResponseBody(CloseableHttpResponse response) throws IOException, ParseException {
        HttpEntity entity = response.getEntity();
        return EntityUtils.toString(entity);
    }

    private List<Flight> obtainFlightFromJson(String responseBody) {
        Gson gson = new Gson();
        JsonObject rateResponse = gson.fromJson(responseBody, JsonObject.class);
        JsonArray list = rateResponse.get("result").getAsJsonObject().get("rates").getAsJsonArray();
        List<Flight> rates = new ArrayList<>();
        list.forEach(jsonElement -> {
            JsonObject jsonObject = jsonElement.getAsJsonObject();
            processFlight(jsonObject, rates);
        });
        return rates;
    }

    private void processFlight(JsonObject jsonObject, List<Flight> flights) {
        double price = jsonObject.get("rate").getAsDouble();
        String platformName = jsonObject.get("name").getAsString();
        Flight flight = null;
        flights.add(flight);
    }
}
