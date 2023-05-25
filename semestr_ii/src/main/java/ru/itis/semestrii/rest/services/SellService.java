package ru.itis.semestrii.rest.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.itis.semestrii.rest.dto.SellDto;
import ru.itis.semestrii.rest.model.Sell;
import ru.itis.semestrii.rest.repositoryes.CountryRepository;
import ru.itis.semestrii.rest.repositoryes.SellRepository;

@Service
public class SellService {
    @Autowired
    private SellRepository sellRepository;
    @Autowired
    private ProductService productService;
    @Autowired
    private ManufacturerService manufacturerService;
    @Autowired
    private CountryRepository countryRepository;
    public Sell save(Sell sell){
        return sellRepository.save(sell);
    }
    public SellDto save(SellDto sell){

        return toDto(sellRepository.save(fromDto(sell)));
    }

    public Sell fromDto(SellDto sellDto) {
        Sell sell = new Sell();
        sell.setProduct(productService.fromDto(sellDto.getProduct()));
        sell.setIsSelled(false);
//        sell.setCountry(countryRepository.findByAlpha3(sell));
        sell.setPrice(sellDto.getPrice());
        sell.setQuantity(sellDto.getQuantity());

        return sell;
    }

    public SellDto toDto(Sell sell) {
        SellDto dto = new SellDto();
        dto.setCurrency(sell.getCurrency().getCode3());
        dto.setPrice(sell.getPrice());
        dto.setQuantity(sell.getQuantity());
        dto.setSellDate(sell.getSellDate());
        dto.setProduct(productService.toDto(sell.getProduct()));
        dto.setManufacturer(
                manufacturerService.toDto(sell.getManufacturer()));
        return dto;
    }
}
