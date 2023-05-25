package ru.itis.semestrii.rest.services;

import org.springframework.stereotype.Service;
import ru.itis.semestrii.rest.dto.ManufacturerDto;
import ru.itis.semestrii.rest.model.Manufacturer;

@Service
public class ManufacturerService {

    public ManufacturerDto toDto(Manufacturer manufacturer) {
        ManufacturerDto dto = new ManufacturerDto();
        dto.setUid(manufacturer.getUid());
        dto.setName(manufacturer.getName());
        dto.setAddress(manufacturer.getAddress());
        return dto;
    }

}
