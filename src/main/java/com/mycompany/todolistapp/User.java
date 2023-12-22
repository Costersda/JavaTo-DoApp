/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.todolistapp;

/**
 * The User class represents a user in the system, including their userId, username, and password.
 */
public class User {
    private int userId;
    private String username;
    private String password;

    /**
     * Constructs a new User with the given user ID, username, and password.
     *
     * @param userId The unique identifier for the user.
     * @param username The username of the user.
     * @param password The password of the user.
     */
    public User(int userId, String username, String password) {
        this.userId = userId;
        this.username = username;
        this.password = password;
    }

    // Getters and Setters

    /**
     * Returns the user ID.
     *
     * @return The user ID.
     */
    public int getUserID() {
        return userId;
    }

    /**
     * Sets the user ID.
     *
     * @param userID The new user ID.
     */
    public void setUserID(int userID) {
        this.userId = userID;
    }

    /**
     * Returns the username.
     *
     * @return The username.
     */
    public String getUsername() {
        return username;
    }

    /**
     * Sets the username.
     *
     * @param username The new username.
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Returns the password.
     *
     * @return The password.
     */
    public String getPassword() {
        return password;
    }

    /**
     * Sets the password.
     *
     * @param password The new password.
     */
    public void setPassword(String password) {
        this.password = password;
    }

}