package com.cydeo.lab08rest.service;

import com.cydeo.lab08rest.dto.ProductDTO;
import com.cydeo.lab08rest.entity.Product;

import java.math.BigDecimal;
import java.util.List;

public interface ProductService {

    List<ProductDTO> findAllProduct();
    List<ProductDTO> findTop3();
    ProductDTO findByName(String name);
    List<ProductDTO> findByCategoryId(Long id);

    List<ProductDTO> findByPriceAndQuantity(BigDecimal price,Integer quantity);
    Integer countProductByPrice(BigDecimal price);
    ProductDTO save(ProductDTO productDTO);
    List<ProductDTO> retrieveAllProductByCategoryAndPrice(List<Long> categoryList, BigDecimal price);
    ProductDTO update(ProductDTO productDTO);
}
