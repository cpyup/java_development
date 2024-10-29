package com.pluralsight.model;

import java.time.LocalDate;

public class Vehicle extends Asset{
    private String makeModel;
    private int year;
    private int odometer;

    public Vehicle(String description, String dateAcquired, double originalCost, String makeModel, int year, int odometer) {
        super(description, dateAcquired, originalCost);
        this.makeModel = makeModel;
        this.year = year;
        this.odometer = odometer;
    }

    public String getMakeModel() {
        return makeModel;
    }

    public void setMakeModel(String makeModel) {
        this.makeModel = makeModel;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getOdometer() {
        return odometer;
    }

    public void setOdometer(int odometer) {
        this.odometer = odometer;
    }

    @Override
    public double getValue() {
        if(year > 10){
            return calculateValue(100);
        }else if(year >= 7){
            return calculateValue(.08);
        }else if(year >= 4){
            return calculateValue(.06);
        }else{
            return calculateValue(.03);
        }
    }

    private double calculateValue(double reductionPercentage){
        int currentYear = LocalDate.now().getYear();
        double total;
        if(reductionPercentage == 100){
            total = super.getValue() - 1000;
        }else{
            total = super.getValue() - ((super.getValue() * reductionPercentage) * currentYear);
        }
        if(odometer > 100000){
            total = total - (total * .25);
        }
        return total;
    }
}
