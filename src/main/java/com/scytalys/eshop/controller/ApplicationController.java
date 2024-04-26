package com.scytalys.eshop.controller;

import com.scytalys.eshop.model.Product;
import com.scytalys.eshop.repository.ProductRepository;
import com.scytalys.eshop.service.ApplicationService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor(onConstructor_ = {@Autowired})
public class ApplicationController {

    private final ApplicationService applicationService;

    @GetMapping
    public String hello() {return "Hello World!";}

    @PostMapping("/product")
    public Product create(@RequestBody Product product){
        return applicationService.createProduct(product);
    }
    @GetMapping("/product/{productId}")
    public Product read(@PathVariable long productId){
        return applicationService.getProduct(productId);
    }
    @GetMapping("/product/")
    public List<Product> read(){
        return applicationService.getProducts();
    }
    @PutMapping("/product/{productId}")
    public Product update(@PathVariable long productId,@RequestBody Product product){
        return applicationService.updateProduct(productId, product);
    }
    @DeleteMapping("/product/{productId}")
    public boolean update(@PathVariable long productId){
        return applicationService.deleteProduct(productId);
    }

}
