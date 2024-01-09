package org.gisela.dacd.businessunit.repository;

import org.gisela.dacd.businessunit.entity.Weather;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class WeatherSqliteRepository  implements WeatherRepository{
    private static final String url = "jdbc:sqlite:datamart.db";

    @Override
    public void saveWeather(Weather weather) {
        String sql = "INSERT INTO weather(location,date, precipitation, clouds, temperature, windSpeed) VALUES(?,?,?,?,?,?)";

        try (Connection conn = DriverManager.getConnection(url);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, weather.getLocation());
            pstmt.setString(2, weather.getDate());
            pstmt.setDouble(3, weather.getPrecipitation());
            pstmt.setDouble(4, weather.getClouds());
            pstmt.setDouble(5, weather.getTemperature());
            pstmt.setDouble(6, weather.getWindSpeed());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public List<Weather> getAllWeather() {
        List<Weather> weathers = new ArrayList<>();
        String sql = "SELECT id,date, location, precipitation, clouds, temperature, windSpeed FROM weather";

        try (Connection conn = DriverManager.getConnection(url);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Weather weather = new Weather(
                        rs.getDouble("precipitation"),
                        rs.getString("date"),
                        rs.getDouble("clouds"),
                        rs.getDouble("temperature"),
                        rs.getDouble("windSpeed"),
                        rs.getString("location")
                );
                weathers.add(weather);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return weathers;
    }

    @Override
    public List<Weather> getWeatherByDate(Date date, String location) {
        String sql = "SELECT id, date,location, precipitation, clouds, temperature, windSpeed" +
                " FROM weather WHERE date = ? AND location = ?";
        List<Weather> weathers = new ArrayList<>();

        try (Connection conn = DriverManager.getConnection(url);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setDate(1, new java.sql.Date(date.getTime()));
            pstmt.setString(2, location);

            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    Weather weather = new Weather(
                            rs.getDouble("precipitation"),
                            rs.getString("date"),
                            rs.getDouble("clouds"),
                            rs.getDouble("temperature"),
                            rs.getDouble("windSpeed"),
                            rs.getString("location")
                    );
                    weathers.add(weather);
                }
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return weathers;
    }
    @Override
    public List<Weather> getWeatherByLocation(String location) {
        String sql = "SELECT id,date, location, precipitation, clouds, temperature, windSpeed FROM weather WHERE location = ?";
        List<Weather> weathers = new ArrayList<>();

        try (Connection conn = DriverManager.getConnection(url);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, location);

            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    Weather weather = new Weather(
                            rs.getDouble("precipitation"),
                            rs.getString("date"),
                            rs.getDouble("clouds"),
                            rs.getDouble("temperature"),
                            rs.getDouble("windSpeed"),
                            rs.getString("location")
                    );
                    weathers.add(weather);
                }
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return weathers;
    }
}
