/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.todolistapp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * The DatabaseHelper class provides utility methods to connect to the SQLite database.
 * It encapsulates the details for connecting to the database, making it easier to manage
 * database connections throughout the application.
 */
public class DatabaseHelper {

    // JDBC driver class for SQLite
    private static final String JDBC_DRIVER = "org.sqlite.JDBC";
    
    // URL of the development database
    private static final String DATABASE_URL = "jdbc:sqlite:./data/ToDo.db";
    
    // URL of the production database
    //private static final String DATABASE_URL = "jdbc:sqlite:ToDo.db";
    
    /**
     * Establishes and returns a connection to the SQLite database.
     *
     * @return A Connection object to the SQLite database.
     * @throws ClassNotFoundException if the JDBC driver class is not found.
     * @throws SQLException if a database access error occurs or the URL is null.
     */
    public static Connection getConnection() throws ClassNotFoundException, SQLException {
        // Load the JDBC driver
        Class.forName(JDBC_DRIVER);
        
        // Establish and return a connection to the database
        return DriverManager.getConnection(DATABASE_URL);
    }
}