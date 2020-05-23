package com.codegym.laptopmanager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
public class LaptopManagerApplication {

    public static void main(String[] args) {
        SpringApplication.run(LaptopManagerApplication.class, args);
    }

}
