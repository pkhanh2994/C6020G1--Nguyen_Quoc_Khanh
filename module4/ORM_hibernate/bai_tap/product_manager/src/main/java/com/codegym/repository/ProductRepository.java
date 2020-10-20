package com.codegym.repository;

import com.codegym.entity.Product;

import java.util.List;

public interface ProductRepository {
    List<Product>findAll();
   void createProduct(Product product);
   Product findById(Integer id);
   void updateProduct(Product product);
   void deleteProductById(Integer id);
}
