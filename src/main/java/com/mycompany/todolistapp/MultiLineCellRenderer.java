/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.todolistapp;

import java.awt.Component;
import java.awt.Dimension;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.table.TableCellRenderer;

/**
 *
 * @author sean
 */
/**
 * MultiLineCellRenderer is a custom cell renderer that extends JTextArea 
 * and implements TableCellRenderer. It is used to render cells in a JTable 
 * that require support for multi-line text and dynamic row height adjustment.
 */
public class MultiLineCellRenderer extends JTextArea implements TableCellRenderer {

    /**
     * Constructor for MultiLineCellRenderer. Initializes the JTextArea 
     * with necessary properties for multi-line text rendering.
     */
    public MultiLineCellRenderer() {
        setLineWrap(true);  // Enable line wrapping within cells
        setWrapStyleWord(true);  // Ensure that lines are wrapped at word boundaries
        setOpaque(true);  // Set the component to be opaque to render background color
    }

    /**
     * Customizes the renderer component for each cell of the table.
     *
     * @param table The JTable that uses this renderer.
     * @param value The value of the cell to be rendered.
     * @param isSelected Whether the cell is selected.
     * @param hasFocus Whether the cell has focus.
     * @param row The row index of the cell.
     * @param column The column index of the cell.
     * @return The JTextArea used as the renderer component.
     */
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value,
                                                   boolean isSelected, boolean hasFocus,
                                                   int row, int column) {
        // Apply selection color or default color based on the cell's selection state
        if (isSelected) {
            setForeground(table.getSelectionForeground());
            setBackground(table.getSelectionBackground());
        } else {
            setForeground(table.getForeground());
            setBackground(table.getBackground());
        }

        // Set the text of the cell, using an empty string for null values
        setText((value == null) ? "" : value.toString());

        // Adjust the height of the row based on the content
        adjustRowHeight(table, row, column);
        return this;
    }

    /**
     * Adjusts the height of a row based on the content of its cells.
     *
     * @param table The JTable containing the cell.
     * @param row The row index of the cell.
     * @param column The column index of the cell.
     */
    private void adjustRowHeight(JTable table, int row, int column) {
        int cWidth = table.getTableHeader().getColumnModel().getColumn(column).getWidth();
        // Set the JTextArea size with a large enough height and the column width
        setSize(new Dimension(cWidth, 1000));
        int prefH = getPreferredSize().height; // Get the preferred height of JTextArea

        // Update the row height if it's less than the JTextArea's preferred height
        if (table.getRowHeight(row) < prefH) {
            table.setRowHeight(row, prefH);
        }
    }
}