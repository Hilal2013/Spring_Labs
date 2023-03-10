package com.cydeo.lab04springmvc.controller;

import com.cydeo.lab04springmvc.service.ProductService;

import lombok.AllArgsConstructor;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@AllArgsConstructor
public class ProductController {

    ProductService productService;
    @RequestMapping("/search-product/{name}")//http://localhost:8080/search-product/milk
    //http://localhost:8080/product/milk
    public String product(@PathVariable String name, Model model){
        model.addAttribute("productList",productService.searchProduct(name));
        return"product/product-list";
    }

}
