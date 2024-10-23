package com.pluralsight;

import java.time.LocalTime;

public class Employee {
    private final String employeeId;
    private final String name;
    private final String department;
    private final double payRate;
    private int hoursWorked;
    private double startTime;

    public Employee(String employeeId, String name, String department, double payRate) {
        this.employeeId = employeeId;
        this.name = name;
        this.department = department;
        this.payRate = payRate;
        this.hoursWorked = 0;
        this.startTime = 0.0;
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

    public double getHoursWorked() {
        return hoursWorked;
    }

    public void setHoursWorked(double hours){
        this.hoursWorked = (int)hours;
    }

    public double getTotalPay(){
        return  (getOvertimeHours() * (payRate*1.5)) + (getRegularHours() * payRate);
    }

    public double getRegularHours(){
        return Math.min(hoursWorked, 40);
    }

    public double getOvertimeHours(){
        return Math.max(getHoursWorked() - getRegularHours(), 0);
    }

    public void punchTimeCard(double time){
        if(startTime > 0.0){
            setHoursWorked(getHoursWorked() + (time - startTime));
            startTime = 0.0;
        }else{
            startTime = time;
        }
    }

    public void punchTimeCard(){
        LocalTime currentTime = LocalTime.now();
        double hours = currentTime.getHour();
        double minutes = (currentTime.getMinute() / 60.0);
        punchTimeCard(hours+minutes);
    }
}
