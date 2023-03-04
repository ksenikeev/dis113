package ru.itis.dis.lab07;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/simplehttp")
public class SimpleHttpServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) {
        try {
            response.getWriter().write("Hello from servlet!");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
