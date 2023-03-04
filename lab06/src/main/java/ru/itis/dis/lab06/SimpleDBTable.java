package ru.itis.dis.lab06;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.util.Vector;

public class SimpleDBTable extends JFrame {

    public SimpleDBTable() {
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
        Vector<Vector<String>> data =
                new Vector<Vector<String>>();

        String url = "jdbc:postgresql://localhost:5432/demo";
        try (Connection conn =
                     DriverManager.getConnection(url,"postgres","passwd")) {

            // работа с БД;
            Statement statement = conn.createStatement();

            // Выборка данных (SELECT)
            String sql ="select airport_code,airport_name,city,coordinates from airports";
            ResultSet resultSet = statement.executeQuery(sql);

            columnNames.add("Code");
            columnNames.add("Name");
            columnNames.add("City");
            columnNames.add("coordinates");

            while (resultSet.next()) {
                Vector<String> row = new Vector<String>();
                row.add(resultSet.getString("airport_code"));
                row.add(resultSet.getString("airport_name"));
                row.add(resultSet.getString("city"));
                row.add(resultSet.getString("coordinates"));
                data.add(row);
            }

            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        JTable table = new JTable(data, columnNames);
        add(new JScrollPane(table));
    }
}
