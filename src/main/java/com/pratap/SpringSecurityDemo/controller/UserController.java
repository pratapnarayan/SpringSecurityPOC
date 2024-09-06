package com.pratap.SpringSecurityDemo.controller;

import com.pratap.SpringSecurityDemo.model.Users;
import com.pratap.SpringSecurityDemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public Users register(@RequestBody Users user) {

        return userService.register(user);
    }

    @PostMapping("/login")
    public String login(@RequestBody Users user) {
        //System.out.println(user);
        //return "Success";
        return userService.verify(user);
    }
}
