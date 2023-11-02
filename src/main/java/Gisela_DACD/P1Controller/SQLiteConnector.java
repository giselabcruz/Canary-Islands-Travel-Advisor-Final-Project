package Gisela_DACD.P1Controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class SQLiteConnector {
    public Connection connection;

    public SQLiteConnector() throws SQLException {
        try {
            connection = DriverManager.getConnection("jdbc:sqlite:canary_islands_weather.db");
            System.out.println("Successful connection to SQLite database.");
        } catch (SQLException e) {
            e.printStackTrace();
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

    public Connection getConnection() {
        return connection;
    }

    public void createOrUpdateTable() throws SQLException {
        ArrayList<String> islands = new ArrayList<>() {
            {
                add("Gran_Canaria");
                add("Fuerteventura");
                add("Lanzarote");
                add("La_Graciosa");
                add("Tenerife");
                add("La_Gomera");
                add("La_Palma");
                add("El_Hierro");
            }
        };

        try (Connection conn = getConnection()) {
            for (String island : islands) {
                String createTableSQL = "CREATE TABLE IF NOT EXISTS table_" + island + "_weather ("
                        + "id INTEGER PRIMARY KEY AUTOINCREMENT,"
                        + "datetime DATETIME,"
                        + "temperature REAL,"
                        + "precipitation REAL,"
                        + "humidity REAL,"
                        + "clouds REAL,"
                        + "wind_speed REAL"
                        + ")";

                try (Statement statement = conn.createStatement()) {
                    statement.execute(createTableSQL);
                    System.out.println("Table 'table_" + island + "_weather' created (or it exists) with specified columns.");
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}