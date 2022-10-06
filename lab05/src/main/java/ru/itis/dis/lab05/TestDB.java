package ru.itis.dis.lab05;

import java.sql.*;

public class TestDB {
    public static void main(String[] args) {

        String url = "jdbc:postgresql://localhost:5432/kfu";
        //String url = "jdbc:h2:~/db_file";
        try (Connection conn =
             DriverManager.getConnection(url,"postgres","passwd")) {

            // работа с БД;


            Statement statement = conn.createStatement();
            // Выборка данных (SELECT)
            String sql ="select name,birthdate,gender,facultet_name,height from student";
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                System.out.print(resultSet.getString("name"));
                System.out.print("|");
                System.out.print(resultSet.getDate("birthdate"));
                System.out.print("|");
                System.out.print(resultSet.getString("gender"));
                System.out.print("|");
                System.out.print(resultSet.getString("facultet_name"));
                System.out.print("|");
                System.out.print(resultSet.getInt("height"));
                System.out.print("\n");
            }

            resultSet.close();

/*
            sql = "INSERT INTO facultet (name,build)" +
                    " VALUES ('ИТИС','Кремлевская 35')";
*/
            sql = "INSERT INTO student (name,birthdate,gender,facultet_name,height)" +
                    " VALUES ('Ахмад','2001-09-11','m','ИТИС',185)";

            int rows = statement.executeUpdate(sql);

            System.out.println("inserted " + rows + " rows");

            sql = "UPDATE student SET height = 187 WHERE name = 'Ахмад'";

            rows = statement.executeUpdate(sql);

            System.out.println("updated " + rows + " rows");

            sql = "DELETE FROM student WHERE name = 'Иван'";
            rows = statement.executeUpdate(sql);

            System.out.println("deleted " + rows + " rows");
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
