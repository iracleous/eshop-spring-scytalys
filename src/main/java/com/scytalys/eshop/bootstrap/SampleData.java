package com.scytalys.eshop.bootstrap;

import com.scytalys.eshop.dto.CartProductDto;
import com.scytalys.eshop.dto.EmployeeDto;
import com.scytalys.eshop.exception.EmployeeCannotCreateException;
import com.scytalys.eshop.model.*;
import com.scytalys.eshop.service.CartService;
import com.scytalys.eshop.service.EmployeeService;
import com.scytalys.eshop.service.ProductService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.math.BigDecimal;

@AllArgsConstructor
@Configuration
@Slf4j
public class SampleData {
    private final ProductService productService;
    private final CartService cartService;
    private final EmployeeService employeeService;

    @Bean
    public CommandLineRunner myCommandLineRunner() {
        return this::run;
    }

    private void run(String... args) {
        Product product = new Product();
        product.setName("cloth");
        product.setPrice(new BigDecimal("15.0"));
        product.setQuantity(5);
        product.setCategory(ProductCategory.CLOTHING);
        productService.createProduct(product);

        Product product2 = new Product();
        product2.setName("shirt");
        product2.setPrice(new BigDecimal("25.0"));
        product2.setQuantity(15);
        product2.setCategory(ProductCategory.CLOTHING);
        productService.createProduct(product2);

        Customer customer = new Customer();
        customer.setEmail("dim@mail.fr");
        cartService.createCustomer(customer);


        Cart cart = cartService.createCart(customer.getId());
        int quantity = 2;
        cartService.addProduct(new CartProductDto(cart.getId(),product2.getId(), product2.getPrice(), quantity));

        Cart cart2 = cartService.getCartById(1L);
        log.info("Cart 1: {}", cart2.getCustomer().getEmail());

        EmployeeDto employeeDto = new EmployeeDto();
        employeeDto.setOfficialName("Dimitris");
        employeeDto.setFamilyName("Dimitriu");
        try {
            employeeDto = employeeService.saveEmployee(employeeDto);
        } catch (EmployeeCannotCreateException e) {
            throw new RuntimeException(e);
        }
        log.info("employeeDto 1: {}", employeeDto.getId());

    }
}
