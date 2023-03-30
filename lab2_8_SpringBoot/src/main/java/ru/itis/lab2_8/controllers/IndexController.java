package ru.itis.lab2_8.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

    @RequestMapping({"/","/index"})
    public String index(Model model) {
        // -> index.ftlh

        model.addAttribute("message","Hello!");

        return "index";
    }

}
