package semestrii.gui.services;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import semestrii.gui.repositoryes.ProductRepository;
import semestrii.gui.repositoryes.UnitsRepository;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.Charset;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import semestrii.gui.model.*;
import semestrii.gui.dto.ProductDto;

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

        if (productDto.getInnerUID() == null) {
            productDto.setInnerUID(UUID.randomUUID().toString());
        }

        product.setInnerUID(productDto.getInnerUID());
        product.setName(productDto.getName());
        product.setUnits(unitsRepository.findByCode(productDto.getUnitsCode()));
        product.setCreateTime(LocalDateTime.now());
        repository.save(product);

        // send to REST API : POST htt[://localhost:8090/product/add

        try {
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(new URI("http://localhost:8090/product/add"))
                    .header("Content-Type","application/json")
                    .POST(HttpRequest.BodyPublishers.ofString(productDto.toJSON())).build();

            HttpResponse response = HttpClient
                    .newHttpClient()
                    .send(request,HttpResponse.BodyHandlers.ofString());
            String resp = (String) response.body();

        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

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
