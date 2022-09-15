package com.example.stacckycpepapi.service;

import java.util.ArrayList;

public class PepCheckService {

    public static Pep pepCheck(String name) { // TODO: Refine searching. Allow searching using aliases
        int numberOfHits = 0;
        ArrayList<Person> hits = new ArrayList<>();
        for (Person person : CsvMapper.getPersons()) {
            if (person.getName().equalsIgnoreCase(name.trim())) {
                numberOfHits++;
                hits.add(person);
            }
        }
        return new Pep(numberOfHits, hits);
    }
}
