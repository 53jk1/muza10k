package com.example.muza10k;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;

@SpringBootApplication
@EnableGlobalMethodSecurity(securedEnabled = true)
public class Muza10kApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(Muza10kApplication.class, args);
    }
}
