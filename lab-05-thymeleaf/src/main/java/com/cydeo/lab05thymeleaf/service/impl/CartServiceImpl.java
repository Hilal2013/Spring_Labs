package com.cydeo.lab05thymeleaf.service.impl;

import com.cydeo.lab05thymeleaf.model.Cart;
import com.cydeo.lab05thymeleaf.model.CartItem;
import com.cydeo.lab05thymeleaf.model.Product;
import com.cydeo.lab05thymeleaf.repository.ProductRepository;
import com.cydeo.lab05thymeleaf.service.CartService;
import com.cydeo.lab05thymeleaf.service.ProductService;

import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.UUID;

@Service
public class CartServiceImpl implements CartService {
    public static Cart CART = new Cart(BigDecimal.ZERO,new ArrayList<>());

    private final ProductService productService;

    public CartServiceImpl(ProductService productService) {
        this.productService = productService;

    }

    @Override
    public Cart addToCart(UUID productId, Integer quantity){
        //todo retrieve product from repository method
        Product product = productService.findProductById(productId);
        //todo initialise cart item
    CartItem cartItem= CART.getCartItemList().stream()
                .filter(p->p.getProduct().getId().equals(productId))
                .findAny().get();

        //todo calculate cart total amount
     cartItem.setTotalAmount(product.getPrice().multiply(BigDecimal.valueOf(cartItem.getQuantity())));
        //todo add to cart

        return CART;
    }

    @Override
    public boolean deleteFromCart(UUID productId){

        //todo delete product object from cart using stream
        CART.getCartItemList().stream()
                .filter(cartItem -> cartItem.getProduct().getId().equals(productId))
                .findAny().get();

        return true;
    }
}
