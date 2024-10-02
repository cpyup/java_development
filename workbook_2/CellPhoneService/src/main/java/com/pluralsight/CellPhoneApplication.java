package com.pluralsight;

import java.util.Scanner;

public class CellPhoneApplication {
    public static void main(String[] args) {
        CellPhone newPhone = InputPrompt();
        DisplayOutput(newPhone);
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

    public static void DisplayOutput(CellPhone ourPhone) {
        System.out.println("\nCell Phone Details:");
        System.out.println("Serial Number: " + ourPhone.getSerialNumber());
        System.out.println("Model: " + ourPhone.getModel());
        System.out.println("Carrier: " + ourPhone.getCarrier());
        System.out.println("Phone Number: " + ourPhone.getPhoneNumber());
        System.out.println("Owner: " + ourPhone.getOwner());
    }
}
