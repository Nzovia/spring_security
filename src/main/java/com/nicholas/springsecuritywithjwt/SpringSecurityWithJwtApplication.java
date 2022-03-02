package com.nicholas.springsecuritywithjwt;

import com.nicholas.springsecuritywithjwt.entities.AppUser;
import com.nicholas.springsecuritywithjwt.entities.UserRoles;
import com.nicholas.springsecuritywithjwt.userservice.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;

@SpringBootApplication
public class SpringSecurityWithJwtApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringSecurityWithJwtApplication.class, args);
    }

    //test the apis by adding data
    @Bean
    CommandLineRunner runner(UserService userService){
        return  args -> {
            userService.saveRoles(new UserRoles(1, "USER"));
            userService.saveRoles(new UserRoles(2, "ADMIN"));
            userService.saveRoles(new UserRoles(3, "SUPER-USER"));

            //adding new users
            userService.saveAppUser(new AppUser(null, "Nic Nzov", "Nzov", "123456", new ArrayList<>()));
            userService.saveAppUser(new AppUser(null, "Fid Nic", "Fid", "123456", new ArrayList<>()));
            userService.saveAppUser(new AppUser(null, "Ben Man", "Ben", "123456", new ArrayList<>()));

            //adding role to users
            userService.addRoleToUser("Nzov", "USER");
            userService.addRoleToUser("Fid", "ADMIN");
            userService.addRoleToUser("Ben", "SUPER-USER");



        };
    }

}
