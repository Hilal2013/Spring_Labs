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
   @ManyToMany(mappedBy = "categoryList")
private List<Product> productList;

    public Category(String name, List<Product> productList) {
        this.name = name;
        this.productList = productList;
    }
}
