package com.codegym.repository;

import com.codegym.entity.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import javax.xml.ws.WebEndpoint;

public interface CategoryRepository extends JpaRepository<Category,Integer> {
    @Query(value = "select * from category where category_name like %?1%",nativeQuery = true)
    Page<Category>findAllbyName(Pageable pageable,String name);
}
