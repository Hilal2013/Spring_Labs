package com.cydeo.lab08rest.service.impl;

import com.cydeo.lab08rest.dto.CustomerDTO;
import com.cydeo.lab08rest.dto.ProductDTO;
import com.cydeo.lab08rest.entity.Customer;
import com.cydeo.lab08rest.entity.Product;
import com.cydeo.lab08rest.mapper.MapperUtil;
import com.cydeo.lab08rest.repository.ProductRepository;
import com.cydeo.lab08rest.service.ProductService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {

    private  final ProductRepository productRepository;
    private final MapperUtil mapperUtil;

    public ProductServiceImpl(ProductRepository productRepository, MapperUtil mapperUtil) {
        this.productRepository = productRepository;
        this.mapperUtil = mapperUtil;
    }

    @Override
    public List<ProductDTO> findAllProduct() {
        return productRepository.findAll().stream()
                .map(entity -> mapperUtil.convert(entity, new ProductDTO()))
                .collect(Collectors.toList());

    }

    @Override
    public List<ProductDTO> findTop3() {
        return productRepository.findTop3ByOrderByPriceDesc().stream()
                .map(entity -> mapperUtil.convert(entity, new ProductDTO()))
                .collect(Collectors.toList());


    }

    @Override
    public ProductDTO findByName(String name) {
        return mapperUtil.convert(productRepository.findFirstByName(name),new ProductDTO());

    }

    @Override
    public List<ProductDTO> findByCategoryId(Long id) {
        return productRepository.retrieveProductListByCategory(id).stream()
                .map(entity -> mapperUtil.convert(entity, new ProductDTO()))
                .collect(Collectors.toList());

    }

    @Override
    public List<ProductDTO> findByPrice(BigDecimal price) {
        return productRepository.findByPrice(price).stream()
                .map(entity -> mapperUtil.convert(entity, new ProductDTO()))
                .collect(Collectors.toList());

    }

    @Override
    public List<ProductDTO> findByPriceAndQuantity(BigDecimal price, Integer quantity) {
        return productRepository.findByPriceAndQuantity(price,quantity).stream()
                .map(entity -> mapperUtil.convert(entity, new ProductDTO()))
                .collect(Collectors.toList());

    }

    @Override
    public ProductDTO save(ProductDTO productDTO) {
        productRepository.save(mapperUtil.convert(productDTO,new Product()));
        return productDTO ;
    }

    @Override
    public ProductDTO saveCategoryAndPrice(ProductDTO productDTO) {
        return null;
    }

    @Override
    public void update(ProductDTO productDTO) {
        Product product = mapperUtil.convert(productDTO, new Product());
        productRepository.findById(product.getId())
                .ifPresent(renewProduct->{renewProduct.setName(product.getName());
                    renewProduct.setPrice(product.getPrice());
                    renewProduct.setQuantity(product.getQuantity());
                    renewProduct.setRemainingQuantity(product.getRemainingQuantity());
                    renewProduct.setId(product.getId());
                  //  renewProduct.setCategoryList(product.getCategoryList());
                    productRepository.save(renewProduct);
                });
    }
}
