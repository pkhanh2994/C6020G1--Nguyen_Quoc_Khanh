package com.codegym.service.securirtyFurama;


import com.codegym.entity.securityFurama.AppUser;

public interface UserRoleService {
    void saveUserRole(AppUser appUser, Long idAppRole);
}
