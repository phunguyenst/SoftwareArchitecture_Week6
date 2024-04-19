package org.example.controllers;

import org.example.model.Product;
import org.example.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v2")
public class ProductController {
    @Autowired
    private ProductRepository productRepository;
    @RequestMapping("/product")
    public String getProduct() {
        return "Product";
    }

    @GetMapping("/products")
    public List<Product> getProducts() {
        return productRepository.findAll();
    }

    @GetMapping("/product/{id}")
    public Product getProduct(Long id) {
        return productRepository.findById(id).orElse(null);
    }
}
