package com.ibm.controller;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Import;

import com.ibm.properties.DatabaseProperties;

@SpringBootApplication
@EnableConfigurationProperties
@Import(DatabaseProperties.class)
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);

    }
}