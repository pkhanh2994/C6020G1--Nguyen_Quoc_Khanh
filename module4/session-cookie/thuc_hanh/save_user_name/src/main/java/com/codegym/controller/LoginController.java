package com.codegym.controller;

import com.codegym.entity.User;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@SessionAttributes("userLogin")
public class LoginController {
    @GetMapping("/")
    public String loginView(Model model, @CookieValue(value = "emailP",defaultValue = "") String email,
                            @CookieValue(value = "passwordP",defaultValue = "") String password, HttpServletRequest request) {
        model.addAttribute("userLogin",new User(email,password));
        return "home-page";
    }

    @PostMapping("login")
    public String loginPage(@ModelAttribute(value = "userLogin")User user,HttpServletResponse response){
        Cookie userEmail=new Cookie("emailP",user.getEmail());
        Cookie userPassword=new Cookie("passwordP",user.getPassword());
        userEmail.setMaxAge(60*60*24);
        userPassword.setMaxAge(60*60*24);
        response.addCookie(userEmail);
        response.addCookie(userPassword);
        return "success";
    }
}
