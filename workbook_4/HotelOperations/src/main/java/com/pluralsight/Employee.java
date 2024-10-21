package com.pluralsight;

public class Employee {
    private final String employeeId;
    private final String name;
    private final String department;
    private final double payRate;
    private final int hoursWorked;

    public Employee(String employeeId, String name, String department, double payRate, int hoursWorked) {
        this.employeeId = employeeId;
        this.name = name;
        this.department = department;
        this.payRate = payRate;
        this.hoursWorked = hoursWorked;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public String getName() {
        return name;
    }

    public String getDepartment() {
        return department;
    }

    public double getPayRate() {
        return payRate;
    }

    public int getHoursWorked() {
        return hoursWorked;
    }

    public double getTotalPay(){
        double total = (getOvertimeHours() * payRate) * 1.5;
        total += getRegularHours() * payRate;
        return total;
    }

    public int getRegularHours(){
        return Math.min(hoursWorked, 40);
    }

    public int getOvertimeHours(){
        return Math.max(getHoursWorked() - getRegularHours(), 0);
    }
}
