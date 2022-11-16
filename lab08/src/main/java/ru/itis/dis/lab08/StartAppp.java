package ru.itis.dis.lab08;


import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@WebListener
public class StartAppp implements ServletContextListener {

    public static Connection connection = null;

    public static Connection getConnection() {
        try {
            if (connection == null || connection.isClosed())
                makeConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return connection;
    }

    private static void makeConnection() {
        try {
            Class.forName("org.postgresql.Driver");
            String url = "jdbc:postgresql://localhost:5432/kfu";
            connection =
                    DriverManager.getConnection(url,"postgres","passwd");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void contextInitialized(ServletContextEvent sce) {
        makeConnection();
    }

    public void contextDestroyed(ServletContextEvent sce) {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        System.out.println("app destroyed");
    }

}
