package com.codegym.controller;

import com.codegym.service.TypeOfProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Controller
public class TypeOfProducController {
    @Autowired
    private TypeOfProductService typeOfProduct;
    @GetMapping("/productType")
    public String listProductPage(Model model) {

            model.addAttribute("listType", this.typeOfProduct.findAll());

        return "product-type";

    }
}
