package ru.itis.lab2_10.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.itis.lab2_10.model.Groupp;
import ru.itis.lab2_10.services.ExamService;
import ru.itis.lab2_10.services.GrouppService;
import ru.itis.lab2_10.services.StudentService;
import ru.itis.lab2_10.services.SubjectService;

@Controller
public class RootController {

    @Autowired
    private GrouppService grouppService;
    @Autowired
    private StudentService studentService;
    @Autowired
    private ExamService examService;
    @Autowired
    private SubjectService subjectService;

    @GetMapping({"/","/index"})

    public String getRootPage(Model model) {

        model.addAttribute("groupps",
                grouppService.findAll());
        model.addAttribute("subjects",
                subjectService.findAll());
        model.addAttribute("students",
                studentService.findAll());
        model.addAttribute("exams",
                examService.findAll());

        return "index";
    }

}
