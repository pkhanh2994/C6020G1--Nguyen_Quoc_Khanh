package com.codegym.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/loginHome")
public class LoginController {
    @GetMapping(value = "/login")
    public String loginPage() {
        return "login/login-page";
    }
//    @GetMapping(value = "/logout")
//    public String logOut(){
//        return "display";
//    }
    @GetMapping("/403")
    public String pageError(){
        return "login/403";
    }
}
