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

        //adding logs to see what's happening
        log.info("add new user {} to the db", user.getUsername());

        //to save a user, we return userRepo with saveAll method
        return userRepository.save(user);
    }

    @Override
    public UserRoles saveRoles(UserRoles roles) {

        //adding logs to see what's happening
        log.info("add new roles {}to the db", roles.getRoleName());

        //to save a user, we return userRepo with saveAll method
        return rolesRepository.save(roles);
    }

    @Override
    public void addRoleToUser(String username, String roleName) {
        //adding logs to see what's happening
        log.info("add new roles {}to User {} new role, and pass to the db", roleName, username);

        //to successfully add role to user, first we user by username
        AppUser user = userRepository.findByUsername(username);
        //then get the role, using findByroleName method
        UserRoles roles = rolesRepository.findByRoleName(roleName);

        //now add roles onto the user
        user.getRoles().add(roles);


    }

    @Override
    public AppUser getUser(String username) {
        //adding logs to see what's happening
        log.info("fetching user details{}", username);

        //helps find userBy userName
        return userRepository.findByUsername(username);
    }

    @Override
    public List<AppUser> getUsers() {
        log.info("fetching all users");
        //to get all the users, users in the database
        return userRepository.findAll();
    }
}
