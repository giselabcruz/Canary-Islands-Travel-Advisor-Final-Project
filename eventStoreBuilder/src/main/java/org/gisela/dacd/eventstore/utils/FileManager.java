package org.gisela.dacd.eventstore.utils;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.Instant;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import static org.gisela.dacd.eventstore.infrastructure.SubscriberActiveMQ.handleError;

public class FileManager {

    public void storeEventToFile(String json) {
        Gson gson = new Gson();
        JsonObject jsonObject = gson.fromJson(json, JsonObject.class);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");
        String formattedTimestamp = Instant.now().atOffset(ZoneOffset.UTC).format(formatter);
        File directory = new File("eventstore/prediction.Weather/" + jsonObject.get("ss").getAsString()
                .replace("\"", "") + "/");
        if (!directory.exists() && !directory.mkdirs()) {
            handleError("Error creating directory: " + directory.getAbsolutePath());
            return;
        }
        File file = new File(directory, formattedTimestamp + ".events");
        try (FileWriter writer = new FileWriter(file); BufferedWriter bufferedWriter = new BufferedWriter(writer)) {
            gson.toJson(jsonObject, bufferedWriter);
            System.out.println("Event stored successfully at: " + file.getAbsolutePath());
        } catch (IOException e) {
            handleError("Error writing event to file: " + e.getMessage());
        }
    }
}
