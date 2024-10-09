package com.pluralsight;

public class Product {
    private final int id;
    private final String name;
    private final double price;

    public Product(int id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public double getPrice(){
        return price;
    }

    @Override
    public String toString() {
        return "id: " + id + ", name: '" + name + "', price: " + price;
    }
}
