package com.cydeo.lab05thymeleaf.service.impl;


import com.cydeo.lab05thymeleaf.model.Product;
import com.cydeo.lab05thymeleaf.repository.ProductRepository;
import com.cydeo.lab05thymeleaf.service.ProductService;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }
    @Override
    public boolean productCreate(Product product){
        // todo implement method
        //first set Id
       product.setId(UUID.randomUUID());
       productRepository.save(product);
        return true;
    }

    @Override
    public List<Product> listProduct() {
        // todo implement method
        return productRepository.findAll();
    }

    @Override
    public Product findProductById(UUID uuid){
        // todo implement method
        return productRepository.findProductById(uuid);
    }

}
