package com.pluralsight;

import java.util.ArrayList;
import java.util.List;

public class Table {  // Handle amount of players
    public List<Player> players = new ArrayList<>();
    private Deck deck;

    public void addPlayer(Player player){
        players.add(player);
    }

    public void prepareDeck(){
        deck = new Deck();
        deck.shuffle();
        dealAllPlayers();
    }

    public void dealAllPlayers(){
        for(Player player : players){
            player.hand.deal(deck.deal());
        }
        for(Player player : players){
            player.hand.deal(deck.deal());
        }
    }

    public void dealSingleCard(Player player){
        player.hand.deal(deck.deal());
    }
}
