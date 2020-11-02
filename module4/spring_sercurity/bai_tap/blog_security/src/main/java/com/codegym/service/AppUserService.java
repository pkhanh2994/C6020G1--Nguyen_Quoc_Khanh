package com.codegym.service;

import com.codegym.entity.AppUser;

import java.util.List;

public interface AppUserService {
    void saveUser(AppUser appUser);
    List<AppUser>findAll();
}
