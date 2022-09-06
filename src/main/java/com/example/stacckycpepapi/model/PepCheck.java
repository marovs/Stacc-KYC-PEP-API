package com.example.stacckycpepapi.model;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.ResourceLoader;

import java.io.IOException;
import java.util.List;

public class PepCheck {

    public static PepCheck INSTANCE;
    private static List<Person> persons;

    public PepCheck() {
        if (INSTANCE == null) {
            INSTANCE = this;
        }

        try {
            persons = mapPepData();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * De-serializes JSON into Person objects
     *
     * @return List of Person objects
     */
    private List<Person> mapPepData() throws IOException {
        ResourceLoader resourceLoader = new DefaultResourceLoader();
        ObjectMapper objectMapper = new ObjectMapper();

        return objectMapper.readValue(resourceLoader.getResource("classpath:pep_small.json").getInputStream(), new TypeReference<>() {
        });
    }

    public static Person pepCheck(String name) { // TODO: Refine searching. Allow searching using aliases
        for (Person person : persons) {
            if (person.getName().equalsIgnoreCase(name.trim())) {
                return person;
            }
        }
        return null;
    }
}
