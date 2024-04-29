package com.scytalys.eshop.bootstrap;

import com.scytalys.eshop.model.*;
import com.scytalys.eshop.service.CartService;
import com.scytalys.eshop.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.LocalDateTime;

@AllArgsConstructor
@Configuration
public class SampleData {
    private final ProductService productService;
    private final CartService cartService;

    @Bean
    public CommandLineRunner myCommandLineRunner() {
        return args -> {
            Product product = new Product();
            product.setName("cloth");
            product.setPrice(15.0);
            product.setQuantity(5);
            product.setCategory(ProductCategory.CLOTHING);
            productService.createProduct(product)  ;


            Product product2 = new Product();
            product2.setName("shirt");
            product2.setPrice(25.0);
            product2.setQuantity(15);
            product2.setCategory(ProductCategory.CLOTHING);
            productService.createProduct(product2)  ;

            Customer customer = new Customer();
            customer.setEmail("dim@mail.fr");

            Cart cart = new Cart();
            cart.setCustomer(customer);
            cart.setOrderDate(LocalDateTime.now());

            Cartproduct cartproduct = new Cartproduct();
            cartproduct.setProduct(product);
            cartproduct.setCart(cart);
            cartproduct.setQuantity(2);



        };
    }

}
