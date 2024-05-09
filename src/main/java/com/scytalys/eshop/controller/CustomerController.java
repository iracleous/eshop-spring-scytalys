package com.scytalys.eshop.controller;

import com.scytalys.eshop.dto.ResponseApi;
import com.scytalys.eshop.model.Customer;
import com.scytalys.eshop.service.CartService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v2/customer")
@AllArgsConstructor
public class CustomerController {
    private final CartService cartService;

    @PostMapping("")
    public ResponseApi<Customer> addCustomer(@RequestBody Customer customer) {
        return cartService.createCustomer(customer);
    }

    @GetMapping("")
    public List<Customer> getCustomers() {
        return cartService.getCustomers();
    }

}
