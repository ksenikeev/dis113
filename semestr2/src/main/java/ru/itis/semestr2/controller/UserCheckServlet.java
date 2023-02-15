package ru.itis.semestr2.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import ru.itis.semestr2.model.*;
import ru.itis.semestr2.repository.TripRepository;
import ru.itis.semestr2.repository.UserCheckRepository;
import ru.itis.semestr2.repository.UserRepository;

import java.io.IOException;
import java.util.List;

// save registration data
@WebServlet("/usercheck")
public class UserCheckServlet extends HttpServlet {

    public void doPost(HttpServletRequest request, HttpServletResponse response) {

        String successPage = "client_page.jsp";
        String errorMessage = "";

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        UserCheckRepository repository = new UserCheckRepository();

        User user = repository.checkUser(username, password);

        if (user != null) {
            if (user.getRole().getId() == 2) {
                successPage = "driver_page.jsp";

                TripRepository tripRepository = new TripRepository();
                List<Trip> trips = tripRepository.getFreeTrips();
                request.setAttribute("trips", trips);
            }

            HttpSession session = request.getSession(true);
            session.setAttribute("user", user);
        } else {
            successPage = "login_page.jsp";
            errorMessage = "Неверный логин или пароль!";
        }


        try {
            request.setAttribute("error_msg", errorMessage);
            request.getRequestDispatcher(successPage).forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
