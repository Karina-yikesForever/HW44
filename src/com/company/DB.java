package com.company;

import com.sun.xml.internal.bind.v2.model.core.ID;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DB {
    private final String url = "jdbc:postgresql://localhost:5432/";
    private final String user = "postgres";
    private final String password = "55555555k";

    public Connection connect() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url, user, password);
            System.out.println("Connected to the PostegreSQL server successfully.");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return conn;
    }


    public List<City> printAllCities() throws SQLException {
        List<City> citiesList = new ArrayList<>();
        String SQL = "select count* from cities";
        try (Connection conn = connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(SQL)) {
            while (rs.next()) {
                City ci = new City();
                System.out.println(rs.getInt("ID") + " ");
                System.out.println(rs.getString("NAME") + " ");
                System.out.println(rs.next());
                citiesList.add(ci);
            }
        }
        return citiesList;
    }

    public void addCity(String name, int people_id) {
        String SQL = "INSERT INTO countries (name,people_id) values(?,?)";
        try (Connection conn = connect();
             PreparedStatement statement = conn.prepareStatement(SQL)) {
            statement.setString(1, name);
            statement.setInt(2, people_id);
            statement.executeUpdate();
            System.out.println("All okay");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<City> IfIdDouble() throws SQLException {
        List<City> citiesList = new ArrayList<>();
        String SQL = "select count* from cities where (id)=id";
        try (Connection conn = connect();
             PreparedStatement stmt = conn.prepareStatement(SQL)) {
            stmt.setInt(1, 1);
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    City ci = new City();
                    System.out.println(rs.getInt("ID") + " ");
                    System.out.println(rs.getString("NAME") + " ");
                    System.out.println(rs.next());
                    citiesList.add(ci);

                }
            }
            return citiesList;
        }
    }
}