package com.pluralsight;

import java.util.Random;
import java.util.Scanner;

public class FamousQuotes {
    public static final String[] quoteList = new String[]{
            "The only way to deal with an unfree world is to become so absolutely free that your very existence is an act of rebellion.",
            "If you are going through hell, keep going.",
            "The smallest minority on earth is the individual. Those who deny individual rights cannot claim to be defenders of minorities.",
            "If you are distressed by anything external, the pain is not due to the thing itself, but to your estimate of it; and this you have the power to revoke at any moment.",
            "Death is nothing to us. When we exist, death is not; and when death exists, we are not.",
            "The struggle itself toward the heights is enough to fill a man's heart. One must imagine Sisyphus happy.",
            "The individual has always had to struggle to keep from being overwhelmed by the tribe. If you try it, you will be lonely often, and sometimes frightened. But no price is too high to pay for the privilege of owning yourself.",
            "There is nothing in the desert, and no man needs nothing.",
            "The higher we soar the smaller we appear to those who cannot fly.",
            "I write differently from what I speak, I speak differently from what I think, I think differently from the way I ought to think, and so it all proceeds into deepest darkness."
    };
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            try {
                if (!handleInput()) {
                    break;
                }
            } catch (Exception e) {
                System.out.println("Invalid Input\n");
            }
        }
    }

    public static Boolean handleInput() {
        System.out.println("Enter a number (1-"+quoteList.length+") to display a quote, R for a random quote, or E to exit\n");
        String selection = scanner.nextLine().trim();

        switch (selection) {
            case "R", "r" -> {
                Random random = new Random();
                int randomIndex = random.nextInt(quoteList.length);
                System.out.println("\"" + quoteList[randomIndex] + "\"\n");
                return true;
            }
            case "E", "e" -> {
                return false;
            }
            default -> {
                try {
                    int index = Integer.parseInt(selection);
                    if (index < 1 || index > quoteList.length) {
                        System.out.println("Please enter a number between 1 and " + quoteList.length + ".\n");
                    } else {
                        System.out.println("\"" + quoteList[index - 1] + "\"\n");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Please enter a valid number, R, or E.\n");
                }
                return true;
            }
        }
    }
}
