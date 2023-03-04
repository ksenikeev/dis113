package ru.itis.dis.lab08;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;

@WebServlet(value = {"/currency","/currency/add"})
public class CurrencyServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
            response.getWriter().println("/currency");
    }
}
