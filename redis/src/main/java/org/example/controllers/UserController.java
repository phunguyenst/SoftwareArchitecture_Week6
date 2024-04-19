package org.example.controllers;

import org.example.models.Car;
import org.example.models.User;
import org.example.repositories.UserRepository;
import org.example.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class UserController {
    RestTemplate restTemplate = new RestTemplate();
    @Autowired
    UserRepository userRepository;

    @Autowired
    private UserService userService;

    @GetMapping("/user/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id, @RequestHeader(HttpHeaders.AUTHORIZATION)String token){
        if(token.isEmpty()){
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);
        }
        try{
            String apiUrl = "http://localhost:8081/car";
            HttpHeaders headers = new HttpHeaders();
            headers.set("Authorization", token);
            System.out.println(token);

            HttpEntity<String> entity = new HttpEntity<>(headers);
            ParameterizedTypeReference<ArrayList<Car>> responseType = new ParameterizedTypeReference<ArrayList<Car>>() {};
            ResponseEntity<ArrayList<Car>> response = restTemplate.exchange(apiUrl, HttpMethod.GET, entity, responseType);
            ArrayList<Car> carList = response.getBody();
            System.out.println("carlist:"+carList);

            User user = userService.findUserById(id);
            user.setCars(carList);
            userService.updateUser(user);
            return ResponseEntity.status(HttpStatus.OK).body(user);

        }
        catch (Exception e){
            System.out.println(e);
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);
        }
    }

    @GetMapping("/listUsers")
    public List<User> getAllUsers(){
        return userService.findAll();
    }

    @GetMapping("/user/{id}/details")
    public User getUserById(@PathVariable Long id){
        return userService.findUserById(id);
    }

    @PostMapping("/Adduser")
    public User saveUser(@RequestBody User user){
        return userService.save(user);
    }

    @PutMapping("/user")
    public User updateUser(@RequestBody User user){
        return userService.updateUser(user);
    }

    @DeleteMapping("/user/{id}")
    public Long deleteUser(@PathVariable Long id){
        return userService.deleteUser(id);
    }
}
