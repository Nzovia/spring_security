package com.nicholas.springsecuritywithjwt.controllers;

import com.nicholas.springsecuritywithjwt.userservice.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

@Controller
public class UserController {
    private UserService userService;
}
