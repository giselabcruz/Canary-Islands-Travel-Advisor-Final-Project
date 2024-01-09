package org.gisela.dacd.businessunit.infrastructure;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class SQLiteConnector {

    private static final String URL = "jdbc:sqlite:datamart.db";
    public Connection connection;


    public Connection getConnection() {
        return connection;
    }
    public SQLiteConnector() {
        try {
            connection = DriverManager.getConnection("jdbc:sqlite:canary_islands_weather.db");
            System.out.println("Successful connection to SQLite database.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void createNewTable() {
        String sqlHotel = "CREATE TABLE IF NOT EXISTS hotel (\n"
                + " id INTEGER PRIMARY KEY AUTOINCREMENT,\n"
                + " name TEXT NOT NULL,\n"
                + " location TEXT NOT NULL,\n"
                + " platformName TEXT NOT NULL,\n"
                + " price REAL NOT NULL,\n"
                + " checkIn TEXT NOT NULL,\n"
                + " checkOut TEXT NOT NULL\n"
                + ");";

        String sqlWeather = "CREATE TABLE IF NOT EXISTS weather (\n"
                + " id INTEGER PRIMARY KEY,\n"
                + " location TEXT NOT NULL,\n"
                + " date TEXT NOT NULL,\n"
                + " precipitation REAL,\n"
                + " clouds REAL,\n"
                + " temperature REAL,\n"
                + " windSpeed REAL\n"
                + ");";

        try (Connection conn = DriverManager.getConnection(URL);
             Statement stmt = conn.createStatement()) {
            stmt.execute(sqlHotel);
            stmt.execute(sqlWeather);
            System.out.println("Table  weather created (or it exists) with specified columns.");
            System.out.println("Table  hotel created (or it exists) with specified columns.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void closeConnection() {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
                System.out.println("Connection to SQLite database closed.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
