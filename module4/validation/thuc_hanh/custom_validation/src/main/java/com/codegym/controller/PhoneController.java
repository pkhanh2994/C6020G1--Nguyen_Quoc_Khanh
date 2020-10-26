package com.codegym.controller;

import com.codegym.entity.Phone;
import com.codegym.service.PhoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class PhoneController {
    @Autowired
    private PhoneService phoneService;
    @GetMapping("/")
    public String showForm(Model model){
        model.addAttribute("phoneBd",new Phone());
        return "form-create";
    }
    @PostMapping("/create")
    public String savePhone(@Validated @ModelAttribute("phoneBd") Phone phone , BindingResult bindingResult, Model model){
        new Phone().validate(phone,bindingResult);
        if(bindingResult.hasFieldErrors()){
            model.addAttribute("phoneBd",phone);
            return "form-create";

        }
        this.phoneService.save(phone);
        return "success";
    }
}
