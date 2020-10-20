package com.codegym.service.impl;

import com.codegym.entity.Product;
import com.codegym.repository.ProductRepository;
import com.codegym.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    ProductRepository productRepository;

    @Override
    public List<Product> findAll() {
        return this.productRepository.findAll();
    }

    @Override
    public void createProduct(Product product) {
        this.productRepository.createProduct(product);

    }

    @Override
    public Product findById(Integer id) {
        return this.productRepository.findById(id);
    }

    @Override
    public void updateProduct(Product product) {
        this.productRepository.updateProduct(product);

    }

    @Override
    public void deleteProductById(Integer id) {
        this.productRepository.deleteProductById(id);

    }
}
