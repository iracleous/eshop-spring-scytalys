package com.scytalys.eshop.service.impl;

import com.scytalys.eshop.dto.ResponseApi;
import com.scytalys.eshop.model.Customer;
import com.scytalys.eshop.service.CustomerValidator;
import org.springframework.stereotype.Service;

@Service
public class CustomerValidatorImpl implements CustomerValidator {
    /**
     * @param customer customer details
     * @return ResponseApi<Customer> embeds validation errors
     */
    @Override
    public ResponseApi<Customer> validate(Customer customer) {

        if (customer == null){
            return new ResponseApi<>(101,"null customer provided", null);
        }
        if (customer.getZip()!=null && ! customer.getZip().matches( "\\d{5}"))
        {
            return new ResponseApi<>(103,"incorrect format for  customer zip provided", null);
        }
        if (customer.getEmail()!=null && ! customer.getEmail().matches("^(.+)@(\\S+)$"))
        {
            return new ResponseApi<>(104,"incorrect format for customer email provided", null);
        }
         return new ResponseApi<>(0,"validation passed", customer);
    }
}
