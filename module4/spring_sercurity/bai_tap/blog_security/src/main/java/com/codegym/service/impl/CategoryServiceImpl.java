package com.codegym.service.impl;

import com.codegym.entity.Category;
import com.codegym.repository.CategoryRepository;
import com.codegym.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public List<Category> findAll() {
        return this.categoryRepository.findAll();
    }

    @Override
    public Page<Category> findAll(Pageable pageable) {
        return this.categoryRepository.findAll(pageable);
    }

    @Override
    public Category findById(Integer id) {
        return this.categoryRepository.findById(id).orElse(null);
    }

    @Override
    public void save(Category category) {
        this.categoryRepository.save(category);

    }

    @Override
    public void deleteById(Integer id) {
        this.categoryRepository.deleteById(id);
    }

    @Override
    public Page<Category> findAllbyName(Pageable pageable, String name) {
        return this.categoryRepository.findAllbyName(pageable,name);
    }
}
