package com.pluralsight;

import java.util.Scanner;

public class SandwichShop {
    public static void main(String[] args) {
        GetInput();
    }

    public static void GetInput(){
        Scanner input = new Scanner(System.in);

        System.out.println("Size:\nEnter 0 for regular, 1 for large\n");
        int size = input.nextInt();

        System.out.println("\nEnter customer age");
        int age = input.nextInt();

        Calculate(size,age);
    }

    public static void Calculate(int size, int age){
        double baseCost;

        // Initial pricing
        switch (size){
            default:  // Regular
                baseCost = 5.45;
                break;
            case 2:  // Large
                baseCost = 8.95;
                break;
        }

        int discount;

        // Age based discounts
        if(age > 17 && age < 65){  // No age discounts
            DisplayOutput(baseCost);
            return;
        }

        if(age <= 17){  // 10-20% discount
            discount = 10;
        }else{
            discount = 20;
        }

        DisplayOutput(baseCost - ((baseCost*discount)/100));
    }

    public static void DisplayOutput(double cost){
        System.out.println("Total Cost: $"+ String.format("%.2f",cost));
    }
}
