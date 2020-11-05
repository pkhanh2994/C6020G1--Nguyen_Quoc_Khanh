package com.codegym.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {
    @GetMapping(value = "/")
    public String loginPage() {
        return "login";
    }
    @GetMapping("/403")
    public String pageError(){
        return "403";
    }
}
