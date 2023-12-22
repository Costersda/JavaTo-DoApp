/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.todolistapp;

import java.time.LocalDate;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author sean
 */

/**
 * The CalendarController class extends DefaultTableModel to manage the display
 * and data of a calendar within a JTable. It handles the organization of tasks
 * by dates for a given week.
 */
public class CalendarController extends DefaultTableModel {

    private static final String[] WEEK_DAYS = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
    private LocalDate startDate;
    private static final int DAYS_IN_WEEK = 7;
    private TaskDAO taskDAO = new TaskDAO();
    private Map<String, List<Task>> dateToTasksMap = new HashMap<>();

    /**
     * Constructs a CalendarController with a specified start date.
     *
     * @param startDate The start date of the calendar week.
     */
    public CalendarController(LocalDate startDate) {
        super(new Object[][]{}, WEEK_DAYS); // Initialize with empty data and column names
        this.startDate = startDate;
    }

    /**
     * Sets the start date of the calendar and reloads the tasks for the new week.
     *
     * @param startDate The new start date to set.
     */
    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
        loadWeekTasks(); // Reload tasks when the start date changes
    }

    /**
     * Loads the tasks for each day of the week into the table model.
     * It adjusts row heights based on the number of tasks for each day
     * and maps tasks to their respective dates.
     */
    public void loadWeekTasks() {
        setRowCount(0); // Clear previous rows

        // Find the maximum number of tasks in a single day
        int maxTasksInADay = 0;
        for (int i = 0; i < DAYS_IN_WEEK; i++) {
            LocalDate date = startDate.plusDays(i);
            List<Task> tasks = taskDAO.getTasksForDate(date);
            maxTasksInADay = Math.max(maxTasksInADay, tasks.size());

            // Populate the map with the date and its tasks
            dateToTasksMap.put(date.toString(), tasks);
        }

        // Create rows to accommodate the maximum number of tasks in any day
        // plus one additional row for the dates
        for (int i = 0; i < maxTasksInADay + 1; i++) {
            addRow(new Object[DAYS_IN_WEEK]); // Add a row with a cell for each day
        }

        // Set the dates in the first row
        for (int i = 0; i < DAYS_IN_WEEK; i++) {
            LocalDate date = startDate.plusDays(i);
            setValueAt(date.toString(), 0, i); // Set date in the first row
        }

        // Populate the table with tasks
        for (int day = 0; day < DAYS_IN_WEEK; day++) {
            LocalDate date = startDate.plusDays(day);
            List<Task> tasks = dateToTasksMap.get(date.toString());

            for (int taskIndex = 0; taskIndex < tasks.size(); taskIndex++) {
                Task task = tasks.get(taskIndex);
                setValueAt(task.getName(), taskIndex + 1, day); // Set task in the corresponding row and column
            }
        }
        fireTableDataChanged(); // Notify the JTable of the update
    }

    // Override to ensure JCheckBox are handled correctly
    @Override
    public Class<?> getColumnClass(int columnIndex) {
        return String.class;
    }

    /**
     * Retrieves the list of tasks for a specified date.
     *
     * @param date The date for which to retrieve tasks.
     * @return A list of tasks scheduled for the given date.
     */
    public List<Task> getTasksForDate(String date) {
        return dateToTasksMap.getOrDefault(date, Collections.emptyList());
    }
}