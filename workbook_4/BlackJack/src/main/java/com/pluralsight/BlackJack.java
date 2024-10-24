package com.pluralsight;

import java.util.Scanner;

public class BlackJack {
    private static Scanner scanner = new Scanner(System.in);
    private static Table table;
    public static void main(String[] args) {
        promptPlayerCount();
        prepareGame();

        boolean running = true;

        while(running){
            runGame();
            System.out.println("\nPress Enter To Deal New Hand");
            scanner.nextLine();
            newHand();
        }
    }

    private static void promptPlayerCount(){ // Get input for amount of players for this game
        System.out.println("Enter The Amount Of Players");
        int input;

        while(true){
            try{
                input = Integer.parseInt(scanner.nextLine());
                break;
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
            String input = scanner.nextLine();
            table.addPlayer(new Player(input));
        }
    }

    private static void prepareGame(){
        table.prepareDeck();
    }

    private static void displayHands(){
        for(Player player : table.players){
            System.out.println("\n"+player.getName()+"\n");
            player.hand.print();
        }
    }

    private static void displayHands(Player player){
        System.out.println("\n"+player.getName()+"\n");
        player.hand.print();
    }

    private static void determineWinner(){
        String winner = "";
        int winningScore =0;

        for(Player player : table.players){
            if(player.hand.getValue() > winningScore && player.hand.getValue() < 21){
                winningScore = player.hand.getValue();
                winner = player.getName();
            }
        }

        displayHands();

        System.out.println(winner+" Wins!");
    }

    private static void runGame(){
        //displayHands();
        playerTurn();
        determineWinner();
    }

    private static void playerTurn(){
        for(Player player : table.players){
            displayHands(player);
            System.out.println("\n"+player.getName()+"'s Turn\n\n'H' To Hit Or 'S' To Stay");
            String input = "";

            while (!input.equalsIgnoreCase("s")){
                input = scanner.nextLine();
                if(input.equalsIgnoreCase("h")){
                    table.dealSingleCard(player);

                    if(player.hand.getValue() > 21){
                        System.out.println("\n"+player.getName()+" Busted!");
                        if(checkBustWin())return;
                        break;
                    }
                    displayHands(player);
                    System.out.println("\n'H' To Hit Or 'S' To Stay");
                }
            }

            //if(input.equalsIgnoreCase("s"))continue;


        }
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

    private static void newHand(){
        System.out.println("\nPress Enter To Deal New Hand");
        for(Player player : table.players){
            player.hand.discardHand();
        }
        table.dealAllPlayers();
    }
}
