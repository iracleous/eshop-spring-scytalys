package com.scytalys.eshop.bootstrap;

import com.scytalys.eshop.model.Product;
import com.scytalys.eshop.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@AllArgsConstructor
@Configuration
public class SampleData {
private final ProductService productService;

    @Bean
    public CommandLineRunner myCommandLineRunner() {
        return args -> {
            Product product = new Product();
            product.setName("cloth");
            product.setPrice(15.0);
            product.setQuantity(5);
            productService.createProduct(product)  ;





        };
    }

}
