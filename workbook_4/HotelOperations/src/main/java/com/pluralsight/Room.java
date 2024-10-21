package com.pluralsight;

public class Room {
    private final int bedCount;
    private final double price;
    private final boolean occupied;
    private final boolean dirty;

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

    public boolean isDirty() {
        return dirty;
    }

    public boolean isAvailable() {
        return !isOccupied() && !isDirty();
    }
}
