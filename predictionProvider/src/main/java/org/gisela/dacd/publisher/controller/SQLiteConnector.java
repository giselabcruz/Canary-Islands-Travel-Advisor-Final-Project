package org.gisela.dacd.publisher.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class SQLiteConnector {

    public Connection connection;

    public SQLiteConnector() {
        try {
            connection = DriverManager.getConnection("jdbc:sqlite:canary_islands_weather.db");
            System.out.println("Successful connection to SQLite database.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Connection getConnection() {
        return connection;
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
