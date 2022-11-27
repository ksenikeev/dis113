package ru.itis.lab12;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

// show index page
@WebServlet("/showimg/*")
public class ShowImageServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) {
        String fileName = request.getPathInfo().substring(1);

        File file =
            new File(Consts.UPLOAD_DIRECTORY + File.separator + fileName);

        try(FileInputStream fis = new FileInputStream(file)) {

            byte[] buffer = new byte[4096];
            int r = 0;
            while ((r = fis.read(buffer)) != -1) {
                response.getOutputStream().write(buffer,0, r);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
