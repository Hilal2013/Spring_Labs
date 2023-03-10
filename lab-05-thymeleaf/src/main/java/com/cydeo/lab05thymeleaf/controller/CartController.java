package com.cydeo.lab05thymeleaf.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/cart")
public class CartController {
    @GetMapping("/show")
    public String showCart(){


        return "cart/show-cart";
    }

}
