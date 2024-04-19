package org.example;

//import com.github.javafaker.Faker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//public class ApiApplication implements CommandLineRunner {
public class ApiApplication  {
//    @Autowired
//    private UserRepository userRepository;
    public static void main(String[] args) {
        SpringApplication.run(ApiApplication.class, args);
    }

//    @Override
//    public void run(String... args) throws Exception {
//        Faker faker = new Faker();
//        for (int i = 0; i < 10; i++) { // Thay đổi 10 thành số lượng bản ghi mong muốn
//            User user = new User();
//            user.setName(faker.name().fullName());
//            userRepository.save(user);
//        }
//    }
}
