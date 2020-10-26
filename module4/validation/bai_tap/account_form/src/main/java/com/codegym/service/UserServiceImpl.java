package com.codegym.service;

import com.codegym.entity.User;
import com.codegym.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;



    @Override
    public Page<User> findByFirstName(Pageable pageable, String name) {
        return this.userRepository.findAllByFirstNameContaining(pageable,name);
    }

    @Override
    public Page<User> findAll(Pageable pageable) {
        return this.userRepository.findAll(pageable);
    }

    @Override
    public void save(User user) {
        this.userRepository.save(user);
    }
}
