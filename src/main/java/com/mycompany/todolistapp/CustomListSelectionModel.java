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
/**
 * CustomListSelectionModel extends DefaultListSelectionModel to customize
 * the selection behavior in a JTable. Specifically, it prevents the first row
 * from being selectable.
 */
public class CustomListSelectionModel extends DefaultListSelectionModel {
    // Constant representing the unselectable row index
    private static final int UNSELECTABLE_ROW = 0;

    /**
     * Overrides setSelectionInterval to block selection of the first row.
     *
     * @param index0 one end of the interval.
     * @param index1 other end of the interval.
     */
    @Override
    public void setSelectionInterval(int index0, int index1) {
        // Check if either index corresponds to the unselectable row
        if (index0 == UNSELECTABLE_ROW || index1 == UNSELECTABLE_ROW) {
            // Clear selection to prevent the first row from being selected
            clearSelection();
        } else {
            // Proceed with normal selection behavior
            super.setSelectionInterval(index0, index1);
        }
    }

    /**
     * Overrides addSelectionInterval to prevent adding the first row to the current selection.
     *
     * @param index0 one end of the interval.
     * @param index1 other end of the interval.
     */
    @Override
    public void addSelectionInterval(int index0, int index1) {
        // Check if either index corresponds to the unselectable row
        if (index0 == UNSELECTABLE_ROW || index1 == UNSELECTABLE_ROW) {
            // Do nothing to prevent adding the first row to the selection
            return;
        }
        // Proceed with normal behavior for adding to the selection
        super.addSelectionInterval(index0, index1);
    }
}