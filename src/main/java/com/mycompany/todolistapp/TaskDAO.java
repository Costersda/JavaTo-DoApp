/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.todolistapp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


public class TaskDAO {

    // Get all the tasks for the current user
    public List<Task> getTasksForUser(int userId) {
        List<Task> tasks = new ArrayList<>();
        String sql = "SELECT TaskID, Title, Description, DueDate FROM Task WHERE UserId = ? ORDER BY DueDate ASC;";

        try (Connection connection = DatabaseHelper.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setInt(1, userId);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    String taskId = resultSet.getString("TaskID");
                    String title = resultSet.getString("Title");
                    String description = resultSet.getString("Description");
                    LocalDate dueDate = resultSet.getObject("DueDate", LocalDate.class);

                    // Construct Task object with all fields
                    Task task = new Task(taskId, title, description, dueDate);
                    // Add the task to the list
                    tasks.add(task);
                }
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return tasks;
    }
    
    // Delete a task given its taskId
    public boolean deleteTask(String taskId) {
        String sql = "DELETE FROM Task WHERE TaskID = ?;";

        try (Connection connection = DatabaseHelper.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setString(1, taskId);
            int affectedRows = preparedStatement.executeUpdate();
            return affectedRows > 0;

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    
    // Get a single task given a taskId
    public Task getTaskById(String taskId) {
        String sql = "SELECT * FROM Task WHERE TaskID = ?;";

        try (Connection connection = DatabaseHelper.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setString(1, taskId);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    String title = resultSet.getString("Title");
                    String description = resultSet.getString("Description");
                    LocalDate dueDate = resultSet.getObject("DueDate", LocalDate.class);
                    return new Task(taskId, title, description, dueDate);
                }
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
    
    // Update a task
    public boolean updateTask(Task task) {
        String sql = "UPDATE Task SET Title = ?, Description = ?, DueDate = ? WHERE TaskID = ?;";

        try (Connection connection = DatabaseHelper.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setString(1, task.getName());
            preparedStatement.setString(2, task.getDetails());
            preparedStatement.setString(3, task.getDueDateForSQLite());
            preparedStatement.setString(4, task.getTaskID());

            int affectedRows = preparedStatement.executeUpdate();
            return affectedRows > 0;

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    // Get all the tasks for a date
    public List<Task> getTasksForDate(LocalDate date) {
        List<Task> tasks = new ArrayList<>();
        String sql = "SELECT TaskID, Title, Description, DueDate FROM Task WHERE DueDate = ? ORDER BY DueDate ASC;";

        try (Connection connection = DatabaseHelper.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setObject(1, date);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    String taskId = resultSet.getString("TaskID");
                    String title = resultSet.getString("Title");
                    String description = resultSet.getString("Description");
                    LocalDate dueDate = resultSet.getObject("DueDate", LocalDate.class); // Fetching as LocalDate

                    // Construct Task object with all fields
                    Task task = new Task(taskId, title, description, dueDate);
                    tasks.add(task);
                    System.out.println(tasks.size());
                }
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        return tasks;
    }
}