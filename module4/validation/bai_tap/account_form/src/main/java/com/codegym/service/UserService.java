package com.codegym.service;

import com.codegym.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface UserService {
Page<User>findByFirstName(Pageable pageable,String name);
    Page<User> findAll(Pageable pageable);
    void save(User user);
}
