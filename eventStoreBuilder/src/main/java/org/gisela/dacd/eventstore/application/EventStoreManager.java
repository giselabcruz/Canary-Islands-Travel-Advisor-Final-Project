package org.gisela.dacd.eventstore.application;

import static org.gisela.dacd.eventstore.infrastructure.SubscriberActiveMQ.handleError;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.Instant;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;

public class EventStoreManager implements EventStore {
    // TODO: Changed name to EventStoreManager
    // TODO: Changed to interface

    @Override
    public void storeEventToFile(String json) {
        // TODO: clean code
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
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file, true))) {
            gson.toJson(jsonObject, writer);
            writer.newLine();
            System.out.println("Event stored successfully at: " + file.getAbsolutePath());
        } catch (IOException e) {
            handleError("Error writing event to file: " + e.getMessage());
        }
    }
}
