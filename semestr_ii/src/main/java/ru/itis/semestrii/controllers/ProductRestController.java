package ru.itis.semestrii.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.itis.semestrii.dto.CountryDto;
import ru.itis.semestrii.dto.ProductDto;
import ru.itis.semestrii.services.CountryService;
import ru.itis.semestrii.services.ProductService;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/product")//service name
public class ProductRestController {

    @Autowired
    private ProductService service;

    @GetMapping("/all")
    public List<ProductDto> getAllProduct() {
        return service.getAll()
                .stream()
                .map(product -> service.convertToDto(product))
                .toList();
    }

    @GetMapping("/allfrom") // /allfrom?time=2023-05-04T11:30
    public List<ProductDto> getAllProductFromTime(
            @RequestParam("time") LocalDateTime time) {
        return service.getAllAfterDate(time)
                .stream()
                .map(product -> service.convertToDto(product))
                .toList();
    }

    @PostMapping("/add")
    public void addCountry(@RequestBody ProductDto dto) {
        service.addProduct(dto);
    }
}
