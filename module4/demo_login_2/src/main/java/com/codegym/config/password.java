package com.codegym.config;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class password {
    public static void main(String[] args) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encodedPassword = passwordEncoder.encode("123");

        System.out.println(encodedPassword);

    }
}