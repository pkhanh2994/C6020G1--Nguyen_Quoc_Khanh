package com.codegym.service;

import com.codegym.entiy.TypeOfProduct;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface TypeOfProductService {
    List<TypeOfProduct>findAll();
    Page<TypeOfProduct>findAllByNameOfTypeOfProductContaining(Pageable pageable,String nameTypeProduct);

}
