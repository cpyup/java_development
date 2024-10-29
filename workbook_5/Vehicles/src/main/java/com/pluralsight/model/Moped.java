package com.pluralsight.model;

public class Moped extends Vehicle {
    private int maxWeight;

    public Moped(String model, String color, int topSpeed, int fuelCapacity, int numberOfPassengers, int cargoCapacity, int maxWeight) {
        super(model, color, topSpeed, fuelCapacity, numberOfPassengers, cargoCapacity);
        this.maxWeight = maxWeight;
    }

    public int getMaxWeight() {
        return maxWeight;
    }

    public void setMaxWeight(int maxWeight) {
        this.maxWeight = maxWeight;
    }

    public void ride(){

    }
}
