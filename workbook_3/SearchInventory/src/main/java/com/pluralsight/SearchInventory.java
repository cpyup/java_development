package com.pluralsight;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;

public class SearchInventory {
    public static ArrayList<Product> inventory = new ArrayList<>();

    public static void main(String[] args) {
        getInventory("inventory.csv");
        sortInventory();
        printInventory();
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
        inventory.sort(Comparator.comparingInt(Product::getId)); // Sort by product ID
    }

    public static void printInventory() {
        for (Product product : inventory) {
            System.out.println(product);
        }
    }
}
