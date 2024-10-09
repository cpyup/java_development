package com.pluralsight;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class SearchInventoryMap {
    static Map<String, Product> inventory = new HashMap<>();
    static final String path = "inventory.csv";

    public static void main(String[] args) {
        loadInventory();

        Scanner scanner = new Scanner(System.in);
        System.out.print("What item name are you interested in? ");
        String name = scanner.nextLine();
        Product matchedProduct = inventory.get(name);

        if (matchedProduct == null) {
            System.out.println("We don't carry that product");
            return;
        }

        System.out.printf("We carry %s and the price is $%.2f%n",
                matchedProduct.getName(), matchedProduct.getPrice());
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
                    inventory.put(name, product);
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading the inventory file: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.err.println("Error parsing a number: " + e.getMessage());
        }
    }
}
