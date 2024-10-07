package com.pluralsight;

import java.util.Random;
import java.util.Scanner;

public class FamousQuotes {
    public static final String[] quoteList = new String[]{
            "The only way to deal with an unfree world is to become so absolutely free that your very existence is an act of rebellion.",
            "2",
            "3",
            "4",
            "5",
            "6",
            "7",
            "8",
            "9",
            "10"
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
        System.out.println("Enter a number (1-10) to display a quote, R for a random quote, or E to exit\n");
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
