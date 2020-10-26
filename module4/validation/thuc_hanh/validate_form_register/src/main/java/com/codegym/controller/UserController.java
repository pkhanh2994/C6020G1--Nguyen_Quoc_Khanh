package com.codegym.controller;

import com.codegym.entity.User;
import com.codegym.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.bind.BindResult;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
public class UserController {
    @Autowired
    private UserRepository userRepository;
    @GetMapping("/")
    public String formRegister(Model model){
        model.addAttribute("userAbc",new User());
        return "form-register";
    }
    @PostMapping("/create")
    public String saveUser(@Valid @ModelAttribute("userAbc") User user, BindingResult bindResult, Model model){
        if(bindResult.hasFieldErrors()){
            model.addAttribute("userAbc", user);
            return "form-register";
        }
        this.userRepository.save(user);
        return "success";

    }
}
