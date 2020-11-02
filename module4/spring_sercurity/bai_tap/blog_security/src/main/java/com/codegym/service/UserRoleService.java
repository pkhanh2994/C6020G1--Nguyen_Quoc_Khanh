package com.codegym.service;

import com.codegym.entity.AppUser;
import com.codegym.entity.UserRole;

public interface UserRoleService {
    void saveUserRole(AppUser appUser, Long idAppRole);
}
