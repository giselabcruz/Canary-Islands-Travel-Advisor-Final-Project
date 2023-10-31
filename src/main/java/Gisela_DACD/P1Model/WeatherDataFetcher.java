package Gisela_DACD.P1Model;

import com.google.gson.Gson;
import org.apache.hc.client5.http.classic.methods.HttpGet;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.HttpClients;
import org.apache.hc.client5.http.impl.classic.CloseableHttpResponse;
import org.apache.hc.core5.http.HttpEntity;
import org.apache.hc.core5.http.ParseException;
import org.apache.hc.core5.http.io.entity.EntityUtils;

import java.io.IOException;

public class WeatherDataFetcher implements WeatherDataProvider {

    private final String apiKey;

    public WeatherDataFetcher(String apiKey) {
        this.apiKey = apiKey;
    }

    @Override
    public WeatherDTO getWeatherData(Island island) {
        String url = String.format("https://api.openweathermap.org/data/2.5/forecast?lat=%s&lon=%s&units=metric&appid=%s",
                island.getLat(), island.getLongitude(), apiKey);

        try (CloseableHttpClient httpclient = HttpClients.createDefault()) {
            HttpGet httpGet = new HttpGet(url);
            try (CloseableHttpResponse response = httpclient.execute(httpGet)) {
                HttpEntity entity = response.getEntity();
                String responseBody = EntityUtils.toString(entity);
                Gson gson = new Gson();
                return gson.fromJson(responseBody, WeatherDTO.class);
            }
        } catch (IOException | ParseException e) {
            throw new RuntimeException(e);
        }
    }
}
