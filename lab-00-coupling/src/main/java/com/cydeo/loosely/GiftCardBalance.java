package com.cydeo.loosely;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.UUID;

public class GiftCardBalance extends Balance{
    public GiftCardBalance(UUID userId, BigDecimal amount) {
        super(userId, amount);
    }

    public BigDecimal addBalance(BigDecimal amount) {
        BigDecimal bonusAmount =
                amount.multiply(BigDecimal.TEN)
                        .divide(new BigDecimal(100)
                                , MathContext.DECIMAL64);
        setAmount(this.getAmount().add(amount).add(bonusAmount));
        return this.getAmount();
    }
    public static void main(String[] args) {
        BigDecimal bd = new BigDecimal(1);
        BigDecimal bd2 = new BigDecimal(3);

        BigDecimal result = bd.divide(bd2, MathContext.DECIMAL32);
        System.out.println(result);//0.3333333//7 digits
        result = bd.divide(bd2, MathContext.DECIMAL64);
        System.out.println(result);//0.3333333333333333//16 digits
        result = bd.divide(bd2, MathContext.DECIMAL128);
        System.out.println(result);//0.3333333333333333333333333333333333 //34 digits
        result = bd.divide(bd2, MathContext.UNLIMITED);
        System.out.println(result);//.ArithmeticException
    }
}
