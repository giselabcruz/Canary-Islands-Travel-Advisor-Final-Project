package org.gisela.dacd.businessunit.repository;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import org.gisela.dacd.businessunit.entity.Hotel;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DatalakeFileRepository implements DatalakeRepository {
    @Override
    public List<Hotel> getHotelHistoricalData() throws IOException {
        List<Hotel> hotelList = new ArrayList<>();
        Gson gson = new Gson();
        try (BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\Gisela\\IdeaProjects\\P1_dataFromExternalSource_Openweathermap\\datalake\\eventstore\\sensor.Hotel\\hotel-provider\\20240109.events"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                JsonObject jsonObject = gson.fromJson(line, JsonObject.class);
                String name = jsonObject.get("name").getAsString();
                String checkIn = jsonObject.get("checkIn").getAsString();
                String checkOut= jsonObject.get("checkOut").getAsString();
                JsonArray list = jsonObject.get("rates").getAsJsonArray();
                String location = jsonObject.get("location").getAsJsonObject().get("name").getAsString();
                list.forEach(jsonElement -> {
                    JsonObject rate = jsonElement.getAsJsonObject();
                    double price = rate.get("price").getAsDouble();
                    String platformName = rate.get("platformName").getAsString();
                    hotelList.add(new Hotel(name, location, price, platformName, checkIn, checkOut));
                });
            }
        }
        return hotelList;
    }
}

