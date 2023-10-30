package Gisela_DACD;

import Gisela_DACD.P1Model.*;
import io.github.cdimascio.dotenv.Dotenv;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Dotenv dotenv = Dotenv.configure().load();
        String apiKey = dotenv.get("OPEN_WEATHER_APIKEY");
        ArrayList<Island> islands = IslandProvider.initializeIslands();

        WeatherDataFetcher dataFetcher = new WeatherDataFetcher(apiKey);
        WeatherDataRepository dataSaver = new WeatherDataSaverInSQLite();

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