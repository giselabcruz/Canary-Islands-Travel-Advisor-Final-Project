package Gisela_DACD.Infrastructure.SQLite;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class SQLiteConnector {

    private Connection connection;

    public SQLiteConnector() throws SQLException {
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
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public void createOrUpdateTable() {
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

        for (String island : islands) {
            String createTableSQL = "CREATE TABLE IF NOT EXISTS table_" + island + "_weather ("
                    + island + "TEXT,"
                    + "datetime DATETIME,"
                    + "temperature REAL,"
                    + "precipitation REAL,"
                    + "humidity REAL,"
                    + "clouds REAL,"
                    + "wind_speed REAL"
                    + ")";

            try {
                assert connection != null;
                try (Statement statement = connection.createStatement()) {
                    statement.execute(createTableSQL);
                    System.out.println("Table 'table_" + island + "_weather' created (or it exists) with specify columns.");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
