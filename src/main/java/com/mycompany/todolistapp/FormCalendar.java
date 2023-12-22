/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.todolistapp;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.time.temporal.TemporalAdjusters;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;

/**
 *
 * @author sean
 */
public class FormCalendar extends JFrame {

    private LocalDate startDate;
    private CalendarController calendarController;
    
    /**
     * Creates new form FormCalendar
     */
    public FormCalendar() {
        initComponents();
        startDate = LocalDate.now().with(TemporalAdjusters.previousOrSame(DayOfWeek.SUNDAY));
        calendarController = new CalendarController(startDate);

        // Set the custom table model
        calendar.setModel(calendarController);
        
        // Enable cell selection
        calendar.setCellSelectionEnabled(true);
        calendar.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        
        // Disable column reordering
        calendar.getTableHeader().setReorderingAllowed(false);

        // Disable row sorting
        if (calendar.getRowSorter() != null) {
            calendar.setRowSorter(null);
        }
        
        // Apply the custom cell renderer to the calendar table
        calendar.setDefaultRenderer(Object.class, new MultiLineCellRenderer());
    
        // Load tasks into the calendar
        refreshCalendar();
    }
    
    private void goToNextWeek() {
        // Move the start date to the next week
        startDate = startDate.plusWeeks(1);
        calendarController.setStartDate(startDate);
        calendarController.loadWeekTasks();
    }
    
