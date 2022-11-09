package ru.itis.dis.lab08;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.security.crypto.bcrypt.BCrypt;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

@WebServlet("/login")
public class AuthHttpServlet extends HttpServlet {

    /*
        Дописать аутентификацию,
        если верно - redirect (302) true.html
        иначе - false.html
     */
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

        String login = request.getParameter("login");
        String password = request.getParameter("password");

        String dbPassword = "";
        try {
            // работа с БД;
            Statement statement = StartAppp.getConnection().createStatement();
            String sql = "SELECT username, password from users " +
                    "where username = '" + login + "'";
            ResultSet resultSet = statement.executeQuery(sql);

            if(resultSet.next()) {
                dbPassword = resultSet.getString("password");
            }

            resultSet.close();
            statement.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        if (BCrypt.checkpw(password, dbPassword)) {
            HttpSession session = request.getSession(true);
            session.setAttribute("username", login);
            response.sendRedirect("/lab08/true.html");
        } else
            response.sendRedirect("/lab08/false.html");
    }
}
