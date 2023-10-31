package Gisela_DACD.P1Controller;

import Gisela_DACD.Infrastructure.SQLite.SQLiteConnector;
import Gisela_DACD.Infrastructure.SQLite.SQLiteInsertWeatherData;
import Gisela_DACD.P1Model.Island;
import Gisela_DACD.P1Model.Weather;

import java.sql.SQLException;

public class WeatherRepositorySQLite implements WeatherRepository {

    public WeatherDataSaverInSQLite() {

    }

    @Override
    public void saveWeatherData(Island island, WeatherDTO weatherDTO) {
        SQLiteConnector connector = null;
        try {
            connector = new SQLiteConnector();
            connector.createOrUpdateTable();
            SQLiteInsertWeatherData.insert(island.getName(), weatherDTO, connector.getConnection());
            connector.closeConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}