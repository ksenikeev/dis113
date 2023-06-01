package ru.itis.jwt;

import lombok.*;

@Getter@Setter@Builder
public class User {

    private static final long serialVersionUID = 9132222312087392904L;

    private Long id;

    private String email;

    private String hashPassword;

    private State state;

    private Role role;

    private String firstName;
    private String lastName;
    private String patronymic;

    public enum State {
        ACTIVE, BANNED
    }

    public enum Role {
        USER, ADMIN
    }

    public boolean isActive() {
        return this.state == State.ACTIVE;
    }

    public boolean isBanned() {
        return this.state == State.BANNED;
    }

    public boolean isAdmin() {
        return this.role == Role.ADMIN;
    }

}
