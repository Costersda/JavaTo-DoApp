/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.todolistapp;

import java.time.LocalDate;
import javax.swing.JOptionPane;

/**
 *
 * @author sean
 */
public class FormTaskDetails extends javax.swing.JFrame {

        private FormTaskList formTaskListInstance;
        private FormCalendar formCalendarInstance;
        private String taskId;
        private Task task;
    
        public FormTaskDetails(FormTaskList formTaskList ,Task task) {        
            initComponents();
            this.formTaskListInstance = formTaskList;
            this.taskId = task.getTaskID(); 
            this.task = task;
            
            // Set the task details to labels
            titleLabel.setText("Task Title: " + task.getName());
            dueDateLabel.setText("Due Date: " + task.getDueDate());
            descriptionLabel.setText("Description: " + task.getDetails());
        }
        
       public FormTaskDetails(FormCalendar formCalendar, Task task) {
        initComponents();
        this.formCalendarInstance = formCalendar;
        this.taskId = task.getTaskID();
        this.task = task;
        
        // Set the task details to labels
        titleLabel.setText("Task Title: " + task.getName());
        dueDateLabel.setText("Due Date: " + task.getDueDate());
        descriptionLabel.setText("Description: " + task.getDetails());
    } 
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btnBack2 = new javax.swing.JButton();
        titleLabel = new javax.swing.JLabel();
        dueDateLabel = new javax.swing.JLabel();
        descriptionLabel = new javax.swing.JLabel();
        btnAddTask = new javax.swing.JButton();
        btnDeleteTask = new javax.swing.JButton();
        btnEditTask = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(630, 515));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setText("To-Do App");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 10, -1, -1));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel2.setText("Task Details");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 60, -1, -1));

        btnBack2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnBack2.setText("Back");
        btnBack2.setMargin(new java.awt.Insets(14, 14, 14, 14));
        btnBack2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBack2ActionPerformed(evt);
            }
        });
        getContentPane().add(btnBack2, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 410, 101, 45));

        titleLabel.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        titleLabel.setText("Task Title:");
        getContentPane().add(titleLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(39, 178, -1, -1));

        dueDateLabel.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        dueDateLabel.setText("Due Date:");
        getContentPane().add(dueDateLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(39, 221, -1, -1));

        descriptionLabel.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        descriptionLabel.setText("Description:");
        getContentPane().add(descriptionLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 265, -1, -1));

        btnAddTask.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnAddTask.setText("Add Task");
        btnAddTask.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddTaskActionPerformed(evt);
            }
        });
        getContentPane().add(btnAddTask, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 110, -1, -1));

        btnDeleteTask.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnDeleteTask.setText("Delete Task");
        btnDeleteTask.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteTaskActionPerformed(evt);
            }
        });
        getContentPane().add(btnDeleteTask, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 110, -1, -1));

        btnEditTask.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnEditTask.setText("Edit Task");
        btnEditTask.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditTaskActionPerformed(evt);
            }
        });
        getContentPane().add(btnEditTask, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 110, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddTaskActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddTaskActionPerformed
        // Use the correct constructor depending on where this form was opened
        if (formTaskListInstance != null){
            FormAddTask addTaskScreen = new FormAddTask(formTaskListInstance);
            addTaskScreen.setVisible(true);
        }
        if (formCalendarInstance != null){
            FormAddTask addTaskScreen = new FormAddTask(formCalendarInstance, task.getDueDateForSQLite());
            addTaskScreen.setVisible(true);
        }
        dispose();
    }//GEN-LAST:event_btnAddTaskActionPerformed

    private void btnBack2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBack2ActionPerformed
        dispose();
    }//GEN-LAST:event_btnBack2ActionPerformed

    private void btnDeleteTaskActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteTaskActionPerformed
        TaskDAO taskDAO = new TaskDAO();
        if (taskDAO.deleteTask(taskId)) {
            JOptionPane.showMessageDialog(this, "Task deleted successfully.", "Task Deleted", JOptionPane.INFORMATION_MESSAGE);
            // Refresh the correct list depending on where this form was accessed
            if (formTaskListInstance != null){
                formTaskListInstance.refreshTaskList();
            }
            if (formCalendarInstance != null) {
                formCalendarInstance.refreshCalendar();
            }
            dispose();
        } else {
            JOptionPane.showMessageDialog(this, "Failed to delete task.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnDeleteTaskActionPerformed

    private void btnEditTaskActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditTaskActionPerformed
        TaskDAO taskDAO = new TaskDAO();
        Task task = taskDAO.getTaskById(taskId);

        if (task != null) {
            // Pass the correct instance depending on where the form was accessed            
            if (formTaskListInstance != null){
                FormEditTask editTaskForm = new FormEditTask(formTaskListInstance, task);
                System.out.println("List instance created");
                editTaskForm.setVisible(true);
            }
            if (formCalendarInstance != null) {
                FormEditTask editTaskForm = new FormEditTask(formCalendarInstance, task);
                System.out.println("Calendar instance created");
                editTaskForm.setVisible(true);
            }
            dispose();
        } else {
            JOptionPane.showMessageDialog(this, "Failed to load task details.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnEditTaskActionPerformed

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
            java.util.logging.Logger.getLogger(FormTaskDetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormTaskDetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormTaskDetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormTaskDetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        Task exampleTask = new Task("1", "Sample Task", "This is a sample description", LocalDate.now());
        FormTaskList formTaskList = new FormTaskList();
        
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                
                FormTaskDetails detailsForm = new FormTaskDetails(formTaskList, exampleTask);
                detailsForm.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddTask;
    private javax.swing.JButton btnBack2;
    private javax.swing.JButton btnDeleteTask;
    private javax.swing.JButton btnEditTask;
    private javax.swing.JLabel descriptionLabel;
    private javax.swing.JLabel dueDateLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel titleLabel;
    // End of variables declaration//GEN-END:variables
}
