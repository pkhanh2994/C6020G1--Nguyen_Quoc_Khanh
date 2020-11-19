package com.codegym.controller;

import com.codegym.entity.customer.Customer;
import com.codegym.service.customer.CustomerService;
import com.codegym.service.customer.TypeOfCustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;

@Controller
@RequestMapping("/customerHome")
public class CustomerController {
    @Autowired
    private CustomerService customerService;
    @Autowired
    private TypeOfCustomerService typeOfCustomerService;

    @GetMapping("/customerList")
    public String listCustomerPage(@PageableDefault(size = 4) Pageable pageable, Model model, @RequestParam Optional<String> keyword) {
        String holdKeyword = "";
        if (keyword.isPresent()) {
            holdKeyword = keyword.get();
            model.addAttribute("listCustomer", this.customerService.findAllByNameCustomer(pageable, holdKeyword));
        } else {
            model.addAttribute("listCustomer", this.customerService.findAll(pageable));
        }
        model.addAttribute("holdKeyword", holdKeyword);

        return "customer/list-customer-page";

    }

    @GetMapping("/createCustomer")
    public String createForm(Model model) {
        model.addAttribute("customer", new Customer());
        model.addAttribute("typeOfCustomerList", this.typeOfCustomerService.findAllTypeOfCustomer());
        return "customer/create-customer";
    }
    @PostMapping("/createCustomer")
    public String createCustomer(@Validated @ModelAttribute("customer") Customer customer, BindingResult bindingResult, RedirectAttributes redirectAttributes,Model model){
        if(bindingResult.hasFieldErrors()){
            model.addAttribute("typeOfCustomerList", this.typeOfCustomerService.findAllTypeOfCustomer());
            model.addAttribute("customer",customer);
            return "customer/create-customer";
        }
        this.customerService.save(customer);
        redirectAttributes.addFlashAttribute("message","created new customer");
        return "redirect:/customerHome/customerList";
    }
    @GetMapping("/updateCustomer")
    public String updateForm(Model model,@RequestParam String idCustomer){
        model.addAttribute("typeOfCustomerList", this.typeOfCustomerService.findAllTypeOfCustomer());
        model.addAttribute("customer",this.customerService.findCustomerById(idCustomer));
        return "customer/update-customer";
    }
    @PostMapping("/updateCustomer")
    public String updateCustomer(@Validated @ModelAttribute Customer customer,BindingResult bindingResult,Model model){
        if(bindingResult.hasFieldErrors()){
            model.addAttribute("typeOfCustomerList", this.typeOfCustomerService.findAllTypeOfCustomer());
            model.addAttribute("customer",customer);
            return "customer/update-customer";
        }
        this.customerService.save(customer);
        return "redirect:/customerHome/customerList";
    }
    @GetMapping("/delete")
    public String deleteCustomer(@RequestParam String idCustomer){
        this.customerService.deleteCustomerById(idCustomer);
        return "redirect:/customerHome/customerList";
    }

}
