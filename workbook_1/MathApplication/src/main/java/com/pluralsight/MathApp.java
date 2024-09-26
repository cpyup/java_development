package com.pluralsight;

public class MathApp {
    public static void main(String[] args) {
        SalaryComp();
        Cars();
        AreaOfCircle();
        SquareRoot();
        DistanceBetween();
        AbsoluteValue();
        RandomValue();
    }

    public static void SalaryComp(){
        int bobSalary = 1;
        int garySalary = 0;
        int highestSalary = Math.max(bobSalary,garySalary);

        System.out.println("The Highest Salary is "+highestSalary);
    }

    public static void Cars(){
        int carPrice = 0;
        int truckPrice = 1;
        int lowestPrice = Math.min(carPrice,truckPrice);

        System.out.println(lowestPrice+" is the lowest price");
    }

    public static void AreaOfCircle(){
        double radius = 7.25;
        double area = radius*radius*Math.PI;

        System.out.println(area);
    }

    public static void SquareRoot(){
        double targetValue = 5.0;
        double returnValue = Math.sqrt(targetValue);

        System.out.println(returnValue);
    }

    public static void DistanceBetween(){
        int x1 = 5;
        int y1 = 10;
        int x2 = 85;
        int y2 = 50;

        double distance = Math.sqrt(Math.pow(x2 - x1,2)+ Math.pow(y2-y1,2));

        System.out.println(distance);
    }

    public static void AbsoluteValue(){
        float negativeIn = -3.8f;
        float absOut = Math.abs(negativeIn);

        System.out.println(absOut);
    }

    public static void RandomValue(){
        double rng = Math.random();
        System.out.println(rng);
    }
}
