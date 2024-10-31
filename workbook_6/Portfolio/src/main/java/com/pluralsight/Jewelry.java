package com.pluralsight;

import com.pluralsight.FixedAsset;

public class Jewelry extends FixedAsset {
    private double karat;
    public Jewelry(String name, double value, double karat) {
        super(name, value);
        this.karat = karat;
    }

    @Override
    public double getValue() {
        return 0;
    }
}
