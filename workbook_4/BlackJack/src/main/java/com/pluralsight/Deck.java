package com.pluralsight;

import java.util.ArrayList;
import java.util.Collections;

public class Deck {
    private final ArrayList<Card> cards = new ArrayList<>();

    public Deck() {
        String[] suits = {"Hearts", "Spades", "Diamonds", "Clubs"};
        String[] values = {"2", "3", "4", "5", "6", "7", "8",
                "9", "10", "J", "Q", "K", "A"};

        // these loops create all the cards in the deck
        // and add them to the ArrayList
        for (String suit : suits) {
            for (String value : values) {
                Card card = new Card(suit, value);
                cards.add(card);
            }
        }
    }

    public void shuffle() {
        Collections.shuffle(cards);
    }

    public Card deal() {
        // deal the top card (if there are any cards left
        if (getSize() > 0) {
            return cards.remove(0);
        } else {
            return null;
        }
    }

    public int getSize() {
        return cards.size();
    }
}