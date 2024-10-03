package com.pluralsight;

import java.util.Scanner;

public class CellPhoneApplication {
    public static void main(String[] args) {
        System.out.println("Phone #1:\n");
        CellPhone phone1 = InputPrompt();
        System.out.println("\nPhone #2:\n");
        CellPhone phone2 = InputPrompt(); // Creating a second instance of CellPhone

        display(phone1); // Display the first cell phone
        display(phone2); // Display the second cell phone

        System.out.println("\nDialing between the two phones\n");

        // Just to clarify, in the previous section I had already used the requested method for my output, hence printing from main rather than refactoring too much
        System.out.println(phone1.dial(phone2.getPhoneNumber()));
        System.out.println(phone2.dial(phone1.getPhoneNumber()));
    }

    public static CellPhone InputPrompt() {
        Scanner scanner = new Scanner(System.in);
        CellPhone phone = new CellPhone();

        System.out.print("Enter serial number (1000000 - 9999999): ");
        int serialNumber = scanner.nextInt();
        phone.setSerialNumber(serialNumber);

        scanner.nextLine(); // Clear the newline

        System.out.print("Enter model: ");
        String model = scanner.nextLine();
        phone.setModel(model);

        System.out.print("Enter carrier: ");
        String carrier = scanner.nextLine();
        phone.setCarrier(carrier);

        System.out.print("Enter phone number (format: xxx-xxx-xxxx): ");
        String phoneNumber = scanner.nextLine();
        phone.setPhoneNumber(phoneNumber);

        System.out.print("Enter owner: ");
        String owner = scanner.nextLine();
        phone.setOwner(owner);

        return phone;
    }

    public static void display(CellPhone phone) {
        System.out.println("\nCell Phone Details:");
        System.out.println("Serial Number: " + phone.getSerialNumber());
        System.out.println("Model: " + phone.getModel());
        System.out.println("Carrier: " + phone.getCarrier());
        System.out.println("Phone Number: " + phone.getPhoneNumber());
        System.out.println("Owner: " + phone.getOwner());
    }
}
