package com.codegym.controller;

import com.codegym.entity.customer.Customer;
import com.codegym.entity.employee.Employee;
import com.codegym.repository.employee.DivisionRepository;
import com.codegym.repository.employee.EducationDegreeRepository;
import com.codegym.repository.employee.PositionRepository;
import com.codegym.service.employee.EmployeeService;
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
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private PositionRepository positionRepository;
    @Autowired
    private DivisionRepository divisionRepository;
    @Autowired
    EducationDegreeRepository educationDegreeRepository;

    @GetMapping("/listEmployee")
    public String listEmployeePage(@PageableDefault(size = 4) Pageable pageable, Model model, @RequestParam Optional<String> keyword) {
        String holdKeyword = "";
        if (keyword.isPresent()) {
            holdKeyword = keyword.get();
            model.addAttribute("listEmployee", this.employeeService.findAllByNameEmployee(pageable, holdKeyword));
        } else {
            model.addAttribute("listEmployee", this.employeeService.findAll(pageable));
        }
        model.addAttribute("holdKeyword", holdKeyword);

        return "employee/list-employee-page";
    }
    @GetMapping("/deleteEmployee")
    public String deleteEmployee(@RequestParam String idEmployee, RedirectAttributes redirectAttributes){
        this.employeeService.deleteEmployeeById(idEmployee);
        redirectAttributes.addFlashAttribute("message","deleted employee");
        return "redirect:/employee/listEmployee";
    }
    @GetMapping("/createEmployee")
    public String createForm(Model model) {
        model.addAttribute("employee", new Employee());
        model.addAttribute("eduList", this.educationDegreeRepository.findAll());
        model.addAttribute("divisionList", this.divisionRepository.findAll());
        model.addAttribute("positionList", this.positionRepository.findAll());
        return "employee/create-employee";
    }
    @PostMapping("/createEmployee")
    public String createCustomer(@Validated @ModelAttribute Employee employee, BindingResult bindingResult,
                                 Model model, RedirectAttributes redirectAttributes){
        if(bindingResult.hasFieldErrors()){
            model.addAttribute("eduList", this.educationDegreeRepository.findAll());
            model.addAttribute("divisionList", this.divisionRepository.findAll());
            model.addAttribute("positionList", this.positionRepository.findAll());
            model.addAttribute("employee",employee);
            return "employee/create-employee";
        }
        this.employeeService.save(employee);
        redirectAttributes.addFlashAttribute("message","created new employee");
        return "redirect:/employee/listEmployee";
    }
    @GetMapping("/updateEmployee")
    public String updateForm(Model model,@RequestParam String idEmployee){
        model.addAttribute("employee",this.employeeService.findEmployeeById(idEmployee));
        model.addAttribute("eduList", this.educationDegreeRepository.findAll());
        model.addAttribute("divisionList", this.divisionRepository.findAll());
        model.addAttribute("positionList", this.positionRepository.findAll());

        return "employee/update-employee";
    }
    @PostMapping("/updateCustomer")
    public String updateCustomer(@Validated @ModelAttribute Employee employee,BindingResult bindingResult,Model model,
                                 RedirectAttributes redirectAttributes){
        if(bindingResult.hasFieldErrors()){
            model.addAttribute("eduList", this.educationDegreeRepository.findAll());
            model.addAttribute("divisionList", this.divisionRepository.findAll());
            model.addAttribute("positionList", this.positionRepository.findAll());
            model.addAttribute("employee",employee);
            return "employee/update-employee";

        }
        this.employeeService.save(employee);
        redirectAttributes.addFlashAttribute("message","updated employee");
        return "redirect:/employee/listEmployee";
    }


}
