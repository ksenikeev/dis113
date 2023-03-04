package ru.itis.semestr2.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.security.crypto.bcrypt.BCrypt;

@Getter@Setter
public class User {
    private Integer id;
    private String username;
    private String password;
    private String name;
    private String phone;
    private String cardNumber;
    private UserRole role;

    public void setPassword(String password) {
        this.password = BCrypt.hashpw(password, BCrypt.gensalt(12));
    }
}
