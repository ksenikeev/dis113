package ru.itis.lab2_11.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import ru.itis.dis.s2lab10.controllers.dto.LoginFormDto;
import ru.itis.lab2_11.repositoryes.UserRepository;

@Controller
public class LoginFormController {

    @Autowired
    private UserRepository repository;

    @GetMapping("/login")
    public String loginPage(Model model) {
        return "login";
    }

    @PostMapping("/usercheck")
    public String loginForm(HttpServletRequest request, Model model, LoginFormDto form) {

        try {
            request.login(form.getUsername(), form.getPassword());
        } catch (ServletException e) {
            e.printStackTrace();
        }
        return "/";

    }
}
