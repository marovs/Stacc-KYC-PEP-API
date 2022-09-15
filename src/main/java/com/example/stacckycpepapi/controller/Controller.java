package com.example.stacckycpepapi.controller;

import com.example.stacckycpepapi.service.PepCompany;
import com.example.stacckycpepapi.service.PepPerson;
import com.example.stacckycpepapi.domainmodel.enheter.EnheterRoot;
import com.example.stacckycpepapi.domainmodel.pep.PepRoot;
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
    private static final String PEP = API_URL + "pep?name=";
    private static final String ROLLER = API_URL + "roller?orgNr=";
    private static final String ENHETER = API_URL + "enheter?orgNr=";

    @GetMapping("/hello")
    public String index() {
        return "Hello World";
    }

    // TODO: Remove endpoint
    @GetMapping("/pepcheck")
    public PepPerson pep(@RequestParam(value = "name", defaultValue = "") String name) {
        return PepCheckService.checkPerson(name);
    }

    @GetMapping("/pep")
    public PepRoot getPep(@RequestParam(value = "name", defaultValue = "Knut Arild Hareide") String name) {
        String url = PEP + name;
        return restTemplate.getForObject(url, PepRoot.class);
    }

    @GetMapping("/roller")
    public PepCompany getRoller(@RequestParam(value = "orgNr", defaultValue = "988971375") String orgNr) {
        String url = ROLLER + orgNr;
        RollerRoot[] rollerRoots = restTemplate.getForObject(url, RollerRoot[].class);

        EnheterRoot enheterRoot = getEnheter(orgNr);

        return PepCheckService.checkCompany(rollerRoots, enheterRoot);
    }

    // TODO: Keep endpoint?
    @GetMapping("/enheter")
    public EnheterRoot getEnheter(@RequestParam(value = "orgNr", defaultValue = "981078365") String orgNr) {
        String url = ENHETER + orgNr;
        return restTemplate.getForObject(url, EnheterRoot.class);
    }
}
