package com.scytalys.eshop.service.impl;

import com.scytalys.eshop.dto.ResponseApi;
import com.scytalys.eshop.model.Customer;
import com.scytalys.eshop.model.Employee;
import com.scytalys.eshop.repository.CustomerRepository;

import com.scytalys.eshop.service.CustomerValidator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@SpringBootTest
class CartServiceImplTest {

    private Customer customer;

    @Mock
    private  CustomerRepository customerRepository;
    @Spy
    private  CustomerValidator customerValidator = new  CustomerValidatorImpl() ;

    @InjectMocks
    private CartServiceImpl cartService;

    @Test
    void getCustomer() {
    }

    @BeforeEach
    void setUp() {
        customer = new Customer();
        customer.setEmail("email@email.com");
        customer.setZip("11111");
        customer.setName("name");
    }

    @Test
    void createCustomer() {
        when(customerRepository.save(customer)) .thenReturn(customer);
        ResponseApi<Customer> customerResponseApi = cartService.createCustomer(customer);

        assertNotNull(customerResponseApi);
        assertEquals(0, customerResponseApi.getCode());
    }
}