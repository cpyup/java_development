package com.pluralsight;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class PayrollCalculator {
    public static ArrayList<Employee> employees = new ArrayList<>();
    public static Scanner input = new Scanner(System.in);
    public static void main(String[] args) {
        String fileToLoad;
        System.out.println("Enter the name of the file to load:");
        fileToLoad = input.nextLine().trim();
        ReadCsv(fileToLoad);

        System.out.println("Enter the name of the file to write to:");
        fileToLoad = input.nextLine().trim();


        String extension = fileToLoad.split("\\.")[1];

        if(extension.equalsIgnoreCase("csv")){
            WriteCsv(fileToLoad);
        }else if(extension.equalsIgnoreCase("json")){
            WriteJson(fileToLoad);
        }else{
            System.out.println("Error With Output File Extension");
        }
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

    public static void WriteCsv(String fileName){
        try{
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(fileName));

            bufferedWriter.write("id|name|gross_pay");
            for (Employee thisEmployee : employees) {
                String newLine = String.format("%d|%s|%.2f\n",
                        thisEmployee.getEmployeeId(),
                        thisEmployee.getName(),
                        thisEmployee.getGrossPay());
                bufferedWriter.write(newLine);
            }
            bufferedWriter.close();
        }catch (Exception e){
            System.out.println("Error Writing File");
            e.printStackTrace();
        }
    }

    public static void WriteJson(String fileName) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(fileName))) {
            bufferedWriter.write("[\n");
            for (int i = 0; i < employees.size(); i++) {
                Employee thisEmployee = employees.get(i);

                String jsonEmployee = String.format(  // Formatting JSON output
                        """
                                  {
                                    "id": %d,
                                    "name": "%s",
                                    "gross_pay": %.2f
                                  }\
                                """,
                        thisEmployee.getEmployeeId(),
                        thisEmployee.getName(),
                        thisEmployee.getGrossPay()
                );
                bufferedWriter.write(jsonEmployee);

                if (i < employees.size() - 1) {
                    bufferedWriter.write(",\n");
                } else {
                    bufferedWriter.write("\n"); // End of last object
                }
            }
            bufferedWriter.write("]\n"); // End of JSON
        } catch (Exception e) {
            System.out.println("Error Writing JSON File");
            e.printStackTrace();
        }
    }
}
