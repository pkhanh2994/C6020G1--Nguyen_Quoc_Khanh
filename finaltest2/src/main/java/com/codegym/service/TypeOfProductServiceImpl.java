package com.codegym.service;

import com.codegym.entiy.TypeOfProduct;
import com.codegym.repository.TypeOfProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TypeOfProductServiceImpl implements TypeOfProductService {
    @Autowired
    private TypeOfProductRepository typeOfProductRepository;

    @Override
    public List<TypeOfProduct> findAll() {
        return this.typeOfProductRepository.findAll();
    }

    @Override
    public Page<TypeOfProduct> findAllByNameOfTypeOfProductContaining(Pageable pageable, String nameTypeProduct) {
        return this.typeOfProductRepository.findAllByNameOfTypeOfProductContaining(pageable,nameTypeProduct);
    }

}