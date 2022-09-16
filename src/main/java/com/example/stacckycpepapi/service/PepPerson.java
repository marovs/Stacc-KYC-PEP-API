package com.example.stacckycpepapi.service;

import lombok.AllArgsConstructor;

import java.util.List;

/**
 * Object containing information about a PEP
 */
@AllArgsConstructor
public class PepPerson {

    public int numberOfHits;
    public List<Person> hits;
}
