package com.pluralsight;

import java.sql.*;

public class Application {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/northwind";
        String user = "root";
        String password = "P@ssw0rd";

        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            if (connection != null) {
                System.out.println("Connected to the database!");
                String query = "SELECT * FROM products";

                Statement statement = connection.createStatement();
                ResultSet results = statement.executeQuery(query);

                while(results.next()){
                    System.out.println(results.getString("ProductName"));
                }

            }
        } catch (SQLException e) {
            System.err.println("Connection error: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
