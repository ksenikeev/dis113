package ru.itis.semestr2.weblistener;


import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Обработка событий старт и завершение приложения
 */
@WebListener
public class StartAppp implements ServletContextListener {

    public static Connection connection = null;

    // Singletone connection
    public static Connection getConnection() {
        Connection locConnection = connection;
        try {
            if (locConnection == null || locConnection.isClosed()) {

                synchronized (StartAppp.class) {
                    locConnection = connection;
                    if (locConnection == null || locConnection.isClosed()) {
                        connection = locConnection = makeConnection();
                    }
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return connection;
    }

    private static Connection makeConnection() {
        try {
            Class.forName("org.postgresql.Driver");
            String url = "jdbc:postgresql://localhost:5432/taxi";
            connection =
                    DriverManager.getConnection(url,"postgres","passwd");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return connection;
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
