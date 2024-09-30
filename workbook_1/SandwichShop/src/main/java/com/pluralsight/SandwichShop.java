package com.pluralsight;

import java.util.Objects;
import java.util.Scanner;

public class SandwichShop {
    public static void main(String[] args) {
        GetInput();
    }

    public static void GetInput(){
        Scanner input = new Scanner(System.in);

        System.out.println("Size:\nEnter 1 for regular, 2 for large\n");
        int size = input.nextInt();

        System.out.println("\nEnter customer age");
        int age = input.nextInt();

        input.nextLine();  // Clear buffer before getting string

        // Convert string to bool (for loaded)
        System.out.println("\nLoaded? (yes/no)");
        String S_loaded = input.nextLine();

        boolean B_loaded = Objects.equals(S_loaded, "yes");


        Calculate(size,age,B_loaded);
    }

    public static void Calculate(int size, int age, boolean isLoaded){
        double baseCost;

        // Initial pricing
        switch (size){
            default:  // Regular
                baseCost = 5.45;
                if(isLoaded){baseCost += 1.0;}  // Loaded
                break;
            case 2:  // Large
                baseCost = 8.95;
                if(isLoaded){baseCost += 1.75;}  // Loaded
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
