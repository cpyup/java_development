package com.pluralsight.model;

public class SaleByCategory {

    private String productName;
    private double totalSales;

    public SaleByCategory(String categoryName, double totalSales) {
        this.productName = categoryName;
        this.totalSales = totalSales;
    }

    public String getCategoryName() {
        return productName;
    }

    public double getTotalSales() {
        return totalSales;
    }

    @Override
    public String toString() {
        return "SaleByCategory{" +
                "productName='" + productName + '\'' +
                ", totalSales=" + totalSales +
                '}';
    }
}
