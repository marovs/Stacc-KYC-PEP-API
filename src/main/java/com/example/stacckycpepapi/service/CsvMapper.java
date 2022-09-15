package com.example.stacckycpepapi.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class CsvMapper {

    private static List<Person> persons;

    public static void initializePersons() {
        try {
            persons = mapCSVToPerson();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * De-serializes rows of CSV file into Person objects
     *
     * @return List of Person objects
     */
    private static List<Person> mapCSVToPerson() throws IOException {
        List<String[]> stringArrays = getStringArrays();
        List<Person> persons = new ArrayList<>(stringArrays.size());

        for (String[] personArr : stringArrays.subList(1, stringArrays.size())) { // First array is header information
            int idx = 0;

            Person person = Person.builder()
                    .id(personArr[idx++])
                    .schema(personArr[idx++])
                    .name(personArr[idx++])
                    .aliases(personArr[idx++])
                    .birth_date(personArr[idx++])
                    .countries(personArr[idx++])
                    .addresses(personArr[idx++])
                    .identifiers(personArr[idx++])
                    .sanctions(personArr[idx++])
                    .phones(personArr[idx++])
                    .emails(personArr[idx++])
                    .dataset(personArr[idx++])
                    .last_seen(personArr[idx++])
                    .first_seen(personArr[idx])
                    .build();

            persons.add(person);
        }
        return persons;
    }

    private static List<String[]> getStringArrays() throws IOException {
        try (Stream<String> stringStream = Files.lines(Paths.get("src/main/resources/pep.csv"))) {
            return stringStream.map(line -> line
                    .substring(1, line.length()-1)
                    .split("\",\""))
                    .toList();
        }
    }

    public static List<Person> getPersons() {
        return persons;
    }
}
