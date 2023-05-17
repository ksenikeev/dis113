package ru.itis.semestrii.rest.client;

import java.time.LocalDateTime;
import java.util.UUID;

public class UIDGenerator {
    public static void main(String[] args) {
        System.out.println(UUID.randomUUID());
        System.out.println(LocalDateTime.now());
    }
}
