/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.todolistapp;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class Main {

    public static void main(String[] args) {
        
        DatabaseHelper dbHelper = new DatabaseHelper();
        UserDAO userDAO = new UserDAO();
        // Load default user Dave from the database
        try (Connection connection = dbHelper.getConnection()) {
            User currentUser = userDAO.loadUser("Dave", connection);
            if (currentUser != null) {
                System.out.println("Loaded user: " + currentUser.getUsername());
            } else {
                System.out.println("User Dave not found.");
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }     


         //Testing code to delete all tasks and reset TaskId
//        try (Connection connection = DatabaseHelper.getConnection();
//             Statement statement = connection.createStatement()) {
//
//            // Delete all tasks
//            statement.executeUpdate("DELETE FROM Task;");
//
//            // Reset the auto-increment counter for 'Task'
//            statement.executeUpdate("DELETE FROM sqlite_sequence WHERE name='Task';");
//
//            System.out.println("All tasks deleted and taskId reset.");
//        } catch (SQLException | ClassNotFoundException e) {
//            e.printStackTrace();
//        }




        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception ex) {
            java.util.logging.Logger.getLogger(FormToDoMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormToDoMenu().setVisible(true);
            }
        });           
     
    }
        
}

