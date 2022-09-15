package com.example.stacckycpepapi.service;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class Person {

    private String id;
    private String schema;
    private String name;
    private String aliases; // TODO: Split into list of aliases
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

}
