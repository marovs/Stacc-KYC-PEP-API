package com.example.stacckycpepapi.controller;

import com.example.stacckycpepapi.model.PepCheck;
import com.example.stacckycpepapi.model.Person;
import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.core.io.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

@RestController
public class Controller {

    @GetMapping("/")
    public String index() throws IOException {
//        InputStream stream = PepCheck.loadPepData();
//        Files.copy(stream, new File("src/main/resources/test").toPath(), StandardCopyOption.REPLACE_EXISTING);
//        File jsonFile = PepCheck.loadPepData();
//        JsonNode node = PepCheck.objectMapper.readTree(jsonFile);
//        for (Iterator<JsonNode> it = node.elements(); it.hasNext(); ) {
//            JsonNode jsonNode = it.next();
//            for (Iterator<Map.Entry<String, JsonNode>> iter = jsonNode.fields(); iter.hasNext(); ) {
//                Map.Entry<String, JsonNode> field = iter.next();
//                System.out.println(field.getKey() + " " + field.getValue());
//            }
//        }
//        List<Person> personList = PepCheck.mapPepData();

        return "Hello World";
    }

    @GetMapping("/pep")
    public Person pep(@RequestParam(value = "name", defaultValue = "") String name) {
//        return new Person(name); // TODO
        return PepCheck.pepCheck(name);
    }
}
