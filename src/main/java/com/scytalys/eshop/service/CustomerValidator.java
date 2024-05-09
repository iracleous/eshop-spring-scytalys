package com.scytalys.eshop.service;

import com.scytalys.eshop.dto.ResponseApi;
import com.scytalys.eshop.model.Customer;

public interface CustomerValidator {
    ResponseApi<Customer> validate(Customer customer);
}
