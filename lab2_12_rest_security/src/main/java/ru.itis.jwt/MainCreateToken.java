package ru.itis.jwt;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;

public class MainCreateToken {

    private static final String SECRET = "123efeas134";

    // https://jwt.io/

    public static void main(String[] args) {
        User user = User.builder()
                .id(10L)
                .firstName("Kamil")
                .lastName("Enikeev")
                .email("ksenikeev@kpfu.ru")
                .role(User.Role.USER)
                .state(User.State.ACTIVE)
                .build();

        String token = JWT.create()
                .withSubject(user.getId().toString())
                .withClaim("role", user.getRole().toString())
                .withClaim("state", user.getState().toString())
                .withClaim("email", user.getEmail())
                .sign(Algorithm.HMAC256(SECRET));

        System.out.println(token);

    }
}
