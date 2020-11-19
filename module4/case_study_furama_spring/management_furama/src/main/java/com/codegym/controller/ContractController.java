package com.codegym.controller;

import com.codegym.entity.contract.Contract;
import com.codegym.entity.employee.Employee;
import com.codegym.repository.contract.ContractRepository;
import com.codegym.repository.customer.CustomerRepository;
import com.codegym.repository.employee.EmployeeRepository;
import com.codegym.repository.service.ServiceRepository;
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
@RequestMapping("/contract")
public class ContractController {
    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private ServiceRepository serviceRepository;
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private ContractRepository contractRepository;

    @GetMapping("/contractList")
    public String listContractPage(@PageableDefault(size = 4) Pageable pageable, Model model, @RequestParam Optional<String> keyword) {
        String holdKeyword = "";
        if (keyword.isPresent()) {
            holdKeyword = keyword.get();
            model.addAttribute("listContract", this.contractRepository.findAllByIdContract(pageable, holdKeyword));
        } else {
            model.addAttribute("listContract", this.contractRepository.findAll(pageable));
        }
        model.addAttribute("holdKeyword", holdKeyword);

        return "contract/list-contract-page";

    }
    @GetMapping("/createContract")
    public String createForm(Model model) {
        model.addAttribute("contract", new Contract());
        model.addAttribute("employeeList", this.employeeRepository.findAll());
        model.addAttribute("serviceList", this.serviceRepository.findAll());
        model.addAttribute("customerList", this.customerRepository.findAll());
        return "contract/create-contract-page";
    }
    @PostMapping("/createContract")
    public String createCustomer(@Validated  @ModelAttribute Contract contract, BindingResult bindingResult,
                                 Model model, RedirectAttributes redirectAttributes){
        if(bindingResult.hasFieldErrors()){
            model.addAttribute("employeeList", this.employeeRepository.findAll());
            model.addAttribute("serviceList", this.serviceRepository.findAll());
            model.addAttribute("customerList", this.customerRepository.findAll());
            model.addAttribute("contract",contract);
            return "contract/create-contract-page";
        }
        this.contractRepository.save(contract);
        redirectAttributes.addFlashAttribute("message","created new contract");
        return "redirect:/contract/contractList";
    }
}
