package com.pluralsight;

public class Hotel {
    private final String name;
    private final int numberOfSuites;
    private final int numberOfRooms;
    private int bookedSuites;
    private int bookedBasicRooms;
    public Hotel(int numberOfSuites, int numberOfRooms) {
        this.numberOfSuites = numberOfSuites;
        this.numberOfRooms = numberOfRooms;
        this.bookedSuites = 0;
        this.bookedBasicRooms = 0;
        this.name = "Hotel #1";
    }

    public Hotel(int numberOfSuites, int numberOfRooms, int bookedSuites, int bookedBasicRooms) {
        this.numberOfSuites = numberOfSuites;
        this.numberOfRooms = numberOfRooms;
        this.bookedSuites = bookedSuites;
        this.bookedBasicRooms = bookedBasicRooms;
        this.name = "Hotel #2";
    }

    public int getAvailableRooms(){
        return numberOfRooms - bookedBasicRooms;
    }

    public int getAvailableSuites(){
        return numberOfSuites - bookedSuites;
    }

    public String getHotelName(){
        return name;
    }

    public boolean bookRoom(int numberOfRooms, boolean isSuite){
        if(!isSuite && getAvailableRooms() >= numberOfRooms){
            bookedBasicRooms += numberOfRooms;
            return true;
        }

        if(getAvailableSuites() >= numberOfSuites){
            bookedSuites += numberOfSuites;
            return true;
        }
        return false;
    }
}
