package com.example.stacckycpepapi.controller;

import com.example.stacckycpepapi.model.PepCheck;
import com.example.stacckycpepapi.model.Person;
import com.example.stacckycpepapi.model.enheter.EnheterRoot;
import com.example.stacckycpepapi.model.pep.PepRoot;
import com.example.stacckycpepapi.model.roller.RollerRoot;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class Controller {

    @GetMapping("/hello")
    public String index() {
        return "Hello World";
    }

    @GetMapping("/pep")
    public Person pep(@RequestParam(value = "name", defaultValue = "") String name) {
        return PepCheck.pepCheck(name);
    }

    @GetMapping("/callhello")
    private String getHelloClient() {
        String url = "http://localhost:8080/hello";
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject(url, String.class);
    }

    @GetMapping("/knut")
    public PepRoot getKnut() {
        String url = "https://code-challenge.stacc.dev/api/pep?name=Knut Arild Hareide";

        RestTemplate restTemplate = new RestTemplate();

        return restTemplate.getForObject(url, PepRoot.class);
    }

    @GetMapping("/roller")
    public RollerRoot[] getRoller() {
        String url = "https://code-challenge.stacc.dev/api/roller?orgNr=988971375";

        RestTemplate restTemplate = new RestTemplate();

        return restTemplate.getForObject(url, RollerRoot[].class);
    }

    @GetMapping("/enheter")
    public EnheterRoot getEnheter() {
        String url = "https://code-challenge.stacc.dev/api/enheter?orgNr=981078365";

        RestTemplate restTemplate = new RestTemplate();

        return restTemplate.getForObject(url, EnheterRoot.class);
    }
}
