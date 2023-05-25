package ru.itis.semestrii.rest.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.itis.semestrii.rest.dto.PurchaseDto;

@RestController
public class PurchaseController {

    @PostMapping("/addpurchase")
    public PurchaseDto addPurchase(PurchaseDto purchaseDto) {
        return purchaseDto;
    }
}
