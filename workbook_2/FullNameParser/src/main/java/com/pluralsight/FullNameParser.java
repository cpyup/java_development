package com.pluralsight;

import java.util.Scanner;

public class FullNameParser {
    public static void main(String[] args) {
        GetInput();
    }

    public static void GetInput(){
        Scanner input = new Scanner(System.in);

        System.out.println("Enter your name:\n");
        String[] nameIn = input.nextLine().trim().split(" ");

        switch (nameIn.length){
            case 1:
                System.out.println("\nFirst name: "+nameIn[0]+"\nMiddle Name: (none)\nLast Name: (none)");
                break;
            case 2:
                System.out.println("\nFirst name: "+nameIn[0]+"\nMiddle Name: (none)\nLast Name: "+nameIn[1]);
                break;

            case 3:
                System.out.println("\nFirst name: "+nameIn[0]+"\nMiddle Name: "+nameIn[1]+"\nLast Name: "+nameIn[2]);
                break;
        }
        input.close();
    }
}
