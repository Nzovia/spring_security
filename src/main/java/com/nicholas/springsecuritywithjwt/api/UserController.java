package com.nicholas.springsecuritywithjwt.api;

import com.nicholas.springsecuritywithjwt.entities.AppUser;
import com.nicholas.springsecuritywithjwt.userservice.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    //post data to the server
    @GetMapping("/users")
    public ResponseEntity<AppUser> saveUsers(@RequestBody AppUser appUser){
        return ResponseEntity.ok().body(userService.saveAppUser(appUser));
    }
}
