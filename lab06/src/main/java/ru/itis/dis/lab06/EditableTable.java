package ru.itis.dis.lab06;

import javax.swing.*;
import javax.swing.event.CellEditorListener;
import javax.swing.event.ChangeEvent;
import java.awt.*;
import java.sql.*;
import java.util.Vector;

public class EditableTable extends JFrame {

    public EditableTable() {
        super();
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(800, 600);
        this.setTitle("Simple tabl DB");

        init();

        this.setVisible(true);
    }

    private void init() {
        this.setLayout(new GridLayout(1, 1));

        Vector<String> columnNames = new Vector<>();
        Vector<Vector<String>> data = new Vector<Vector<String>>();

        columnNames.add("Name");
        columnNames.add("Color");

        Vector<String> row1 = new Vector<String>();
        row1.add("Камиль");
        row1.add("Зеленый");
        data.add(row1);

        Vector<String> row2 = new Vector<String>();
        row2.add("Хоссам");
        row2.add("Красный");
        data.add(row2);

        Vector<String> row3 = new Vector<String>();
        row3.add("Зияд");
        row3.add("Белый");
        data.add(row3);

        JComboBox combo = new JComboBox(
            new String[] { "Зеленый", "Желтый", "Белый", "Красный", "Синий"});

        DefaultCellEditor editor = new DefaultCellEditor(combo);

        editor.addCellEditorListener(new CellEditorListener() {
            @Override
            public void editingStopped(ChangeEvent e) {
                System.out.println(((DefaultCellEditor)e.getSource()).getCellEditorValue());
            }

            @Override
            public void editingCanceled(ChangeEvent e) {
                System.out.println("edit canseling");
            }
        });

        JTable table = new JTable(data, columnNames);

        table.getColumnModel().getColumn(1).
                setCellEditor(editor);

        add(new JScrollPane(table));
    }
}
