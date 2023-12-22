/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.todolistapp;

import javax.swing.DefaultListSelectionModel;

/**
 *
 * @author sean
 */
public class CustomListSelectionModel extends DefaultListSelectionModel {
    private static final int UNSELECTABLE_ROW = 0;

    @Override
    public void setSelectionInterval(int index0, int index1) {
        if (index0 == UNSELECTABLE_ROW || index1 == UNSELECTABLE_ROW) {
            // Prevents the first row from being selected.
            clearSelection();
        } else {
            super.setSelectionInterval(index0, index1);
        }
    }

    @Override
    public void addSelectionInterval(int index0, int index1) {
        if (index0 == UNSELECTABLE_ROW || index1 == UNSELECTABLE_ROW) {
            return;
        }
        super.addSelectionInterval(index0, index1);
    }
}