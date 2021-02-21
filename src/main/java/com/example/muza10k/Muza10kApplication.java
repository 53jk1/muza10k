package com.example.muza10k;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan("com.example.muza10k.services")
@SpringBootApplication

public class Muza10kApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(Muza10kApplication.class, args);
    }
}
