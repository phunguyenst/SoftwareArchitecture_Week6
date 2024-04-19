package org.example.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class UserController {
//    @Autowired
//    private UserRepository userRepository;

//    @GetMapping("/users")
//    List<User> getUsers(){
//        return userRepository.findAll();
//    }
//
//    @GetMapping("/user/{id}")
//    User getUserById(@PathVariable long id){
//        return userRepository.findById(id).get();
//    }

    @GetMapping("/user")
    public String getHello() {
        return "Hello cac ban nhe";
    }
}
