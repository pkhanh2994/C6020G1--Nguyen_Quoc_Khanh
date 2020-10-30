package com.codegym.controller;

import com.codegym.entity.Product;
import com.codegym.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@SessionAttributes({"userLogin","productList"})
public class ProductController {
    @Autowired
    private ProductService productService;
    @ModelAttribute("productList")
    public List<Product>productList(){
        return new ArrayList<>();
    }
    @PostMapping("addCart")
    public String addCart(@RequestParam Integer id, @ModelAttribute("productList") List<Product>productList){
        Product product=this.productService.findById(id);
        if(productList==null)
        {
            productList.add(product);
        }else {
            for(Product product1 : productList){
                if(product1.getId().equals(product.getId())){
                    product1.setQuantity(product1.getQuantity()+product.getQuantity());
                    productList.add(product1);

                }

            }

        }
        return  "redirect:/homePage";
    }
    @GetMapping("infoCart")
    public String info( @ModelAttribute("productList") List<Product>productList,Model model){
        model.addAttribute("productList",productList);
        return "inforCart-page";
    }

    @GetMapping("/homePage")
    public String homeProduct(Model model){
        model.addAttribute("listProduct",this.productService.findAllProduct());
        return "home-page";

    }
    @GetMapping("{id}/detailsProduct")
    public String detailsProduct(@PathVariable Integer id, Model model) {
        Product product=this.productService.findById(id);
        model.addAttribute("product", product);
        return "by-page";
    }

}
