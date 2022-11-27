package ru.itis.dis.lab11;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

@WebServlet("/value")
public class ValueServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) {
        try {
            PrintWriter pw = response.getWriter();
            pw.print("Hello!");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(
                request.getInputStream()));

        String jsonData = reader.readLine();

        try {
            PrintWriter pw = response.getWriter();
            pw.print(jsonData);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


}
