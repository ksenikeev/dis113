package ru.itis.dis.lab07;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

@WebServlet("/demo")
public class DBDemoServlet implements Servlet {

    private Connection conn;

    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        try {
            Class.forName("org.postgresql.Driver");
            String url = "jdbc:postgresql://localhost:5432/demo";
            conn =
                    DriverManager.getConnection(url,"postgres","passwd");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        try {
            // работа с БД;
            Statement statement = conn.createStatement();
            String sql = "SELECT passenger_name, passenger_id from tickets t " +
                    "join Ticket_flights tf on t.ticket_no=tf.ticket_no " +
                    "join flights f on f.flight_id=tf.flight_id " +
                    "where departure_airport='SVO' and scheduled_departure::date='2017-09-10'";

            ResultSet resultSet = statement.executeQuery(sql);

            PrintWriter writer = servletResponse.getWriter();

            writer.print("<html><head><meta charset='UTF-8'></head><body>");
            writer.print("<h1> Заголовок 1</h1>");
            writer.print("<h2> Заголовок 2</h2>");
            writer.print("<h3> Заголовок 3</h3>");
            writer.print("<h4> Заголовок 4</h4>");
            writer.print("<h5> Заголовок 5</h5>");
            writer.print("<h6> Заголовок 6</h6>");

            writer.print("<table><thead><th>Name</th><th>Passport</th></thead>");
            writer.print("<tbody>");
            while (resultSet.next()) {
                writer.print("<tr>");
                writer.print("<td>");
                writer.print(resultSet.getString("passenger_name"));
                writer.print("</td>");
                writer.print("<td>");
                writer.print(resultSet.getString("passenger_id"));
                writer.print("</td>");
                writer.print("</tr>");
            }
            writer.print("</tbody></table>");
            writer.print("</body></html>");

            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {
        try {
            if (conn != null && !conn.isClosed()) {
                conn.close();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
