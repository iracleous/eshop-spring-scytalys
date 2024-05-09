package com.scytalys.eshop.service;

import com.scytalys.eshop.dto.EmployeeDto;
import com.scytalys.eshop.mapper.EshopMapper;
import com.scytalys.eshop.model.Employee;
import com.scytalys.eshop.repository.EmployeeRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


/**
 * Implementation of the {@link EmployeeService} interface that provides
 * methods to manage employee data.
 */
@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final EshopMapper eshopMapper;

    /**
     * Retrieves an employee by their ID.
     *
     * @param id the ID of the employee to retrieve
     * @return an {@link Optional} containing the employee if found, otherwise empty
     */
    @Override
    public EmployeeDto getEmployee(Long id) {
        Employee employee = employeeRepository.findById(id).orElse(null);
        return eshopMapper.toEmployeeDto(employee) ;
    }

    /**
     * Retrieves all employees.
     *
     * @return a {@link List} of all employees
     */
    @Override
    public List<EmployeeDto> getAllEmployees() {
        return employeeRepository
                .findAll()
                .stream()
                .map(eshopMapper::toEmployeeDto)
                .collect(Collectors.toList());
    }

    /**
     * Saves an employee.
     *
     * @param employee the employee to save
     * @return the saved employee
     */
    @Override
    public EmployeeDto saveEmployee(EmployeeDto employee) {
        return eshopMapper
                .toEmployeeDto(
                        employeeRepository
                            .save(eshopMapper.toEmployee(employee))) ;
    }

    /**
     * Deletes an employee by their ID.
     *
     * @param id the ID of the employee to delete
     */
    @Override
    public boolean deleteEmployee(Long id) {
        Employee employee = employeeRepository.findById(id).orElse(null);
        if (employee != null) {
            employeeRepository.delete(employee);
            return true;
        }
       return false;
    }
}