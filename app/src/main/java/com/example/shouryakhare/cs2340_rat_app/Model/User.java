package com.example.shouryakhare.cs2340_rat_app.Model;

/**
 * Created by shouryakhare on 9/22/17.
 *
 * Information holder - Represents a single user in model.
 */

public class User {

    /*
    Represents next id of user.
     */
    private static int NextId = 0;

    /*
    Represents id of current user.
     */
    private int id;

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
    public int getId() { return id; }

    /*
    No arg constructor
     */
    public User() {}

    /*
    2 arg constructor
     */
    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    /*
    4 arg constructor
     */
    public User(String fullName, String username, String password, boolean admin) {
        this.id = User.NextId++;
        this.fullName = fullName;
        this.username = username;
        this.password = password;
        this.isAdmin = admin;
    }

    @Override
    public String toString() {
        return String.valueOf(id) + " " + fullName + " " + username + " " + isAdmin;
    }
}
