package com.nicholas.springsecuritywithjwt.api;

import com.nicholas.springsecuritywithjwt.entities.AppUser;
import com.nicholas.springsecuritywithjwt.entities.UserRoles;
import com.nicholas.springsecuritywithjwt.userservice.UserService;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    //a method to return a list of all the users
    @GetMapping("/users")
    public ResponseEntity<List<AppUser>> getUsers(){
        //calling the service to return users from the DB
        return ResponseEntity.ok().body(userService.getUsers());
    }

    //post user data to the server
    @PostMapping("/user/save")
    public ResponseEntity<AppUser> saveUsers(@RequestBody AppUser appUser){

        //send 201 response to show that a resource was created in the server, by getting the server's URI
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/api/user/save").toUriString());
        return ResponseEntity.created(uri).body(userService.saveAppUser(appUser));
    }

    //adding  roles to the database
    @PostMapping("/role/save")
    public ResponseEntity<UserRoles> saveRoles(@RequestBody UserRoles userRoles){

        //send 201 response to show that a resource was created in the server, by getting the server's URI
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/api/role/save").toUriString());
        return ResponseEntity.created(uri).body(userService.saveRoles(userRoles));

    }

    //assigning role to specific user
    @PostMapping("/role/assignRole")
    public ResponseEntity<?> addRolesRoUsers(@RequestBody AssignUserRoles formRoles){
        userService.addRoleToUser(
                formRoles.getUsername(), formRoles.getRoleName());
        return ResponseEntity.ok().build(); //not returning body because it only sends response

    }
}

@Data//to enhance getters and setters
class  AssignUserRoles {
    private String username;
    private String roleName;
}
