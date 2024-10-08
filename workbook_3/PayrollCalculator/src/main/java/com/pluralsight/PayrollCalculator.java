package com.pluralsight;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class PayrollCalculator {
    public static void main(String[] args) {
        ArrayList<Employee> employees = new ArrayList<>();

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("employees.csv"))) {
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

        for (Employee thisEmployee : employees) {
            System.out.printf("ID: %d, Name: %s, Hours Worked: %.2f, Pay Rate: %.2f\n",
                    thisEmployee.getEmployeeId(),
                    thisEmployee.getName(),
                    thisEmployee.getHoursWorked(),
                    thisEmployee.getPayRate());
        }
    }
}
