package org.gisela.dacd.businessunit.infrastructure;

import org.gisela.dacd.businessunit.entity.Hotel;
import org.gisela.dacd.businessunit.service.HotelRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class HotelSqliteRepository implements HotelRepository {
    private static final String url = "jdbc:sqlite:datamart.db";

    @Override
    public void saveHotel(Hotel hotel) {
        String sql = "INSERT INTO hotel(name,location, platformName, price, checkIn, checkOut) VALUES(?,?,?,?,?,?)";
        try (Connection conn = DriverManager.getConnection(url);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, hotel.getName());
            pstmt.setString(2, hotel.getLocation());
            pstmt.setString(3, hotel.getPlatformName());
            pstmt.setDouble(4, hotel.getPrice());
            pstmt.setString(5, hotel.getCheckIn());
            pstmt.setString(6, hotel.getCheckOut());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public List<Hotel> getAllHotels() {
        List<Hotel> hotels = new ArrayList<>();
        String sql = "SELECT * FROM hotel";

        try (Connection conn = DriverManager.getConnection(url);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Hotel hotel = new Hotel(
                        rs.getString("name"),
                        rs.getString("location"),
                        rs.getDouble("price"),
                        rs.getString("platformName"),
                        rs.getString("checkIn"),
                        rs.getString("checkOut")
                );
                hotels.add(hotel);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return hotels;
    }

    @Override
    public List<Hotel> getHotelByLocation(String location) {
        List<Hotel> hotels = new ArrayList<>();
        String sql = "SELECT * FROM hotel WHERE location = ?";

        try (Connection conn = DriverManager.getConnection(url);
             PreparedStatement pstmt  = conn.prepareStatement(sql)){

            pstmt.setString(1, location);

            ResultSet rs  = pstmt.executeQuery();

            while (rs.next()) {
                Hotel hotel = new Hotel(
                        rs.getString("name"),
                        rs.getString("location"),
                        rs.getDouble("price"),
                        rs.getString("platformName"),
                        rs.getString("checkIn"),
                        rs.getString("checkOut")
                );
                hotels.add(hotel);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return hotels;
    }

    @Override
    public List<Hotel> getHotelByDate(String location, String checkIn, String checkOut) {
        List<Hotel> hotels = new ArrayList<>();
        String sql = "SELECT * FROM hotel WHERE location = ? AND checkIn = ? AND checkOut = ?";

        try (Connection conn = DriverManager.getConnection(url);
             PreparedStatement pstmt  = conn.prepareStatement(sql)){

            pstmt.setString(1, location);
            pstmt.setString(2, checkIn);
            pstmt.setString(3, checkOut);

            ResultSet rs  = pstmt.executeQuery();

            while (rs.next()) {
                Hotel hotel = new Hotel(
                        rs.getString("name"),
                        rs.getString("location"),
                        rs.getDouble("price"),
                        rs.getString("platformName"),
                        rs.getString("checkIn"),
                        rs.getString("checkOut")
                );
                hotels.add(hotel);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return hotels;
    }
}
