package com.cydeo.loosely;

import java.math.BigDecimal;
import java.util.UUID;

public class CustomerBalance extends Balance{
    public CustomerBalance(UUID userId, BigDecimal amount) {
        super(userId, amount);
    }

}
