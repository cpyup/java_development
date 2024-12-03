package com.pluralsight;

import com.pluralsight.db.DataManager;
import com.pluralsight.model.Shipper;
import org.apache.commons.dbcp2.BasicDataSource;

import java.util.List;
import java.util.Scanner;

public class Program {
    private static final int MAX_LENGTH_NAME = 40;
    private static final int MAX_LENGTH_PHONE = 24;
    public static void main(String[] args) {
        if (args.length != 2) {
            System.out.println("User and Password are needed!");
            System.exit(1);
        }

        String username = args[0];
        String password = args[1];

        BasicDataSource sakilaDataSource = new BasicDataSource();
        sakilaDataSource.setUrl("jdbc:mysql://localhost:3306/northwind");
        sakilaDataSource.setUsername(username);
        sakilaDataSource.setPassword(password);

        DataManager dataManager = new DataManager(sakilaDataSource);

        Scanner scanner = new Scanner(System.in);

        String name;
        String number;

        while (true) {
            System.out.println("Enter The Company Name:");

            String input = scanner.nextLine();

            if(input.length() > MAX_LENGTH_NAME){
                System.out.println("Max Name Length 40 Chars");
            }else{
                name = input.trim();
                break;
            }
        }

        while(true){
            System.out.println("Enter The Company Phone Number:");

            String input = scanner.nextLine();

            if(input.length() > MAX_LENGTH_PHONE){
                System.out.println("Max Phone Number Length 24 Chars");
            }else{
                number = input.trim();
                break;
            }
        }
        Shipper newShipper = new Shipper(name,number);

        dataManager.insertIntoWithGeneratedKeys(newShipper);

        List<Shipper> shippers = dataManager.getAllShippers();

        while(true){
            shippers.forEach(System.out::println);
            System.out.println("Enter Id Of Number To Change (1-3 Cannot Be Modified)");
            int selectedID = scanner.nextInt();
            scanner.nextLine();

            if(selectedID <= 3){
                System.out.println("Out Of Range, Select Another Shipper");
            }else{
                System.out.println("Enter The New Phone Number");
                String phoneNumber = scanner.nextLine();
                dataManager.updateRecord(phoneNumber,selectedID);
                break;
            }
        }

        shippers = dataManager.getAllShippers();

        while(true){
            for (int i = 0; i < shippers.size(); i++) {
                Shipper shipper = shippers.get(i);
                System.out.println((i+1)+" - "+shipper);
            }

            System.out.println("Select Entry To Delete (1-3 Cannot Be Removed)");
            int selectedShipper = scanner.nextInt() -1;
            scanner.nextLine();

            if(selectedShipper <= 2){
                System.out.println("Out Of Range, Select Another Shipper");
            }else{
                dataManager.deleteRecord(shippers.get(selectedShipper));
                break;
            }
        }

        shippers = dataManager.getAllShippers();
        shippers.forEach(System.out::println);


    }
}
