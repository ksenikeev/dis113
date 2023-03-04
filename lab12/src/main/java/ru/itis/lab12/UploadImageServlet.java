package ru.itis.lab12;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Загрузка файла и сохранение на сервере в директорию ~/img
 */
@WebServlet("/upimg")
@MultipartConfig
public class UploadImageServlet extends HttpServlet {

    private static final String UPLOAD_DIRECTORY = System.getProperty("user.home") + File.separator + "img";

    public void doPost(HttpServletRequest request, HttpServletResponse response) {

        String fileName = "";

        try {
            for (Part part : request.getParts()) {
                // получаем размер файла
                int fileSize = (int) part.getSize();
                // готовим буфер для получения данных
                byte[] img = new byte[fileSize];
                InputStream is = part.getInputStream();
                is.read(img);

                // получаем имя файла
                fileName = part.getSubmittedFileName();

                // сохраняем буфер в файл
                try(FileOutputStream fos
                            = new FileOutputStream(new File(UPLOAD_DIRECTORY + File.separator + fileName))) {
                    fos.write(img);
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        }

        request.setAttribute("file_name", fileName);

        try {
            request.getRequestDispatcher("img_page.jsp").forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
