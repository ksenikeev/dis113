package ru.itis.dis.lab06;

import javax.swing.*;
import java.awt.*;
import java.util.Vector;

public class SimpleTableFrame extends JFrame {

    public SimpleTableFrame() {
        super();
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(600, 600);
        this.setTitle("Inner Frame");

        init();

        this.setVisible(true);
    }

    private void init() {

        this.setLayout(new GridLayout(3, 1));

        JTable table;
        // Table data
        Object[][] data = new String[][] {
                { "Красный", "Зеленый", "Синий" },
                { "Желтый", "Оранжевый", "Белый" },
        };
        // column header
        Object[] header = new String[] {
                "Цвет", "Еще цвет", "Тоже цвет"
        };
        table = new JTable(data, header);
        add(new JScrollPane(table));


        JTable table2 = new JTable(5, 5);
        add(new JScrollPane(table2));

        Vector<String> columnNames = new Vector<>();
        Vector<Vector<String>> data1 =
                new Vector<Vector<String>>();
        Vector<String> row1 = new Vector<String>();
        Vector<String> row2 = new Vector<String>();for (int i=0; i<4; i++) {
            columnNames.add("Столбец #" + i);
        }
        JTable table3 = new JTable(data1, columnNames);
        add(new JScrollPane(table3));

    }
}
