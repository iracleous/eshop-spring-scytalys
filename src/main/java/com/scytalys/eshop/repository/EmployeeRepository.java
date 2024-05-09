package com.scytalys.eshop.repository;

import com.scytalys.eshop.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
