package com.pluralsight.main;

import com.pluralsight.model.*;

public class Vehicles {
    public static void main(String[] args) {
        updateVehicleValues();
    }

    private static void updateVehicleValues(){
        Moped moped = new Moped("","",100,100,1,100,100);
        Car car = new Car("","",100,100,4,100,4);
        SemiTruck semiTruck = new SemiTruck("","",100,100,100,100,100);
        Hovercraft hovercraft = new Hovercraft("","",100,100,100,100,100);

        displayVehicles(moped,car,semiTruck,hovercraft);
    }

    private static void displayVehicles(Moped moped, Car car, SemiTruck semiTruck, Hovercraft hovercraft){
        System.out.println(moped.getMaxWeight());
        System.out.println(car.getNumberOfDoors());
        System.out.println(semiTruck.getNumberOfTrailers());
        System.out.println(hovercraft.getAirCushionPressure());
    }
}
