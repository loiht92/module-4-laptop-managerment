package com.codegym.laptopmanager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;

@Controller
public class UserController {

    @Autowired
    private PasswordEncoder bCryptPasswordEncoder;

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/user")
    public String user(Principal principal) {
        System.out.println(principal.getName());
        return "login/login-user";
    }

    @GetMapping("/admin")
    public String admin(Principal principal) {
        // Get authenticated user name from Principal
        System.out.println(principal.getName());
       return "login/admin";
    }
}
