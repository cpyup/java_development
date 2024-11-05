package com.pluralsight;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Program {
    private static final Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        List<Person> people = new ArrayList<>();
        populateList(people);
        promptSearch(people);
    }

    private static void populateList(List<Person> people){
        people.add(new Person("Emma", "Johnson", 25));
        people.add(new Person("Liam", "Smith", 32));
        people.add(new Person("Olivia", "Brown", 28));
        people.add(new Person("James", "Davis", 40));
        people.add(new Person("Sophia", "Martinez", 22));
        people.add(new Person("Benjamin", "Garcia", 35));
        people.add(new Person("Ava", "Rodriguez", 29));
        people.add(new Person("Mason", "Wilson", 33));
        people.add(new Person("Isabella", "Moore", 26));
        people.add(new Person("Lucas", "Taylor", 31));
    }

    private static void promptSearch(List<Person> people){
        System.out.println("Enter the name to search");
        String input = scanner.nextLine().trim();

        List<Person> matches = new ArrayList<>();
        int totalAge = 0;
        int oldestAge = Integer.MIN_VALUE;
        int youngestAge = Integer.MAX_VALUE;

        for(Person person : people){
            // Add to matches if the person matches the search input
            if(person.getFirstName().equalsIgnoreCase(input) || person.getLastName().equalsIgnoreCase(input)){
                matches.add(person);
                System.out.println(person);
            }

            // Calculate total age for average age calculation
            totalAge += person.getAge();

            // Update the oldest and youngest age
            if(person.getAge() > oldestAge){
                oldestAge = person.getAge();
            }
            if(person.getAge() < youngestAge){
                youngestAge = person.getAge();
            }
        }

        // Calculate and display average age
        if (!people.isEmpty()) {
            int averageAge = totalAge / people.size();
            System.out.println("Average age of all people: " + averageAge);
        }

        // Display the age of the oldest and youngest person
        System.out.println("Oldest age: " + oldestAge);
        System.out.println("Youngest age: " + youngestAge);
    }

}
