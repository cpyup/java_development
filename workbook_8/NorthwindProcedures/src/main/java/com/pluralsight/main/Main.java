package com.pluralsight.main;

import com.pluralsight.db.DataManager;
import com.pluralsight.model.CustomerOrderHistory;
import com.pluralsight.model.SaleByCategory;
import com.pluralsight.model.SaleByYear;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input;

        DataManager dataManager = new DataManager("jdbc:mysql://localhost:3306/northwind", "root", "P@ssw0rd");

        while(true){
            printMenu();
            input = scanner.nextLine();
            switch (input){
                case "1" -> searchCustomerHistory(scanner, dataManager);
                case "2" -> searchSalesByYear(scanner, dataManager);
                case "3" -> searchSalesByCat(scanner, dataManager);
                case "4" -> {
                    return;
                }
                default -> System.out.println("Invalid Input");
            }
        }
    }

    private static void searchCustomerHistory(Scanner scanner, DataManager dataManager){
        System.out.println("Enter a customer ID: ");
        String customerID = scanner.nextLine();

        List<CustomerOrderHistory> orderHistoryList = dataManager.searchCustomerOrderHistory(customerID);

        System.out.println("Customer Order History:");
        for (CustomerOrderHistory orderHistory : orderHistoryList) {
            System.out.println("Product Name: " + orderHistory.getProductName()
                    + ", Total Quantity: " + orderHistory.getTotalQuantity());
        }
    }

    private static void searchSalesByYear(Scanner scanner, DataManager dataManager){
        System.out.println("Enter start date (yyyy-mm-dd): ");
        String startDate = scanner.nextLine();
        System.out.println("Enter end date (yyyy-mm-dd): ");
        String endDate = scanner.nextLine();

        List<SaleByYear> salesByYearList = dataManager.searchSalesByYear(startDate, endDate);

        System.out.println("Sales by Year:");
        salesByYearList.forEach(System.out::println);
    }

    private static void searchSalesByCat(Scanner scanner, DataManager dataManager){
        System.out.println("Enter category name: ");
        String categoryName = scanner.nextLine();
        System.out.println("Enter year: ");
        String orderYear = scanner.nextLine();

        List<SaleByCategory> salesByCategoryList = dataManager.searchSalesByCategory(categoryName, orderYear);

        System.out.println("Sales by Category:");
        for (SaleByCategory saleByCategory : salesByCategoryList) {
            System.out.println("Category: " + saleByCategory.getCategoryName() + ", Total Sales: " + saleByCategory.getTotalSales());
        }
    }

    private static void printMenu(){
        System.out.println("\nMain Menu\nOptions:");
        System.out.println("\t1 - Search Customer History");
        System.out.println("\t2 - Search Sales By Year");
        System.out.println("\t3 - Search Sales By Category");
        System.out.println("\t4 - Exit");
    }
}
