package com.nicholas.springsecuritywithjwt.repos;

import com.nicholas.springsecuritywithjwt.entities.UserRoles;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RolesRepository extends JpaRepository<UserRoles, Long> {
    UserRoles findByRoleName(String roleName);
}
