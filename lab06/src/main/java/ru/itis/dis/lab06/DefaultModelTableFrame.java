package ru.itis.dis.lab06;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class DefaultModelTableFrame extends JFrame {

    private JTable table;
    private DefaultTableModel dtm;


    public DefaultModelTableFrame() {
        super();
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(600, 600);
        this.setTitle("Inner Frame");

        init();

        this.setVisible(true);
    }

    private void init() {
        this.setLayout(new GridLayout(1, 1));

        dtm = new DefaultTableModel();
        // задаем названия стоблцов
        dtm.setColumnIdentifiers(
                new String[] {"Номер", "Товар", "Цена"});
        // наполняем модель данными
        dtm.addRow(new String[] {"№1", "Блокнот", "5.5"});
        dtm.addRow(new String[] {"№2", "Телефон", "175"});
        dtm.addRow(new String[] {"№3", "Карандаш", "1.2"});
        table = new JTable(dtm);


        add(new JScrollPane(table));

    }
}
