package com.pluralsight;

import java.util.Scanner;

public class FullNameApplication {
    public static String first,last,middle,suffix;
    public static void main(String[] args) {
        InputPrompt();
    }

    public static void InputPrompt(){
        Scanner input = new Scanner(System.in);

        System.out.println("Enter your first name (required)\n");
        first = input.nextLine().trim().toLowerCase();

        if(first.isBlank()){
            System.out.println("First Name Is Required\n");
            return;
        }

        System.out.println("Enter your last name (required)\n");
        last = input.nextLine().trim().toLowerCase();

        if(last.isBlank()){
            System.out.println("Last Name Is Required\n");
            return;
        }

        System.out.println("Enter your middle name (optional)\n");
        middle = input.nextLine().trim().toLowerCase();

        System.out.println("Enter suffix (optional)\n");
        suffix = input.nextLine().trim();

        ProcessInput();
    }

    public static void ProcessInput(){
        first = first.substring(0,1).toUpperCase() + first.substring(1,first.length());
        last = last.substring(0,1).toUpperCase() + last.substring(1,last.length());

        if(middle.isBlank()){
            middle = " ";
        }else{
            middle = " "+middle.substring(0,1).toUpperCase() + middle.substring(1,middle.length())+" ";

        }

        if(suffix.isBlank()){
            suffix = "";
        }else{
            suffix = ", "+suffix;

        }


        String fullName = first+middle+last+suffix;

        System.out.println(fullName);

    }
}
