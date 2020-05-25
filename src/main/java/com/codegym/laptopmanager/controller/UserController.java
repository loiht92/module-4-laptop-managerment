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

//    @PostMapping("/register")
//    public ModelAndView processRegister(@ModelAttribute("appUser")AppUser appUser){
//        List<GrantedAuthority> authorities = new ArrayList<>();
//        authorities.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
//
//        appUser.getUsername();
//        return (ModelAndView) authorities;
//    }
    //

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/user")
    public String user(Principal principal) {
        // Get authenticated user name from Principal
        System.out.println(principal.getName());
        return "login/user";
    }

    @GetMapping("/admin")
    public String admin(Principal principal) {
        // Get authenticated user name from Principal
        System.out.println(principal.getName());
        return "login/admin";
    }


//    @GetMapping("/accessDenied")
//    public String error() {
//        return "/accessDenied";
//    }
}
