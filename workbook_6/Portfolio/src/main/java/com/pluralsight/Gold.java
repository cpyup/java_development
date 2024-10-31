package com.pluralsight;

import com.pluralsight.FixedAsset;

public class Gold extends FixedAsset {
    private double weight;

    public Gold( double weight) {
        super("Gold", 100);
        this.weight = weight;
    }

    @Override
    public double getValue() {
        return 0;
    }
}
