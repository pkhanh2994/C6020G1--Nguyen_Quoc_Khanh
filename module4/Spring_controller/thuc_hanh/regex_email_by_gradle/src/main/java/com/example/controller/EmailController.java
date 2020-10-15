package com.example.controller;

import com.example.service.EmailRegex;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class EmailController {
    @Autowired
    EmailRegex emailRegex;

    @GetMapping("/")
    String homepage(){
        return "Home";
    }
    @GetMapping("/Home")
    String successEmail(@RequestParam String email, Model model){
        boolean result=emailRegex.regexEmail(email);
        if(!result){
            model.addAttribute("message","Email is invalid");
            return "Home";
        }
        model.addAttribute("message","oke babe");
        return "Home";
    }
}
