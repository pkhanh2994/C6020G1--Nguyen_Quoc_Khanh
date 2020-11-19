package com.codegym.repository.securityFurama;


import com.codegym.entity.securityFurama.AppUser;
import com.codegym.entity.securityFurama.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRoleRepository extends JpaRepository<UserRole, Long> {
    List<UserRole> findByAppUser(AppUser appUser);
}
