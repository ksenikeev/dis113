package ru.itis.dis.lab07;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;

import java.io.IOException;
import java.util.Date;

@WebServlet("/simple")
public class SimpleServlet implements Servlet {

    public final Date date = new Date();

    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        System.out.println("init SimpleServlet");
    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    @Override
    public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
        System.out.println("service SimpleServlet");
        response.getWriter().println("Hello! " + this);
    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {
        System.out.println("destroy SimpleServlet");
    }
}
