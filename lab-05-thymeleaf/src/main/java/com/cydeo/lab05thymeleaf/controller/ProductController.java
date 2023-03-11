package com.cydeo.lab05thymeleaf.controller;

import com.cydeo.lab05thymeleaf.model.Product;
import com.cydeo.lab05thymeleaf.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller

public class ProductController {

 private final   ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/create-product")
    public String createProduct(Model model){

model.addAttribute("product",new Product());

        return "product/create-product";
    }
    @PostMapping("/create-form")
    public String addProduct(){


        return "redirect:/create-product";
    }

    @GetMapping("/list")
    public String list(Model model){

model.addAttribute("productList",productService.listProduct());
        return "product/list";
    }



}
