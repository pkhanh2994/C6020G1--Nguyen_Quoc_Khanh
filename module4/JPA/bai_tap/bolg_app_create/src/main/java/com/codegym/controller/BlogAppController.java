package com.codegym.controller;

import com.codegym.entity.BlogApp;
import com.codegym.service.BlogAppService;
import com.codegym.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Optional;

@Controller
public class BlogAppController {
    @Autowired
    private BlogAppService blogAppService;
    @Autowired
    private CategoryService categoryService;

    @GetMapping("/")
    public String homePage(Model model, @PageableDefault(size = 2)Pageable pageable, Optional<String>keyword){
        String holdKeyword="";
        if(keyword.isPresent()){
            holdKeyword=keyword.get();
            model.addAttribute("blogAppList",this.blogAppService.selectBlogByName(pageable,holdKeyword));
        }else {
            model.addAttribute("blogAppList",this.blogAppService.findAll(pageable));
        }
        model.addAttribute("holdKeyword",holdKeyword);
        return "home-page";
    }
    @GetMapping("create")
    public String newForm(Model model){
        model.addAttribute("categoryList",this.categoryService.findAll());
        model.addAttribute("blog",new BlogApp());


        return "create";
    }
    @PostMapping("create")
    public String createBlog( @ModelAttribute BlogApp blogApp, RedirectAttributes redirectAttributes){
        this.blogAppService.save(blogApp);
        redirectAttributes.addFlashAttribute("message","created new blog");
        return "redirect:/";
    }
    @GetMapping("{id}/delete")
    public String deleteInfo(@PathVariable String id,Model model){
        BlogApp blogApp=this.blogAppService.findById(id);
        model.addAttribute("blog",blogApp);
        return "delete";
    }
    @PostMapping("/delete")
    public String deleteBlog(@RequestParam String id, RedirectAttributes redirectAttributes){

        this.blogAppService.deleteById(id);
        redirectAttributes.addFlashAttribute("message","deleted blog");
        return "redirect:/";

    }
    @GetMapping("{id}/detail")
    public String detailBlog(@PathVariable String id,Model model){
        BlogApp blogApp=this.blogAppService.findById(id);
        model.addAttribute("blog",blogApp);
        return "detail";
    }
    @GetMapping("{id}/update")
    public String updateInfo(@PathVariable String id, Model model){
        BlogApp blogApp=this.blogAppService.findById(id);
        model.addAttribute("blog",blogApp);
        return "update";
    }
    @PostMapping("/update")
    public String updateBlog(@ModelAttribute BlogApp blogApp, RedirectAttributes redirectAttributes){
        this.blogAppService.save(blogApp);
        redirectAttributes.addFlashAttribute("message","updated blog");
        return "redirect:/";
    }

}
