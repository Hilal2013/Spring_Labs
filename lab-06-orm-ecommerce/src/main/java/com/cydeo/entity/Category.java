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
public class Category extends BaseEntity{

   private String name;
  // @ManyToMany(mappedBy = "categoryList")
//private List<Product> productList;


}
