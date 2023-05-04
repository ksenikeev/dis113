package ru.itis.semestrii.services;

import org.springframework.beans.factory.annotation.Autowired;
import ru.itis.semestrii.dto.UnitsDto;
import ru.itis.semestrii.model.Units;
import ru.itis.semestrii.repositoryes.UnitsRepository;
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
