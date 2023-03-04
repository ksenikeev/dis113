package ru.itis.dis.lab08;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/simple")
public class SimpleHttpServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String content = "";

        PrintWriter pw = response.getWriter();

        pw.println(request.getMethod());
        pw.println(request.getProtocol());
        pw.println(request.getContextPath());
        pw.println(request.getPathInfo());

        pw.println(request.getContentLength());
        pw.println(request.getContentType());

        pw.println(request.getHeader("User-Agent"));
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

        String login = request.getParameter("login");
        String password = request.getParameter("password");


        PrintWriter pw = response.getWriter();
        pw.println("Hello from POST SimpleHttpServlet");
        pw.println("User: " + login);
        pw.println("Password: " + password);

        pw.println(request.getMethod());
        pw.println(request.getProtocol());
        pw.println(request.getContextPath());
        pw.println(request.getPathInfo());

        pw.println(request.getContentLength());
        pw.println(request.getContentType());

        pw.println(request.getHeader("User-Agent"));
    }
}
