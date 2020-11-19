package com.codegym.controller;

import com.codegym.entiy.Product;
import com.codegym.service.ProductService;
import com.codegym.service.TypeOfProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;

@Controller
public class ProductController {
    @Autowired
    private ProductService productService;
    @Autowired
    private TypeOfProductService typeOfProduct;

    @GetMapping("/")
    public String listProductPage(@PageableDefault(size = 4) Pageable pageable, Model model,
                                   @RequestParam Optional<String> keyword ) {
        String holdKeyword = "";
        if (keyword.isPresent()) {
            holdKeyword = keyword.get();
            model.addAttribute("listProduct", this.productService.findProduct(pageable, holdKeyword));
        } else {
            model.addAttribute("listProduct", this.productService.findAll(pageable));
        }
        model.addAttribute("holdKeyword", holdKeyword);
        model.addAttribute("listTypeOfProduct",this.typeOfProduct.findAll());

        return "homepage";

    }
    @GetMapping("/delete")
    public String deleteProduct(@RequestParam Integer idProduct){
        this.productService.deleteProduct(idProduct);
        return "redirect:/";
    }
    @GetMapping("/createProduct")
    public String createForm(Model model) {
        model.addAttribute("product", new Product());
        model.addAttribute("listTypeOfProduct", this.typeOfProduct.findAll());
        return "create-product";
    }
    @PostMapping("/createProduct")
    public String createCustomer(@Validated @ModelAttribute("product") Product product, BindingResult bindingResult, RedirectAttributes redirectAttributes, Model model){
        if(bindingResult.hasFieldErrors()){
            model.addAttribute("listTypeOfProduct", this.typeOfProduct.findAll());
            model.addAttribute("product",product);
            return "create-product";
        }
        this.productService.saveProduct(product);
        redirectAttributes.addFlashAttribute("message","created new product");
        return "redirect:/";
    }
}
