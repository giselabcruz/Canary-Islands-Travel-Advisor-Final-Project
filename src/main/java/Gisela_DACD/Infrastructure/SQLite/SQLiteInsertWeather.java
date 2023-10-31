package Gisela_DACD.Infrastructure.SQLite;

import Gisela_DACD.P1Model.Weather;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SQLiteInsertWeather {
    public static void insert(String islandName, Weather weather, Connection connection) {

        Date date = new Date();
        double temperature = weather.getMainData().getTemp();
        double humidity = weather.getMainData().getHumidity();
        double clouds = weather.getClouds().getAllClouds();
        double windSpeed = weather.getWind().getSpeed();
        double precipitation = 0;

        if (weather.getRain() != null) {
            if (weather.getRain() != null) {
                precipitation = weather.getRain().getHour();
            }
        }

        try {
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
