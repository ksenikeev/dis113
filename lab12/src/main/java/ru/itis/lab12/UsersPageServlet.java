package ru.itis.lab12;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet("/users")
public class UsersPageServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) {

        UserService service = new UserService();
        List<User> users = service.getAllUsers();

        request.setAttribute("users", users);

        try {
            request.getRequestDispatcher("show_users_page.jsp").forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
