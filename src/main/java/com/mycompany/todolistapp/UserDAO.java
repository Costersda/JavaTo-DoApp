/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.todolistapp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * The UserDAO class is responsible for handling all database
 * operations related to the User entity. It provides a method to retrieve user data from the database.
 */
public class UserDAO {

    /**
     * Loads a User from the database based on the provided username.
     *
     * @param username   The username of the user to be loaded.
     * @param connection The database connection to use for the query.
     * @return A User object if found, null otherwise.
     */
    public User loadUser(String username, Connection connection) {
        String sql = "SELECT UserId, Username, Password FROM User WHERE Username = ?;";
        
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, username);
            
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    int userId = resultSet.getInt("UserId");
                    String userUsername = resultSet.getString("Username");
                    String userPassword = resultSet.getString("Password");
                    // Creates a new User object with the data retrieved from the database
                    return new User(userId, userUsername, userPassword);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        // Returns null if the user is not found or if an error occurs
        return null;
    }
}