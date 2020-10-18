package com.codegym.controller;

import com.codegym.model.Customer;
import com.codegym.service.CustomerService;
import com.codegym.service.CustomerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class CustomerController {
//    private CustomerService customerService = new CustomerServiceImpl();
@Autowired
CustomerService customerService;
    @GetMapping("/")
    public String index(Model model) {

        List <Customer>customerList = customerService.findAll();
        model.addAttribute("customers", customerList);
        return "view";
    }

}
