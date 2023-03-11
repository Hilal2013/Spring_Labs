package com.cydeo.lab05thymeleaf.repository;


import com.cydeo.lab05thymeleaf.model.Product;


import java.util.List;
import java.util.UUID;

public interface ProductRepository {
    boolean save(Product product);

    Product findProductById(UUID productId);

    List<Product> findAll();
}
