package com.scytalys.eshop.repository;

import com.scytalys.eshop.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
