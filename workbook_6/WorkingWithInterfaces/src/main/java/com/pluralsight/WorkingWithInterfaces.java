package com.pluralsight;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class WorkingWithInterfaces {
    public static void main(String[] args) {
        List<Person> people = new ArrayList<>();
        people.add(new Person("George","Jones", 52));
        people.add(new Person("Oscar","Jones", 29));
        people.add(new Person("George","Michael", 88));
        people.add(new Person("Ezra","Aiden", 19));
        people.add(new Person("Oscar","Jones", 32));
        people.add(new Person("George","Jones", 22));

        people.forEach(person -> System.out.println(person.getLastName()+", "+person.getFirstName()+", "+person.getAge()));
        System.out.println("\n");

        Collections.sort(people);
        people.forEach(person -> System.out.println(person.getLastName()+", "+person.getFirstName()+", "+person.getAge()));
    }
}
