package com.codegym.repository;

import com.codegym.entity.BlogApp;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;



public interface BlogAppRepository extends JpaRepository<BlogApp,String> {
    @Query(value = "select * from blog where blog_name like concat('%',?1, '%')",nativeQuery = true)
    Page<BlogApp> selectBlogByName(Pageable pageable, String blogName);
}
