package com.example.project.model;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Teaching Technician has functions of request an animal, block and remove students, search and view animal profiles, and take comments on animal profiles.
 *
 * @author Arman Hosseinsarraf
 */
public class TeachingTechnician {
    AnimalDatabase animals;
    ArrayList<User> studentUsers;

    User teachingTechnician;
    UserDB userDB;


    /**
     * Teaching Technician Constructor, creates objects from UserDB, AnimalDB, List of users and animals and fills both lists from database
     *
     * @param user
     * @throws SQLException
     */
    public TeachingTechnician(User user, UserDB userDB) throws SQLException {
        teachingTechnician = user;
        animals = new AnimalDatabase();
        studentUsers = new ArrayList<User>();
        this.userDB = userDB;
        addUser();
    }


    /**
     * Teaching Technician can remove students.
     *
     * @param userID
     */
    public void removeStudent(int userID) throws SQLException {
        for (User user : studentUsers) {
            if (user.getUsername() == userID) {
                userDB.removeUser(String.valueOf(user.getPassword()));// Student with that username and password will be deleted from the database
                user.setStatus("Removed");
            }
        }
    }

    public void blockStudent(int userID) throws SQLException {
        for (User user : studentUsers) {
            if (user.getUsername() == userID) {
                userDB.blockUser(String.valueOf(user.getPassword()));// Student with that username and password will be deleted from the database
                user.setStatus("Blocked");

            }
        }
    }

    /**
     * Teaching Technician can search for an animal with the animal name
     *
     * @param name
     * @return
     * @throws SQLException
     */
    public ArrayList<Animal> searchAnimalByName(String name) throws SQLException {
        return animals.findAnimalByName(name);
    }

    /**
     * Teaching Technician can search for an animal with the animal ID
     *
     * @param id
     * @return
     * @throws SQLException
     */
    public Animal searchAnimalByID(int id) throws SQLException {
        return animals.findAnimal(id);
    }


    public String userName() {
        return teachingTechnician.getFname();
    }

    /**
     * addUser() loads the users from the database and keep them in the user list.
     */
    public void addUser() throws SQLException {
        String user = (userDB.adminAccessGetUser());
        Scanner scanner = new Scanner(user);
        while (scanner.hasNextLine()) {
            String userPass = scanner.nextLine();
            String[] a = userPass.split(" ");
            if (new User(Integer.parseInt(a[0]), Integer.parseInt(a[1])).getPermission().equals("Student")) {
                studentUsers.add(new User(Integer.parseInt(a[0]), Integer.parseInt(a[1]))); // it creates a user object for each user id, password that exist on the database
            }
        }
        scanner.close();
    }

    public ArrayList<User> getUsers() {
        ArrayList<User> active = new ArrayList<>();
        for (User user : studentUsers)
            if (user.getStatus().equals("Active"))
                active.add(user);
        return active;
    }

    public ArrayList<User> getBlocklist() {
        ArrayList<User> blocked = new ArrayList<>();
        for (User user : studentUsers) {
            if (user.getStatus().equals("Blocked"))
                blocked.add(user);
        }
        return blocked;
    }

    /**
     * Teaching Technician can request an animal with animal ID
     *
     * @param id
     * @throws SQLException
     */
    public void requestAnimal(int id) throws SQLException {
        userDB.updateAnimalStatusToRequested(id); // Animal status will be updated to "requested" in the database
        animals.initializeDatabase();

    }
}
