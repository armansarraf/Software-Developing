package com.example.project.model;

import java.sql.SQLException;

/**
 * Login Checker class checks the username and password with the information in
 * the user database to see if that user is authorized
 * 
 * @author Arman Hosseinsarraf, Behnaz Sheikhi
 */
public class LoginChecker {
    UserDB userDB;
    int username;
    int password;
    int flag = -1;

    /**
     * LoginChecker Constructor gets the username and password from login page, it
     * also builds a connection with user database
     * 
     * @param username
     * @param password
     */
    public LoginChecker(int username, int password) throws SQLException {
        userDB = new UserDB();
        this.username = username;
        this.password = password;
    }

    /**
     * checkUsernamePassword() checks the username and password with the database to
     * see if the user is authorized
     * 
     * @return true if user is in database and false if the information is not in
     *         database
     */

    public User checkUsernamePassword() throws SQLException {
        flag = userDB.validateUser(username, password);
        if (flag == 1)
            return new User(username, password);
        else
            return null;
    }
}