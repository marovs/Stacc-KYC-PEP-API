package com.example.stacckycpepapi.controller;

import com.example.stacckycpepapi.domainmodel.roller.Navn;
import com.example.stacckycpepapi.domainmodel.roller.Roller;
import com.example.stacckycpepapi.service.Pep;
import com.example.stacckycpepapi.service.CsvMapper;
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

    @GetMapping("/hello")
    public String index() {
        return "Hello World";
    }

    @GetMapping("/pepcheck")
    public Pep pep(@RequestParam(value = "name", defaultValue = "") String name) {
        return PepCheckService.pepCheck(name);
    }

    @GetMapping("/pep")
    public PepRoot getPep(@RequestParam(value = "name", defaultValue = "Knut Arild Hareide") String name) {
        String url = "https://code-challenge.stacc.dev/api/pep?name=" + name;

        return restTemplate.getForObject(url, PepRoot.class);
    }

    @GetMapping("/roller")
    public PepRoot getRoller(@RequestParam(value = "orgNr", defaultValue = "988971375") String orgNr) {
        String url = "https://code-challenge.stacc.dev/api/roller?orgNr=" + orgNr;
        System.out.println(url);

        RollerRoot[] rollerRoots = restTemplate.getForObject(url, RollerRoot[].class);

        for (RollerRoot rollerRoot : rollerRoots) {
            System.out.println(rollerRoot.type.beskrivelse);
            for (Roller roller : rollerRoot.roller) {
                if (roller.person != null)
                    System.out.println(roller.type.beskrivelse + ", " + roller.person.navn.fornavn + " " + roller.person.navn.etternavn);
            }
        }
        Navn navn = rollerRoots[1].roller.get(0).person.navn;
        String navnString = navn.fornavn + " " + navn.etternavn;


        return getPep(navnString);
    }

    @GetMapping("/enheter")
    public EnheterRoot getEnheter(@RequestParam(value = "orgNr", defaultValue = "981078365") String orgNr) {
        String url = "https://code-challenge.stacc.dev/api/enheter?orgNr=" + orgNr;

        return restTemplate.getForObject(url, EnheterRoot.class);
    }
}
