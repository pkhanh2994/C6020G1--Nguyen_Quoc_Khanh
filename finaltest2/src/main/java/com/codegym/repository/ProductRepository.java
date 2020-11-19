package com.codegym.repository;

import com.codegym.entiy.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ProductRepository extends JpaRepository<Product,Integer> {
    @Query(value = "select * from product where concat(product_name,'',price,'',id_type_of_product,'')   like %?1%", nativeQuery = true)
    Page<Product>findProduct(Pageable pageable,String productDetail);
}
