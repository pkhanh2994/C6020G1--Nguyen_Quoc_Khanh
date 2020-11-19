package com.codegym.service.securirtyFurama;


import com.codegym.entity.securityFurama.AppUser;

import com.codegym.repository.securityFurama.AppUserRepository;
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
