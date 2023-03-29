package ru.itis.lab2_8.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import ru.itis.lab2_8.dto.LoginDto;
import ru.itis.lab2_8.model.AccessProtocol;
import ru.itis.lab2_8.repository.AccessProtocolRepository;

import java.util.Date;

@Controller
public class LoginController {

    @Autowired
    private AccessProtocolRepository repository;

    @PostMapping("/login")

    /**
     * LoginDto - form data
     */
    @Transactional
    public String login(LoginDto loginDto) {

        System.out.println(loginDto);

        AccessProtocol protocol = new AccessProtocol();

        protocol.setUsername(loginDto.getUsername());
        protocol.setAccessTime(new Date());

        if (loginDto.getUsername().equals("Kamil")
                    &&
                loginDto.getPassword().equals("1234567")) {

            protocol.setSuccess(true);

            repository.save(protocol);

            return "success";
        }
        else {
            protocol.setSuccess(false);

            repository.save(protocol);
            return "error";
        }
    }
}
