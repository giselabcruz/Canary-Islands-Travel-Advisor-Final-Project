package Gisela_DACD.P1.controller;

import Gisela_DACD.P1.model.Location;
import Gisela_DACD.P1.model.Weather;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import org.apache.hc.client5.http.classic.methods.HttpGet;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.HttpClients;
import org.apache.hc.client5.http.impl.classic.CloseableHttpResponse;
import org.apache.hc.core5.http.HttpEntity;
import org.apache.hc.core5.http.ParseException;
import org.apache.hc.core5.http.io.entity.EntityUtils;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class OpenWeatherProvider implements WeatherProvider {
    private final String apiKey;
    public OpenWeatherProvider(String apiKey) {
        this.apiKey = apiKey;
    }
    @Override
    public List<Weather> getWeatherData(Location location) {
        String url = buildApiUrl(location);

        try (CloseableHttpClient httpclient = HttpClients.createDefault()) {
            HttpGet httpGet = new HttpGet(url);
            try (CloseableHttpResponse response = httpclient.execute(httpGet)) {
                String responseBody = obtainResponseBody(response);
                return obtainWeatherFromJson(responseBody, location);
            } catch (ParseException e) {
                throw new RuntimeException(e);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private String buildApiUrl(Location location) {
        return String.format("https://api.openweathermap.org/data/2.5/forecast?lat=%s&lon=%s&units=metric&appid=%s",
                location.getLat(), location.getLongitude(), apiKey);
    }

    private String obtainResponseBody(CloseableHttpResponse response) throws IOException, ParseException {
        HttpEntity entity = response.getEntity();
        return EntityUtils.toString(entity);
    }

    private List<Weather> obtainWeatherFromJson(String responseBody, Location location) {
        Gson gson = new Gson();
        JsonObject weatherResponse = gson.fromJson(responseBody, JsonObject.class);
        JsonArray list = weatherResponse.get("list").getAsJsonArray();
        List<Weather> weatherList = new ArrayList<>();

        for (JsonElement l : list) {
            JsonObject jsonObject = l.getAsJsonObject();
            long ts = jsonObject.get("dt").getAsLong();
            double temperature = jsonObject.get("main").getAsJsonObject().get("temp").getAsDouble();
            double humidity = jsonObject.get("main").getAsJsonObject().get("humidity").getAsDouble();
            double clouds = jsonObject.get("clouds").getAsJsonObject().get("all").getAsDouble();
            double windSpeed = jsonObject.get("wind").getAsJsonObject().get("speed").getAsDouble();
            double precipitation = 0.0;
            if (jsonObject.get("rain") != null) {
                precipitation = jsonObject.get("rain").getAsJsonObject().get("3h").getAsDouble();
            }
            Date date = new Date(ts * 1000);
            SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
            String formattedDate = dateFormat.format(date);
            if (formattedDate.equals("00:00:00")) {
                Weather weather = new Weather(humidity, temperature, precipitation, clouds, windSpeed, location,
                        date.toInstant());
                weatherList.add(weather);
            }
        }
        return weatherList;
    }
}
