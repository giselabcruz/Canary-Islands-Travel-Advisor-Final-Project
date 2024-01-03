package org.gisela.dacd.eventstore.application;

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

    @Override
    public void storeEventToFile(String json, String topicName) {
        try {
            Gson gson = new Gson();
            JsonObject jsonObject = gson.fromJson(json, JsonObject.class);
            String formattedTimestamp = getCurrentFormattedTimestamp();
            File directory = createDirectory(jsonObject,topicName);
            File file = new File(directory, formattedTimestamp + ".events");
            writeEventToFile(gson, jsonObject, file);
        } catch (IOException e) {
            handleError(e);
        }
    }

    private String getCurrentFormattedTimestamp() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");
        return Instant.now().atOffset(ZoneOffset.UTC).format(formatter);
    }

    private File createDirectory(JsonObject jsonObject, String topicName) throws IOException {
        String directoryPath = "eventstore/"+ topicName + "/" + getCleanedStringValue(jsonObject) + "/";
        File directory = new File(directoryPath);
        if (!directory.exists() && !directory.mkdirs()) {
            throw new IOException("Error creating directory: " + directory.getAbsolutePath());
        }
        return directory;
    }

    private void writeEventToFile(Gson gson, JsonObject jsonObject, File file) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file, true))) {
            gson.toJson(jsonObject, writer);
            writer.newLine();
            System.out.println("Event stored successfully at: " + file.getAbsolutePath());
        }
    }

    private String getCleanedStringValue(JsonObject jsonObject) {
        return jsonObject.get("ss").getAsString().replace("\"", "");
    }

    private void handleError(Exception e) {
        System.err.println("Error handling event" + ": " + e.getMessage());
    }
}
