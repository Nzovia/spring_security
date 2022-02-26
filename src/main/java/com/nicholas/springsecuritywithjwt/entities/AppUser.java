package com.nicholas.springsecuritywithjwt.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AppUser {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private  String username;
    private String password;

    //relationship between the user and the roles
    @ManyToMany(fetch = FetchType.EAGER) // means fetch the user and all their roles
    private Collection<UserRoles> roles = new ArrayList<>();

}
