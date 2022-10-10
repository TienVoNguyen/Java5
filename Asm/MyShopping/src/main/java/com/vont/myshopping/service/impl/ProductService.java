package com.vont.myshopping.service.impl;

import com.vont.myshopping.models.dto.ProductDto;
import com.vont.myshopping.models.entity.Category;
import com.vont.myshopping.models.entity.Product;
import com.vont.myshopping.repository.CategoryRepository;
import com.vont.myshopping.repository.ProductRepository;
import com.vont.myshopping.service.IProductService;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService implements IProductService {
    private final ProductRepository productRepository;

    private final CategoryRepository categoryRepository;
    private final ModelMapper modelMapper;
    public ProductService(ProductRepository productRepository, CategoryRepository categoryRepository, ModelMapper modelMapper) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public Product save(Product product) {
        return productRepository.save(product);
    }

    @Override
    public void delete(long[] ids) {
        for (long id:ids) {
            productRepository.deleteById(id);
        }
    }

    @Override
    public ProductDto findById(Long id) {
        Optional<Product> product = productRepository.findById(id);
        return this.convertToDTO(product.orElseGet(Product::new));
    }

    @Override
    public List<ProductDto> findByCategory(Long id) {
        return this.getProductDTOList(productRepository.findAllByCategory_Id(id));
    }

    @Override
    public List<ProductDto> findAll(Pageable pageable) {
        return this.getProductDTOList(productRepository.findAll(pageable).getContent());
    }

    @Override
    public List<ProductDto> findAll() {
        return this.getProductDTOList(productRepository.findAll());
    }

    private List<ProductDto> getProductDTOList( List<Product> productList) {
        List<ProductDto> productDTOList = new ArrayList<>();
        for(Product product: productList) {
            ProductDto productDTO = convertToDTO(product);

            productDTOList.add(productDTO);
        }
        return productDTOList;
    }

    private Product convertToModel(ProductDto productDTO) {
        Product blog = modelMapper.map(productDTO, Product.class);
        if (productDTO.getId() != null) {
            Product oldProduct = productRepository.getReferenceById(productDTO.getId());
            blog.setId(oldProduct.getId());
            blog.setCreateDate(oldProduct.getCreateDate());
        }
        Category category = categoryRepository.findById(productDTO.getCategoryId()).get();
        blog.setCategory(category);
        return blog;
    }

    private ProductDto convertToDTO(Product product) {
        ProductDto productDTO = modelMapper.map(product, ProductDto.class);

        productDTO.setCategoryId(product.getCategory().getId());
        return productDTO;
    }
}
