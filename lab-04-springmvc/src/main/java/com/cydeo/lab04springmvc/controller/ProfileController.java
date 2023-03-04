package com.cydeo.lab04springmvc.controller;

import com.cydeo.lab04springmvc.model.Profile;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDateTime;

@Controller
public class ProfileController {
    @RequestMapping("/profile") //http://localhost:8080/profile
    public String profile(Model model){
Profile profile=new Profile();
        profile.setName("Mike");
        profile.setSurname("Smith");
        profile.setPhoneNumber("+1234567");
        profile.setEmail("abc@gmail.com");
        profile.setCreatedDate(LocalDateTime.now());
        model.addAttribute("profile",profile);
        return "product/profile/profile-info";
    }

}
