package com.example.stacckycpepapi.service;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Getter;

import java.util.LinkedList;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@Getter
@Builder
public class Person {

    private String id;
    private String schema;
    private String name;
    private List<String> aliases;
    private String birth_date;
    private String countries;
    private String addresses;
    private String identifiers;
    private String sanctions;
    private String phones;
    private String emails;
    private String dataset;
    private String last_seen;
    private String first_seen;

    @JsonIgnore
    public List<String> getNames() {
        List<String> names = new LinkedList<>(aliases);
        if (!containsIgnoreCase(names)) {
            names.add(0, name);
        }
        return names;
    }

    private boolean containsIgnoreCase(List<String> names) {
        for (String name : names) {
            if (name.equalsIgnoreCase(this.name)) {
                return true;
            }
        }
        return false;
    }
}
