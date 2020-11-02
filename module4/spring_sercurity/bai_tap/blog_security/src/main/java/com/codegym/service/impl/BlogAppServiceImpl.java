package com.codegym.service.impl;

import com.codegym.entity.BlogApp;
import com.codegym.repository.BlogAppRepository;
import com.codegym.service.BlogAppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class BlogAppServiceImpl implements BlogAppService {
    @Autowired
    private BlogAppRepository blogAppRepository;
    @Override
    public Page<BlogApp> findAll(Pageable pageable) {
        return this.blogAppRepository.findAll(pageable);
    }

    @Override
    public BlogApp findById(String id) {
        return this.blogAppRepository.findById(id).orElse(null);
    }

    @Override
    public void save(BlogApp blogApp) {
        this.blogAppRepository.save(blogApp);
    }

    @Override
    public void deleteById(String id) {
        this.blogAppRepository.deleteById(id);
    }

    @Override
    public Page<BlogApp> selectBlogByName(Pageable pageable, String name) {
        return this.blogAppRepository.selectBlogByName(pageable,name);
    }

}
