package com.cydeo.model;

import lombok.Data;

import java.math.BigDecimal;
@Data
public class Ingredients {
    private String name;
    private BigDecimal quantity;
    private QuantityType quantityType;
}
