package com.scytalys.eshop.controller;

import com.scytalys.eshop.model.Product;
import com.scytalys.eshop.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor(onConstructor_ = {@Autowired})
@CrossOrigin(origins = "http://localhost:3000")
public class ProductController {

    private final ProductService productService;

    @GetMapping
    public String hello() {return "Hello World!";}

    @PostMapping("/product")
    public ResponseEntity<Product> create(@RequestBody Product product){
        return ResponseEntity.ok(productService.createProduct(product));
    }
    @GetMapping("/product/{productId}")
    public ResponseEntity<Product> read(@PathVariable long productId){
        Product product = productService.getProduct(productId);
        return product == null ? ResponseEntity.notFound().build() : ResponseEntity.ok(product);
    }
    @GetMapping("/product/")
    public List<Product> read(){
        return productService.getProducts();
    }
    @PutMapping("/product/{productId}")
    public Product update(@PathVariable long productId,@RequestBody Product product){
        return productService.updateProduct(productId, product);
    }
    @DeleteMapping("/product/{productId}")
    public boolean update(@PathVariable long productId){
        return productService.deleteProduct(productId);
    }

}
