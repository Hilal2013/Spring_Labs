package com.cydeo.loosely;

import java.math.BigDecimal;

public class BalanceManager {
    public boolean checkout(Balance balance, BigDecimal checkoutAmount){
BigDecimal finalAmount=balance.getAmount().subtract(checkoutAmount);
        if(finalAmount.compareTo(BigDecimal.ZERO) >= 0){
            balance.setAmount(finalAmount);
            return true;
        }
        return false;
    }
}
