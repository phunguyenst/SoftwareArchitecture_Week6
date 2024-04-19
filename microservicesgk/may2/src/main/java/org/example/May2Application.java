package org.example;

//import com.github.javafaker.Faker;
import org.example.model.Product;
import org.example.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//public class May2Application implements CommandLineRunner {
public class May2Application  {

//    @Autowired
//    private UserRepository userRepository;
//    @Autowired
//    private ProductRepository productRepository;
    public static void main(String[] args) {
        SpringApplication.run(May2Application.class, args);
    }

//    @Override
//    public void run(String... args) throws Exception {
//        Faker faker = new Faker();
//        for (int i = 0; i < 10; i++) {
//            User user = new User();
//            Product product = new Product();
//            product.setName(faker.name().fullName());
//            product.setPrice(Double.parseDouble(faker.commerce().price()));
//            user.setName(faker.name().fullName());
//            product.setUser(user);
//            userRepository.save(user);
//            productRepository.save(product);
//        }
//    }

}
