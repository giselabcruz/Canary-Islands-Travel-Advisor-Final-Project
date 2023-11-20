package org.gisela.dacd.publisher.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public record WeatherRepositorySQLite(Connection connection) implements WeatherRepository {

    @Override
    public void saveWeatherData(Location location, Weather weather) {
        String islandName = location.getName();
        String insertSQL = "INSERT INTO table_" + islandName + "_weather (datetime, temperature, precipitation, " +
                "humidity, clouds, wind_speed) VALUES (?, ?, ?, ?, ?, ?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(insertSQL)) {
            preparedStatement.setString(1, weather.getTs().toString());
            preparedStatement.setDouble(2, weather.getTemperature());
            preparedStatement.setDouble(3, weather.getPrecipitation());
            preparedStatement.setDouble(4, weather.getHumidity());
            preparedStatement.setDouble(5, weather.getClouds());
            preparedStatement.setDouble(6, weather.getWindSpeed());
            preparedStatement.executeUpdate();
            System.out.println("Weather data inserted into the corresponding table.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
