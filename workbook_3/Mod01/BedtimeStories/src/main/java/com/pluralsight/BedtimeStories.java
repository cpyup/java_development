package com.pluralsight;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class BedtimeStories {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Enter the name of the book to read\n");
        String selection = input.nextLine().trim();

        try{
            FileInputStream fis = new FileInputStream(selection);
            Scanner fileIn = new Scanner(fis);

            String contents;
            int lineCount = 1;

            while (fileIn.hasNextLine()){
                contents = lineCount+". "+fileIn.nextLine();
                System.out.println(contents);
                lineCount++;
            }
            fileIn.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
