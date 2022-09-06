package com.example.stacckycpepapi.controller;

import com.example.stacckycpepapi.model.PepCheck;
import com.example.stacckycpepapi.model.Person;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    @GetMapping("/")
    public String index() {
        return "Hello World";
    }

    @GetMapping("/pep")
    public Person pep(@RequestParam(value = "name", defaultValue = "") String name) {
        return PepCheck.pepCheck(name);
    }
}
