package ru.itis.semestrii.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import ru.itis.semestrii.dto.CountryDto;
import ru.itis.semestrii.services.CountryService;

import java.util.List;

@RestController
public class CountryRestController {

    @Autowired
    private CountryService service;

    @GetMapping("/country/{alpha3}")
    public CountryDto getCountryByAlpha3(@PathVariable("alpha3") String alpha3) {
        return service.findByAlpha3(alpha3);
    }

    @GetMapping("/country/all")
    public List<CountryDto> getAllCountry() {
        return service.getAll();
    }

}
