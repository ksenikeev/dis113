package ru.itis.semestrii.rest.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.itis.semestrii.rest.dto.SellDto;
import ru.itis.semestrii.rest.services.SellService;

import java.util.List;

@RestController
public class SellController {

    @Autowired
    private SellService service;

    @PostMapping("/addsell")
    public SellDto addSell(SellDto sellDto) {
        return service.save(sellDto);
    }

    @GetMapping("/allsells")
    public List<SellDto> allSell() {
        return null;
    }

    @GetMapping("/allsellsproduct")
    public List<SellDto> allSellProduct(@RequestParam("product") String product) {
        return null;
    }
}
