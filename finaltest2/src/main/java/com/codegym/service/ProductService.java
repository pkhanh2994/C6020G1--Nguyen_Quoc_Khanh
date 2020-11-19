package com.codegym.service;

import com.codegym.entiy.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ProductService {
    void saveProduct(Product product);
    Product findById(Integer idProduct);
    void deleteProduct(Integer idProduct);
    Page<Product> findProduct(Pageable pageable, String productDetail);
    Page<Product>findAll(Pageable pageable);
}
