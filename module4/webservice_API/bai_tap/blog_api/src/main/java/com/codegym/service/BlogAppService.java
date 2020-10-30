package com.codegym.service;

import com.codegym.entity.BlogApp;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface BlogAppService {
    List<BlogApp>findAll();
    Page<BlogApp> findAll(Pageable pageable);
    BlogApp findById(String id);
    void save(BlogApp blogApp);
    void deleteById(String id);
    Page<BlogApp> selectBlogByName(Pageable pageable, String name);
    List<BlogApp>selectBlogByNameAjax(String blogName);
}
