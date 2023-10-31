package Gisela_DACD.P1Controller;

import Gisela_DACD.Infrastructure.SQLite.SQLiteConnector;
import Gisela_DACD.Infrastructure.SQLite.SQLiteInsertWeather;
import Gisela_DACD.P1Model.Location;
import Gisela_DACD.P1Model.Weather;

public class WeatherRepositorySQLite implements WeatherRepository {

    private final SQLiteConnector connector;

    public WeatherRepositorySQLite(SQLiteConnector connector) {
        this.connector = connector;
    }

    @Override
    public void saveWeatherData(Location location, Weather weather) {
        connector.createOrUpdateTable();
        SQLiteInsertWeather.insert(location.getName(), weather, connector.getConnection());
        connector.closeConnection();
    }
}