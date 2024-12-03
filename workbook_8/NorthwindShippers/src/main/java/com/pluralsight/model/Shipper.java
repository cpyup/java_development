package com.pluralsight.model;

public class Shipper {
    private int shipperId;
    private String companyName;
    private String phoneNumber;

    public Shipper(int shipperId, String companyName, String phoneNumber) {
        this.shipperId = shipperId;
        this.companyName = companyName;
        this.phoneNumber = phoneNumber;
    }

    public Shipper(String companyName, String phoneNumber){
        this.shipperId = -1;
        this.companyName = companyName;
        this.phoneNumber = phoneNumber;
    }

    public int getShipperId() {
        return shipperId;
    }

    public String getCompanyName() {
        return companyName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    @Override
    public String toString() {
        return "Shipper{" +
                "shipperId=" + shipperId +
                ", companyName='" + companyName + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }
}
