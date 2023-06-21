package com.cydeo.lab08rest.service;

import com.cydeo.lab08rest.dto.CartDTO;
import com.cydeo.lab08rest.entity.Cart;
import com.cydeo.lab08rest.entity.CartItem;
import com.cydeo.lab08rest.entity.Customer;

import java.math.BigDecimal;
import java.util.List;

public interface CartService {
    boolean existById(Long id);

    CartDTO findById(Long id);

    //you should check product id exists and stock is enough , customer already exists and validations protections passed return true
    boolean addToCart(Customer customer, Long productId, Integer quantity);
   //you need to find out which discount is eligible (ifAplicaple)after custumer can have discount we need to calculate
    BigDecimal applyDiscountToCartIfApplicableAndCalculateDiscountAmount(String discountName, Cart cart);
    BigDecimal calculateTotalCartAmount(List<CartItem> cartItemList);
}
