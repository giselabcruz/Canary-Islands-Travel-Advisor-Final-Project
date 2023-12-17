package org.gisela.dacd.sensorprovider.infrastructure;

import org.apache.hc.client5.http.classic.methods.HttpGet;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.CloseableHttpResponse;
import org.apache.hc.client5.http.impl.classic.HttpClients;
import org.apache.hc.core5.http.HttpEntity;
import org.apache.hc.core5.http.ParseException;
import org.apache.hc.core5.http.io.entity.EntityUtils;
import org.gisela.dacd.sensorprovider.application.HotelProvider;
import org.gisela.dacd.sensorprovider.domain.Hotel;
import java.io.IOException;
import java.util.List;

public class XoteloProvider implements HotelProvider {

    public XoteloProvider() {}

    @Override
    public List<Hotel> getHotelRates(String hotelKey) {
        String url = buildUrlApiRates(hotelKey);
        try (CloseableHttpClient httpclient = HttpClients.createDefault()) {
            HttpGet httpGet = new HttpGet(url);
            try (CloseableHttpResponse response = httpclient.execute(httpGet)) {
                String responseBody = obtainResponseBody(response);
                return obtainWeatherFromJson(responseBody, hotelKey);
            } catch (ParseException e) {
                throw new RuntimeException(e);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Hotel> getHotelHeatmap(String hotelKey) {
        String url = buildUrlApiHeatmap(hotelKey);
        try (CloseableHttpClient httpclient = HttpClients.createDefault()) {
            HttpGet httpGet = new HttpGet(url);
            try (CloseableHttpResponse response = httpclient.execute(httpGet)) {
                String responseBody = obtainResponseBody(response);
                return obtainWeatherFromJson(responseBody, hotelKey);
            } catch (ParseException e) {
                throw new RuntimeException(e);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private List<Hotel> obtainWeatherFromJson(String responseBody, String hotelKey) {
        return null;
    }

    private String obtainResponseBody(CloseableHttpResponse response) throws IOException, ParseException {
        HttpEntity entity = response.getEntity();
        return EntityUtils.toString(entity);
    }

    private String buildUrlApiRates(String hotelKey) {
        return String.format("https://data.xotelo.com/api/rates?hotel_key=%s&chk_in=%s&chk_out=%s&currency=EUR",
                hotelKey,"2023-12-25","2023-12-27");
    }

    private String buildUrlApiHeatmap(String hotelKey) {
        return String.format("https://data.xotelo.com/api/heatmap?hotel_key=%s&chk_out=%s",
                hotelKey,"2023-12-27");
    }
}
