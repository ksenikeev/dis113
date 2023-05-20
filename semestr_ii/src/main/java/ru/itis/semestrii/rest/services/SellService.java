package ru.itis.semestrii.rest.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.itis.semestrii.rest.dto.ProductDto;
import ru.itis.semestrii.rest.dto.SellDto;
import ru.itis.semestrii.rest.model.Sell;
import ru.itis.semestrii.rest.repositoryes.CountryRepository;
import ru.itis.semestrii.rest.repositoryes.SellRepository;

@Service
public class SellService {
    @Autowired
    private SellRepository sellRepository;
    @Autowired
    private CountryRepository countryRepository;

    @Autowired
    private ProductService productService;
    public Sell save(Sell sell){
        return sellRepository.save(sell);
    }

    public Sell fromDto(SellDto sellDto) {
        Sell sell = new Sell();
        sell.setProduct(productService.convertFromDto(sellDto.getProduct()));
        sell.setIsSelled(false);
//        sell.setCountry(countryRepository.findByAlpha3(sell));
        sell.setPrice(sellDto.getPrice());
        sell.setQuantity(sellDto.getQuantity());

        return sell;
    }
}
