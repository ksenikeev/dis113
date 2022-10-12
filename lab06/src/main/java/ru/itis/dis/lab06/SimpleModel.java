package ru.itis.dis.lab06;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;

class SimpleModel extends AbstractTableModel {
    // количество строк
    public int getRowCount() {
        return 100;
    }

    // количество столбцов
    public int getColumnCount() {
        return 3;
    }

    // тип данных, хранимых в столбце
    public Class getColumnClass(int column) {
        switch (column) {
            case 0: return String.class;
            case 1: return Boolean.class;
            case 2: return Icon.class;
            default: return Object.class;
        }
    }
    // данные в ячейке
    public Object getValueAt(int row, int column) {
        boolean isEven = (row % 2 == 0);
// разные данные для разных стобцов
        switch (column) {
            case 0: return "" + row;
            case 1: return isEven;
            case 2: return new ImageIcon("smile.png");
        }
        return "Пусто";
    }
}