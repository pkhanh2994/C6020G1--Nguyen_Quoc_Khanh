package com.codegym.service.impl;

import com.codegym.entity.AppUser;
import com.codegym.repository.AppUserRepository;
import com.codegym.repository.UserRoleRepository;
import com.codegym.service.AppUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppUserServiceImpl implements AppUserService {
    @Autowired
    AppUserRepository appUserRepository;
    @Override
    public void saveUser(AppUser appUser) {
        this.appUserRepository.save(appUser);
    }

    @Override
    public List<AppUser> findAll() {
        return this.appUserRepository.findAll();
    }
}
