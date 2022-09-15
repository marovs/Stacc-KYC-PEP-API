package com.example.stacckycpepapi.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class CsvMapper {

    public static final List<Person> persons = mapCSVToPerson();

    /**
     * De-serializes rows of CSV file into Person objects
     *
     * @return List of Person objects
     */
    public static List<Person> mapCSVToPerson() {
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

    /**
     * Reads pep.csv line by line and maps each line to a String[] after splitting appropriately
     *
     * @return List of String[]
     */
    private static List<String[]> getStringArrays() {
        try (Stream<String> stringStream = Files.lines(Paths.get("src/main/resources/pep.csv"))) {
            return stringStream.map(line -> line
                    .substring(1, line.length()-1)
                    .split("\",\""))
                    .toList();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
