package com.cydeo.lab05thymeleaf.controller;

import com.cydeo.lab05thymeleaf.service.CartService;
import com.cydeo.lab05thymeleaf.service.impl.CartServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.UUID;

@Controller

public class CartController {
private  final CartService cartService;

    public CartController(CartService cartService) {
        this.cartService = cartService;
    }

    @GetMapping("/cart")
    public String showCart(Model model){
model.addAttribute("cartList",CartServiceImpl.CART.getCartItemList());
model.addAttribute("cartTotalAmount", CartServiceImpl.CART.getCartTotalAmount());
        return "cart/show-cart";
    }

    @GetMapping("/addToCart/{productId}/{quantity}")
    public String addToCart(@PathVariable ("productId") String productId,@PathVariable("quantity") int quantity){

cartService.addToCart(UUID.fromString(productId),quantity);
        return "redirect:/list";
    }

    @GetMapping("/delete/{productId}")
    public String delete(@PathVariable ("productId") UUID productId){
cartService.deleteFromCart(productId);

        return "redirect:/cart";
    }

}
