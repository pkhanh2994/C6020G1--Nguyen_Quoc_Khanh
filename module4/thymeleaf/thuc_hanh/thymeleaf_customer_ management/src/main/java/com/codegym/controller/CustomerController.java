package com.codegym.controller;

import com.codegym.model.Customer;
import com.codegym.service.CustomerService;
import com.codegym.service.CustomerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class CustomerController {

@Autowired
CustomerService customerService;
    @GetMapping("/")
    public String index(Model model) {
        List <Customer>customerList = customerService.findAll();
        model.addAttribute("customers", customerList);
        return "view";
    }
    @GetMapping("create")
    public String create(Model model) {
        model.addAttribute("customer", new Customer());
        return "create";
    }
    @PostMapping("save")
    public String save(Customer customer, RedirectAttributes redirect) {
        customer.setId((int)(Math.random() * 10000));
        customerService.save(customer);
        redirect.addFlashAttribute("success", "Saved customer successfully!");
        return "redirect:/";
    }
    @GetMapping("{id}/edit")
    public String edit(@PathVariable int id, Model model, Customer customer) {
        customer=customerService.findById(id);
        model.addAttribute("customer", customer);
        return "edit";
    }
    @PostMapping("{id}/click")
    public String update(@PathVariable int id, RedirectAttributes redirect,Customer customer) {
        customerService.update(id, customer);

        redirect.addFlashAttribute("success", "Modified customer successfully!");

        return "redirect:/";
    }
    @GetMapping("{id}/delete")
    public String delete(@PathVariable int id, Model model) {
        model.addAttribute("customer", customerService.findById(id));
        return "delete";
    }
    @PostMapping("{id}/deleteProduct")
    public String delete(@PathVariable int id, RedirectAttributes redirectAttributes){
        customerService.remove(id);
        redirectAttributes.addFlashAttribute("success","deleted a customer");
        return "redirect:/";
    }

    @GetMapping("{id}/viewInfo")
    public String view(@PathVariable int id, Model model) {
        model.addAttribute("customer", customerService.findById(id));
        return "viewInfo";
    }
}
