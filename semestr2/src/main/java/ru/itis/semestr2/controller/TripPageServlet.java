package ru.itis.semestr2.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import ru.itis.semestr2.model.Trip;
import ru.itis.semestr2.model.User;
import ru.itis.semestr2.repository.TripRepository;

import java.io.IOException;

// show registration page
@WebServlet("/trip")
public class TripPageServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) {

        String page = "login_page.jsp";

        String idParam = request.getParameter("id");

        HttpSession session = request.getSession(false);
        if (session != null && session.getAttribute("user") != null ) {
            User user = (User) session.getAttribute("user");

            TripRepository repository = new TripRepository();
            Trip trip = repository.findTrip(Integer.parseInt(idParam));

            request.setAttribute("trip", trip);
            if (user.getRole().getId() == 2) {
                page = "driver_trip_page.jsp";
            } else {
                page = "trip_page.jsp";
            }
        }

        try {
            request.getRequestDispatcher(page).forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
