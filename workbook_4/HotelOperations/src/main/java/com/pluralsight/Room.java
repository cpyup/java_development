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

    private void setIsOccupied(boolean occupied){
        this.occupied = occupied;
    }

    public boolean isDirty() {
        return dirty;
    }

    public boolean isAvailable() {
        return !isOccupied() && !isDirty();
    }

    public boolean checkIn(){
        if(isAvailable()){
            setIsDirty(true);
            setIsOccupied(true);
            return true;
        }
        return false;
    }

    public boolean checkOut(){
        if(!isAvailable())setIsOccupied(false);
        return isOccupied();
    }

    public void cleanRoom(){
        if(!isOccupied())setIsDirty(false);
    }

    private void setIsDirty(boolean dirty){
        this.dirty = dirty;
    }
}
