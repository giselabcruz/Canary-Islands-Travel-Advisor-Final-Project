package Gisela_DACD.Infrastructure.SQLite;

import Gisela_DACD.P1Model.Rain;
import Gisela_DACD.P1Model.WeatherDTO;
import Gisela_DACD.P1Model.WeatherDataFetcher;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class SQLiteInsertWeatherData {
    public  static void  insert(String islandName, WeatherDTO weatherDTO, Connection connection) {

        Date date = new Date();
        double temperature = weatherDTO.getMainData().getTemp();
        double precipitation = 0; //TODO Check Rain Class properties
        double humidity = weatherDTO.getMainData().getHumidity();
        double clouds = weatherDTO.getClouds().getAllClouds();
        double windSpeed = weatherDTO.getWind().getSpeed();
        double precipitation = 0;

        if (weatherDTO.getRain() != null) {
            if (weatherDTO.getRain() != null) {
                precipitation = weatherDTO.getRain().getHour();
            }
        }

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

            String insertSQL = "INSERT INTO table_" + islandName + "_weather (datetime, temperature, precipitation, " +
                    "humidity, clouds, wind_speed) VALUES (?, ?, ?, ?, ?, ?)";

            PreparedStatement preparedStatement = connection.prepareStatement(insertSQL);
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String formattedDate = dateFormat.format(date);

            preparedStatement.setString(1, formattedDate);
            preparedStatement.setDouble(2, temperature);
            preparedStatement.setDouble(3, precipitation);
            preparedStatement.setDouble(4, humidity);
            preparedStatement.setDouble(5, clouds);
            preparedStatement.setDouble(6, windSpeed);

            preparedStatement.executeUpdate();
            System.out.println("Weather data inserted into the corresponding table.");

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
