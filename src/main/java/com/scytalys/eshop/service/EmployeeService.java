package com.scytalys.eshop.service;

import com.scytalys.eshop.dto.EmployeeDto;
import com.scytalys.eshop.exception.EmployeeCannotCreateException;

import java.util.List;

public interface EmployeeService {

    /**
     * Get an employee by ID.
     *
     * @param id The ID of the employee.
     * @return The employee with the specified ID, or null if not found.
     */
    EmployeeDto getEmployee(Long id);

    /**
     * Get all employees.
     *
     * @return A list of all employees.
     */
    List<EmployeeDto> getAllEmployees();

    /**
     * Save an employee.
     *
     * @param employee The employee to save.
     * @return The saved employee.
     * @throws EmployeeCannotCreateException when the Employee was not created
     */
    EmployeeDto saveEmployee(EmployeeDto employee) throws EmployeeCannotCreateException;

    /**
     * Delete an employee by ID.
     *
     * @param id The ID of the employee to delete.
     */
    boolean deleteEmployee(Long id);
}
