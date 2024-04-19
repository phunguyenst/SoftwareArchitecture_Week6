package org.example.controller;

import org.example.model.User;
import org.example.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class UserController {
    @GetMapping("/user")
    public String getHello() {
        return "Hello cac ban nhe";
    }
    @Autowired
    private UserRepository userRepository;

    @GetMapping("/users")
    List<User> getUsers(){
        return userRepository.findAll();
    }
    @GetMapping("/user/{id}")
    User getUser(@PathVariable Long id){
        return userRepository.findById(id).orElse(null);
    }
}
