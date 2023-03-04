package ru.itis.dis.lab09;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

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

        response.sendRedirect("/lab09/true.html");
    }
}
