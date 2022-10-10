package com.vont.myshopping.controller.api;

import com.vont.myshopping.models.dto.ProductDto;
import com.vont.myshopping.service.IProductService;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
@RequestMapping("api/product")
public class ProductAPI {
    private final IProductService productService;

    public ProductAPI(IProductService productService) {
        this.productService = productService;
    }
    @GetMapping("{id}")
    public ProductDto getOne (@PathVariable Long id) {
        return productService.findById(id);
    }
}
