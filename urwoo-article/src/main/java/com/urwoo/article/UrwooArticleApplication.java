package com.urwoo.article;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.urwoo.article"})
public class UrwooArticleApplication {
    public static void main( String[] args ) {
        SpringApplication.run(UrwooArticleApplication.class, args);
    }
}
