package com.cydeo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class StringConfig {
    @Bean
    public String string1(){
        return "Welcome to CydeoApp";
    }

    @Bean("Spring")
    public String string2(){
        return "Spring Core Practice";
    }

}
