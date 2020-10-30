package com.codegym.controller;

import com.codegym.entity.BlogApp;
import com.codegym.entity.Category;
import com.codegym.service.BlogAppService;
import com.codegym.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/blogRest")
@CrossOrigin("*")
public class BlogAPIController {
    @Autowired
    private CategoryService categoryService;
    @Autowired
    private BlogAppService blogAppService;
    @GetMapping("/listCategory")
    public ResponseEntity<List<Category>>findAllCategory(){
        return new ResponseEntity<>(this.categoryService.findAll(), HttpStatus.OK);
    }
    @GetMapping("/listBlog")
    public ResponseEntity<List<BlogApp>>findAllBlog(){
        return new ResponseEntity<>(this.blogAppService.findAll(),HttpStatus.OK);
    }
    @GetMapping("/listBlogCategory/{id}")
    public ResponseEntity<Category>detailsCategory(@PathVariable Integer id){
        return new ResponseEntity<>(this.categoryService.findById(id),HttpStatus.OK);
    }
    @GetMapping("/detailBlog/{id}")
    public ResponseEntity<BlogApp>detailBlog(@PathVariable String id){
        return new ResponseEntity<>(this.blogAppService.findById(id),HttpStatus.OK);
    }
    @GetMapping("/listBlog/{name}")
    public ResponseEntity<List<BlogApp>>findBlogByName(@PathVariable String name){
        if(name==null||name==""){
            return new ResponseEntity<>(this.blogAppService.findAll(),HttpStatus.OK);
        }else {
            return new ResponseEntity<>(this.blogAppService.selectBlogByNameAjax(name), HttpStatus.OK);
        }
    }
    @PostMapping("/saveBlog")
    public ResponseEntity<Void> createBlog(@RequestBody BlogApp blogApp){
        this.blogAppService.save(blogApp);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
