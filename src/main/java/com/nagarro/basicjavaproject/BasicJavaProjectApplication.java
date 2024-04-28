package com.nagarro.basicjavaproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
//@ComponentScan("com.nagarro")
public class BasicJavaProjectApplication {

    public static void main(String[] args) {
        SpringApplication.run(BasicJavaProjectApplication.class, args);
    }
}
