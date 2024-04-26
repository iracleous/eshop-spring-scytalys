package com.scytalys.eshop.controller;

import com.scytalys.eshop.model.Product;
import com.scytalys.eshop.repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor(onConstructor_ = {@Autowired})
public class ApplicationController {

    private final ProductRepository productRepository;

    @GetMapping
    public String hello() {return "Hello World!";}

    @PostMapping("/product")
    public Product create(@RequestBody Product product){
        productRepository.save(product);
        return product;
    }
    @GetMapping("/product/{productId}")
    public Product read(@PathVariable long productId){
        return productRepository.findById(productId).orElseThrow();
    }
}
