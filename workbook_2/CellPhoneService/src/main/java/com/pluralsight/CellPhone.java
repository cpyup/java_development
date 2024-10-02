package com.pluralsight;

public class CellPhone {
    private int serialNumber;
    private String model;
    private String carrier;
    private String phoneNumber;
    private String owner;

    // Parameterless constructor with default values
    public CellPhone() {
        this.serialNumber = 0;
        this.model = "";
        this.carrier = "";
        this.phoneNumber = "";
        this.owner = "";
    }

    // Getter and setter for serialNumber
    public int getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(int serialNumber) {
        if (serialNumber >= 1000000 && serialNumber <= 9999999) {
            this.serialNumber = serialNumber;
        } else {
            throw new IllegalArgumentException("Serial number must be between 1000000 and 9999999.");
        }
    }

    // Getter and setter for model
    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    // Getter and setter for carrier
    public String getCarrier() {
        return carrier;
    }

    public void setCarrier(String carrier) {
        this.carrier = carrier;
    }

    // Getter and setter for phoneNumber
    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    // Getter and setter for owner
    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }
}
