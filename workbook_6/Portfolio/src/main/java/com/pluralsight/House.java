package com.pluralsight;

public class House extends FixedAsset {
    private int yearBuilt;
    private int squareFeet;
    private int bedrooms;

    public House(int yearBuilt, int squareFeet, int bedrooms) {
        super("House", 100);
        this.yearBuilt = yearBuilt;
        this.squareFeet = squareFeet;
        this.bedrooms = bedrooms;
    }

    @Override
    public double getValue() {
        return 0;
    }
}
