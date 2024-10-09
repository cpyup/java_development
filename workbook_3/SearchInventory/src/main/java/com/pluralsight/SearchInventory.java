package com.pluralsight;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class SearchInventory {
    public static ArrayList<Product> inventory = new ArrayList<>();

    public static void main(String[] args) {
        getInventory("inventory.csv");
        sortInventory();
        runMenu();
    }

    public static void getInventory(String filePath) {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split("\\|");
                if (values.length == 3) {
                    int id = Integer.parseInt(values[0].trim());
                    String name = values[1].trim();
                    double price = Double.parseDouble(values[2].trim());
                    inventory.add(new Product(id, name, price));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void sortInventory() {
        inventory.sort(Comparator.comparing(Product::getName)); // Sort by product NAME
    }

    public static void printInventory() {
        for (Product product : inventory) {
            System.out.println(product);
        }
    }

    public static void runMenu() {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\nWhat do you want to do?");
            System.out.println("\t1- List all products");
            System.out.println("\t2- Lookup a product by its id");
            System.out.println("\t3- Find all products within a price range");
            System.out.println("\t4- Add a new product");
            System.out.println("\t5- Quit the application\n");
            System.out.print("Enter command: ");

            int command = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (command) {
                case 1 -> printInventory();
                case 2 -> lookupProductById(scanner);
                case 3 -> findProductsInPriceRange(scanner);
                case 4 -> addNewProduct(scanner);
                case 5 -> running = false;
                default -> System.out.println("Invalid command. Please try again.");
            }
        }
        scanner.close();
    }

    private static void lookupProductById(Scanner scanner) {
        System.out.print("\nEnter product ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        Product product = inventory.stream()
                .filter(p -> p.getId() == id)
                .findFirst()
                .orElse(null);

        if (product != null) {
            System.out.println("Found: " + product);
        } else {
            System.out.println("Product not found.");
        }
    }

    private static void findProductsInPriceRange(Scanner scanner) {
        System.out.print("\nEnter minimum price: ");
        double minPrice = scanner.nextDouble();
        System.out.print("Enter maximum price: ");
        double maxPrice = scanner.nextDouble();
        scanner.nextLine();

        ArrayList<Product> foundProducts = new ArrayList<>();
        for (Product product : inventory) {
            if (product.getPrice() >= minPrice && product.getPrice() <= maxPrice) {
                foundProducts.add(product);
            }
        }

        if (foundProducts.isEmpty()) {
            System.out.println("No products found in this price range.");
        } else {
            System.out.println("Products found in this price range:");
            for (Product product : foundProducts) {
                System.out.println(product);
            }
        }
    }

    private static void addNewProduct(Scanner scanner) {  // Only adds to array, not file, instructions did not specify
        System.out.print("\nEnter product ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter product name: ");
        String name = scanner.nextLine();
        System.out.print("Enter product price: ");
        double price = scanner.nextDouble();
        scanner.nextLine();

        inventory.add(new Product(id, name, price));
        sortInventory();
        System.out.println("Product added successfully.");
    }
}
