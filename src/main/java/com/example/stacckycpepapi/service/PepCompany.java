package com.example.stacckycpepapi.service;

import com.example.stacckycpepapi.domainmodel.enheter.EnheterRoot;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class PepCompany {

    public int numberOfCompanyHits;
    public List<PepPerson> companyHits;
    public EnheterRoot enhet;
}
