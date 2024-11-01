package com.pluralsight;

public class Person implements Comparable<Person>{
    private String firstName;
    private String lastName;
    private int age;

    public Person(String firstName, String lastName, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public int compareTo(Person p) {
        // Sort by last name, if the last name is the same, sort by first, then age
        int last = this.lastName.compareTo(p.getLastName());
        int first = this.firstName.compareTo(p.getFirstName());

        if(last == 0 && first == 0){
            if(this.age == p.age){
                return 0;
            }else if(this.age > p.age){
                return 1;
            }else{
                return -1;
            }
        }

        return last == 0 ? this.firstName.compareTo(p.firstName) : last;
    }
}
