package ru.itis.dis.lab07;

import jakarta.servlet.*;
import java.io.IOException;
import java.io.PrintWriter;


public class ServletRequestInfo implements Servlet {
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {

    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    @Override
    public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
        PrintWriter writer = response.getWriter();
        writer.println(request.getRemotePort());
        writer.println(request.getRemoteHost());
        writer.println(request.getRemoteAddr());
        writer.println(request.getProtocol());
        writer.println(request.getLocalPort());
        writer.println(request.getScheme());
        writer.println(request.getLocalAddr());
        writer.println(request.getContentType());
        writer.println(request.getRealPath(""));
    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {

    }
}
