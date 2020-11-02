package com.codegym.service.impl;

import com.codegym.entity.AppRole;
import com.codegym.entity.AppUser;
import com.codegym.entity.UserRole;
import com.codegym.repository.AppRoleRepository;
import com.codegym.repository.UserRoleRepository;
import com.codegym.service.UserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserRoleServiceImpl implements UserRoleService {
    @Autowired
    private UserRoleRepository userRoleRepository;
    @Autowired
    private AppRoleRepository appRoleRepository;

    @Override
    public void saveUserRole(AppUser appUser, Long idRoleApp) {
        UserRole userRole = new UserRole(appUser, this.appRoleRepository.findById(idRoleApp).orElse(null));
        this.userRoleRepository.save(userRole);

    }
}
