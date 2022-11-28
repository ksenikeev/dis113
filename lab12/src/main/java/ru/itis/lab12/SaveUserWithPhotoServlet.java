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
 * Обработка формы с данными пользователя и фотографии
 * сохраняем в БД
 */
@WebServlet("/saveuser")
@MultipartConfig
public class SaveUserWithPhotoServlet extends HttpServlet {

    public void doPost(HttpServletRequest request, HttpServletResponse response) {

        User user = new User();

        user.setUsername(request.getParameter("username"));

        user.setPassword(request.getParameter("password"));

        user.setPhone(request.getParameter("phone"));

        try {
            for (Part part : request.getParts()) {
                if (part.getName().equals("imgfile")) {
                    // получаем размер файла
                    int fileSize = (int) part.getSize();
                    // готовим буфер для получения данных
                    byte[] img = new byte[fileSize];
                    InputStream is = part.getInputStream();
                    is.read(img);
                    user.setPhoto(img);
                }
            }

            UserService service = new UserService();
            service.saveUser(user);

        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        }

        try {
            request.getRequestDispatcher("img_page.jsp").forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
