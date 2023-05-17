package ru.itis.semestrii.rest.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.itis.semestrii.rest.dto.CountryDto;
import ru.itis.semestrii.rest.services.CountryService;

import java.util.List;

@RestController
@RequestMapping("/country")//service name
public class CountryRestController {

    @Autowired
    private CountryService service;

    @GetMapping("/{alpha3}")
    public CountryDto getCountryByAlpha3(@PathVariable("alpha3") String alpha3) {
        return service.findByAlpha3(alpha3);
    }

    @GetMapping("/all")
    public List<CountryDto> getAllCountry() {
        return service.getAll();
    }

    @PostMapping("/add")
    public CountryDto addCountry(@RequestBody CountryDto dto) {
        dto = service.addCountry(dto);
        return dto;
    }

    @PutMapping("/edit")
    public CountryDto editCountry(@RequestBody CountryDto dto) {
        dto = service.editCountry(dto);
        return dto;
    }

    @DeleteMapping("/delete/{id}")
    public void deleteCountry(@PathVariable("id") Long id) {
        service.deleteById(id);
    }

}
