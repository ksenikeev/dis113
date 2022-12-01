package ru.itis.semestr2.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import ru.itis.semestr2.model.*;
import ru.itis.semestr2.repository.UserRepository;

import java.io.IOException;

// save registration data
@WebServlet("/savereg")
public class SaveRegistrationServlet extends HttpServlet {

    public void doPost(HttpServletRequest request, HttpServletResponse response) {

        String successPage = "client_page.jsp";

        String role_id = request.getParameter("user_role");
        User user = UserFactory.getNewUser(
                new UserRole(Integer.parseInt(role_id)));

        user.setName(request.getParameter("name"));
        user.setPhone(request.getParameter("phone"));
        user.setCardNumber(request.getParameter("card_number"));
        user.setUsername(request.getParameter("username"));
        user.setPassword(request.getParameter("password"));

        if (user instanceof Driver) {
            Car car = new Car(
                    request.getParameter("car_number"),
                    request.getParameter("car_brand"),
                    request.getParameter("color")
            );
            ((Driver) user).setCar(car);
            successPage = "driver_page.jsp";
        }

        UserRepository repository = new UserRepository();
        user = repository.saveUser(user);

        if (user.getId() != null) {
            HttpSession session = request.getSession(true);
            session.setAttribute("user", user);
        }
        try {
            request.getRequestDispatcher(successPage).forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
