package com.cydeo.stereotype_annotations;

import com.cydeo.stereotype_annotations.config.DevConfig;
import com.cydeo.stereotype_annotations.model.DataStructure;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class DevApp {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(DevConfig.class);
DataStructure ds=context.getBean(DataStructure.class);
ds.getTotalHours();//30
    }
}
