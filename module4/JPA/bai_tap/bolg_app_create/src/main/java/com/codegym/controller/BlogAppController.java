package com.codegym.controller;

import com.codegym.entity.BlogApp;
import com.codegym.service.BlogAppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class BlogAppController {
    @Autowired
    private BlogAppService blogAppService;

    @GetMapping("/")
    public String homePage(Model model){
        List<BlogApp>blogAppList;
        blogAppList=this.blogAppService.findAll();
        model.addAttribute("blogAppList",blogAppList);
        return "home-page";
    }
    @GetMapping("create")
    public String newForm(Model model){
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
