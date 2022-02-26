package com.nicholas.springsecuritywithjwt.repos;

import com.nicholas.springsecuritywithjwt.entities.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<AppUser, Long> {
    AppUser findByUsername(String username); //same as select user

}
