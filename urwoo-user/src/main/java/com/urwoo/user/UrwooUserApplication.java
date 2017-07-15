package com.urwoo.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.urwoo.user"})
public class UrwooUserApplication {

    public static void main(String[] args) {
        SpringApplication.run(UrwooUserApplication.class, args);
    }
}
