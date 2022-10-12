package ru.itis.dis.lab06;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.*;

public class ExModelTableFrame extends JFrame {

    private JTable table;
    private SimpleModel sm;
    private DbModel dbModel;

    private Statement statement;
    private ResultSet resultSet;

    public ExModelTableFrame() {
        super();
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(800, 600);
        this.setTitle("Table Models");

        init();

        this.setVisible(true);
    }

    private void init() {
        this.setLayout(new GridLayout(1, 1));

        //sm = new SimpleModel();
        //table = new JTable(sm);

        dbModel = new DbModel(true);
        try {
            dbModel.setDataSource(getDataSource());
        } catch (Exception e) {
            e.printStackTrace();
        }
        table = new JTable(dbModel);


        add(new JScrollPane(table));


    }

    private ResultSet getDataSource() {

        String url = "jdbc:postgresql://localhost:5432/demo";
        try (Connection connection =
                     DriverManager.getConnection(url, "postgres", "passwd")) {

            // работа с БД;
            statement = connection.createStatement();

            // Выборка данных (SELECT)
            String sql = "select airport_code,airport_name,city,coordinates from airports";
            resultSet = statement.executeQuery(sql);

            return resultSet;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }
}