package ru.itis.dis.lab10;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

// form handler
@WebServlet("/adduser")
public class AddUserServlet extends HttpServlet {

    public void doPost(HttpServletRequest request, HttpServletResponse response) {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String group = request.getParameter("group");

        try {
            request.setAttribute("username", username);
            request.setAttribute("group", group);

            request.getRequestDispatcher("showuserdata.jsp").forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