    private void goToPreviousWeek() {
        // Move the start date to the previous week
        startDate = startDate.minusWeeks(1);
        calendarController.setStartDate(startDate);
        refreshCalendar();
}
    
    
    public void refreshCalendar() {
        calendarController.loadWeekTasks();
        calendar.revalidate();
        calendar.repaint();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnBack = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btnBack1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        calendar = new javax.swing.JTable();
        btnAddTask = new javax.swing.JButton();
        btnDeleteTask = new javax.swing.JButton();
        btnEditTask = new javax.swing.JButton();
        btnViewTask = new javax.swing.JButton();
        btnNext = new javax.swing.JButton();
        btnPrevious = new javax.swing.JButton();

        btnBack.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnBack.setText("Back");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setText("To-Do App");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel2.setText("Calendar");

        btnBack1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnBack1.setText("Back");
        btnBack1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBack1ActionPerformed(evt);
            }
        });

        calendar.setAutoCreateRowSorter(true);
        calendar.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        calendar.setShowGrid(false);
        calendar.setShowVerticalLines(true);
        jScrollPane1.setViewportView(calendar);

        btnAddTask.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnAddTask.setText("Add Task");
        btnAddTask.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddTaskActionPerformed(evt);
            }
        });

        btnDeleteTask.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnDeleteTask.setText("Delete Task");
        btnDeleteTask.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteTaskActionPerformed(evt);
            }
        });

        btnEditTask.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnEditTask.setText("Edit Task");
        btnEditTask.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditTaskActionPerformed(evt);
            }
        });

        btnViewTask.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnViewTask.setText("View Task");
        btnViewTask.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnViewTaskActionPerformed(evt);
            }
        });

        btnNext.setText("Next");
        btnNext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNextActionPerformed(evt);
            }
        });

        btnPrevious.setText("Previous");
        btnPrevious.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPreviousActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 211, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(180, 180, 180)
                                .addComponent(jLabel2))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnAddTask)
                                .addGap(42, 42, 42)
                                .addComponent(btnEditTask)
                                .addGap(37, 37, 37)
                                .addComponent(btnViewTask)
                                .addGap(42, 42, 42)
                                .addComponent(btnDeleteTask))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(166, 166, 166)
                                .addComponent(jLabel1)
                                .addGap(189, 189, 189))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnPrevious)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnNext, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(92, 92, 92)
                        .addComponent(btnBack1, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(23, 23, 23))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(btnBack1, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAddTask)
                    .addComponent(btnDeleteTask)
                    .addComponent(btnEditTask)
                    .addComponent(btnViewTask))
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnPrevious)
                    .addComponent(btnNext))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(33, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBack1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBack1ActionPerformed
        dispose();
    }//GEN-LAST:event_btnBack1ActionPerformed

    private void btnAddTaskActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddTaskActionPerformed
        int selectedColumn = calendar.getSelectedColumn();
        if (selectedColumn >= 0) {
            // Retrieve the date from the first row of the selected column
            Object dateValue = calendar.getValueAt(0, selectedColumn);
            if (dateValue != null) {
                try {
                    String selectedDateStr = dateValue.toString();
                    LocalDate selectedDate = LocalDate.parse(selectedDateStr);
                    LocalDate currentDate = LocalDate.now();

                    if (selectedDate.isBefore(currentDate)) {
                        JOptionPane.showMessageDialog(this, "You cannot add a task on a past date.", "Error", JOptionPane.ERROR_MESSAGE);
                    } else {
                        FormAddTask addTaskScreen = new FormAddTask(this, selectedDateStr);
                        addTaskScreen.setVisible(true);
                    }
                } catch (DateTimeParseException e) {
                    JOptionPane.showMessageDialog(this, "Invalid date format.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        } else {
            JOptionPane.showMessageDialog(this, "Please select a date to add a new task", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnAddTaskActionPerformed

    private void btnNextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNextActionPerformed
        goToNextWeek();
    }//GEN-LAST:event_btnNextActionPerformed

    private void btnPreviousActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPreviousActionPerformed
        goToPreviousWeek();
    }//GEN-LAST:event_btnPreviousActionPerformed

    private void btnEditTaskActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditTaskActionPerformed
        int selectedRow = calendar.getSelectedRow();
        int selectedColumn = calendar.getSelectedColumn();
        // Check that a task is selected, not the date row
        if (selectedRow >= 0 && selectedColumn >= 0) {
            Object dateValue = calendar.getValueAt(0, selectedColumn);
            if (dateValue != null) {
                String selectedDate = dateValue.toString();
                Object cellValue = calendar.getValueAt(selectedRow, selectedColumn);
                // valid cell is selected
                if (cellValue != null) {
                    String taskName = cellValue.toString();
                    List<Task> tasksForDate = calendarController.getTasksForDate(selectedDate);
                    Task selectedTask = tasksForDate.stream()
                                                    .filter(task -> task.getName().equals(taskName))
                                                    .findFirst()
                                                    .orElse(null);

                    if (selectedTask != null) {
                        FormEditTask editTaskForm = new FormEditTask(this, selectedTask);
                        editTaskForm.setVisible(true);
                    } else {
                        JOptionPane.showMessageDialog(this,
                            "No task found for the selected cell.",
                            "Task Not Found",
                            JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(this,
                        "Please select a task to edit.",
                        "No Task Selected",
                        JOptionPane.WARNING_MESSAGE);
                }
            }
        } else {
            JOptionPane.showMessageDialog(this,
                "Please select a task from the calendar.",
                "No Selection",
                JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btnEditTaskActionPerformed

    private void btnViewTaskActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnViewTaskActionPerformed
        int selectedRow = calendar.getSelectedRow();
        int selectedColumn = calendar.getSelectedColumn();
        // Check that a task is selected, not the date row
        if (selectedRow >= 0 && selectedColumn >= 0) {
            Object dateValue = calendar.getValueAt(0, selectedColumn);
            if (dateValue != null) {
                String selectedDate = dateValue.toString();
                Object cellValue = calendar.getValueAt(selectedRow, selectedColumn);
                // valid cell is selected
                if (cellValue != null) {
                    String taskName = cellValue.toString();
                    List<Task> tasksForDate = calendarController.getTasksForDate(selectedDate);
                    Task selectedTask = tasksForDate.stream()
                                                    .filter(task -> task.getName().equals(taskName))
                                                    .findFirst()
                                                    .orElse(null);

                    if (selectedTask != null) {
                        FormTaskDetails taskDetailsForm = new FormTaskDetails(this, selectedTask);
                        taskDetailsForm.setVisible(true);
                    } else {
                        JOptionPane.showMessageDialog(this,
                            "No task found for the selected cell.",
                            "Task Not Found",
                            JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(this,
                        "Please select a task to view its details.",
                        "No Task Selected",
                        JOptionPane.WARNING_MESSAGE);
                }
            }
        } else {
            JOptionPane.showMessageDialog(this,
                "Please select a task from the calendar.",
                "No Selection",
                JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btnViewTaskActionPerformed

    private void btnDeleteTaskActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteTaskActionPerformed
        int selectedRow = calendar.getSelectedRow();
        int selectedColumn = calendar.getSelectedColumn();
        // Check if a task is selected, not the date row
        if (selectedRow > 0 && selectedColumn >= 0) { 
            Object dateValue = calendar.getValueAt(0, selectedColumn); // Get the date from the first row
            if (dateValue != null) {
                String selectedDate = dateValue.toString();
                Object cellValue = calendar.getValueAt(selectedRow, selectedColumn);

                if (cellValue != null) {
                    String taskName = cellValue.toString();
                    List<Task> tasksForDate = calendarController.getTasksForDate(selectedDate);
                    Task selectedTask = tasksForDate.stream()
                                                    .filter(task -> task.getName().equals(taskName))
                                                    .findFirst()
                                                    .orElse(null);

                    if (selectedTask != null) {
                        // Confirm deletion
                        int confirm = JOptionPane.showConfirmDialog(this,
                                "Are you sure you want to delete this task?",
                                "Confirm Deletion",
                                JOptionPane.YES_NO_OPTION);

                        if (confirm == JOptionPane.YES_OPTION) {
                            // Perform deletion
                            TaskDAO taskDAO = new TaskDAO();
                            if (taskDAO.deleteTask(selectedTask.getTaskID())) {
                                JOptionPane.showMessageDialog(this, "Task deleted successfully.", "Success", JOptionPane.INFORMATION_MESSAGE);
                                calendarController.loadWeekTasks(); // Refresh the calendar
                            } else {
                                JOptionPane.showMessageDialog(this, "Failed to delete task.", "Error", JOptionPane.ERROR_MESSAGE);
                            }
                        }
                    } else {
                        JOptionPane.showMessageDialog(this, "No task selected.", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        } else {
            JOptionPane.showMessageDialog(this, "Please select a task to delete.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnDeleteTaskActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FormCalendar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormCalendar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormCalendar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormCalendar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                FormCalendar formCalendar = new FormCalendar();
                formCalendar.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddTask;
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnBack1;
    private javax.swing.JButton btnDeleteTask;
    private javax.swing.JButton btnEditTask;
    private javax.swing.JButton btnNext;
    private javax.swing.JButton btnPrevious;
    private javax.swing.JButton btnViewTask;
    private javax.swing.JTable calendar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}