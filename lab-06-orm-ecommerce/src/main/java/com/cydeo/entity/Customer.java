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
public class Customer extends BaseEntity{

    private String email;
    private String firstName;
    private String lastName;
    private String userName;
   // @OneToMany(mappedBy = "customer")
   // private List<Address> addressList;

  //  @OneToOne(mappedBy = "customer")
  //  private Balance balance;

  //  @OneToMany(mappedBy = "customer")
   // private List<Cart> cartList;

    @OneToMany(mappedBy = "customer")
    private List<Order> orderList;

    public Customer(String email, String firstName, String lastName, String userName) {
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = userName;
    }
}
