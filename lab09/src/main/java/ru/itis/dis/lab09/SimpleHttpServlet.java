package ru.itis.dis.lab09;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/index")
public class SimpleHttpServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String content = "";

        List<DbModel> dataModel = new ArrayList<>();
        request.setAttribute("tblData", dataModel);

        try {
            System.out.println("forward");
            request.getRequestDispatcher("index.ftlh").forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    class DbModel {
        public String field1;
        public String field2;
        public String field3;
    }

}
