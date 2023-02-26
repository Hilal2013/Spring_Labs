package com.cydeo.config;

import com.cydeo.bean_practice.FullTimeEmployee;
import com.cydeo.bean_practice.PartTimeEmployee;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class EmployeeConfig {
  @Bean
    public FullTimeEmployee fullTimeEmployee(){
        return new FullTimeEmployee();
    }
  @Bean
  public PartTimeEmployee partTimeEmployee(){
      return new PartTimeEmployee();
  }


}
