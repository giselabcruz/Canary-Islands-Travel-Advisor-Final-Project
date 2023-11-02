package Gisela_DACD.P1Controller;

import Gisela_DACD.P1Model.Location;
import Gisela_DACD.P1Model.Weather;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class WeatherRepositorySQLite implements WeatherRepository {

    public final Connection connection;
    public WeatherRepositorySQLite(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void saveWeatherData(Location location, Weather weather) throws SQLException {

        String islandName = location.getName();

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
            String formattedDate = dateFormat.format(new Date(TimeUnit.SECONDS.toMillis(weather.getDt())));

            preparedStatement.setString(1, formattedDate);
            preparedStatement.setDouble(2, weather.getMainData().getTemp());
            preparedStatement.setDouble(3, precipitation);
            preparedStatement.setDouble(4, weather.getMainData().getHumidity());
            preparedStatement.setDouble(5, weather.getClouds().getAllClouds());
            preparedStatement.setDouble(6, weather.getWind().getSpeed());

            preparedStatement.executeUpdate();
            System.out.println("Weather data inserted into the corresponding table.");

            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}