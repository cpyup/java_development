package com.pluralsight.model;

public class SemiTruck extends Vehicle{
    private int numberOfTrailers;

    public SemiTruck(String model, String color, int topSpeed, int fuelCapacity, int numberOfPassengers, int cargoCapacity, int numberOfTrailers) {
        super(model, color, topSpeed, fuelCapacity, numberOfPassengers, cargoCapacity);
        this.numberOfTrailers = numberOfTrailers;
    }

    public int getNumberOfTrailers() {
        return numberOfTrailers;
    }

    public void setNumberOfTrailers(int numberOfTrailers) {
        this.numberOfTrailers = numberOfTrailers;
    }

    public void loadCargo(){

    }

    public void unloadCargo(){

    }
}
