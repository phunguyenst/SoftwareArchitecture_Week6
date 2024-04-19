package org.example.controller;

import org.example.model.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {
//    @Autowired
//    private UserRepository userRepository;
//
//    @GetMapping("/users")
//    List<User> getUsers(){
//        return userRepository.findAll();
//    }
//
//    @GetMapping("/user")
//    public String getHello() {
//        return "Hello cac ban nhe";
//    }

    @GetMapping("/user")
    public String getUser() {
        return "This is a user";
    }

}
