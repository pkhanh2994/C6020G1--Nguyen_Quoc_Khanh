package com.codegym.controller;

import com.codegym.entity.Product;
import com.codegym.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.jws.WebParam;
import java.util.List;

@Controller
public class ProductController {
    @Autowired
    ProductService productService;
    @GetMapping("/")
    public String homePage(Model model){
        List<Product>productList=this.productService.findAll();
        model.addAttribute("productList",productList);
        return "home-page";
    }
    @GetMapping("/create")
    public String showCreateForm(Model model){
        model.addAttribute("product",new Product());
        return "create_product";
    }
    @PostMapping("/create")
    public String createProduct(@ModelAttribute Product product, RedirectAttributes redirectAttributes){
        this.productService.createProduct(product);
        redirectAttributes.addFlashAttribute("message","created new product");
        return "redirect:/";
    }
    @GetMapping("{id}/update")
    public String updateForm(@PathVariable Integer id, Model model){
        Product product;
        product=this.productService.findById(id);
        model.addAttribute("product",product);
        return "update_product";
    }
    @PostMapping("/update")
    public String updateProduct(@ModelAttribute Product product,RedirectAttributes redirectAttributes){
        this.productService.updateProduct(product);
        redirectAttributes.addFlashAttribute("message","updated");
        return "redirect:/";
    }
    @GetMapping("{id}/delete")
    public String showDeleteInfo(@PathVariable Integer id,Model model){
        Product product;
        product=this.productService.findById(id);
        model.addAttribute("product",product);
        return "delete";

    }
    @PostMapping("/delete")
    public String deleteProduct(@RequestParam Integer id,RedirectAttributes redirectAttributes){
        this.productService.deleteProductById(id);
        redirectAttributes.addFlashAttribute("message","deleted product");
        return "redirect:/";
    }
    @GetMapping("{id}/detail")
    public String viewDetailProduct(@PathVariable Integer id,Model model){
      Product product=  this.productService.findById(id);
        model.addAttribute("product",product);
        return "detail_product";

    }
}
