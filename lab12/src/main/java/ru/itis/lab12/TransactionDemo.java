package ru.itis.lab12;

import java.sql.*;

public class TransactionDemo {

    public static void main(String[] args) {
        try {
            Class.forName("org.postgresql.Driver");
            String url = "jdbc:postgresql://localhost:5432/kfu";
            Connection connection =
                    DriverManager.getConnection(url,"postgres","passwd");

            // add new USER:
            String sql1 =
                    "insert into users (username,password) values ('Iskandar','1') returning id";
            String sql2 =
                    "insert into user_info (id,phone) values (?, '876897696')";

            // begin transaction;
            connection.setAutoCommit(false);

            Integer id = null;
            PreparedStatement ps1 = connection.prepareStatement(sql1);

            // Query 1
            ResultSet rs = ps1.executeQuery();
            if (rs.next()) {
                id = rs.getInt("id");
            }

            if (id != null) {
                PreparedStatement ps2 = connection.prepareStatement(sql2);
                ps2.setInt(1, id);
                //Query 2
                ps2.executeUpdate();
                ps2.close();
            } else {
                connection.rollback();
            }

            rs.close();
            ps1.close();

            // end transaction;
            connection.commit();
            connection.setAutoCommit(true);

            connection.close();

        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }


}
