package com.pluralsight;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class TheaterReservations {
    public static void main(String[] args) {
        GetInput();
    }

    public static void GetInput(){
        Scanner input = new Scanner(System.in);
        DateTimeFormatter format = DateTimeFormatter.ofPattern("MM/dd/yyyy");

        System.out.println("Enter your full name: ");
        String[] fullName = input.nextLine().trim().split(" ");

        System.out.println("Enter the date (MM/dd/yyyy): ");
        LocalDate dateIn = LocalDate.parse(input.nextLine(),format);

        System.out.println("Enter desired amount of tickets: ");
        int ticketCount = Integer.parseInt(input.nextLine());

        if(ticketCount > 1){
            System.out.println(ticketCount+" tickets reserved for "+ dateIn + " under " + fullName[1] + ", " + fullName[0]);
        }else{
            System.out.println("1 ticket reserved for "+ dateIn + " under " + fullName[1] + ", " + fullName[0]);
        }
    }
}
