package com.nicholas.springsecuritywithjwt.userservice;

import com.nicholas.springsecuritywithjwt.entities.AppUser;
import com.nicholas.springsecuritywithjwt.entities.UserRoles;


import java.util.List;

//here we define all the methods we want to have
// in the application so that we can manage AppUsers
public interface UserService {

    //method for saving users
    AppUser saveAppUser(AppUser user);
    UserRoles saveRoles(UserRoles roles);

    //add a role to specific user
    void addRoleToUser(String username, String roleName);

    //a method to return user
    AppUser getUser(String username);

    //method that returns a list of users
    List<AppUser>getUsers(); //for large Apps use paging

    //Note: we inject our services into the controllers so that we can manage the activities of the AppUsers
}
