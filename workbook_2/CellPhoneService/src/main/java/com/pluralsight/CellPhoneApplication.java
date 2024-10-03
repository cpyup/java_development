package com.pluralsight;

import java.util.Scanner;

public class CellPhoneApplication {
    public static void main(String[] args) {
        System.out.println("Phone #1:\n");
        CellPhone phone1 = InputPrompt();

        System.out.println("\nPhone #2:\n");
        CellPhone phone2 = InputPrompt(); // Creating a second instance of CellPhone

        // Display the first two cell phones
        display(phone1);
        display(phone2);

        // Creating a third phone using the overloaded constructor
        CellPhone phone3 = new CellPhone(7654321, "Samsung Galaxy", "AT&T", "555-5678", "Bob");
        display(phone3); // Display the third cell phone

        System.out.println("\nDialing between the phones:\n");
        System.out.println(phone1.dial(phone2.getPhoneNumber())); // Phone 1 dials Phone 2
        System.out.println(phone2.dial(phone1.getPhoneNumber())); // Phone 2 dials Phone 1
        System.out.println(phone1.dial(phone3.getPhoneNumber())); // Phone 1 dials Phone 3
        System.out.println(phone3.dial(phone1.getPhoneNumber())); // Phone 3 dials Phone 1
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
