package com.codegym.service;

import com.codegym.entity.BlogApp;

import java.util.List;

public interface BlogAppService {
    List<BlogApp>findAll();
    BlogApp findById(String id);
    void save(BlogApp blogApp);
    void deleteById(String id);
}
