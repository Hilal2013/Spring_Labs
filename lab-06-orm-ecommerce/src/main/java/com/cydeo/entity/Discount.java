package com.cydeo.entity;

import com.cydeo.enums.DiscountType;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class Discount extends BaseEntity {

    private BigDecimal discount;
    @Enumerated(EnumType.STRING)
    private DiscountType discountType;
    private String name;

  // @OneToMany(mappedBy = "discount")
//private List<Cart> cartList;


    public Discount(BigDecimal discount, DiscountType discountType, String name) {
        this.discount = discount;
        this.discountType = discountType;
        this.name = name;
    }
}
