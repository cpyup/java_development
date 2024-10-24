package com.pluralsight;

public class Player {
    private final String name;
    public Hand hand;

    public Player(String name){
        this.name = name;
        this.hand = new Hand();
    }

    public String getName(){
        return name;
    }
}
