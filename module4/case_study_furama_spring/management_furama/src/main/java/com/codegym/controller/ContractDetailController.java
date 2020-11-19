package com.codegym.controller;

import com.codegym.entity.contract.Contract;
import com.codegym.entity.contractdetail.ContractDetail;
import com.codegym.repository.contract.ContractRepository;
import com.codegym.service.attachService.AttachServiceService;
import com.codegym.service.contract.ContractService;
import com.codegym.service.contractdetail.ContractDetailService;
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
@RequestMapping("/contractDetail")
public class ContractDetailController {
    @Autowired
    private ContractDetailService contractDetailService;
    @Autowired
    private ContractService contractService;
    @Autowired
    private AttachServiceService attachServiceService;
    @GetMapping("/contractDetailList")
    public String listContractPage(@PageableDefault(size = 4) Pageable pageable, Model model, @RequestParam Optional<String> keyword) {
        String holdKeyword = "";
        if (keyword.isPresent()) {
            holdKeyword = keyword.get();
            model.addAttribute("listContractDetail", this.contractDetailService.findAllContractDetailById(pageable, holdKeyword));
        } else {
            model.addAttribute("listContractDetail", this.contractDetailService.findAll(pageable));
        }
        model.addAttribute("holdKeyword", holdKeyword);

        return "contractDetail/list-contractDetail-page";

    }
    @GetMapping("/createContractDetail")
    public String createForm(Model model) {
        model.addAttribute("contractDetail", new ContractDetail());
        model.addAttribute("contractList", this.contractService.findAll());
        model.addAttribute("attachServiceList", this.attachServiceService.findAll());
        return "contractDetail/create-contractDetail-page";
    }
    @PostMapping("/createContractDetail")
    public String createCustomer(@Validated @ModelAttribute ContractDetail contractDetail, BindingResult
            bindingResult,Model model, RedirectAttributes redirectAttributes){
        if(bindingResult.hasFieldErrors()){
            model.addAttribute("contractList", this.contractService.findAll());
            model.addAttribute("attachServiceList", this.attachServiceService.findAll());
            model.addAttribute("contractDetail",contractDetail);
            return "contractDetail/create-contractDetail-page";
        }
        this.contractDetailService.save(contractDetail);
        redirectAttributes.addFlashAttribute("message","created new contract details");
        return "redirect:/contractDetail/contractDetailList";
    }

}
