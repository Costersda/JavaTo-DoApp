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
public class MultiLineCellRenderer extends JTextArea implements TableCellRenderer {
    
    // Constructor
    public MultiLineCellRenderer() {
        setLineWrap(true);
        setWrapStyleWord(true);
        setOpaque(true);
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value,
                                                   boolean isSelected, boolean hasFocus,
                                                   int row, int column) {
        // Change the foreground and background colors when a cell is selected
        if (isSelected) {
            setForeground(table.getSelectionForeground());
            setBackground(table.getSelectionBackground());
        } else {
            setForeground(table.getForeground());
            setBackground(table.getBackground());
        }
        // Set the text of the cell to the value passed; if null, set it to an empty string
        setText((value == null) ? "" : value.toString());
        adjustRowHeight(table, row, column);
        return this;
    }

    // Method to adjust the row height to fit the content
    private void adjustRowHeight(JTable table, int row, int column) {
        int cWidth = table.getTableHeader().getColumnModel().getColumn(column).getWidth();
        setSize(new Dimension(cWidth, 1000));
        int prefH = getPreferredSize().height;
        if (table.getRowHeight(row) < prefH) {
            table.setRowHeight(row, prefH);
        }
    }
}