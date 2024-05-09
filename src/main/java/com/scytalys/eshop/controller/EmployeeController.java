package com.scytalys.eshop.controller;

import com.scytalys.eshop.dto.EmployeeDto;
import com.scytalys.eshop.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor(onConstructor_ = {@Autowired})
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/employee/v2/")
public class EmployeeController {

    private final EmployeeService employeeService;

    @PostMapping("/")
    public ResponseEntity<EmployeeDto> create(@RequestBody EmployeeDto employee){
        return ResponseEntity.ok(employeeService.saveEmployee(employee));
    }
    @GetMapping("/{employeeId}")
    public ResponseEntity<EmployeeDto> read(@PathVariable long employeeId){
        EmployeeDto employee = employeeService.getEmployee(employeeId);
        return employee == null ? ResponseEntity.notFound().build() : ResponseEntity.ok(employee);
    }
    @GetMapping("/")
    public List<EmployeeDto> read(){
        return employeeService.getAllEmployees();
    }

    @DeleteMapping("/{employeeId}")
    public boolean update(@PathVariable long employeeId){
        return employeeService.deleteEmployee(employeeId);
    }
}
