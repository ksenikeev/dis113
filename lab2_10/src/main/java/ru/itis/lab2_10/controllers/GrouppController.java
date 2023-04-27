package ru.itis.lab2_10.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import ru.itis.lab2_10.dto.GroupDto;
import ru.itis.lab2_10.model.Groupp;
import ru.itis.lab2_10.services.GrouppService;

@Controller
public class GrouppController {

    @Autowired
    private GrouppService service;

    @GetMapping("/groupp")
    public String grouppIndex() {
        System.out.println("groupp");
        return "groupp";
    }

    @PostMapping("/addgroupp")
    public String addGroupp(GroupDto groupDto) {

        Groupp groupp = service.save(groupDto);

        return "groupp";
    }
}
