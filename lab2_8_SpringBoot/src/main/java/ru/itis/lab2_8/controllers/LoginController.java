package ru.itis.lab2_8.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
/*
    public String login(@RequestParam("username") String username,
                        @RequestParam("password") String password) {
*/

        System.out.println(loginDto);

        AccessProtocol protocol = new AccessProtocol();

        protocol.setUsername(loginDto.getUsername());
        protocol.setAccessTime(new Date());

        if (loginDto.getUsername().equals("admin")
                    &&
                loginDto.getPassword().equals("admin")) {

            protocol.setSuccess(true);

            repository.save(protocol);

            return "success";
        } else {
            protocol.setSuccess(false);

            repository.save(protocol);
            return "error";
        }
    }
}
