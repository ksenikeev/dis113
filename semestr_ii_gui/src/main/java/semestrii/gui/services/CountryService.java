package ru.itis.semestrii.rest.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.itis.semestrii.rest.dto.CountryDto;
import ru.itis.semestrii.rest.model.Country;
import ru.itis.semestrii.rest.repositoryes.CountryRepository;

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

    @Transactional
    public CountryDto addCountry(CountryDto countryDto) {
        Country country = new Country();
        country.setName(countryDto.getName());
        country.setCode(countryDto.getCode());
        country.setAlpha3(countryDto.getAlpha3());
        country.setCurrency(countryDto.getCurrency());
        country.setId(repository.getNexId());
        country = repository.save(country);
        countryDto.setId(country.getId());
        return countryDto;
    }

    @Transactional
    public CountryDto editCountry(CountryDto countryDto) {
        Country country = repository.findByAlpha3(countryDto.getAlpha3());
        country.setName(countryDto.getName());
        country.setCode(countryDto.getCode());
        country.setAlpha3(countryDto.getAlpha3());
        country.setCurrency(countryDto.getCurrency());
        country.setId(countryDto.getId());
        if (country.getAlpha2() == null)
            country.setAlpha2(countryDto.getAlpha3().substring(0,2));
        if (country.getFullName() == null)
            country.setFullName(countryDto.getName());

        country = repository.save(country);

        return countryDto;
    }

    @Transactional
    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
