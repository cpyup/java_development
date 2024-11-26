package com.pluralsight;

import java.sql.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        if (args.length != 2) {
            System.out.println("Application needs two arguments to run: " +
                    "java com.pluralsight.Main <username> <password>");
            System.exit(1);
        }

        String username = args[0];
        String password = args[1];

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("What do you want to do?");
            System.out.println("\t1) Display all products");
            System.out.println("\t2) Display all customers");
            System.out.println("\t3) Display all categories");
            System.out.println("\t0) Exit");
            int choice = getValidMenuChoice(scanner);

            switch (choice) {
                case 1 -> displayAllProducts(username, password);
                case 2 -> displayAllCustomers(username, password);
                case 3 -> displayAllCategories(username, password);
                case 0 -> {
                    System.out.println("Exiting...");
                    return;
                }
                default -> {
                }
            }
        }
    }

    private static int getValidMenuChoice(Scanner scanner) {
        int choice;
        while (true) {
            System.out.print("\nSelect an option: ");
            if (scanner.hasNextInt()) {
                choice = scanner.nextInt();
                if (choice >= 0 && choice <= 3) {
                    break;
                } else {
                    System.out.println("Invalid choice. Please enter a number between 0 and 3.");
                }
            } else {
                System.out.println("Invalid input. Please enter a valid number.");
                scanner.next();
            }
        }
        return choice;
    }

    private static void displayAllProducts(String username, String password) {
        try (Connection connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/northwind", username, password);
             PreparedStatement statement = connection.prepareStatement(
                     "SELECT ProductID, ProductName, UnitPrice, UnitsInStock FROM products");
             ResultSet results = statement.executeQuery()) {

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

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void displayAllCustomers(String username, String password) {
        try (Connection connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/northwind", username, password);
             PreparedStatement statement = connection.prepareStatement(
                     "SELECT ContactName, CompanyName, City, Country, Phone FROM Customers ORDER BY Country");
             ResultSet results = statement.executeQuery()) {

            while (results.next()) {
                String contactName = results.getString("ContactName");
                String companyName = results.getString("CompanyName");
                String city = results.getString("City");
                String country = results.getString("Country");
                String phone = results.getString("Phone");

                System.out.println("Contact Name: " + contactName);
                System.out.println("Company Name: " + companyName);
                System.out.println("City: " + city);
                System.out.println("Country: " + country);
                System.out.println("Phone: " + phone);
                System.out.println("-----------------------------------------");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void displayAllCategories(String username, String password) {
        try (Connection connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/northwind", username, password);
             PreparedStatement statement = connection.prepareStatement(
                     "SELECT CategoryID, CategoryName FROM Categories");
             ResultSet results = statement.executeQuery()) {

            while (results.next()) {
                int categoryId = results.getInt("CategoryID");
                String categoryName = results.getString("CategoryName");

                System.out.println("Category ID: " + categoryId);
                System.out.println("Category Name: " + categoryName);
                System.out.println("-----------------------------------------");
            }

            int categoryId = getValidCategoryId();

            displayProductsByCategory(username, password, categoryId);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void displayProductsByCategory(String username, String password, int categoryId) {
        try (Connection connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/northwind", username, password);
             PreparedStatement statement = connection.prepareStatement(
                     "SELECT ProductID, ProductName, UnitPrice, UnitsInStock FROM Products WHERE CategoryID = ?")) {

            statement.setInt(1, categoryId);
            try (ResultSet results = statement.executeQuery()) {

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
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static int getValidCategoryId() {
        Scanner scanner = new Scanner(System.in);
        int categoryId;
        while (true) {
            System.out.print("Enter a category ID to view products: ");
            if (scanner.hasNextInt()) {
                categoryId = scanner.nextInt();
                if (categoryId > 0) {
                    break;
                } else {
                    System.out.println("Invalid category ID. Please enter a positive number.");
                }
            } else {
                System.out.println("Invalid input. Please enter a valid number.");
                scanner.next();
            }
        }
        return categoryId;
    }
}
