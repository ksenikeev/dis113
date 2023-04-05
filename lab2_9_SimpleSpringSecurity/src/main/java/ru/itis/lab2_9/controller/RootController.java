package ru.itis.lab2_9.controller;

import org.springframework.security.access.method.P;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RootController {

    @GetMapping("/")
    // http://localhost:8090/?
    public String getIndex(Model model) {
        model.addAttribute("text", "111");
        return "index";
    }

    //@PostMapping("/login")
}
