package com.codegym.service.securirtyFurama;


import com.codegym.entity.securityFurama.AppUser;
import com.codegym.entity.securityFurama.UserRole;
import com.codegym.repository.securityFurama.AppRoleRepository;
import com.codegym.repository.securityFurama.UserRoleRepository;
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
