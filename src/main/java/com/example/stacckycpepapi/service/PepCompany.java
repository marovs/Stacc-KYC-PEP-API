package com.example.stacckycpepapi.service;

import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class PepCompany {

    public int numberOfCompanyHits;
    public List<PepPerson> companyHits;
}
