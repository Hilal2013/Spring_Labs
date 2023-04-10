package com.cydeo.entity;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class Location extends BaseEntity {

    private String name;
    private String address;
    private String latitude;
    private String longitude;
    private String country;
    private String city;
    private String state;
    private String postalCode;


}