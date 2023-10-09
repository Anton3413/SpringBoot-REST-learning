package com.example.springboot.rest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
public class SpringbootRestLearningApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootRestLearningApplication.class, args);
    }

}
