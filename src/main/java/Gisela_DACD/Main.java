package Gisela_DACD;

import Gisela_DACD.P1Model.Island;
import Gisela_DACD.P1Model.WeatherData;
import com.google.gson.Gson;
import org.apache.hc.client5.http.classic.methods.HttpGet;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.CloseableHttpResponse;
import org.apache.hc.client5.http.impl.classic.HttpClients;
import org.apache.hc.core5.http.HttpEntity;
import org.apache.hc.core5.http.ParseException;
import org.apache.hc.core5.http.io.entity.EntityUtils;
import java.io.IOException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException, ParseException {
        String apiKey = "";
        ArrayList<Island> islands = new ArrayList<>() {
            {
                add(new Island("Gran Canaria", 28.0997, -15.4134));
//                add(new Island("Fuerteventura", 28.5004, -13.8627));
//                add(new Island("Lanzarote", 28.963, -13.5477));
//                add(new Island("La Graciosa", 29.255217, -13.504110));
//                add(new Island("Tenerife", 28.5392, -16.203));
//                add(new Island("La Gomera", 28.0916, -17.1133));
//                add(new Island("La Palma", 28.6835, -17.7642));
//                add(new Island("El Hierro", 27.8063, -17.9158));
            }
        };

        Gson gson = new Gson();

        for (Island island : islands) {
            String url = String.format("https://api.openweathermap.org/data/2.5/weather?lat=%s&lon=%s&units=metric&appid=%s",
                            island.getLat(), island.getLongitude(),apiKey);

            CloseableHttpClient httpclient = HttpClients.createDefault();
            HttpGet httpGet = new HttpGet(url);
            CloseableHttpResponse response = httpclient.execute(httpGet);
            HttpEntity entity = response.getEntity();
            String responseBody = EntityUtils.toString(entity);

            WeatherData weatherData = gson.fromJson(responseBody,WeatherData.class);


            System.out.println(weatherData.getWind().getSpeed());
            System.out.println(weatherData.getMainData().getTemp());
            System.out.println(weatherData.getMainData().getHumidity());
            System.out.println(weatherData.getClouds().getAllClouds());

            httpclient.close();
        }
    }

}
