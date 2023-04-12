package ru.itis.lab2_10.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.itis.lab2_10.model.Exam;
import ru.itis.lab2_10.services.ExamService;

import java.util.List;

@Controller
public class ExamController {

    @Autowired
    private ExamService service;

    @GetMapping("/allscores")
    public String getAllScores(Model model) {

        Iterable<Exam> exams = service.findAll();

        model.addAttribute("exams", exams);

        return "allscores";
    }

}
