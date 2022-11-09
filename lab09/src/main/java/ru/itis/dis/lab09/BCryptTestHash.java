package ru.itis.dis.lab09;


import org.springframework.security.crypto.bcrypt.BCrypt;

public class BCryptTestHash {
    public static void main(String[] args) {

        String password = "321";

        String pw_hash = BCrypt.hashpw(password, BCrypt.gensalt(12));

        System.out.println(pw_hash);

        /*
            password: 1 - 72 bytes

            $2a$12$OQNab5.VZQM.QNXi6bumveTMvSvdP2cLap1viE613PZe19ikAl2Vq
            \_/ \_/\____________________/\_____________________________/
             A   C          S                         H
            A - algorythm (BCrypt)
            C - cost
            S - salt (16 bytes) 22 char
            H - hash (24 bytes) 31 char
            radix-64 в bcrypt использует таблицу./ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789
         */

        if (BCrypt.checkpw("123", pw_hash))
            System.out.println("It matches");
        else
            System.out.println("It does not match");



    }
}
