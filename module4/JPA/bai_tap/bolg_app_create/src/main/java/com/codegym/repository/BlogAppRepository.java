package com.codegym.repository;

import com.codegym.entity.BlogApp;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface BlogAppRepository extends JpaRepository<BlogApp,String> {
}
