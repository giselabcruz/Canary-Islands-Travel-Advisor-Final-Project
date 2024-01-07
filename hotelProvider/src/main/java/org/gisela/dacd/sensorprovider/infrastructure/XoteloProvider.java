package org.gisela.dacd.sensorprovider.infrastructure;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import org.apache.hc.client5.http.classic.methods.HttpGet;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.CloseableHttpResponse;
import org.apache.hc.client5.http.impl.classic.HttpClients;
import org.apache.hc.core5.http.HttpEntity;
import org.apache.hc.core5.http.ParseException;
import org.apache.hc.core5.http.io.entity.EntityUtils;
import org.gisela.dacd.sensorprovider.application.HotelProvider;
import org.gisela.dacd.sensorprovider.domain.Rate;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class XoteloProvider implements HotelProvider {

    public XoteloProvider() {}

    @Override
    public List<Rate> getHotelRates(String hotelKey) {
        String url = buildUrlApiRates(hotelKey);
        try (CloseableHttpClient httpclient = HttpClients.createDefault()) {
            HttpGet httpGet = new HttpGet(url);
            try (CloseableHttpResponse response = httpclient.execute(httpGet)) {
                String responseBody = obtainResponseBody(response);
                return obtainRatesFromJson(responseBody);
            } catch (ParseException e) {
                throw new RuntimeException(e);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private List<Rate> obtainRatesFromJson(String responseBody) {
        Gson gson = new Gson();
        JsonObject rateResponse = gson.fromJson(responseBody, JsonObject.class);
        JsonArray list = rateResponse.get("result").getAsJsonObject().get("rates").getAsJsonArray();
        List<Rate> rates = new ArrayList<>();
        list.forEach(jsonElement -> {
            JsonObject jsonObject = jsonElement.getAsJsonObject();
            processRate(jsonObject, rates);
        });
        return rates;
    }

    private void processRate(JsonObject jsonObject, List<Rate> rates) {
        double price = jsonObject.get("rate").getAsDouble();
        String platformName = jsonObject.get("name").getAsString();
        Rate rate = new Rate(price,platformName);
        rates.add(rate);
    }

    private String obtainResponseBody(CloseableHttpResponse response) throws IOException, ParseException {
        HttpEntity entity = response.getEntity();
        return EntityUtils.toString(entity);
    }

    private String buildUrlApiRates(String hotelKey) {
        return String.format("https://data.xotelo.com/api/rates?hotel_key=%s&chk_in=%s&chk_out=%s&currency=EUR",
                hotelKey,"2024-01-08","2024-01-15"); //TODO: implement a solution for dates
    }

}
