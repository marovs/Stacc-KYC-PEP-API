package com.example.stacckycpepapi;

import com.example.stacckycpepapi.service.CsvMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class StaccKycPepApiApplication {

    public static void main(String[] args) {
        CsvMapper.mapCSVToPerson();
        SpringApplication.run(StaccKycPepApiApplication.class, args);
    }

}
