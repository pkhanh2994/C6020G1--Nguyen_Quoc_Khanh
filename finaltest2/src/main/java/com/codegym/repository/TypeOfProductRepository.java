package com.codegym.repository;

import com.codegym.entiy.TypeOfProduct;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TypeOfProductRepository extends JpaRepository<TypeOfProduct,Integer> {
    Page<TypeOfProduct>findAllByNameOfTypeOfProductContaining(Pageable pageable,String nameTypeProduct);
}
