package com.cydeo.lab05thymeleaf.controller;


import com.cydeo.lab05thymeleaf.service.CartService;
import com.cydeo.lab05thymeleaf.service.impl.CartServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import static com.cydeo.lab05thymeleaf.service.impl.CartServiceImpl.CART;

import java.util.UUID;

@Controller

public class CartController {
private  final CartService cartService;

  public CartController(CartService cartService) {
        this.cartService = cartService;
    }



    @GetMapping("/cart")
    public String showCart(Model model){
        model.addAttribute("cart",CART);
//model.addAttribute("cartList",CartServiceImpl.CART.getCartItemList());
//model.addAttribute("cartTotalAmount", CART.getCartTotalAmount());
        return "cart/show-cart";
    }

    @GetMapping("/addToCart/{productId}/{quantity}")
    public String addToCart(@PathVariable ("productId") UUID productId,@PathVariable("quantity") Integer quantity){

cartService.addToCart(productId,quantity);
        return "redirect:/cart";
    }

    @GetMapping("/delete/{productId}")
    public String delete(@PathVariable ("productId") UUID productId){
cartService.deleteFromCart(productId);

        return "redirect:/cart";
    }

}
