package com.example.stacckycpepapi.service;

import com.example.stacckycpepapi.domainmodel.roller.Roller;
import com.example.stacckycpepapi.domainmodel.roller.RollerRoot;

import java.util.ArrayList;
import java.util.List;

public class PepCheckService {

    public static PepPerson checkPerson(String name) { // TODO: Refine searching. Allow searching using aliases
        int numberOfHits = 0;
        List<Person> hits = new ArrayList<>();
        for (Person person : CsvMapper.persons) {
            if (person.getName().equalsIgnoreCase(name.trim())) {
                numberOfHits++;
                hits.add(person);
            }
        }
        return new PepPerson(numberOfHits, hits);
    }

    public static PepCompany checkCompany(RollerRoot[] rollerRoots) {
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
        return new PepCompany(numberOfCompanyHits, companyHits);
    }

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
