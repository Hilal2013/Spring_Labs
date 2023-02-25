package com.cydeo.loosely;

import java.math.BigDecimal;
import java.util.UUID;

public class GiftCardBalance extends Balance{
    public GiftCardBalance(UUID userId, BigDecimal amount) {
        super(userId, amount);
    }


}
