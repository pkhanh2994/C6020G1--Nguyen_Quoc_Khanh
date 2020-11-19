package com.codegym.controller;

import com.codegym.entity.customer.Customer;
import com.codegym.entity.service.ServiceFrurama;
import com.codegym.service.serviceFurama.ServiceFuramaService;
import com.codegym.service.serviceFurama.TypeOfRentService;
import com.codegym.service.serviceFurama.TypeOfServiceService;
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
@RequestMapping("/service")
public class ServiceController {
    @Autowired
    private ServiceFuramaService serviceFuramaService;
    @Autowired
    private TypeOfServiceService typeOfServiceService;
    @Autowired
    private TypeOfRentService typeOfRentService;;

    @GetMapping("/serviceList")
    public String listCustomerPage(@PageableDefault(size = 4) Pageable pageable, Model model, @RequestParam Optional<String> keyword) {
        String holdKeyword = "";
        if (keyword.isPresent()) {
            holdKeyword = keyword.get();
            model.addAttribute("listService", this.serviceFuramaService.findAllByNameService(pageable, holdKeyword));
        } else {
            model.addAttribute("listService", this.serviceFuramaService.findAll(pageable));
        }
         model.addAttribute("holdKeyword", holdKeyword);

        return "service/list-service-page";
    }
    @GetMapping("/createService")
    public String createServiceForm(Model model){
        model.addAttribute("service",new ServiceFrurama());
        model.addAttribute("listTypeOfRent",this.typeOfRentService.findAllTypeOfRent());
        model.addAttribute("listTypeOfService",this.typeOfServiceService.findAllTypeOfService());
        return "service/create-service-page";
    }
    @PostMapping("/createService")
    public String createCustomer(@Validated @ModelAttribute("service") ServiceFrurama service,BindingResult bindingResult,Model model,
                                 RedirectAttributes redirectAttributes){
        if(bindingResult.hasFieldErrors()){
            model.addAttribute("listTypeOfRent",this.typeOfRentService.findAllTypeOfRent());
            model.addAttribute("listTypeOfService",this.typeOfServiceService.findAllTypeOfService());
            model.addAttribute("service",service);
            return "service/create-service-page";
        }
        this.serviceFuramaService.save(service);
        redirectAttributes.addFlashAttribute("message","created new service");
        return "redirect:/service/serviceList";
    }

    @GetMapping("/updateService")
    public String updateServiceForm(Model model,@RequestParam String idService){
        model.addAttribute("service",this.serviceFuramaService.findServiceById(idService));
        model.addAttribute("listTypeOfRent",this.typeOfRentService.findAllTypeOfRent());
        model.addAttribute("listTypeOfService",this.typeOfServiceService.findAllTypeOfService());
        return "service/update-service";
    }
    @PostMapping("/updateService")
    public String updateService(@Validated @ModelAttribute("service") ServiceFrurama service, BindingResult bindingResult,
                                Model model, RedirectAttributes redirectAttributes){
        if(bindingResult.hasFieldErrors()){
            model.addAttribute("listTypeOfRent",this.typeOfRentService.findAllTypeOfRent());
            model.addAttribute("listTypeOfService",this.typeOfServiceService.findAllTypeOfService());
            model.addAttribute("service",service);
            return "service/update-service";
        }
        this.serviceFuramaService.save(service);
        redirectAttributes.addFlashAttribute("message","updated service");
        return "redirect:/service/serviceList";
    }
    @GetMapping("/deleteService")
    public String deleteService(@RequestParam String idService){
        this.serviceFuramaService.deleteServiceById(idService);
        return "redirect:/service/serviceList";
    }
}
