package com.scytalys.eshop.service.impl;

import com.scytalys.eshop.dto.ResponseApi;
import com.scytalys.eshop.model.Customer;
import com.scytalys.eshop.service.CustomerValidator;
import org.springframework.stereotype.Service;

@Service
public class CustomerValidatorImpl implements CustomerValidator {
    /**
     * @param customer
     * @return
     */
    @Override
    public ResponseApi<Customer> validate(Customer customer) {

        if (customer == null){
            return new ResponseApi<Customer>(101,"null customer provided", null);
        }
        if (customer.getZip()!=null && ! customer.getZip().matches( "\\d{5}"))
        {
            return new ResponseApi<Customer>(103,"incorrect format for  customer zip provided", null);
        }
         return new ResponseApi<Customer>(0,"validation passed", new Customer());
    }
}
