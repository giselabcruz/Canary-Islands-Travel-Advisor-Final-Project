package org.gisela.dacd.eventstore.application;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class EventStoreManager implements EventStore {

    //TODO: Implement structure
    @Override
    public void storeEventToFile(String json) {
        try {
            Gson gson = new Gson();
            JsonObject jsonObject = gson.fromJson(json, JsonObject.class);
            File directory = createDirectory();
            File file = new File(directory, "data-lake");
            writeEventToDatalake(gson, jsonObject, file);
        } catch (IOException e) {
            handleError(e);
        }
    }

    private File createDirectory() throws IOException {
        String directoryPath = "datalake/cleansed";
        File directory = new File(directoryPath);
        if (!directory.exists() && !directory.mkdirs()) {
            throw new IOException("Error creating directory: " + directory.getAbsolutePath());
        }
        return directory;
    }

    private void writeEventToDatalake(Gson gson, JsonObject jsonObject, File file) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file, true))) {
            gson.toJson(jsonObject, writer);
            writer.newLine();
            System.out.println("Event stored successfully at: " + file.getAbsolutePath());
        }
    }

    private void handleError(Exception e) {
        System.err.println("Error handling event" + ": " + e.getMessage());
    }
}
