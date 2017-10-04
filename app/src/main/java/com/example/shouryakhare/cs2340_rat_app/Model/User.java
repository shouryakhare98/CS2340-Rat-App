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

    /*
    Getters
     */
    public String getUsername() { return username; }
    public String getPassword() { return password; }
    public boolean getAdmin() { return isAdmin; }
    public String getFullName() { return fullName; }

    /*
    No arg constructor
     */
    public User() {}

    /*
    4 arg constructor
     */
    public User(String fullName, String username, String password, boolean admin) {
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
