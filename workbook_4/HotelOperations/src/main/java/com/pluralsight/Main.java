package com.pluralsight;

import java.util.ArrayList;

public class Main {
    private static final ArrayList<Room> TESTING_ROOMS = new ArrayList<>();
    private static final ArrayList<Employee> TESTING_EMPLOYEES = new ArrayList<>();
    private static final ArrayList<Reservation> TESTING_RESERVATIONS = new ArrayList<>();
    private static final ArrayList<Hotel> TESTING_HOTELS = new ArrayList<>();
    public static void main(String[] args) {
        setupTestingValues();
        displayTestingValues();
        testEmployeePunch();
        testRoomActions();
        testHotelActions();
    }

    private static void displayTestingValues(){
        System.out.println("\n====================================Testing Room Values");
        TESTING_ROOMS.forEach(Main::displayRoomValues);
        System.out.println("\n====================================Testing Employee Values");
        TESTING_EMPLOYEES.forEach(Main::displayEmployeeValues);
        System.out.println("\n====================================Testing Reservation Values");
        TESTING_RESERVATIONS.forEach(Main::displayReservationValues);
    }

    private static void setupTestingValues(){
        TESTING_ROOMS.add(new Room (2,124.0));
        TESTING_ROOMS.add(new Room (1, 124.0));

        TESTING_EMPLOYEES.add(new Employee("ABC123","Joe","Kitchen",15.0));
        TESTING_EMPLOYEES.add(new Employee("DEF456","George","Maintenance",15.0));
        TESTING_EMPLOYEES.add(new Employee("GHI789", "Sue", "Clerk", 15.0));

        TESTING_RESERVATIONS.add(new Reservation(false,2,true));
        TESTING_RESERVATIONS.add(new Reservation(true, 3,false));

        TESTING_HOTELS.add(new Hotel(20,20));
        TESTING_HOTELS.add(new Hotel(20,20,20,10));
    }

    private static void displayRoomValues(Room room){
        System.out.println("\nNumber Of Beds: "+room.getNumberOfBeds());
        System.out.println("Room Price: "+room.getPrice());
        System.out.println("Is Occupied: "+(room.isOccupied() ? "Yes" : "No"));
        System.out.println("Is Dirty: "+(room.isDirty() ? "Yes" : "No"));
        System.out.println("Is Available: "+(room.isAvailable() ? "Yes" : "No"));
    }

    private static void displayEmployeeValues(Employee employee){
        System.out.println("\nEmployee ID: "+employee.getEmployeeId());
        System.out.println("Employee Name: "+employee.getName());
        System.out.println("Employee Department: "+employee.getDepartment());
        System.out.println("Employee Pay Rate: "+employee.getPayRate());
        System.out.println("Employee Total Hours: "+employee.getHoursWorked());
        System.out.println("Employee Regular Hours: "+employee.getRegularHours());
        System.out.println("Employee Overtime Hours: "+employee.getOvertimeHours());
        System.out.println("Employee Total Pay: "+employee.getTotalPay());
    }

    private static void displayReservationValues(Reservation reservation){
        System.out.println("\nRoom Type: "+(reservation.getRoomType() ? "King" : "Double"));
        System.out.println("Number Of Nights: "+reservation.getNumberOfNights());
        System.out.println("Is Weekend: "+(reservation.isWeekend() ? "Yes" : "No"));
        System.out.println("Base Price: "+reservation.getPrice());
        System.out.println("Total Price: "+reservation.getReservationTotal());
    }

    private static void testEmployeePunch(){
        System.out.println("\n====================================Employee Punch Test");
        Employee testEmployee = TESTING_EMPLOYEES.get(0);
        System.out.println("\nEmployee: "+testEmployee.getName()+"\nHours Worked: "+testEmployee.getHoursWorked());
        testEmployee.punchTimeCard(10.00);
        System.out.println("Clocked In At: 10:00am");
        testEmployee.punchTimeCard(20.00);
        System.out.println("Clocked Out At: 8:00pm\nTotal Hours Worked: "+testEmployee.getHoursWorked());
        testEmployee.punchTimeCard(10.00);
        testEmployee.punchTimeCard();
        System.out.println("\nOverload Test\nTotal Hours Worked: "+testEmployee.getHoursWorked());
    }

    private static void testRoomActions(){
        Room testRoom = TESTING_ROOMS.get(0);
        System.out.println("\n====================================Room Action Testing");
        for(int i =0; i < 5; i++){
            displayTestRoom(testRoom);
            switch (i) {
                case 0 -> {testRoom.checkIn();
                    System.out.println("\n======================Check In");
                }
                case 1 -> {testRoom.checkOut();
                    System.out.println("\n======================Check Out");
                }
                case 2 -> {testRoom.cleanRoom();
                    System.out.println("\n======================Clean Room");
                }
                default -> {
                    return;
                }
            }
        }
    }

    private static void displayTestRoom(Room room){
        System.out.println("\nTesting Room: "+(room.isAvailable() ? "Is " : "Not ")+"Available");
        System.out.println("Occupied: "+(room.isOccupied() ? "Yes" : "No"));
        System.out.println("Clean: "+(room.isDirty() ? "No" : "Yes"));
    }

    private static void testHotelActions(){
        System.out.println("\n====================================Hotel Display\n");
        TESTING_HOTELS.forEach(Main::displayTestHotel);
        System.out.println("====================================Hotel Actions\n");

        System.out.println(TESTING_HOTELS.get(0).bookRoom(10, false) ?
                "Booked 10 Rooms From " + TESTING_HOTELS.get(0).getHotelName() : "Failed To Book, Not Enough Rooms");
        System.out.println(TESTING_HOTELS.get(1).bookRoom(10, false) ?
                "Booked 10 Rooms From " + TESTING_HOTELS.get(1).getHotelName() : "Failed To Book, Not Enough Rooms");
        System.out.println(TESTING_HOTELS.get(0).bookRoom(10, true) ?
                "Booked 10 Suites From " + TESTING_HOTELS.get(0).getHotelName() : "Failed To Book, Not Enough Suites");
        System.out.println(TESTING_HOTELS.get(1).bookRoom(10, true) ?
                "Booked 10 Suites From " + TESTING_HOTELS.get(1).getHotelName() : "Failed To Book, Not Enough Suites");
        System.out.println("\n====================================Hotel Display\n");
        TESTING_HOTELS.forEach(Main::displayTestHotel);
    }

    private static void displayTestHotel(Hotel hotel){
        System.out.println(hotel.getHotelName());
        System.out.println("Available Rooms: "+hotel.getAvailableRooms());
        System.out.println("Available Suites: "+hotel.getAvailableSuites());
        System.out.println("\n");
    }
}
