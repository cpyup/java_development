package com.pluralsight;

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
            "10"};
    public static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        while (true){
            try{
                handleInput();
            }catch (Exception e){
                System.out.println("Invalid Input\n");
                handleInput();
            }
        }
    }

    public static void handleInput(){
        System.out.println("Enter a number (1-10) to display a quote\n");
        int selection = scanner.nextInt();
        System.out.println("\""+quoteList[selection-1]+"\"\n");
    }
}
