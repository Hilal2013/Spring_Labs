package com.cydeo.entity;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

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
