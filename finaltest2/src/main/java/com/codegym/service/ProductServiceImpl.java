package com.codegym.service;

import com.codegym.entiy.Product;
import com.codegym.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepository productRepository;

    @Override
    public void saveProduct(Product product) {
        this.productRepository.save(product);
    }

    @Override
    public Product findById(Integer idProduct) {
        return this.productRepository.findById(idProduct).orElse(null);
    }

    @Override
    public void deleteProduct(Integer idProduct) {
        this.productRepository.deleteById(idProduct);

    }

    @Override
    public Page<Product> findProduct(Pageable pageable, String productDetail) {
        return this.productRepository.findProduct(pageable,productDetail);
    }

    @Override
    public Page<Product> findAll(Pageable pageable) {
        return this.productRepository.findAll(pageable);
    }
}
