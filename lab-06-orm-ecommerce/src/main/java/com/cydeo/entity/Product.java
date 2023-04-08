package com.cydeo.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@NoArgsConstructor
@Data
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Double price;
    private Integer quantity;
    private Integer remaining_quantity;
    @ManyToMany(mappedBy = "productList")
    private List<Category> categoryList;
@OneToMany(mappedBy = "product")
    private List<CartItem> cartItemList;

    public Product(String name, Double price, Integer quantity, Integer remaining_quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.remaining_quantity = remaining_quantity;
    }
}
