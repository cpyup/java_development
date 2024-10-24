package com.pluralsight;

public class NameFormatter {
    public static String format (String prefix, String firstName, String middleName, String lastName, String suffix) {
        return lastName + ", " + (prefix != null ? prefix + " " : "") + firstName + (middleName != null ? " " + middleName : "") + (suffix != null ? ", " + suffix : "");
    }

    public static String format(String firstName, String lastName){
        return format(null,firstName,null,lastName,null);
    }

    public static String format(String fullName){
        String[] input = fullName.split(" ");

        for(int i = 0; i < input.length; i++){
            input[i] = cleanInput(input[i]);
        }

        return switch (input.length) {
            case 2 -> format(input[0], input[1]);
            case 4 -> format(null, input[0], input[1], input[2], input[3]);
            case 5 -> format(input[0], input[1], input[2], input[3], input[4]);
            default -> "Input Error";
        };
    }

    private static String cleanInput(String input){
        return input.replaceAll(",", "");
    }
}
