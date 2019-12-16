package com.example.pets.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins= "http://localhost:4200")
public class PetController {

    @Autowired
    OAuth2RestTemplate oAuth2RestTemplate;

    @GetMapping("/pets")
    public String findAllPets() {
        return oAuth2RestTemplate.getForObject("https://api.petfinder.com/v2/animals", String.class);
    }
}
