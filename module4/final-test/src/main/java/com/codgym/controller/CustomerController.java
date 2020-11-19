package com.codgym.controller;

import com.codgym.entity.Customer;
import com.codgym.service.CustomerService;
import com.codgym.service.TypeOfCustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
public class CustomerController {
    @Autowired
    private CustomerService customerService;
    @Autowired
    private TypeOfCustomerService typeOfCustomerService;

    @GetMapping("/")
    public String listCustomerPage(@PageableDefault(size = 4) Pageable pageable, Model model,
                                   @RequestParam Optional<String> keyword) {
        String holdKeyword = "";
        if (keyword.isPresent()) {
            holdKeyword = keyword.get();
            model.addAttribute("listCustomer", this.customerService.findAllByNameCustomer(pageable, holdKeyword));
        } else {
            model.addAttribute("listCustomer", this.customerService.findAll(pageable));
        }
        model.addAttribute("holdKeyword", holdKeyword);
        model.addAttribute("customer",new Customer());
        model.addAttribute("listTypeOfCustomer",this.typeOfCustomerService.findAllTypeOfCustomer());

        return "customer-page";

    }

    @PostMapping("/save")
    public String createOrUpdate(Customer customer){
        this.customerService.save(customer);
        return "redirect:/";
    }
    @GetMapping("/delete")
    public String deleteCustomer(@RequestParam("id") String id) {
        this.customerService.deleteCustomerById(id);

        return "redirect:/";
    }

}
