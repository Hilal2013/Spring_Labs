package com.cydeo.entity;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class Product extends BaseEntity {

    private String name;
    private Double price;
    private Integer quantity;
    private Integer remaining_quantity;
    @ManyToMany
    @JoinTable(name = "product_category_rel",
            joinColumns = @JoinColumn(name = "p_id"),
            inverseJoinColumns = @JoinColumn(name = "c_id"))
    private List<Category> categoryList;
//@OneToMany(mappedBy = "product")
  //  private List<CartItem> cartItemList;

    public Product(String name, Double price, Integer quantity, Integer remaining_quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.remaining_quantity = remaining_quantity;
    }
}
