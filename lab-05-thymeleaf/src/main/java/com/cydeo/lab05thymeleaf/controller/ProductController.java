package com.cydeo.lab05thymeleaf.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/product")
public class ProductController {
   @GetMapping
    public String create(){


        return "product/create-product";
    }

    @GetMapping
    public String list(){


        return "product/list";
    }


}
