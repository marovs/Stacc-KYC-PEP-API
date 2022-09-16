package com.example.stacckycpepapi.service;

import com.example.stacckycpepapi.domainmodel.enheter.EnheterRoot;
import com.example.stacckycpepapi.domainmodel.roller.Roller;
import com.example.stacckycpepapi.domainmodel.roller.RollerRoot;

import java.util.ArrayList;
import java.util.List;

public class PepCheckService {

    /**
     * Performs a PEP check on the given name by comparing with known politically exposed persons
     *
     * @param name Name of person to check
     * @return PepPerson object with number of hits and stored information about the person
     */
    public static PepPerson checkPerson(String name) { // TODO: Refine/optimize searching
        int numberOfHits = 0;
        List<Person> hits = new ArrayList<>();
        String trimmedName = name.trim();
        for (Person person : CsvMapper.persons) {
            for (String personName : person.getNames()) {
                if (personName.equalsIgnoreCase(trimmedName)) {
                    numberOfHits++;
                    hits.add(person);
                }
            }
        }
        return new PepPerson(numberOfHits, hits);
    }

    /**
     * Performs a PEP check of important people in provided company
     *
     * @param rollerRoots Object containing information about roles in the company
     * @param enheterRoot Object containing information about the company
     * @return PepCompany object with number of hits on people in the company,
     * stored information about them and information about the company
     */
    public static PepCompany checkCompany(RollerRoot[] rollerRoots, EnheterRoot enheterRoot) {
        int numberOfCompanyHits = 0;
        List<PepPerson> companyHits = new ArrayList<>();
        List<String> names = findNamesFromRoller(rollerRoots);

        for (String name : names) {
            PepPerson pepPerson = checkPerson(name);
            int numberOfHits = pepPerson.numberOfHits;
            if (numberOfHits > 0) {
                numberOfCompanyHits += numberOfHits;
                companyHits.add(pepPerson);
            }
        }
        return new PepCompany(numberOfCompanyHits, companyHits, enheterRoot);
    }

    /**
     * Extracts the names of important people in provided company
     *
     * @param rollerRoots Object containing information about roles in the company
     * @return List of names of important people in the company
     */
    private static List<String> findNamesFromRoller(RollerRoot[] rollerRoots) {
        List<String> names = new ArrayList<>();

        for (RollerRoot rollerRoot : rollerRoots) {
            for (Roller roller : rollerRoot.roller) {
                if (roller.person != null) {
                    names.add(roller.person.navn.formatName());
                }
            }
        }
        return names;
    }


}
