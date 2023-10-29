package Gisela_DACD.P1Model.SQLite;

import Gisela_DACD.P1Model.WeatherData;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class SQLiteInsertWeatherData {
    public  static void  insert(String islandName, WeatherData weatherData, Connection connection) {

        Date date = new Date(); // Fecha y hora de subida de datos (puedes reemplazarlo con la fecha y hora real)
        double temperature = weatherData.getMainData().getTemp();
        double precipitation = 0; //TODO Check Rain Class properties
        double humidity = weatherData.getMainData().getHumidity();
        double clouds = weatherData.getClouds().getAllClouds();
        double windSpeed = weatherData.getWind().getSpeed();

        try {

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
            // Define la sentencia SQL de inserción
            String insertSQL = "INSERT INTO table_" + islandName + "_weather (datetime, temperature, precipitation, humidity, clouds, wind_speed) VALUES (?, ?, ?, ?, ?, ?)";

            // Prepara la sentencia SQL
            PreparedStatement preparedStatement = connection.prepareStatement(insertSQL);
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String formattedDate = dateFormat.format(date);

            // Establece los valores de los parámetros en la sentencia SQL
            preparedStatement.setString(1, formattedDate);
            preparedStatement.setDouble(2, temperature);
            preparedStatement.setDouble(3, precipitation);
            preparedStatement.setDouble(4, humidity);
            preparedStatement.setDouble(5, clouds);
            preparedStatement.setDouble(6, windSpeed);

            // Ejecuta la sentencia de inserción
            preparedStatement.executeUpdate();
            System.out.println("Datos meteorológicos insertados en la tabla correspondiente.");

            // Cierra la declaración
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
