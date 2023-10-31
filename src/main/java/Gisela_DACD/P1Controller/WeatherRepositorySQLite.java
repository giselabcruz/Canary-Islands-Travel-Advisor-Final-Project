package Gisela_DACD.P1Controller;

import Gisela_DACD.Infrastructure.SQLite.SQLiteConnector;
import Gisela_DACD.Infrastructure.SQLite.SQLiteInsertWeatherData;
import Gisela_DACD.P1Model.Island;
import Gisela_DACD.P1Model.Weather;

public class WeatherRepositorySQLite implements WeatherRepository {

    private final SQLiteConnector connector;

    public WeatherRepositorySQLite(SQLiteConnector connector) {
        this.connector = connector;
    }

    @Override
    public void saveWeatherData(Island island, Weather weather) {
        connector.createOrUpdateTable();
        SQLiteInsertWeatherData.insert(island.getName(), weather, connector.getConnection());
        connector.closeConnection();
    }
}