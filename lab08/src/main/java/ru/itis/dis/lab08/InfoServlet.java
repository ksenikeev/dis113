package ru.itis.dis.lab08;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.security.crypto.bcrypt.BCrypt;

import java.io.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

@WebServlet("/info")
public class InfoServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession(false);
        if (session != null) {
            String userName = (String) session.getAttribute("username");

            InputStream is = getClass().getClassLoader()
                    .getResourceAsStream("info.html");
            BufferedInputStream isr =
                    new BufferedInputStream(is);
            String info = new String(isr.readAllBytes());
            System.out.println(info);
            info = info.replace("${username}", userName);
            response.getWriter().println(info);
        } else {
            response.sendRedirect("/lab08/false.html");
        }
    }
}
