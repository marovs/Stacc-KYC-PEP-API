package com.example.stacckycpepapi.controller;

import com.example.stacckycpepapi.service.PepCompany;
import com.example.stacckycpepapi.service.PepPerson;
import com.example.stacckycpepapi.domainmodel.enheter.EnheterRoot;
import com.example.stacckycpepapi.domainmodel.roller.RollerRoot;
import com.example.stacckycpepapi.service.PepCheckService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class Controller {

    private final RestTemplate restTemplate = new RestTemplate();
    private static final String API_URL = "https://code-challenge.stacc.dev/api/";
    private static final String ROLLER = API_URL + "roller?orgNr=";
    private static final String ENHETER = API_URL + "enheter?orgNr=";

    /**
     * Endpoint that when requested performs a PEP check on provided name
     *
     * @param name Name of person to check
     * @return PepPerson object with number of hits and stored information about the person
     */
    @GetMapping("/pep")
    public PepPerson pep(@RequestParam(value = "name", defaultValue = "") String name) {
        return PepCheckService.checkPerson(name);
    }


    /**
     * Endpoint that when requested performs a PEP check of important people in provided company
     * <br><br>
     * Performs a call on API that retrieves information about company from <i>brønnøysundregistrene</i>
     *
     * @param orgNr Organization number of company to check
     * @return PepCompany object with number of hits on people in the company,
     * stored information about them and information about the company
     */
    @GetMapping("/roller")
    public PepCompany roller(@RequestParam(value = "orgNr", defaultValue = "") String orgNr) {
        if (orgNr.isBlank()) {
            return new PepCompany();
        }
        String url = ROLLER + orgNr;
        RollerRoot[] rollerRoots = restTemplate.getForObject(url, RollerRoot[].class);

        EnheterRoot enheterRoot = getEnheter(orgNr);

        return PepCheckService.checkCompany(rollerRoots, enheterRoot);
    }

    /**
     * Performs a call on API that retrieves information about company from <i>brønnøysundregistrene</i>
     *
     * @param orgNr Organization number of company to check
     * @return EnheterRoot object containing information about the company
     */
    private EnheterRoot getEnheter(String orgNr) {
        String url = ENHETER + orgNr;
        return restTemplate.getForObject(url, EnheterRoot.class);
    }
}
