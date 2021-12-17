package com.example.project.model;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;
/**
 * Student class is designed to let a student search and view animal profiles and make comments on animal profiles.
 * @author Arman Hosseinsarraf
 */

public class Student {
    ArrayList<Animal> animals;
    User student;
    UserDB userDB;
    JDBCConnect jdbcConnect;

    /**
     * Student Constructor, creates objects from UserDB, AnimalDB, and list of animals and fills the list from database
     *
     * @param user
     * @throws SQLException
     */
    public Student(User user) throws SQLException {
        student = user;
        animals = new ArrayList<>();
        userDB = new UserDB();
        jdbcConnect = new JDBCConnect();
        jdbcConnect.createConnection();
    }


    /**
     * Student can search for an animal with the animal name
     *
     * @param name
     * @return
     * @throws SQLException
     */
    public Animal searchAnimalByName(String name) throws SQLException {
        for (Animal animal : animals)
            if (animal.getName().equals(name)) return animal;
        return null;
    }

    /**
     * Student can search for an animal with the animal ID
     *
     * @param id
     * @return
     * @throws SQLException
     */
    public Animal searchAnimalByID(int id) throws SQLException {
        for (Animal animal : animals)
            if (animal.getAnimalId() == id) return animal;
        return null;
    }


    public String userName() {
        return student.getFname();
    }

}

