package ru.itis.semestrii.rest.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.itis.semestrii.rest.dto.ProductDto;
import ru.itis.semestrii.rest.model.Product;
import ru.itis.semestrii.rest.repositoryes.ProductRepository;
import ru.itis.semestrii.rest.repositoryes.UnitsRepository;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductRepository repository;
    @Autowired
    private UnitsRepository unitsRepository;

    public Product findByInnerUID(String innerUID) {
        return repository.findByInnerUID(innerUID);
    }

    public List<Product> getAll() {
        return repository.getAll();
    }

    public List<Product> getAllAfterDate(LocalDateTime time) {
        return repository.getAllAfterDate(time);
    }

    @Transactional
    public void addProduct(ProductDto productDto) {
        Product product = new Product();
        product.setInnerUID(productDto.getInnerUID());
        product.setName(productDto.getName());
        product.setUnits(unitsRepository.findByCode(productDto.getUnitsCode()));
        product.setCreateTime(LocalDateTime.now());
        repository.save(product);
    }

    public ProductDto toDto(Product product) {
        ProductDto productDto = new ProductDto();
        productDto.setName(product.getName());
        productDto.setInnerUID(product.getInnerUID());
        productDto.setUnitsCode(product.getUnits().getCode());
        return productDto;
    }

    public Product fromDto(ProductDto dto) {
        return findByInnerUID(dto.getInnerUID());
    }
}
