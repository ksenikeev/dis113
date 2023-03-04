package ru.itis.lab12;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

import java.io.IOException;
import java.io.InputStream;

/**
 */
@WebServlet("/user")
public class ShowUserServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) {

        String userId = request.getParameter("userId");//request.getPathInfo().substring(1);
        System.out.println(userId);


        try {
            Integer id = Integer.parseInt(userId);

            UserService service = new UserService();
            User user = service.getUserById(id);
            request.setAttribute("userdata", user);

            request.getRequestDispatcher("show_userdata_page.jsp").forward(request,response);

        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (NumberFormatException e) {
            request.getHeaderNames().asIterator().forEachRemaining(s -> System.out.println(s+":"+request.getHeader(s)));
            request.getAttributeNames().asIterator().forEachRemaining(s -> System.out.println(s+":"+request.getAttribute(s)));
        }
    }
}
