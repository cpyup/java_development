package com.pluralsight;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class SearchInventoryMap {
    static Map<Integer, Product> inventory = new HashMap<>();
    static final String path = "inventory.csv";

    public static void main(String[] args) {
        loadInventory();

        Scanner scanner = new Scanner(System.in);
        boolean continueSearching = true;

        while (continueSearching) {
            System.out.print("What item ID are you interested in? ");
            String input = scanner.nextLine().trim();
            int id;

            try {
                id = Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid ID.");
                continue;
            }

            Product matchedProduct = inventory.get(id);

            if (matchedProduct == null) {
                System.out.println("We don't carry that product.");
            } else {
                System.out.printf("ID #%d =  %s, Price: $%.2f%n",
                        matchedProduct.getId(),matchedProduct.getName(), matchedProduct.getPrice());
            }

            System.out.print("Do you want to search again? (yes/no): ");
            String response = scanner.nextLine().trim().toLowerCase();
            if (!response.equals("yes")) {
                continueSearching = false;
            }
        }
        System.out.println("Goodbye!");

    }

    static void loadInventory() {
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split("\\|");
                if (parts.length == 3) {
                    int id = Integer.parseInt(parts[0].trim());
                    String name = parts[1].trim();
                    float price = Float.parseFloat(parts[2].trim());
                    Product product = new Product(id, name, price);
                    inventory.put(id, product);
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading the inventory file: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.err.println("Error parsing a number: " + e.getMessage());
        }
    }
}
