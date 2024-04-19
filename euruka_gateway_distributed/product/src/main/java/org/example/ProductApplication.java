package org.example;

import com.github.javafaker.Faker;
import org.example.model.Product;
import org.example.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.math.BigDecimal;

@SpringBootApplication
public class ProductApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(ProductApplication.class, args);
    }
    @Autowired
    private ProductRepository productRepository;
    @Override
    public void run(String... args) {
        Faker faker = new Faker();
        for (int i = 0; i < 10; i++) {
            Product product = new Product();
            product.setName(faker.commerce().productName());
            product.setPrice(new BigDecimal(faker.commerce().price()).doubleValue());
            productRepository.save(product);
        }
    }

}
