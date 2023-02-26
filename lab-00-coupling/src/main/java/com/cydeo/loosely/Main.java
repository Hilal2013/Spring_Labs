package com.cydeo.loosely;

import java.math.BigDecimal;
import java.util.UUID;

public class Main {
    public static void main(String[] args) {
        UUID user = UUID.randomUUID();

        CustomerBalance customerBalance = new CustomerBalance(user, BigDecimal.ZERO);
        GiftCardBalance giftCardBalance = new GiftCardBalance(user, BigDecimal.ZERO);

        System.out.println(customerBalance.addBalance(new BigDecimal(150)));
        System.out.println( giftCardBalance.addBalance(new BigDecimal(120)));
BalanceManager balanceManager=new BalanceManager();
        System.out.println(balanceManager.checkout(customerBalance,new BigDecimal("130")));//true
        System.out.println(balanceManager.checkout(giftCardBalance,new BigDecimal("200")));//false



    }
}
