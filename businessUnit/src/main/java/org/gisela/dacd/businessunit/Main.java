package org.gisela.dacd.businessunit;

import com.sun.net.httpserver.HttpServer;
import org.gisela.dacd.businessunit.infrastructure.EventStoreHotelSqliteManager;
import org.gisela.dacd.businessunit.infrastructure.EventStoreWeatherSqliteManager;
import org.gisela.dacd.businessunit.infrastructure.SubscriberActiveMQ;
import org.gisela.dacd.businessunit.repository.HotelSqliteRepository;
import org.gisela.dacd.businessunit.repository.WeatherSqliteRepository;
import org.gisela.dacd.businessunit.service.EventStore;
import org.gisela.dacd.businessunit.service.Subscriber;
import org.gisela.dacd.businessunit.service.VacationRecommendationsHandler;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


public class Main {
    private static final String URL = "jdbc:sqlite:datamart.db";

    private static final String BROKER_URL = "tcp://localhost:61616";
    private static final String CLIENT_ID = "Gisela";
    private static final String PREDICTION_WEATHER_TOPIC = "prediction.Weather";
    private static final String HOTEL_TOPIC = "sensor.Hotel";
    private static final String SUBSCRIBER_ID = "Gisela";
    public static void main(String[] args) throws IOException {
        createNewTable();

        EventStore eventStoreWeatherManager = new EventStoreWeatherSqliteManager(new WeatherSqliteRepository());
        Subscriber subscriberWeather = new SubscriberActiveMQ(BROKER_URL,CLIENT_ID+"_Weather",
                SUBSCRIBER_ID+"_Weather", eventStoreWeatherManager);
        subscriberWeather.start();
        subscriberWeather.subscribe(PREDICTION_WEATHER_TOPIC);

        EventStore eventStoreHotelManager = new EventStoreHotelSqliteManager(new HotelSqliteRepository());
        Subscriber subscriberHotel = new SubscriberActiveMQ(BROKER_URL,CLIENT_ID+"_Hotel",
                SUBSCRIBER_ID+"_Hotel", eventStoreHotelManager);
        subscriberHotel.start();
        subscriberHotel.subscribe(HOTEL_TOPIC);

        int serverPort = 9090;
        HttpServer server = HttpServer.create(new InetSocketAddress(serverPort), 0);
        server.createContext("/api/vacation-recommendations",
                new VacationRecommendationsHandler(new HotelSqliteRepository(),new WeatherSqliteRepository())
        );
        server.setExecutor(null); // creates a default executor
        server.start();
    }

    public static void createNewTable() {
        // Sentencias SQL para crear nuevas tablas
        String sqlHotel = "CREATE TABLE IF NOT EXISTS hotel (\n"
                + " id INTEGER PRIMARY KEY AUTOINCREMENT,\n"
                + " name TEXT NOT NULL,\n"
                + " location TEXT NOT NULL,\n"
                + " platformName TEXT NOT NULL,\n"
                + " price REAL NOT NULL,\n"
                + " checkIn TEXT NOT NULL,\n"
                + " checkOut TEXT NOT NULL\n"
                + ");";


        String sqlWeather = "CREATE TABLE IF NOT EXISTS weather (\n"
                + " id INTEGER PRIMARY KEY,\n"
                + " location TEXT NOT NULL,\n"
                + " date TEXT NOT NULL,\n"
                + " precipitation REAL,\n"
                + " clouds REAL,\n"
                + " temperature REAL,\n"
                + " windSpeed REAL\n"
                + ");";

        try (Connection conn = DriverManager.getConnection(URL);
             Statement stmt = conn.createStatement()) {
            // Crear la tabla hotel
            stmt.execute(sqlHotel);
            // Crear la tabla weather
            stmt.execute(sqlWeather);
            System.out.println("Table  weather created (or it exists) with specified columns.");
            System.out.println("Table  hotel created (or it exists) with specified columns.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
