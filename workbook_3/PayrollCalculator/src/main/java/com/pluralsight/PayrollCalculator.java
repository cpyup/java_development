package com.pluralsight;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class PayrollCalculator {
    public static ArrayList<Employee> employees = new ArrayList<>();
    public static Scanner input = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.println("Enter the name of the file to load");
        String fileToLoad = input.nextLine().trim();

        ReadCsv(fileToLoad);
        PrintCsv();
    }

    public static void ReadCsv(String fileName){
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))) {
            String lineOut;

            while ((lineOut = bufferedReader.readLine()) != null) {
                String[] parsedLine = lineOut.split("\\|");
                employees.add(new Employee(
                        Integer.parseInt(parsedLine[0]),
                        parsedLine[1],
                        Double.parseDouble(parsedLine[2]),
                        Double.parseDouble(parsedLine[3])
                ));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void PrintCsv(){
        try{
            for (Employee thisEmployee : employees) {
                System.out.printf("ID: %d, Name: %s, Hours Worked: %.2f, Gross Pay: %.2f\n",
                        thisEmployee.getEmployeeId(),
                        thisEmployee.getName(),
                        thisEmployee.getHoursWorked(),
                        thisEmployee.getGrossPay());
            }
        }catch (Exception e){
            System.out.println("Error Printing File");
        }
    }
}
