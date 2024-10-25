package com.pluralsight;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class Table {  // Handle players, decks and hands
    private final List<Player> players = new ArrayList<>();
    private final HashMap<String,Hand> playerHands = new HashMap<>();
    private Deck deck; // TODO: Adjust to allow additional decks

    public void addPlayer(Player player){
        players.add(player);
        playerHands.put(player.name(), new Hand());
    }

    public void prepareDeck(){
        deck = new Deck();
        deck.shuffle();
        dealAllPlayers();
    }

    public void dealAllPlayers(){
        for(Player player : players){  // TODO: First card needs to be face down (whatever that means in this context???)
            playerHands.get(player.name()).deal(deck.deal());
        }
        for(Player player : players){
            playerHands.get(player.name()).deal(deck.deal());
        }
    }

    public void dealSingleCard(Player player){
        playerHands.get(player.name()).deal(deck.deal());
    }

    public void displayHands(){
        for(Player player : players){
            System.out.println("\n"+player.name());
            playerHands.get(player.name()).print();
        }
    }

    public void determineWinner(){  // TODO: Modify to use a hashmap of players+scores, will then be able to implement player ties (Maybe use maps on top of score, if multiple match winning, display tie and print all)
        String winner = "";
        int winningScore =0;

        for(Player player : players){
            if(playerHands.get(player.name()).getValue() > winningScore && playerHands.get(player.name()).getValue() <= 21){
                winningScore = playerHands.get(player.name()).getValue();
                winner = player.name();
            }
        }

        displayHands();

        System.out.println("\n"+winner+" Wins!");
    }

    public void playerTurn(Scanner scanner){ // TODO: Could display all hands side by side every turn, allowing incorporation of flipping (and likely more intriguing gameplay)
        for(Player player : players){
            System.out.println("\n"+player.name()+"'s Turn\n");
            displayHands(player);

            if(checkForMax(player)) {
                System.out.println("\nBLACKJACK!!");
                continue;
            }

            System.out.println("\n'H' To Hit Or 'S' To Stay");
            String input = "";

            while (!input.equalsIgnoreCase("s")){
                input = scanner.nextLine();

                if(input.equalsIgnoreCase("h")){
                    dealSingleCard(player);

                    if(playerHands.get(player.name()).getValue() > 21){
                        playerBust(player,scanner);
                        if(checkBustWin())return;
                        break;
                    }

                    displayHands(player);

                    if(checkForMax(player)){
                        System.out.println("\n21!\n\nPress Enter To End Turn");
                        scanner.nextLine();
                        break;
                    }


                    System.out.println("\n'H' To Hit Or 'S' To Stay");
                }
            }
        }
    }

    private static void playerBust(Player player, Scanner scanner){
        System.out.println("\n"+player.name()+" Busted!");
        System.out.println("Press Enter To End Your Turn");
        scanner.nextLine();
    }

    private boolean checkBustWin(){
        int stillInPlay = 0;
        for(Player player : players){
            if(playerHands.get(player.name()).getValue() <= 21){
                stillInPlay += 1;
            }
        }
        return stillInPlay <= 1;
    }

    private boolean checkForMax(Player player){
        return playerHands.get(player.name()).getValue() == 21;
    }

    public void newHand(){
        //System.out.println("\nPress Enter To Deal New Hand");
        for(Player player : players){
            playerHands.get(player.name()).discardHand();
        }
        dealAllPlayers();
    }

    private void displayHands(Player player){
        playerHands.get(player.name()).print();
    }
}
