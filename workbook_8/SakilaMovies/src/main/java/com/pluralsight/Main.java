package com.pluralsight;

import com.pluralsight.db.DataManager;
import com.pluralsight.model.Actor;
import com.pluralsight.model.Film;
import org.apache.commons.dbcp2.BasicDataSource;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        if (args.length != 2) {
            System.out.println("Username and Password are needed to connect to the Database!");
            System.exit(1);
        }

        Scanner scanner = new Scanner(System.in);

        String username = args[0];
        String password = args[1];

        // Create a BasicDataSource
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setUrl("jdbc:mysql://localhost:3306/sakila");
        dataSource.setUsername(username);
        dataSource.setPassword(password);

        System.out.println("Enter name to search");
        String searchName = scanner.nextLine();

        DataManager dataManager = new DataManager(dataSource);
        List<Actor> actorList = dataManager.getActorsByName(searchName);

        actorList.forEach(System.out::println);

        System.out.println("Enter actor id");
        String id = scanner.nextLine();

        List<Film> films = dataManager.getFilmsById(id);
        films.forEach(System.out::println);


    }
}