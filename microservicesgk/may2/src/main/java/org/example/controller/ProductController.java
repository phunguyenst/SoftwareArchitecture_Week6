package org.example.controller;

import io.github.resilience4j.retry.Retry;
import org.example.config.RetryConfigP;
import org.example.model.Product;
import org.example.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.function.Supplier;

@RestController
public class ProductController {

//    @Autowired
//    private ProductRepository productRepository;

    RestTemplate restTemplate = new RestTemplate();

//    @GetMapping("/products")
//    List<Product> getAllProduct(){
//        return productRepository.findAll();
//    }
//    @GetMapping("/product/{id}")
//    Product getUserById(@PathVariable long id){
//        User user = restTemplate.getForObject("http://localhost:8080/user/"+id, User.class);
//        Product product = productRepository.findById(id).get();
//        product.setUser(user);
//        return product;
//    }
    @Autowired
    private RetryConfigP retryConfigP;
    @GetMapping("/product")
    public String getHello() {
        Retry retry = retryConfigP.retry(retryConfigP.retryRegistry());
        Supplier<String> stringSupplier = Retry.decorateSupplier(retry,
                () -> restTemplate.getForObject("http://localhost:8080/user", String.class));

        return stringSupplier.get();
    }
}
