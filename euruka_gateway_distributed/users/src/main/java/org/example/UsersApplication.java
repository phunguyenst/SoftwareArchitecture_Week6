package org.example;

import com.github.javafaker.Faker;
import org.example.model.User;
import org.example.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class UsersApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(UsersApplication.class, args);
    }
    @Autowired
    private UserRepository userRepository;
    @Override
    public void run(String... args) throws Exception {
        Faker faker = new Faker();
        for (int i = 0; i < 10; i++) { // Thay đổi 10 thành số lượng bản ghi mong muốn
            User user = new User();
            user.setName(faker.name().fullName());
            userRepository.save(user);
        }
    }
}
