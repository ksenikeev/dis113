package ru.itis.lab2_10.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import ru.itis.lab2_10.dto.StudentDto;
import ru.itis.lab2_10.model.Groupp;
import ru.itis.lab2_10.services.GrouppService;
import ru.itis.lab2_10.services.StudentService;

import java.util.ArrayList;
import java.util.List;

@Controller
public class StudentController {

    @Autowired
    private StudentService service;
    @Autowired
    private GrouppService grouppService;

    @GetMapping("/student")
    public String studentIndex(Model model) {
        List<Groupp> groupps = new ArrayList<>();
        grouppService.findAll().forEach(g -> groupps.add(g));

        model.addAttribute("groupps", groupps);

        return "student";
    }

    @PostMapping("/addstudent")
    public String addStudent(StudentDto studentDto) {
        service.save(studentDto);
        return "student";
    }

}
