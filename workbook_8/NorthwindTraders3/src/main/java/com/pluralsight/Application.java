package com.pluralsight;

import java.sql.*;
import java.util.Scanner;

public class Application {
    private static final Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        if (args.length != 2) {
            System.out.println(
                    "Application needs two arguments to run: " + "java com.hca.jdbc.UsingDriverManager <username> " +
                            "<password>");
            System.exit(1);
        }

        displayMenu(args);

    }

    private static void displayMenu(String[] args){
        while(true){
            System.out.println("What do you want to do?\n\t1) Display all products\n\t2) Display all customers\n\t0) Exit\nSelect an option:");
            String input = scanner.nextLine().trim();

            switch(input.toLowerCase()){
                case "1" -> displayAllProducts(args);
                case "2" -> displayAllCustomers(args);
                case "0" -> {
                    return;
                }
                default -> System.out.println("Invalid Input");
            }
        }
    }

    private static void displayAllProducts(String[] args){
        try {
            // get the username and password from the command line args
            String username = args[0];
            String password = args[1];

            // load the MySQL Driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // 1. open a connection to the database
            // use the database URL to point to the correct database
            Connection connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/northwind",
                    username,
                    password);

            // define your query with placeholders for parameters
            String query = "SELECT ProductID, ProductName, UnitPrice, UnitsInStock FROM products";

            // 2. Create a PreparedStatement
            PreparedStatement statement = connection.prepareStatement(query);

            // 3. Execute the PreparedStatement and obtain the ResultSet
            ResultSet results = statement.executeQuery();

            // process the results
            while (results.next()) {
                int productId = results.getInt("ProductID");
                String productName = results.getString("ProductName");
                double unitPrice = results.getDouble("UnitPrice");
                int unitsInStock = results.getInt("UnitsInStock");

                System.out.println("Product ID: " + productId);
                System.out.println("Product Name: " + productName);
                System.out.println("Unit Price: " + unitPrice);
                System.out.println("Units In Stock: " + unitsInStock);
                System.out.println("-----------------------------------------");
            }

            // 4. Close the connection and release resources
            results.close();
            statement.close();
            connection.close();

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    private static void displayAllCustomers(String[] args){
        try {
            // get the username and password from the command line args
            String username = args[0];
            String password = args[1];

            // load the MySQL Driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // 1. open a connection to the database
            // use the database URL to point to the correct database
            Connection connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/northwind",
                    username,
                    password);

            // define your query with placeholders for parameters
            String query = "SELECT ContactName, CompanyName, City, Country, Phone FROM customers ORDER BY Country";

            // 2. Create a PreparedStatement
            PreparedStatement statement = connection.prepareStatement(query);

            // 3. Execute the PreparedStatement and obtain the ResultSet
            ResultSet results = statement.executeQuery();

            // process the results
            while (results.next()) {
                String contactName = results.getString("ContactName");
                String companyName = results.getString("CompanyName");
                String city = results.getString("City");
                String country = results.getString("Country");
                String phone = results.getString("Phone");

                System.out.println("Contact: " + contactName);
                System.out.println("Company: " + companyName);
                System.out.println("City: " + city);
                System.out.println("Country: " + country);
                System.out.println("Phone Number: "+phone);
                System.out.println("-----------------------------------------");
            }

            // 4. Close the connection and release resources
            results.close();
            statement.close();
            connection.close();

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
}