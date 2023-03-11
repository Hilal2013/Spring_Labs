package com.cydeo.lab05thymeleaf.service;


import com.cydeo.lab05thymeleaf.model.Product;


import java.util.List;
import java.util.UUID;

public interface ProductService {
    boolean productCreate(Product product);
    List<Product> listProduct();
    Product findProductById(UUID uuid);
}
