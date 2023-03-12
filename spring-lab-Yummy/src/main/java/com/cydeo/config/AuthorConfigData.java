package com.cydeo.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
@ConfigurationProperties(prefix = "author")
@Data
public class AuthorConfigData {
    private String name;
    private String surname;
    private String phone;
    private List<String> socialMedias;
    private String email;
}
