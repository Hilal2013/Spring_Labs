package com.cydeo.entity;

import com.cydeo.enums.CartState;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@Data
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Enumerated(EnumType.STRING)
    private CartState cartState;
    @ManyToOne
//@JoinColumn(name="discount_id")
    private Discount discount;
    @ManyToOne
    private Customer customer;
    @OneToOne(mappedBy = "cart")
    private Order order;


    public Cart(CartState cartState) {
        this.cartState = cartState;
    }
}
