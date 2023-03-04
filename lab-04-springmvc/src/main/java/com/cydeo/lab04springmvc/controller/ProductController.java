package com.cydeo.lab04springmvc.controller;

import com.cydeo.lab04springmvc.service.impl.ProductServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ProductController {
    @RequestMapping("/search-product/{name}")
    public String product(@PathVariable String name, Model model){
        model.addAttribute("productList", ProductServiceImpl.PRODUCT_LIST);
        return"product/product-list";
    }

}
