package com.cydeo.model;

import lombok.Data;

import java.math.BigDecimal;
@Data
public class Ingredients {
    private String name;
    private int quantity;
    private QuantityType quantityType;
}
