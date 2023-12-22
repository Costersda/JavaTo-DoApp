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


/**
 * TaskDAO is responsible for handling all database operations
 * related to the Task entity. It provides methods to retrieve, insert, update,
 * and delete tasks from the database.
 */
public class TaskDAO {

    /**
     * Retrieves all tasks associated with a specific user.
     *
     * @param userId The user ID for which to retrieve tasks.
     * @return A list of Task objects associated with the user.
     */
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

                    tasks.add(new Task(taskId, title, description, dueDate));
                }
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return tasks;
    }

    /**
     * Deletes a task based on its ID.
     *
     * @param taskId The ID of the task to be deleted.
     * @return true if the task was successfully deleted, false otherwise.
     */
    public boolean deleteTask(String taskId) {
        String sql = "DELETE FROM Task WHERE TaskID = ?;";

        try (Connection connection = DatabaseHelper.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setString(1, taskId);
            return preparedStatement.executeUpdate() > 0;
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * Retrieves a single task by its ID.
     *
     * @param taskId The ID of the task to retrieve.
     * @return The Task object if found, null otherwise.
     */
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

    /**
     * Updates an existing task in the database.
     *
     * @param task The Task object containing the updated information.
     * @return true if the task was successfully updated, false otherwise.
     */
    public boolean updateTask(Task task) {
        String sql = "UPDATE Task SET Title = ?, Description = ?, DueDate = ? WHERE TaskID = ?;";

        try (Connection connection = DatabaseHelper.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setString(1, task.getName());
            preparedStatement.setString(2, task.getDetails());
            preparedStatement.setString(3, task.getDueDateForSQLite());
            preparedStatement.setString(4, task.getTaskID());

            return preparedStatement.executeUpdate() > 0;
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * Retrieves all tasks that are due on a specific date.
     *
     * @param date The date for which to retrieve tasks.
     * @return A list of Task objects due on the specified date.
     */
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
                    LocalDate dueDate = resultSet.getObject("DueDate", LocalDate.class);

                    tasks.add(new Task(taskId, title, description, dueDate));
                }
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return tasks;
    }
}