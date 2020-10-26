package com.codegym.service;

import com.codegym.entity.Product;
import com.codegym.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepository productRepository;

    @Override
    public Product findById(Integer id) {
        return this.productRepository.findById(id).orElse(null);
    }

    @Override
    public List<Product> findAllProduct() {
        return this.productRepository.findAll();
    }


    @Override
    public void byProduct(Integer id) throws Exception {
        Product product=findById(id);
        if(product.getQuantity()==0){
            throw new Exception("Oh no, you can't read");
        }else {
            product.setQuantity(product.getQuantity()-1);

        }
    }
}
