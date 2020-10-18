package controller;


import com.sun.org.apache.xpath.internal.operations.Mod;
import model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import service.ProductService;

import java.util.List;

@Controller
public class ProductController {


@Autowired
ProductService productService;
    @GetMapping("/")
    public String homPage(Model model){
     List<Product> productList=productService.findAllProduct();
     model.addAttribute("products",productList);
        return "view";
    }
    @GetMapping("{id}/delete")
    public String showInfoDelete(@PathVariable int id,Model model,Product product){
        product=productService.findProductById(id);
        model.addAttribute(product);
        return "delete";
    }
    @PostMapping("{id}/deleteProduct")
    public String delete(@PathVariable int id, RedirectAttributes redirectAttributes){
        productService.deleteById(id);
        redirectAttributes.addFlashAttribute("message","deleted a product");
        return "redirect:/";
    }
    @GetMapping("{id}/edit")
    public String showUpdateInfo(@PathVariable int id, Model model,Product product){
        product=productService.findProductById(id);
        model.addAttribute("product",product);
        return "edit";

    }
    @PostMapping("{id}/updateProduct")
    public String updateProduct(@PathVariable int id, RedirectAttributes redirectAttributes,Product product){
        productService.update(id,product);
        redirectAttributes.addFlashAttribute("message","updated");
        return "redirect:/";
    }
    @GetMapping("create")
    public String showNewForm(Model model){
        model.addAttribute("product",new Product());
        return "create";
    }
    @PostMapping("save")
    public String createProduct(@ModelAttribute Product product,RedirectAttributes redirectAttributes){
        productService.save(product);
        redirectAttributes.addFlashAttribute("message","created a product");
        return "redirect:/";
    }
    @GetMapping("{id}/viewInfo")
    public String viewDetailsProduct(@PathVariable int id,Product product,Model model){
        product=productService.findProductById(id);
        model.addAttribute("product",product);
        return "viewInfo";
    }
}
