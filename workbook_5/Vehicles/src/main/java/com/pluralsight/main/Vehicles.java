package com.pluralsight.main;

import com.pluralsight.model.*;

import java.util.ArrayList;
import java.util.List;

public class Vehicles {
    private static List<Vehicle> myVehicles;
    public static void main(String[] args) {
        setupTestingList();
        updateVehicleValues();
    }

    private static void setupTestingList(){
        myVehicles = new ArrayList<>();
        myVehicles.add(new Moped());
        myVehicles.add(new Car());
        myVehicles.add(new SemiTruck());
        myVehicles.add(new Hovercraft());
    }

    private static void updateVehicleValues(){
        myVehicles.forEach(vehicle -> vehicle.setColor("Blue"));
        myVehicles.forEach(vehicle -> vehicle.setModel("Test"));
        myVehicles.forEach(vehicle -> vehicle.setTopSpeed(100));
        myVehicles.forEach(vehicle -> vehicle.setFuelCapacity(100));

        Moped moped = (Moped) myVehicles.get(0);
        moped.setMaxWeight(100);
        Car car = (Car) myVehicles.get(1);
        car.setNumberOfDoors(4);
        SemiTruck semiTruck = (SemiTruck) myVehicles.get(2);
        semiTruck.setNumberOfTrailers(2);
        Hovercraft hovercraft = (Hovercraft) myVehicles.get(3);
        hovercraft.setAirCushionPressure(100);
        
        displayVehicles(moped,car,semiTruck,hovercraft);
    }

    private static void displayVehicles(Moped moped, Car car, SemiTruck semiTruck, Hovercraft hovercraft){
        System.out.println(moped.getMaxWeight());
        System.out.println(car.getNumberOfDoors());
        System.out.println(semiTruck.getNumberOfTrailers());
        System.out.println(hovercraft.getAirCushionPressure());
    }
}
