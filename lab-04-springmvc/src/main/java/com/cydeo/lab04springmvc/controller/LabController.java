package com.cydeo.lab04springmvc.controller;

import org.springframework.ui.Model;

public class LabController {

    public String labList(Model model){
        model.addAttribute("firstLab","lab-00-coupling");
        model.addAttribute("secondLab","lab-01-IoC");
        model.addAttribute("thirdLab","lab-02-di");
        model.addAttribute("fourthLab","lab-03-springboot");
        model.addAttribute("fifthLab","lab-04-springmvc");
        return"lab/lab-list";
    }

}
