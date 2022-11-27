package ru.itis.lab12;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

@WebServlet("/userphoto/*")
public class ShowImageFromDBServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) {
        String userId = request.getPathInfo().substring(1);

        Integer id = Integer.parseInt(userId);

        UserService service = new UserService();
        byte[] photo = service.getPhoto(id);

        response.setContentType("image/jpeg");
        try {
            response.getOutputStream().write(photo);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
