package com.vont.myshopping.service;

import com.vont.myshopping.models.dto.ProductDto;
import com.vont.myshopping.models.entity.Product;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IProductService {
    Product save(Product product);
    void delete(long[] ids);
    ProductDto findById(Long id);
    List<ProductDto> findByCategory(Long id);
    List<ProductDto> findAll(Pageable pageable);

    List<ProductDto> findAll();
}
