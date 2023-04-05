package ru.itis.lab2_8.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import ru.itis.lab2_8.model.AccessProtocol;
import ru.itis.lab2_8.repository.AccessProtocolRepository;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Controller
public class ProtocolController {

    @Autowired
    private AccessProtocolRepository repository;

    @GetMapping("/logs")
    @ResponseBody
    public String showLogsAsString() {
        // for, iterator.hasNext, iterator.next
        Iterable<AccessProtocol> logs = repository.findAll();

        String result ="";

        Iterator<AccessProtocol> iterator = logs.iterator();

        while (iterator.hasNext()) {
            AccessProtocol accessProtocol = iterator.next();
            result = result + ", " + accessProtocol.getAccessTime();
        }

        return result;
    }

    @GetMapping("/logspage")
    public String showLogsAsHTML(Model model) {
        // for, iterator.hasNext, iterator.next
        Iterable<AccessProtocol> logs = repository.findAll();

        List<AccessProtocol> result = new ArrayList<>();

        Iterator<AccessProtocol> iterator = logs.iterator();

        while (iterator.hasNext()) {
            AccessProtocol accessProtocol = iterator.next();
            result.add(accessProtocol);
        }

        model.addAttribute("protocols", result);

        return "protocol";
    }

    @GetMapping("/adminlogspage")
    public String showAdminLogsAsHTML(Model model) {
        // for, iterator.hasNext, iterator.next
        Iterable<AccessProtocol> logs =
                repository.findByUsernameOrSuccess("admin", true);

        List<AccessProtocol> result = new ArrayList<>();

        Iterator<AccessProtocol> iterator = logs.iterator();

        while (iterator.hasNext()) {
            AccessProtocol accessProtocol = iterator.next();
            result.add(accessProtocol);
        }

        model.addAttribute("protocols", result);
        // return html template protocol.ftlh
        return "protocol";
    }

}
