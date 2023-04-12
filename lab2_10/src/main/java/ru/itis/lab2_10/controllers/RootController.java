package ru.itis.lab2_10.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RootController {

    @GetMapping({"/","/index"})
    public String getRootPage() {
        return "index";
    }

}
