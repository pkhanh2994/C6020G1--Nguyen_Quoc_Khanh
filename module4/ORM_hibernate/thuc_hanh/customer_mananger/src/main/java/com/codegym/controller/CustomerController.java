package com.codegym.controller;

import com.codegym.entity.Customer;
import com.codegym.service.CustomerService;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @GetMapping("/")
    public String homePage(Model model){
        List<Customer> customerList=this.customerService.findAll();
        model.addAttribute("customerList",customerList);
        return "home-page";
    }
    @GetMapping("create")
    public String showFormCreate(Model model){
        model.addAttribute("customer",new Customer());
        return "create_customer";
    }
    @PostMapping("create")
    public String createStudent(  Customer customer, RedirectAttributes redirectAttributes){
        this.customerService.save(customer);
        redirectAttributes.addFlashAttribute("message","created new customer");
        return "redirect:/";
    }
    @GetMapping("{id}/update")
    public String showUpdateInfo(@PathVariable long id, Model model, Customer customer){
        customer=this.customerService.findById(id);
        model.addAttribute("customer",customer);
        return "update_customer";
    }
    @PostMapping("/update")
    public String updateCustomer(@ModelAttribute  Customer customer, RedirectAttributes redirectAttributes){
      this.customerService.update(customer);
        redirectAttributes.addFlashAttribute("message","updated customer");
        return "redirect:/";
    }

    @GetMapping("{id}/delete")
    public String editInfo(@PathVariable long id, Model model, Customer customer){
         customer=this.customerService.findById(id);
         model.addAttribute("customer",customer);
        return "delete";
    }
    @PostMapping("/delete")
    public String deleteCustomer(@RequestParam long id, RedirectAttributes redirectAttributes){
        this.customerService.remove(id);
        redirectAttributes.addFlashAttribute("message","deleted customer");
        return"redirect:/";
    }
    @GetMapping("{id}/detail")
    public String infoCustomer(@PathVariable long id, Customer customer,Model model){
        customer=this.customerService.findById(id);
        model.addAttribute("customer",customer);
        return "detail_customer";

    }

}
