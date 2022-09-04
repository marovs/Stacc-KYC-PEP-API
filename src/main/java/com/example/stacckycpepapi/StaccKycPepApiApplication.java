package com.example.stacckycpepapi;

import com.example.stacckycpepapi.model.PepCheck;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class StaccKycPepApiApplication {

    public static void main(String[] args) {
        PepCheck pepCheck = new PepCheck();
        SpringApplication.run(StaccKycPepApiApplication.class, args);
    }

}
