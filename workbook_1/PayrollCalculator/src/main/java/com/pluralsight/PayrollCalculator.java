package com.pluralsight;

import java.util.Scanner;

public class PayrollCalculator {
    public static void main(String[] args) {
        GetInput();
    }

    public static void GetInput(){
        Scanner input = new Scanner(System.in);

        System.out.println("Enter Name");
        String name = input.nextLine();

        System.out.println("\nEnter Hours Worked");
        double hoursWorked = input.nextDouble();

        System.out.println("\nEnter Pay Rate");
        double payRate = input.nextDouble();

        input.close();

        DisplayOutput(name,hoursWorked,payRate);

    }

    public static void DisplayOutput(String name, double hours, double rate){
        double grossPay;

        if(hours > 40){
            grossPay = ((hours - 40) * (rate * 1.5)) + (40 * rate);
        }else{
            grossPay = hours*rate;
        }
        String gross = String.format("%.2f",grossPay);
        System.out.println("\nEmployee: "+name+"\nGross Pay: $"+gross);
    }
}
