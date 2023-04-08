package com.cydeo.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@NoArgsConstructor
@Data
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
   private String name;
   @ManyToMany
   @JoinTable(name = "product_category_rel",
           joinColumns = @JoinColumn(name = "p_id"),
           inverseJoinColumns = @JoinColumn(name = "c_id"))
private List<Product> productList;
    public Category(String name) {
        this.name = name;
    }
}
