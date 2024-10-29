package com.pluralsight.main;

import com.pluralsight.model.*;

import java.util.ArrayList;
import java.util.List;

public class AssetManager {
    public static void main(String[] args) {
        List<Asset> assetList = new ArrayList<>();
        assetList.add(new House("My House","122095",200000,"123 Fake Street",3,1000,1000));
        assetList.add((new House("Vacation House","122095",100000,"124 Fake Street",4,1000,1000)));

        assetList.add(new Vehicle("My Car","122095",10000,"Idunno",2000,50000));
        assetList.add(new Vehicle("Vacation Car","122095",10000,"Idunno",2024,50000));

        for(Asset asset : assetList){
            
        }
    }
}
