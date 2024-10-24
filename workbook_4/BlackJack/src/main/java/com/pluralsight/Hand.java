package com.pluralsight;

import java.util.ArrayList;

public class Hand {
    private final ArrayList<Card> cards= new ArrayList<>();

    public Hand() {

    }

    // A Card is dealt to the Hand and the Hand is responsible
    // to store the card
    public void deal(Card card) {
        cards.add(card);
    }

    public int getSize() {
        return cards.size();
    }

    // The Hand uses the methods of each card to determine
    // the value of each card - and adds up all values
    public int getValue() {
        int value = 0;
        int aceCount = 0;

        for (Card card : cards) {
            card.flip(); // turn the card over to see the value
            value += card.getPointValue();
            if(card.getPointValue() == 11)aceCount += 1;
            card.flip(); // hide the card again
        }

        if(value > 21 && aceCount > 0){
            for(int i = 0; i < aceCount; i++){
                value -= 10;
                if(value < 21)return value;
            }
        }

        return value;
    }

    public void print() {
        System.out.println("Cards in Hand:");
        for (Card card : cards) {
            card.flip();
            System.out.println(card.getValue() + " of " + card.getSuit());
            card.flip();
        }
    }

    public void discardHand(){
        cards.clear();
    }
}