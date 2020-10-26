package com.codegym.controller;

import com.codegym.entity.User;
import com.codegym.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;

@Controller
public class UserController {
    @Autowired
    private UserService userService;
    @GetMapping("/")
    public String showListUser(Model model, @PageableDefault(size = 2)Pageable pageable, Optional<String> keyWord){
        String holdKeyword="";
        if(keyWord.isPresent()){
            holdKeyword=keyWord.get();
            model.addAttribute("listUser",this.userService.findByFirstName(pageable,holdKeyword));
        }else {
            model.addAttribute("listUser",this.userService.findAll(pageable));
        }
        model.addAttribute("holdKeyword",holdKeyword);
        return "home-page";
    }
    @GetMapping("create")
    public String formCreate(Model model){
        model.addAttribute("user",new User());
        return "create";
    }
    @PostMapping("create")
    public String createUser( @Validated @ModelAttribute("user") User user, BindingResult bindingResult, Model model, RedirectAttributes redirectAttributes){
        if(bindingResult.hasFieldErrors()){
            model.addAttribute("user",user);
            return "create";
        }
        this.userService.save(user);
//        redirectAttributes.addFlashAttribute("message","created new user");
        return "redirect:/";
    }
}
