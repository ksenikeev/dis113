package semestrii.gui.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import semestrii.gui.dto.ProductDto;
import semestrii.gui.services.ProductService;
import java.util.List;

@Controller
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/newproduct")
    public String getCountryByPageNative(Model model) {
        return "newproduct";
    }

    @PostMapping("/addproduct")
    public String getCountryByPage(Model model, ProductDto productDto) {
        productService.addProduct(productDto);
        return "newproduct";
    }
}
