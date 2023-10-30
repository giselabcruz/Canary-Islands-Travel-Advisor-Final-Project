package Gisela_DACD;

import Gisela_DACD.P1Model.*;
import io.github.cdimascio.dotenv.Dotenv;
import org.apache.hc.client5.http.classic.methods.HttpGet;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.CloseableHttpResponse;
import org.apache.hc.client5.http.impl.classic.HttpClients;
import org.apache.hc.core5.http.HttpEntity;
import org.apache.hc.core5.http.ParseException;
import org.apache.hc.core5.http.io.entity.EntityUtils;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Dotenv dotenv = Dotenv.configure().load();
        String apiKey = dotenv.get("OPEN_WEATHER_APIKEY");
        ArrayList<Island> islands = IslandProvider.initializeIslands();

        for (Island island : islands) {
            String url = String.format("https://api.openweathermap.org/data/2.5/weather?lat=%s&lon=%s&units=metric&appid=%s",
                            island.getLat(), island.getLongitude(),apiKey);

            CloseableHttpClient httpclient = HttpClients.createDefault();
            HttpGet httpGet = new HttpGet(url);
            CloseableHttpResponse response = httpclient.execute(httpGet);
            HttpEntity entity = response.getEntity();
            String responseBody = EntityUtils.toString(entity);

            WeatherData weatherData = gson.fromJson(responseBody,WeatherData.class);

            httpclient.close();
            SQLiteConnector connector = null;
            try {
                connector = new SQLiteConnector();
                connector.createOrUpdateTable();

                SQLiteInsertWeatherData.insert(island.getName(),weatherData, connector.getConnection());

                connector.closeConnection();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }
}