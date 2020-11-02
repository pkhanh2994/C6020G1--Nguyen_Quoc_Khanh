package com.codegym.controller;

import com.codegym.entity.Category;
import com.codegym.service.BlogAppService;
import com.codegym.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;

@Controller
public class CategoryController {
    @Autowired
    private BlogAppService blogAppService;
    @Autowired
    private CategoryService categoryService;
    @GetMapping("/viewCategory")
    public String viewCategory(Model model, @PageableDefault(size = 2) Pageable pageable, Optional<String> keyword){
        String holdKeyWord="";
        if(keyword.isPresent()){
            holdKeyWord=keyword.get();
            model.addAttribute("categoryList",this.categoryService.findAllbyName(pageable,holdKeyWord));
        }else {
        model.addAttribute("categoryList",this.categoryService.findAll(pageable));
        }
        model.addAttribute("holdKeyword");
        return "list-category";
    }
    @GetMapping("createCategory")
    public String formCreate(Model model){
        model.addAttribute("category",new Category());
        return "create-category";
    }
    @PostMapping("createCategory")
    public String createBlog(@ModelAttribute Category category, RedirectAttributes redirectAttributes){
        this.categoryService.save(category);
        redirectAttributes.addFlashAttribute("message","created new category");
        return "redirect:/";
    }
    @GetMapping("{id}/detailCategory")
    public String detailblogList(@PathVariable Integer id, Model model){
        model.addAttribute("category",this.categoryService.findById(id));
        return "blog-list-category";

    }
    @GetMapping("{id}/deleteCategory")
    public String deleteForm(@PathVariable Integer id, Model model){
        model.addAttribute("category",this.categoryService.findById(id));
        return "delete-category";
    }
    @PostMapping("/deleteCategory")
    public String deleteBlog(@ModelAttribute Category category){
        this.categoryService.deleteById(category.getIdCategory());
        return "redirect:/viewCategory";
    }
}
