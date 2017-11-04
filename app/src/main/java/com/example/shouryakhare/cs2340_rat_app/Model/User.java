package com.example.shouryakhare.cs2340_rat_app.Model;

/**
 * Created by shouryakhare on 9/22/17.
 *
 * Information holder - Represents a single user in model.
 */

public class User {

    /*
    Represents full name of user.
     */
    private String fullName;

    /*
    Represents username of user.
     */
    private String username;

    /*
    Represents password of user.
     */
    private String password;

    /*
    Represents whether user is admin or normal.
     */
    private boolean isAdmin;

    /**
     * Username getter
     * @return username
     */
    public String getUsername() { return username; }

    /**
     * Password getter
     * @return password
     */
    public String getPassword() { return password; }

    /**
     * No arg constructor for compilation
     */
    public User() {}

    /**
     * 4 arg constructor for initialization.
     * @param fullName Full name
     * @param username Username
     * @param password Password
     * @param admin Whether admin or not
     */
    User(String fullName, String username, String password, boolean admin) {
        this.fullName = fullName;
        this.username = username;
        this.password = password;
        this.isAdmin = admin;
    }

    @Override
    public String toString() {
        return fullName + " " + username + " " + isAdmin;
    }
}
