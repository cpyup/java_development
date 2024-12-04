package com.pluralsight.model;

public class SaleByYear {

    private String shippedDate;
    private int orderId;
    private double subtotal;
    private String year;

    public SaleByYear(String shippedDate, int orderId, double subtotal, String year) {
        this.shippedDate = shippedDate;
        this.orderId = orderId;
        this.subtotal = subtotal;
        this.year = year;
    }

    public String getShippedDate() {
        return shippedDate;
    }

    public int getOrderId() {
        return orderId;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public String getYear() {
        return year;
    }

    @Override
    public String toString() {
        return "SaleByYear{" +
                "shippedDate='" + shippedDate + '\'' +
                ", orderId=" + orderId +
                ", subtotal=" + subtotal +
                ", year='" + year + '\'' +
                '}';
    }
}
