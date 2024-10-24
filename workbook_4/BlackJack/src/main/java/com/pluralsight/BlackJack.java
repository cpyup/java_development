package com.pluralsight;

import java.util.Scanner;

public class BlackJack {  // TODO: Add option to split hands on double values
    private final static Scanner SCANNER = new Scanner(System.in);
    private final static int MAX_PLAYERS = 7;
    private final static int MIN_PLAYERS = 2;
    private static Table table;
    public static void main(String[] args) {
        promptPlayerCount();
        prepareGame();

        String input = "";

        while(!input.equalsIgnoreCase("e")){
            runGame();
            System.out.println("\nEnter 'H' To Deal New Hand, 'E' To Exit");
            input = SCANNER.nextLine();
            newHand();
        }
    }

    private static void promptPlayerCount(){ // Get input for amount of players for this game
        System.out.println("Enter The Amount Of Players");
        int input;

        while(true){
            try{
                input = Integer.parseInt(SCANNER.nextLine());
                if(input >= MIN_PLAYERS && input <= MAX_PLAYERS)break;
            }catch(Exception e){
                System.out.println("Input Error");
            }
        }
        newPlayerInput(input);
    }

    private static void newPlayerInput(int playerCount){  // Get input for a single player name
        table = new Table();
        for(int i = 0; i < playerCount;i++){
            System.out.println("Enter Player "+(i+1)+" Name");
            String input = SCANNER.nextLine();
            table.addPlayer(new Player(input));
        }
    }

    private static void prepareGame(){
        table.prepareDeck();
    }

    private static void displayHands(){
        for(Player player : table.players){
            System.out.println("\n"+player.getName());
            player.hand.print();
        }
    }

    private static void displayHands(Player player){
        player.hand.print();
    }

    private static void determineWinner(){  // TODO: Modify to use a hashmap of players+scores, will then be able to implement player ties (Maybe use maps on top of score, if multiple match winning, display tie and print all)
        String winner = "";
        int winningScore =0;

        for(Player player : table.players){
            if(player.hand.getValue() > winningScore && player.hand.getValue() <= 21){
                winningScore = player.hand.getValue();
                winner = player.getName();
            }
        }

        displayHands();

        System.out.println("\n"+winner+" Wins!");
    }

    private static void runGame(){
        playerTurn();
        determineWinner();
    }

    private static void playerTurn(){
        for(Player player : table.players){
            System.out.println("\n"+player.getName()+"'s Turn\n");
            displayHands(player);

            if(checkForMax(player)) {
                System.out.println("\nBLACKJACK!!");
                continue;
            }

            System.out.println("\n'H' To Hit Or 'S' To Stay");
            String input = "";

            while (!input.equalsIgnoreCase("s")){
                input = SCANNER.nextLine();

                if(input.equalsIgnoreCase("h")){
                    table.dealSingleCard(player);

                    if(player.hand.getValue() > 21){
                        playerBust(player);
                        if(checkBustWin())return;
                        break;
                    }

                    displayHands(player);

                    if(checkForMax(player)){
                        System.out.println("\n21!\n\nPress Enter To End Turn");
                        SCANNER.nextLine();
                        break;
                    }


                    System.out.println("\n'H' To Hit Or 'S' To Stay");
                }
            }
        }
    }

    private static void playerBust(Player player){
        System.out.println("\n"+player.getName()+" Busted!");
        System.out.println("Press Enter To End Your Turn");
        SCANNER.nextLine();
    }

    private static boolean checkBustWin(){
        int stillInPlay = 0;
        for(Player player : table.players){
            if(player.hand.getValue() <= 21){
                stillInPlay += 1;
            }
        }
        return stillInPlay <= 1;
    }

    public static boolean checkForMax(Player player){
        return player.hand.getValue() == 21;
    }

    private static void newHand(){
        //System.out.println("\nPress Enter To Deal New Hand");
        for(Player player : table.players){
            player.hand.discardHand();
        }
        table.dealAllPlayers();
    }
}
