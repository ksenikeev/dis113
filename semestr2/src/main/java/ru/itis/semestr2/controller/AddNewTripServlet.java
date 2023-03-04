package ru.itis.semestr2.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import ru.itis.semestr2.model.*;
import ru.itis.semestr2.repository.TripRepository;
import ru.itis.semestr2.repository.UserRepository;

import java.io.IOException;

// add new trip
@WebServlet("/addtrip")
public class AddNewTripServlet extends HttpServlet {

    public void doPost(HttpServletRequest request, HttpServletResponse response) {

        String page = "error_page.jsp";

        // Проверка аутентификации
        HttpSession session = request.getSession(false);

        if (session == null || session.getAttribute("user") == null) {
            try {
                request.getRequestDispatcher("login_page.jsp").forward(request,response);
            } catch (ServletException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return;
        }
        User user = (User) session.getAttribute("user");
        // Проверка Авторизации (проверка роли)
        if (user.getRole().getId() == 1) {

            String adddressFrom = request.getParameter("address_from");
            String adddressTo = request.getParameter("address_to");

            TripRepository repository = new TripRepository();
            repository.addTrip(adddressFrom, adddressTo, user.getId());

            // Show page Trip status
            request.setAttribute("address_from", adddressFrom);
            request.setAttribute("address_to", adddressTo);
            request.setAttribute("trip_status", "Заказана");
            page = "trip_page.jsp";

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
