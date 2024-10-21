package com.pluralsight;

public class Reservation {
    private final boolean roomType;
    private final int numberOfNights;
    private final boolean weekend;

    public Reservation(boolean roomType, int numberOfNights, boolean weekend) {
        this.roomType = roomType;
        this.numberOfNights = numberOfNights;
        this.weekend = weekend;
    }

    public boolean getRoomType() {
        return roomType;
    }

    public double getPrice() {
        return (getRoomType() ? 139.0 : 124.0);
    }

    public int getNumberOfNights() {
        return numberOfNights;
    }

    public boolean isWeekend() {
        return weekend;
    }

    public double getReservationTotal() {
        return (isWeekend() ? getPrice() + (getPrice() *.1) : getPrice()) * getNumberOfNights();  // 10% increase on weekend
    }
}
