package com.cydeo;

import com.cydeo.bean_practice.FullTimeEmployee;
import com.cydeo.bean_practice.PartTimeEmployee;
import com.cydeo.config.EmployeeConfig;
import com.cydeo.config.StringConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class EmployeeApp {
    public static void main(String[] args) {
        ApplicationContext context=new AnnotationConfigApplicationContext(EmployeeConfig.class, StringConfig.class);
        FullTimeEmployee ft=context.getBean(FullTimeEmployee.class);
        PartTimeEmployee pt=context.getBean(PartTimeEmployee.class);

String str1=context.getBean("string1",String.class);
        System.out.println(str1);
        String str2=context.getBean("Spring",String.class);
        System.out.println(str2);

        //Welcome to CydeoApp
        //Spring Core Practice
    }
}
