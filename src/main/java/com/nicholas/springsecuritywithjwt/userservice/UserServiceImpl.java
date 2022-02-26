package com.nicholas.springsecuritywithjwt.userservice;

import com.nicholas.springsecuritywithjwt.entities.AppUser;
import com.nicholas.springsecuritywithjwt.entities.UserRoles;
import com.nicholas.springsecuritywithjwt.repos.RolesRepository;
import com.nicholas.springsecuritywithjwt.repos.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class UserServiceImpl implements UserService{

    //add repositories since they communicate with JPARepo directly
    private final UserRepository userRepository;
    private final RolesRepository rolesRepository;
    @Override
    public AppUser saveAppUser(AppUser user) {

        //to save a user, we return userRepo with saveAll method
        return userRepository.save(user);
    }

    @Override
    public UserRoles saveRoles(UserRoles roles) {

        //to save a user, we return userRepo with saveAll method
        return rolesRepository.save(roles);
    }

    @Override
    public void addRoleToUser(String username, String roleName) {

        //to successfully add role to user, first we user bby username
        AppUser user = userRepository.findByUsername(username);

        //then get the role, using findByroleName method
        UserRoles roles = rolesRepository.findByRoleName(roleName);

        //now add roles onto the user
        user.getRoles().add(roles);


    }

    @Override
    public AppUser getUser(String username) {
        //helps find userBy userName
        return userRepository.findByUsername(username);
    }

    @Override
    public List<AppUser> getUsers() {
        //to get all the users, users in the database
        return userRepository.findAll();
    }
}
