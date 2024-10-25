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
            table.newHand();
        }
    }

    private static void promptPlayerCount(){ // Get input for amount of players in this game
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

    private static void runGame(){
        table.playerTurn(SCANNER);
        table.determineWinner();
    }




}
