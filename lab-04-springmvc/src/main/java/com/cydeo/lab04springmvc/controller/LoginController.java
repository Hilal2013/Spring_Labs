package com.cydeo.lab04springmvc.controller;

import com.cydeo.lab04springmvc.model.Login;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Random;

@Controller
public class LoginController {
   // localhost:8080/login/abc@email.com/1234124241
    @RequestMapping("/login/{email}/{phoneNumber}")
    public String login(@PathVariable String email, @PathVariable String phoneNumber, Model model){
        model.addAttribute("email",email);
        model.addAttribute("phoneNumber",phoneNumber);
        model.addAttribute("loginMessage","Login Successful!");

        return "login/login-info";
    }

}
