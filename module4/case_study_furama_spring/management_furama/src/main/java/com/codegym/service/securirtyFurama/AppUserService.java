package com.codegym.service.securirtyFurama;

import com.codegym.entity.securityFurama.AppUser;

import java.util.List;

public interface AppUserService {
    void saveUser(AppUser appUser);
    List<AppUser>findAll();
}
