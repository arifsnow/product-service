package com.example.productservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import lombok.RequiredArgsConstructor;
import java.util.List;

import com.example.productservice.repository.*;
import com.example.productservice.model.*;

@RestController
@EnableAutoConfiguration
@RequestMapping("/api/product")
@RequiredArgsConstructor
@Component
public class ProductController {
 
    private final ProductRepository productRepository;
 
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Product> findAll() {
        return productRepository.findAll();
    }
 
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createProduct(@RequestBody Product product) {
        productRepository.save(product);
    }
}
