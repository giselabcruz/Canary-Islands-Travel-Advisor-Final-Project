package Gisela_DACD.P1Model;

import Gisela_DACD.Infrastructure.SQLite.SQLiteConnector;
import Gisela_DACD.Infrastructure.SQLite.SQLiteInsertWeatherData;

import java.sql.SQLException;

public class WeatherDataSaverInSQLite implements WeatherDataRepository {

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