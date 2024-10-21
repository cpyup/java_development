package com.pluralsight;

public class Room {
    private final int bedCount;
    private final double price;
    private boolean occupied;
    private boolean dirty;

    public Room(int bedCount, double price) {
        this.bedCount = bedCount;
        this.price = price;
        this.occupied = false;
        this.dirty = false;
    }

    public int getNumberOfBeds() {
        return bedCount;
    }

    public double getPrice() {
        return price;
    }

    public boolean isOccupied() {
        return occupied;
    }

    public void setIsOccupied(boolean occupied){
        this.occupied = occupied;
    }

    public boolean isDirty() {
        return dirty;
    }

    public void setIsDirty(boolean dirty){
        this.dirty = dirty;
    }

    public boolean isAvailable() {
        return !isOccupied() && !isDirty();
    }

    public void checkIn(){
        setIsDirty(true);
        setIsOccupied(true);
    }

    public void checkOut(){
        setIsOccupied(false);
    }

    public void cleanRoom(){
        setIsDirty(false);
    }
}
