package com.cydeo.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@Data
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    private String name;
    private String street;
    private String zipCode;
   @ManyToOne
    private Customer customer;


    public Address(String name, String street, String zipCode) {
        this.name = name;
        this.street = street;
        this.zipCode = zipCode;
    }
}
