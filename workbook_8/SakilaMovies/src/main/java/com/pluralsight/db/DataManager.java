package com.pluralsight.db;

import com.pluralsight.model.*;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class DataManager {
    private final DataSource dataSource;

    public DataManager(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public List<Actor> getActorsByName(String firstName) {
        List<Actor> actors = new ArrayList<>();
        String productsQuery = "SELECT actor_id, first_name, last_name FROM actor WHERE first_name LIKE ?";

        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(productsQuery)) {

            preparedStatement.setString(1, "%" + firstName + "%");

            try (ResultSet results = preparedStatement.executeQuery()) {
                while (results.next()) {
                    int actorId = results.getInt("actor_id");
                    String firstNameFromDb = results.getString("first_name");
                    String lastName = results.getString("last_name");

                    Actor actor = new Actor(actorId, firstNameFromDb, lastName);
                    actors.add(actor);
                }
            }

        } catch (Exception ex) {
            System.out.println("An error has occurred!");
            ex.printStackTrace();
        }
        return actors;
    }

    public List<Film> getFilmsById(String id){
        List<Film> films = new ArrayList<>();
        String productsQuery = "SELECT film_id, title, description, release_year, length FROM film WHERE film_id = ?";

        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(productsQuery)) {
             preparedStatement.setString(1,id);

            try (ResultSet results = preparedStatement.executeQuery()) {
                while (results.next()) {
                    int filmId = results.getInt("film_id");
                    String title = results.getString("title");
                    String description = results.getString("description");
                    String releaseYear = results.getString("release_year");
                    int length = results.getInt("length");

                    Film film = new Film(filmId, title, description, releaseYear, length);
                    films.add(film);
                }
            }

        } catch (Exception ex) {
            System.out.println("An error has occurred!");
            ex.printStackTrace();
        }
        return films;
    }
}
