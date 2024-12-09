package com.pluralsight.NothwindTradersSpringBoot4.model;

public class Product {
    private int productId;
    private String name;
    private int category;
    private double price;

    public Product(int productId, String name, int category, double price) {
        this.productId = productId;
        this.name = name;
        this.category = category;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productId=" + productId +
                ", name='" + name + '\'' +
                ", category='" + category + '\'' +
                ", price=" + price +
                '}';
    }

    public int getProductId() {
        return productId;
    }

    public String getName() {
        return name;
    }

    public int getCategory() {
        return category;
    }

    public double getPrice() {
        return price;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }
}
