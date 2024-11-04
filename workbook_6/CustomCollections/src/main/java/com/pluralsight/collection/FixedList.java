package com.pluralsight.collection;

import java.util.ArrayList;
import java.util.List;

public class FixedList<T> {
    private final List<T> items;
    private final int maxSize;

    public FixedList(int maxSize){
        items=new ArrayList<>();
        this.maxSize = maxSize;
    }

    public void add(T item){
        if(items.size() < maxSize){
            items.add(item);
        }
    }

    public List<T> getItems(){
        return items;
    }
}

