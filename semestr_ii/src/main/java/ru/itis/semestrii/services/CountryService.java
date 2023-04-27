package ru.itis.semestrii.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.itis.semestrii.dto.CountryDto;
import ru.itis.semestrii.model.Country;
import ru.itis.semestrii.repositoryes.CountryRepository;

import java.util.List;

@Service
public class CountryService {

    @Autowired
    private CountryRepository repository;

    public CountryDto findByAlpha3(String alpha3) {
        Country country = repository.findByAlpha3(alpha3);

        CountryDto countryDto =
                 country != null ? new CountryDto(country) : null;
        return countryDto;
    }

    public List<CountryDto> getAll() {
        List<Country> lst = repository.getAll();

        List<CountryDto> result = lst
                .stream()
                .map(country -> new CountryDto(country))
                .toList();
        return result;
    }

}
