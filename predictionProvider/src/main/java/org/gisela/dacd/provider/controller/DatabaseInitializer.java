package org.gisela.dacd.provider.controller;

import org.gisela.dacd.provider.model.Location;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

public class DatabaseInitializer {
    public static void createWeatherTable(Connection connection, ArrayList<Location> locations) {
        try (connection) {
            for (Location location : locations) {
                String createTableSQL = "CREATE TABLE IF NOT EXISTS table_" + location.getName() + "_weather ("
                        + "id INTEGER PRIMARY KEY AUTOINCREMENT,"
                        + "datetime DATETIME,"
                        + "temperature REAL,"
                        + "precipitation REAL,"
                        + "humidity REAL,"
                        + "clouds REAL,"
                        + "wind_speed REAL"
                        + ")";
                try (PreparedStatement preparedStatement = connection.prepareStatement(createTableSQL)) {
                    preparedStatement.execute();
                    System.out.println("Table 'table_" + location.getName() + "_weather' created (or it exists) with specified columns.");
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
