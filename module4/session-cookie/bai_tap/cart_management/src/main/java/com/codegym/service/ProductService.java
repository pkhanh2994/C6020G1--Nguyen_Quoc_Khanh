package com.codegym.service;

import com.codegym.entity.Product;

import java.util.List;

public interface ProductService {
    Product findById(Integer id);
    List<Product>findAllProduct();
    void byProduct(Integer id) throws Exception;
}
