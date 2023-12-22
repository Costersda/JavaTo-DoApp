/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.todolistapp;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Task {
    private String taskID;
    private String name;
    private String details;
    private LocalDate dueDate;

    public Task(String taskID, String name, String details, LocalDate dueDate) {
        this.taskID = taskID;
        this.name = name;
        this.details = details;
        this.dueDate = dueDate;
    }

    // Getters and Setters
    public String getTaskID() {
        return taskID;
    }

    public void setTaskID(String taskID) {
        this.taskID = taskID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    // Format for SQLite
    public String getDueDateForSQLite() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return dueDate.format(formatter);
    }
    
    
    public boolean addTask(Connection connection, int userId) {
        // SQL statement to insert a new task
        String insertTaskSql = "INSERT INTO Task (UserId, Title, Description, DueDate) VALUES (?, ?, ?, ?);";

        try (PreparedStatement preparedStatement = connection.prepareStatement(insertTaskSql)) {
            preparedStatement.setInt(1, userId);
            preparedStatement.setString(2, this.name);
            preparedStatement.setString(3, this.details);
            preparedStatement.setString(4, getDueDateForSQLite());

            int affectedRows = preparedStatement.executeUpdate();
            return affectedRows > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}