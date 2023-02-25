package com.cydeo.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "db")
@ComponentScan("com.cydeo")
public class RecipeConfig {
private String name,surname,email,url;

}
