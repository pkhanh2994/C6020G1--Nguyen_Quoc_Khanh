package com.codegym.controller;

import com.codegym.entity.Customer;
import com.codegym.entity.Province;
import com.codegym.service.CustomerService;
import com.codegym.service.ProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Optional;

@Controller
public class CustomerController {
    @Autowired
    private CustomerService customerService;
    @Autowired
    private ProvinceService provinceService;

    @GetMapping("/")
    public String homePage(Model model, @PageableDefault(size = 2)Pageable pageable, @RequestParam Optional<String>keyword){
        String holdKeyword="";
        if(keyword.isPresent()){
            holdKeyword=keyword.get();
            model.addAttribute("customerList",this.customerService.findAllByNameContaining(pageable,holdKeyword));
        }else {
            model.addAttribute("customerList",this.customerService.findAll(pageable));
        }
        model.addAttribute("holdKeyword", holdKeyword);

        return "home-page";
    }
    @GetMapping("create")
    public String showFormCreate(Model model){
        List<Province>provinceList=this.provinceService.findAll();
        model.addAttribute("provinceList",provinceList);
        model.addAttribute("customer",new Customer());
        return "create_customer";
    }
    @PostMapping("create")
    public String createStudent(Customer customer, RedirectAttributes redirectAttributes){
        this.customerService.save(customer);
        redirectAttributes.addFlashAttribute("message","created new customer");
        return "redirect:/";
    }
    @GetMapping("{id}/update")
    public String showUpdateInfo(@PathVariable long id, Model model, Customer customer) throws Exception{
        List<Province>provinceList=this.provinceService.findAll();
        model.addAttribute("provinceList",provinceList);
        customer=this.customerService.findById(id);
        model.addAttribute("customer",customer);
        return "update_customer";
    }
    @PostMapping("/update")
    public String updateCustomer(@ModelAttribute Customer customer, RedirectAttributes redirectAttributes){
      this.customerService.update(customer);
        redirectAttributes.addFlashAttribute("message","updated customer");
        return "redirect:/";
    }

    @GetMapping("{id}/delete")
    public String editInfo(@PathVariable long id, Model model, Customer customer) throws Exception{
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
    public String infoCustomer(@PathVariable long id, Customer customer, Model model) throws Exception{
        customer=this.customerService.findById(id);
        model.addAttribute("customer",customer);
        return "detail_customer";

    }
    @ExceptionHandler(value = Exception.class)
    public String errorPage(){
        return "error_page";
    }

}
