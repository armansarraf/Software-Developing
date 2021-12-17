package com.example.project.model;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Care Attendant is designed to take photos of animals and upload them, request treatment from technicians, change animals’ status, update daily status and treatment, and alert disease and problems (location).
 * @author Behnaz Sheikhi
 */
public class CareAttendant {
    ArrayList<Animal> animals;
    ArrayList<Animal> requestedAnimals;
    User careAtt;
    UserDB userDB;
    JDBCConnect jdbcConnect;
    AnimalDatabase animalDatabase;

    /**
     * Care Attendants Constructor, creates objects from UserDB, AnimalDB, and list of animals and fills the list from database
     * @param user
     * @throws SQLException
     */
    public CareAttendant(User user) throws SQLException {
        careAtt = user;
        animals = new ArrayList<>();
        userDB = new UserDB();
        jdbcConnect = new JDBCConnect();
        jdbcConnect.createConnection();
        animalDatabase = new AnimalDatabase();
        requestedAnimals = new ArrayList<>();
    }

    public ArrayList<Animal> getRequestedAnimals() {
        for (Animal animal:animalDatabase.getAnimals()){
            if (animal.getStatus().contains("Requested"))
                requestedAnimals.add(animal);
        }
        return requestedAnimals;
    }

    /**
     * Care Attendant can request for an animal treatment from the technician
     * @param id
     * @throws SQLException
     */
    public void requestTreatment(int id) throws SQLException {
        userDB.updateAnimalStatusToRequested(id);

    }
}
