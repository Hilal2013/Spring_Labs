package com.cydeo.config;

import com.cydeo.Currency;
import com.cydeo.account.Current;
import com.cydeo.account.Saving;
import lombok.Setter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.math.BigDecimal;
import java.util.UUID;


@Configuration
public class Config {
    @Bean
    public Currency currency() {
        return new Currency("USD","US Dollar");
    }

    @Bean
    public Current current(Currency currency) {
        return new Current(currency, BigDecimal.valueOf(100.23), UUID.randomUUID());
    }


    @Bean
    public Saving saving(Currency currency) {
        return new Saving(currency,new BigDecimal("120.3"),UUID.randomUUID());
    }


}
