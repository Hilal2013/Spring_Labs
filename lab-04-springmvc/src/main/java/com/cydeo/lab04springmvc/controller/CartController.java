package com.cydeo.lab04springmvc.controller;

import com.cydeo.lab04springmvc.service.CartService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.UUID;

@Controller
public class CartController {

 private final   CartService cartService;

    public CartController(CartService cartService) {
        this.cartService = cartService;
    }

    @RequestMapping("/cart-list")//http://localhost:8080/cart-list
    public String cartList(Model model){
model.addAttribute("cartList",cartService.retrieveCartList());

        return "cart/cart-list";
    }


@RequestMapping("/cart-list/{id}")
    public String cartDetail(@PathVariable UUID id, Model model){

model.addAttribute("cartItemList",cartService.retrieveCartDetail(id));
        return "cart/cart-detail";
    }

}
