package com.scytalys.eshop.controller;

import com.scytalys.eshop.dto.IncreaseDto;
import com.scytalys.eshop.model.Product;
import com.scytalys.eshop.repository.ProductSpecifications;
import com.scytalys.eshop.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor(onConstructor_ = {@Autowired})
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/product")
public class ProductController {

    private final ProductService productService;

    @PostMapping("")
    public ResponseEntity<Product> create(@RequestBody Product product){
        return ResponseEntity.ok(productService.createProduct(product));
    }

    @GetMapping("/{productId}")
    public ResponseEntity<Product> read(@PathVariable long productId){
        Product product = productService.getProduct(productId);
        return product == null ? ResponseEntity.notFound().build() : ResponseEntity.ok(product);
    }

    @GetMapping("")
    public List<Product> read(){
        return productService.getProducts();
    }

    @PutMapping("/{productId}")
    public Product update(@PathVariable long productId,@RequestBody Product product){
        return productService.updateProduct(productId, product);
    }

    @DeleteMapping("/{productId}")
    public boolean update(@PathVariable long productId){
        return productService.deleteProduct(productId);
    }

    @PutMapping("/increase")
    public boolean increase(@RequestBody IncreaseDto increaseDto){
        return productService.increasePrices(increaseDto.getValue());
    }

    @GetMapping("/search")
    public List<Product> searchProducts(
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String description) {
        Specification<Product> spec = Specification.where(null);
        if (name != null) {
            spec = spec.and(ProductSpecifications.nameContains(name));
        }
        if (description != null) {
            spec = spec.and(ProductSpecifications.descriptionContains(description));
        }
        return productService.search(spec);
    }
}
