package com.cydeo.entity;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class CartItem extends  BaseEntity{
    private BigDecimal quantity;
    @ManyToOne
    private Cart cart;
    @ManyToOne
    private Product product;
    public CartItem(BigDecimal quantity) {
        this.quantity = quantity;
    }
}
