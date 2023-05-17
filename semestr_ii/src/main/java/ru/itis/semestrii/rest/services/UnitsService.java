package ru.itis.semestrii.rest.services;

import org.springframework.beans.factory.annotation.Autowired;
import ru.itis.semestrii.rest.dto.UnitsDto;
import ru.itis.semestrii.rest.model.Units;
import ru.itis.semestrii.rest.repositoryes.UnitsRepository;
import java.util.List;

public class UnitsService {
    @Autowired
    private UnitsRepository repository;

    public Units findByCode(String code) {
        return repository.findByCode(code);
    }

    public List<Units> getAll() {
        return repository.getAll();
    }

    public UnitsDto convertToDto(Units units) {
        UnitsDto unitsDto = new UnitsDto();
        unitsDto.setId(units.getId());
        unitsDto.setCode(unitsDto.getCode());
        unitsDto.setName(unitsDto.getName());
        return unitsDto;
    }

    public Units convertFromDto(UnitsDto dto) {
        return findByCode(dto.getCode());
    }
}
