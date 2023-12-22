/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.todolistapp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAO {

    public User loadUser(String username, Connection connection) {
        String sql = "SELECT UserId, Username, Password FROM User WHERE Username = ?;";
        
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, username);
            
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    int userId = resultSet.getInt("UserId");
                    String userUsername = resultSet.getString("Username");
                    String userPassword = resultSet.getString("Password");
                    return new User(userId, userUsername, userPassword);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}