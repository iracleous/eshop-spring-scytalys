package com.scytalys.eshop.service.impl;

import com.scytalys.eshop.dto.ResponseApi;
import com.scytalys.eshop.mapper.EshopMapper;
import com.scytalys.eshop.model.Customer;
import com.scytalys.eshop.repository.CartProductRepository;
import com.scytalys.eshop.repository.CartRepository;
import com.scytalys.eshop.repository.CustomerRepository;
import com.scytalys.eshop.repository.ProductRepository;
import com.scytalys.eshop.service.CartService;
import com.scytalys.eshop.service.CustomerValidator;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;
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
    private  CartRepository cartRepository;
    @Mock
    private  CustomerRepository customerRepository;
    @Mock
    private  ProductRepository productRepository;
    @Mock
    private  CartProductRepository cartproductRepository;
    @Spy
    private  CustomerValidator customerValidator = new  CustomerValidatorImpl() ;

    @InjectMocks
    private CartServiceImpl cartService;

    @Test
    void getCustomer() {
    }

    @Test
    void createCustomer() {
        customer = new Customer();
        customer.setEmail("email@email.com");
        customer.setZip("11111");
        customer.setName("name");

        when(customerRepository.save(customer))
                .thenReturn(customer);

        ResponseApi<Customer> customerResponseApi = cartService.createCustomer(customer);

        assertNotNull(customerResponseApi);
        assertEquals(0, customerResponseApi.getCode());
    }
}