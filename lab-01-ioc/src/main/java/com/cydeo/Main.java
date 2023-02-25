package com.cydeo;

import com.cydeo.account.Current;
import com.cydeo.account.Saving;
import com.cydeo.config.Config;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext container = new AnnotationConfigApplicationContext(Config.class);

        Saving saving = container.getBean(Saving.class);
        Current current = container.getBean(Current.class);

        saving.initialize();
        current.initialize();
     //   savings account currency: USDamount: 120.3accountId701dc2fe-c601-48c9-98b3-9253f79953bd
   //     current account currency: USDamount: 100.23accountId7bfdea44-2b44-485f-9e67-13756cdfc0f8
    }
}
