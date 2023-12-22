/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.todolistapp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseHelper {

    private static final String JDBC_DRIVER = "org.sqlite.JDBC";
    
    // development DB
    //private static final String DATABASE_URL = "jdbc:sqlite:./data/ToDo.db";
    
    // production DB
    private static final String DATABASE_URL = "jdbc:sqlite:ToDo.db";
    
    
    public static Connection getConnection() throws ClassNotFoundException, SQLException {
        // Load the JDBC driver
        Class.forName(JDBC_DRIVER);
        
        // Establish a connection to the database
        return DriverManager.getConnection(DATABASE_URL);
    }
}